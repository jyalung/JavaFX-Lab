package JavaFX;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class TipCalculator extends Application {
	private TextField field;
	private Label rCharge;
	private Button calcTip;
	private Label amountTip;
	private Label tTip;
	
	@Override
	public void start(Stage s) {
		rCharge = new Label ("Restaurant Charge:");
		field = new TextField();
		calcTip = new Button("Calculate Tip");
		amountTip = new Label("Amount to Tip:");
		tTip = new Label();
		
		calcTip.setOnAction(new ButtonHandler());
		
		VBox vbox = new VBox(10, rCharge, field, calcTip, amountTip, tTip);
		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(vbox, 200, 200);
		
		s.setScene(scene);
		s.show();
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			final double tPercent = 20;
			double input;
			double tip;
			
			input = Double.parseDouble(field.getText());
			tip = (double) Math.round(input * tPercent) / 100.00;
			
			tTip.setText("$" + String.format("%.2f", tip));
		}
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
