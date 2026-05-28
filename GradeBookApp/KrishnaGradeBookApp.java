package GradeBookApp;

/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
    * Krishna Grade Book Application
 */
public class KrishnaGradeBookApp extends Application {
    private static final String CSV_FILE_NAME = "grades.csv";

    private TextField firstNameField;
    private TextField lastNameField;
    private TextField courseField;
    private ComboBox<String> gradeComboBox;
    private TextArea resultsArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Grade Book Form");

        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setPadding(new Insets(12));

        Label firstNameLabel = new Label("First Name:");
        firstNameField = new TextField();
        firstNameField.setPrefColumnCount(18);
        firstNameField.setOnAction(event -> saveGradeEntry());

        Label lastNameLabel = new Label("Last Name:");
        lastNameField = new TextField();
        lastNameField.setPrefColumnCount(18);
        lastNameField.setOnAction(event -> saveGradeEntry());

        Label courseLabel = new Label("Course:");
        courseField = new TextField();
        courseField.setPrefColumnCount(18);
        courseField.setOnAction(event -> saveGradeEntry());

        Label gradeLabel = new Label("Grade:");
        gradeComboBox = new ComboBox<>();
        gradeComboBox.getItems().addAll("A", "B", "C", "D", "F");
        gradeComboBox.getSelectionModel().selectFirst();
        gradeComboBox.setPrefWidth(160);

        formGrid.add(firstNameLabel, 0, 0);
        formGrid.add(firstNameField, 1, 0);
        formGrid.add(lastNameLabel, 0, 1);
        formGrid.add(lastNameField, 1, 1);
        formGrid.add(courseLabel, 0, 2);
        formGrid.add(courseField, 1, 2);
        formGrid.add(gradeLabel, 0, 3);
        formGrid.add(gradeComboBox, 1, 3);

        Button saveButton = new Button("Save Grade");
        Button viewButton = new Button("View Grades");
        Button clearButton = new Button("Clear Form");

        saveButton.setOnAction(event -> saveGradeEntry());
        viewButton.setOnAction(event -> viewGradeEntries());
        clearButton.setOnAction(event -> clearForm());

        HBox buttonBox = new HBox(10, saveButton, viewButton, clearButton);
        buttonBox.setPadding(new Insets(0, 12, 10, 12));

        resultsArea = new TextArea();
        resultsArea.setEditable(false);
        resultsArea.setWrapText(true);
        resultsArea.setPrefRowCount(8);
        resultsArea.setPrefWidth(500);

        VBox resultsBox = new VBox(8, resultsArea);
        resultsBox.setPadding(new Insets(0, 12, 12, 12));

        BorderPane root = new BorderPane();
        root.setTop(formGrid);
        root.setCenter(buttonBox);
        root.setBottom(resultsBox);

        Scene scene = new Scene(root, 520, 420);
        stage.setScene(scene);
        stage.show();
    }

    private void saveGradeEntry() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String course = courseField.getText().trim();
        String grade = gradeComboBox.getValue();

        if (firstName.isEmpty() || lastName.isEmpty() || course.isEmpty()) {
            resultsArea.setText("Please complete all fields before saving.\n");
            return;
        }

        Student student = new Student(firstName, lastName, course, grade);
        writeStudentToCsv(student);
        resultsArea.setText("Saved: " + student.toString() + "\n");
        clearForm();
    }

    private void viewGradeEntries() {
        File csvFile = new File(CSV_FILE_NAME);
        if (!csvFile.exists()) {
            resultsArea.setText("No grades have been saved yet.\n");
            return;
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            resultsArea.setText(content.toString());
        } catch (IOException e) {
            resultsArea.setText("Error reading grades.csv: " + e.getMessage() + "\n");
        }
    }

    private void clearForm() {
        firstNameField.clear();
        lastNameField.clear();
        courseField.clear();
        gradeComboBox.getSelectionModel().selectFirst();
    }

    private void writeStudentToCsv(Student student) {
        File csvFile = new File(CSV_FILE_NAME);
        boolean needsHeader = !csvFile.exists() || csvFile.length() == 0;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
            if (needsHeader) {
                writer.write("firstName,lastName,course,grade");
                writer.newLine();
            }
            writer.write(student.getFirstName() + "," + student.getLastName() + "," + student.getCourse() + "," + student.getGrade());
            writer.newLine();
        } catch (IOException e) {
            resultsArea.setText("Unable to save grade entry: " + e.getMessage() + "\n");
        }
    }
}
