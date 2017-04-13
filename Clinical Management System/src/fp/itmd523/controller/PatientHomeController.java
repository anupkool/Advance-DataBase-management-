package fp.itmd523.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

import fp.itmd523.dao.AppointmentDAO;
import fp.itmd523.dao.PatientDAO;
import fp.itmd523.model.Appointment;
import fp.itmd523.model.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PatientHomeController {

	
	public void ViewPatientInfo(ActionEvent a)
	{		
		
		System.out.println("In PatientHomeController --> ViewPatientInfo ");
		
		PatientDAO Pdao = new PatientDAO();
		
		System.out.println("Username is : "+LoginController.getLogin().getUsername());
		Patient patient;
		
		patient = Pdao.findPatientInfo(LoginController.getLogin().getUsername());
		System.out.println("User first name: "+ patient.getF_name());
					 
		try{
			Stage stage = new Stage();
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/fp/itmd523/view/ViewPatientInfo.fxml"));
				        AnchorPane anchorPane = loader.load();
				        // Get the Controller from the FXMLLoader
				        BasePatientController controller = loader.getController();
				        // Set data in the controller
				        System.out.println(" inside try f_name: "+patient.getF_name());
				        controller.setLbl_fname(patient.getF_name());
				        controller.setLbl_lname(patient.getL_name());
				        controller.setLbl_gender(patient.getGender());
				        controller.setLbl_dob(patient.getDob());
				        controller.setLbl_email_id(patient.getE_mail());
				        controller.setLbl_mobile_no(patient.getMobile());
				        controller.setLbl_blood_group(patient.getBlood_group());
				        controller.setLbl_weight(patient.getWeight());
				        Scene scene = new Scene(anchorPane);
				        stage.setTitle("Patient Information");
				        stage.setScene(scene);
				        stage.show();
			
			}catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error occured in view: ");
					e.printStackTrace();
				}
			}
	
	//--------------------------------------------------------------------//
	
		public void UpdatePatientInfo(ActionEvent a)
		{
			System.out.println("In PatientHomeController --> UpdatePatientInfo ");
			
			PatientDAO Pdao = new PatientDAO();
			
			System.out.println("Username is : "+LoginController.getLogin().getUsername());
			Patient patient;
			
			patient = Pdao.findPatientInfo(LoginController.getLogin().getUsername());
			System.out.println("Patient first name: "+ patient.getF_name());
			//txtf_name.setText(user.getF_name());
			
			
			try{
				Stage stage = new Stage();
							FXMLLoader loader = new FXMLLoader(getClass().getResource("/fp/itmd523/view/UpdatePatientInfo.fxml"));
					        AnchorPane anchorPane = loader.load();
					        // Get the Controller from the FXMLLoader
					        BasePatientController controller = loader.getController();
					        // Set data in the controller
					        controller.setTxt_fname(patient.getF_name());
					        controller.setTxt_lname(patient.getL_name());
					        controller.setTxt_email_id(patient.getE_mail());
					        controller.setTxt_mobile_no(patient.getMobile());
					        controller.setTxt_weight(patient.getWeight());
					        Scene scene = new Scene(anchorPane);
					        stage.setTitle("Update Patient Information");
					        stage.setScene(scene);
					        stage.show();
				
				}catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Error occured in view: ");
						e.printStackTrace();
					}
				}
		
		//--------------------------------------------------------------------------------------------------//
		
		
		public void gotoSearchAppointment(ActionEvent a)
		{		
			
			System.out.println("In PatientHomeController --> gotoSearchAppointment ");

						 
			try{
				Stage stage = new Stage();
							FXMLLoader loader = new FXMLLoader(getClass().getResource("/fp/itmd523/view/SearchBookAppointment.fxml"));
					        AnchorPane anchorPane = loader.load();
					        Scene scene = new Scene(anchorPane);
					        stage.setScene(scene);
					        stage.show();
				
				}catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Error occured in view: ");
						e.printStackTrace();
					}
			}
	
		//---------------------------------------------------------------------------------------------------------//
		
		@FXML
		private DatePicker dp_aptdt;
		
		
		@FXML
		private RadioButton rb_12PM;
		
		@FXML
		private RadioButton rb_1PM;
		
		@FXML
		private RadioButton rb_2PM;
		
		@FXML
		private RadioButton rb_3PM;
		
		@FXML
		private RadioButton rb_4PM;
		
		@FXML
		private RadioButton rb_doc1;
		
		@FXML
		private RadioButton rb_doc2;
		
		@FXML
		private ToggleGroup SelectAptTime;
		
		@FXML
		private ToggleGroup SelectDoctor;
		
		@FXML
		private Label lbl_search_apt;
		
		public void showAvailableAppointment(ActionEvent a) throws ParseException
		{
			System.out.println("In PatientHomeController --> showAvailableAppointment ");
			
			if(dp_aptdt.getValue() == null || SelectAptTime.equals(null) || SelectDoctor.equals(null))
			{
				System.out.println(" no data selected");
				lbl_search_apt.setText("Please select values for all the choices.");	
				return;
			}
			
			
			/*if(dp_aptdt.getValue() == null || !rb_12PM.equals("") || !rb_1PM.isSelected() || !rb_2PM.isSelected() || !rb_3PM.isSelected() || !rb_4PM.isSelected() || !rb_doc1.isSelected() || !rb_doc2.isSelected())
			{
				System.out.println(" no data selected");
				lbl_search_apt.setText("Please select values for all the choices.");	
				return;
			}*/
			
			String str_aptdt = dp_aptdt.getValue().toString();
			Date today = new Date();
			Date date_due_date = new Date(today.getTime() + 7*(1000 * 60 * 60 * 24));
			
			System.out.println(" today is: "+today +" and +7 days: "+ date_due_date);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String str_today = dateFormat.format(today);
			String str_due_date = dateFormat.format(date_due_date);
			
			Date new_select_date = dateFormat.parse(str_aptdt);
			Date new_today_date = dateFormat.parse(str_today);
			Date new_due_date = dateFormat.parse(str_due_date);
			
			if( new_select_date.compareTo(new_today_date)<=0 || new_select_date.compareTo(date_due_date)>= 0)
			{
				lbl_search_apt.setText("Select a valid range of date. You can search and book appointments of next 6 days");
				return;
			}
			else
			{
				String time = "";
				String doctor_id = "";
				if(rb_12PM.isSelected()){ time = "12 PM";}
				if(rb_1PM.isSelected()){ time = "1 PM";}
				if(rb_2PM.isSelected()){ time = "2 PM";}
				if(rb_3PM.isSelected()){ time = "3 PM";}
				if(rb_4PM.isSelected()){ time = "4 PM";}
				
				if(rb_doc1.isSelected()){ doctor_id = "D001";}
				if(rb_doc2.isSelected()){ doctor_id = "D002";}
				
			AppointmentDAO Adao = new AppointmentDAO();
			String Available_status = Adao.searchAppointment(LoginController.getLogin().getUsername(), doctor_id, str_aptdt, time);
			
			
			if(Available_status == "alreadyBooked")
			{
				lbl_search_apt.setText("You have already booked an appointment!");
				return;
			}
			
			else if(Available_status == "noAvailable")
			{
				lbl_search_apt.setText("Your choice of appointment date is not available!. Kindly search for other.");
				return;
			}
			else if(Available_status == "yesAvailable")
			{
				try{
					Stage stage = new Stage();
								FXMLLoader loader = new FXMLLoader(getClass().getResource("/fp/itmd523/view/BookAppointment.fxml"));
						        AnchorPane anchorPane = loader.load();
						        BasePatientController controller = loader.getController();
						        // Set data in the controller
						        controller.setLbl_apt_date(str_aptdt);
						        controller.setLbl_apt_time(time);
						        controller.setLbl_doctor_id(doctor_id);
						        Scene scene = new Scene(anchorPane);
						        stage.setScene(scene);
						        stage.show();
					
					}catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("Error occured in view: ");
							e.printStackTrace();
						}
			}
				
			}
			
		}
		
		//-------------------------------------------------------------------------------------//
		

		
		// Back Button points to PatientHome
		public void BacktoPatientHome(ActionEvent a)
		{		
				try{
				
					Stage stage = new Stage();	
						 Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("/fp/itmd523/view/PatientHome.fxml"));
						 Scene scene = new Scene(root);
							//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							stage.setTitle("User Home");	
							stage.setScene(scene);
							stage.show();
				
				}catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Error occured in view: ");
						e.printStackTrace();
					}
				}
		
		
		//----------------------------------------------------------------------------------------------//
	
		public void viewBookedAppointments(ActionEvent a)
		{		
			
			System.out.println("In PatientHomeController --> viewBookedAppointments ");
			
			AppointmentDAO Adao = new AppointmentDAO();
			
			System.out.println("Username is : "+LoginController.getLogin().getUsername());
			Appointment appointment;
			
			appointment = Adao.viewBookedAppointment(LoginController.getLogin().getUsername());
			
			try{
				Stage stage = new Stage();
							FXMLLoader loader = new FXMLLoader(getClass().getResource("/fp/itmd523/view/ShowBookedAppointment.fxml"));
					        AnchorPane anchorPane = loader.load();
					        // Get the Controller from the FXMLLoader
					        BasePatientController controller = loader.getController();
					        // Set data in the controller
					        controller.setLbl_doctor_id(appointment.getDoctor_id());
					        controller.setLbl_apt_date(appointment.getAppmt_dt());
					        controller.setLbl_apt_time(appointment.getTime());
					        controller.setLbl_purpose(appointment.getPurpose());
					        Scene scene = new Scene(anchorPane);
					        stage.setScene(scene);
					        stage.show();
				
				}catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Error occured in view: ");
						e.printStackTrace();
					}
				
		}
		
		//-----------------------------------------------------------------//

		public void gotoLogin(ActionEvent a)
		{		
			
			System.out.println("In PatientHomeController --> gotoPatientHomeController ");
						 
			try{
				Stage stage = new Stage();
							FXMLLoader loader = new FXMLLoader(getClass().getResource("/fp/itmd523/view/Login.fxml"));
					        AnchorPane anchorPane = loader.load();
					        Scene scene = new Scene(anchorPane);
					        stage.setScene(scene);
					        stage.show();
				
				}catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Error occured in view: ");
						e.printStackTrace();
					}
			}
		
		//----------------------------------------------------------------//
		
