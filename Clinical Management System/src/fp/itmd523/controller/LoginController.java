package fp.itmd523.controller;

import java.awt.Desktop.Action;
import java.io.IOException;

import application.Main;
import fp.itmd523.dao.LoginDAO;
import fp.itmd523.model.Login;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {

	private static Login login;
	
	@FXML
	private TextField txtUsername;
	
	@FXML
	private PasswordField txtPassword;
	
	@FXML
	private Label lbl_login_error;
	
	public void Login()
	{		
		String username = txtUsername.getText();
		String password = txtPassword.getText();
		System.out.println(username+"   "+password);
		Login L = new Login();
		System.out.println("In LoginController");
		
		//validate empty fields
		if(username.isEmpty() || password.isEmpty())
		{
			System.out.println("Username or Password cannot be empty");
			lbl_login_error.setText("Username or Password cannot be empty");
			return;
		}
		LoginDAO dao = new LoginDAO();
		L = dao.findUserLogin(username, password);
		
		System.out.println();
		
		login = L;
		
		//validate username and password
		if( L == null)
				{
			System.out.println("Invalid username or password");
			lbl_login_error.setText("Invalid username or password");
			return;
				}

		// Differentiate user
		if(username.equalsIgnoreCase(login.getUsername()) && password.equals(login.getPassword()))
		{
			System.out.println("Username and password matched!!!");
			
			try{
			
				Stage stage = new Stage();
				System.out.println("in try block");
				System.out.println(L.getUsername() + L.getPassword() + L.getUsertype());
			if(login.getUsertype().equalsIgnoreCase("Admin"))
			{
				System.out.println("Admin login");
				
					 Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("/fp/itmd523/view/DoctorHome.fxml"));
					 Scene scene = new Scene(root);
						//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setTitle("Doctor Home");	
						stage.setScene(scene);
						stage.show();
						
			}
			if(login.getUsertype().equalsIgnoreCase("Patient"))
			{
				System.out.println("User login");
				//Stage stage = new Stage();
					 Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("/fp/itmd523/view/PatientHome.fxml"));
					 Scene scene = new Scene(root);
						//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setTitle("Patient Home");	
						stage.setScene(scene);
						stage.show();
				} 
			
			
			
			}catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error occured in view: ");
					e.printStackTrace();
				}
			}
			
		}
	public static Login getLogin() {
		return login;
	}
		
	public static void logout() {
		login = null;
	}
	
	
		
	}
	
	

