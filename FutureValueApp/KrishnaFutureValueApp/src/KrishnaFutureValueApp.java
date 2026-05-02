/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
*/ 

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
Create a JavaFX application that calculates the future value of monthly payments.
 */
public class KrishnaFutureValueApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label lblMonthlyPayment = new Label("Monthly Payment:");
        TextField monthlyPayment = new TextField();

        Label lblInterestRate = new Label("Interest Rate:");
        TextField interestRate = new TextField();

        Label interestRateHint = new Label("Enter 11.1% as 11.1");
        interestRateHint.setTextFill(Color.RED);

        Label yearsLabel = new Label("Years:");
        ComboBox<Integer> yearsComboBox = new ComboBox<>();
        for (int i = 1; i <= 30; i++) {
            yearsComboBox.getItems().add(i);
        }
        yearsComboBox.setPrefWidth(120);
        yearsComboBox.setPromptText("Select years");

        TextArea futureValueTextArea = new TextArea();
        futureValueTextArea.setEditable(false);
        futureValueTextArea.setWrapText(true);
        futureValueTextArea.setPrefRowCount(6);

        Label errorMessageLabel = new Label();
        errorMessageLabel.setTextFill(Color.RED);

        Button btnCalculate = new Button("Calculate");
        Button btnClear = new Button("Clear");

        btnCalculate.setOnAction(event -> {
            errorMessageLabel.setText("");
            futureValueTextArea.clear();

            String paymentText = monthlyPayment.getText().trim();
            String rateText = interestRate.getText().trim();
            Integer years = yearsComboBox.getValue();

            if (paymentText.isEmpty() || rateText.isEmpty() || years == null) {
                errorMessageLabel.setText("Please enter all values and select years.");
                return;
            }

            try {
                double payment = Double.parseDouble(paymentText);
                double annualRate = Double.parseDouble(rateText);

                if (payment <= 0 || annualRate <= 0) {
                    errorMessageLabel.setText("Monthly payment and interest rate must be positive.");
                    return;
                }

                double monthlyRate = annualRate / 100.0 / 12.0;
                int totalMonths = years * 12;
                double futureValue = payment * (Math.pow(1 + monthlyRate, totalMonths) - 1) / monthlyRate;

                futureValueTextArea.setText(String.format(
                        "Monthly Payment: $%.2f\nInterest Rate: %.3f%%\nYears: %d\n\nFuture Value: $%.2f",
                        payment, annualRate, years, futureValue));
            } catch (NumberFormatException ex) {
                errorMessageLabel.setText("Please enter valid numeric values for payment and rate.");
            }
        });

        btnClear.setOnAction(event -> {
            monthlyPayment.clear();
            interestRate.clear();
            yearsComboBox.getSelectionModel().clearSelection();
            futureValueTextArea.clear();
            errorMessageLabel.setText("");
        });

        GridPane inputGrid = new GridPane();
        inputGrid.setAlignment(Pos.CENTER);
        inputGrid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        inputGrid.setHgap(5.5);
        inputGrid.setVgap(5.5);
        inputGrid.add(lblMonthlyPayment, 0, 0);
        inputGrid.add(monthlyPayment, 1, 0);
        inputGrid.add(lblInterestRate, 0, 1);
        inputGrid.add(interestRate, 1, 1);
        inputGrid.add(interestRateHint, 1, 2);
        inputGrid.add(yearsLabel, 0, 3);
        inputGrid.add(yearsComboBox, 1, 3);
        GridPane.setHalignment(lblInterestRate, HPos.RIGHT);

        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().add(btnClear);
        actionBtnContainer.getChildren().add(btnCalculate);
        inputGrid.add(actionBtnContainer, 1, 4);

        VBox root = new VBox(10,
                inputGrid,
                actionBtnContainer,
                futureValueTextArea,
                errorMessageLabel);
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 420, 360);

        primaryStage.setTitle("Krishna Future Value App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