/*		@FXML
		private Label lbl_no_history;
		
		@FXML
		private Label lbl_appointment_dt;
		
		@FXML
		private Label lbl_doctor_name;
		
		@FXML
		private TextArea txtarea_prescription; */
		
		public void viewHistory(ActionEvent a)
		{		
			
			System.out.println("In PatientHomeController --> viewHistory ");
			AppointmentDAO Adao = new AppointmentDAO();
			
			String status = Adao.checkAppointmentHistory(LoginController.getLogin().getUsername());
			
			if(status == "No")
			{
				try{
					Stage stage = new Stage();
								FXMLLoader loader = new FXMLLoader(getClass().getResource("/fp/itmd523/view/ViewPatientHistory.fxml"));
						        AnchorPane anchorPane = loader.load();
						        // Get the Controller from the FXMLLoader
						        BasePatientController controller = loader.getController();
						        // Set data in the controller
						        controller.setLbl_no_history("No history found!");
						        Scene scene = new Scene(anchorPane);
						        stage.setScene(scene);
						        stage.show();
					
					}catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("Error occured in view: ");
							e.printStackTrace();
						}
			}
			
			else
			{
			String historyDetails[] = new String[3];
			historyDetails =  Adao.showAppointmentHistory(LoginController.getLogin().getUsername());
			
			System.out.println("historyDetails 0: "+historyDetails[0]+" historyDetails 1: "+historyDetails[1]);
			
			//lbl_appointment_dt.setText("none");
			//lbl_doctor_name.setText("none");
			//txtarea_prescription.setText(historyDetails[3]);
						 
			try{
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fp/itmd523/view/ViewPatientHistory.fxml"));
		        AnchorPane anchorPane = loader.load();
		        // Get the Controller from the FXMLLoader
		        BasePatientController controller = loader.getController();
		        // Set data in the controller
		        controller.setLbl_appointment_dt(historyDetails[0]);
		        controller.setLbl_doctor_name(historyDetails[1]);
		        controller.setTxtarea_prescription(historyDetails[2]);
		        Scene scene = new Scene(anchorPane);
		        stage.setScene(scene);
		        stage.show();
				
				}catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Error occured in view: ");
						e.printStackTrace();
					}
			}
		}
		

}
