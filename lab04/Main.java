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
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		primaryStage.setTitle("Lab04");
		GridPane grid = new GridPane();


        Label UserName = new Label("UserName:");
        grid.add(UserName,0,0);

        TextField unameField = new TextField();
        unameField.setPromptText("UserName");
        grid.add(unameField,1,0);

        Label pass = new Label("Password:");
        grid.add(pass,0,2);

        PasswordField passField = new PasswordField();
		passField.setPromptText("Password");
        grid.add(passField,1,2);

        Label fullName = new Label("Full Name:");
        grid.add(fullName,0,4);

        TextField fullField = new TextField();
        fullField.setPromptText("Full Name");
        grid.add(fullField,1,4);

        Label email = new Label("Email:");
        grid.add(email,0,6);

        TextField emailField = new TextField();
        emailField.setPromptText("Fake@email.com");
        grid.add(emailField,1,6);

        Label phone = new Label("Phone #:");
        grid.add(phone,0,8);

        TextField phoneField = new TextField();
        phoneField.setPromptText("Password");
        grid.add(phoneField,1,8);

        Label DOB = new Label("Date Of Birth:");
        grid.add(DOB,0,10);

        DatePicker DOBFeild = new DatePicker(LocalDate.now());
        grid.add(DOBFeild,1,10);
        Label SubmitLabel = new Label("");
		grid.add(SubmitLabel,0,12); 

        Button SubButton = new Button("Submit");
        SubButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String UserName = unameField.getText();
                String Password = passField.getText();
                String FullName = fullField.getText();
                String Email = emailField.getText();
                String PhoneNumber = phoneField.getText();
                LocalDate DateOfBirth = DOBFeild.getValue();
                System.out.println("UserName: "+ UserName + "\nPassword: " + Password + "\nFull Name: " + FullName + "\nEmail: " + Email + "\nPhoneNumber: "+PhoneNumber+ "\nDOB: " + DateOfBirth);
            }
        });

        grid.add(SubButton, 1, 12);

        Scene scene = new Scene(grid);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        primaryStage.setScene(scene);
        primaryStage.show();
	}
}