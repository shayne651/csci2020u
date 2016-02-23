package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.image.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.*;
import java.time.LocalDate;

public class Main extends Application
{
        //layout lets us store the table as well as the grid inside it 
        private BorderPane layout;
        @Override
        public void start(Stage primaryStage) throws Exception 
        {
                primaryStage.setTitle("Lab05");
                //grid contains all of the textfeilds, labels , buttons, ect..
                GridPane grid = new GridPane();
                //the tableview puts all of our data into a exel like format
                TableView<StudentRecord> table = new TableView<>();
                table.setItems(DataSource.getAllMarks());
                table.setEditable(true);

                TableColumn<StudentRecord,String> IDColumn = null;
                IDColumn = new TableColumn<>("SID");
                IDColumn.setMinWidth(100);
                //the thing in quotes is what it will search for in the StudentRecords.java (MAKE SURE THERE IS A GET FUNCTION FOR THAT VARIBALE)
                IDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));

                TableColumn<StudentRecord,Double> AssignmentColumn = null;
                AssignmentColumn = new TableColumn<>("Assignment");
                AssignmentColumn.setMinWidth(100);
                AssignmentColumn.setCellValueFactory(new PropertyValueFactory<>("Assign"));

                TableColumn<StudentRecord,Float> MidtermColumn = null;
                MidtermColumn = new TableColumn<>("Midterm");
                MidtermColumn.setMinWidth(100);
                MidtermColumn.setCellValueFactory(new PropertyValueFactory<>("Midterm"));

                TableColumn<StudentRecord,Float> FinalColumn = null;
                FinalColumn = new TableColumn<>("Final Exam");
                FinalColumn.setMinWidth(100);
                FinalColumn.setCellValueFactory(new PropertyValueFactory<>("Final"));

                TableColumn<StudentRecord,String> GradeColumn = null;
                GradeColumn = new TableColumn<>("Letter Grade");
                GradeColumn.setMinWidth(100);
                GradeColumn.setCellValueFactory(new PropertyValueFactory<>("Grade"));


                table.getColumns().add(IDColumn);
                table.getColumns().add(AssignmentColumn);
                table.getColumns().add(MidtermColumn);
                table.getColumns().add(FinalColumn);
                table.getColumns().add(GradeColumn);


                Label IDLabel = new Label("SID:");
                grid.add(IDLabel,0,0);

                TextField IDField = new TextField();
                IDField.setPromptText("SID");
                grid.add(IDField,1,0);

                Label AssignLabel = new Label("Assignments:");
                grid.add(AssignLabel,2,0);

                TextField AssignField = new TextField();
                AssignField.setPromptText("Assignment");
                grid.add(AssignField,3,0);

                Label MidLabel = new Label("Midterm:");
                grid.add(MidLabel,0,1);

                TextField midField = new TextField();
                midField.setPromptText("Midterm");
                grid.add(midField,1,1);

                Label FinalLabel = new Label("Final:");
                grid.add(FinalLabel,2,1);

                TextField FinalField = new TextField();
                FinalField.setPromptText("Final");
                grid.add(FinalField,3,1);

                Button AddButton = new Button("Add");
                AddButton.setOnAction(new EventHandler<ActionEvent>() {
            @   Override public void handle(ActionEvent e) {
                        char Grade;
                        String SID = IDField.getText();
                        Float Assignment = Float.parseFloat(AssignField.getText());
                        Float Midterm = Float.parseFloat(midField.getText());
                        Float Final = Float.parseFloat(FinalField.getText());
                        table.getItems().add(new StudentRecord(SID,Assignment,Midterm,Final));

                        IDField.setText("");
                        AssignField.setText("");
                        midField.setText("");
                        FinalField.setText("");
                 }
                 });
                grid.add(AddButton,0,2);

                layout = new BorderPane();
                layout.setCenter(table);
                layout.setBottom(grid);
                
                Scene scene = new Scene(layout);
                grid.setPadding(new Insets(10, 10, 10, 10));
                grid.setVgap(10);
                grid.setHgap(10);

                primaryStage.setScene(scene);
                primaryStage.show();
        }
}