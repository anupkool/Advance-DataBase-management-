package fp.itmd523.controller;

import fp.itmd523.dao.DoctorDAO;
import fp.itmd523.dao.PatientDAO;
import fp.itmd523.model.Patient;
import fp.itmd523.model.Prescription;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DoctorHomeController {

	@FXML
	private TextField txt_patient_id;
	
	@FXML
	private Label lbl_search_patient_alert;
	
	public void gotoDoctorSearchPatient(ActionEvent a)
	{
		try{
			Stage stage = new Stage();
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/fp/itmd523/view/DoctorSearchPatient.fxml"));
				        AnchorPane anchorPane = loader.load();
				        Scene scene = new Scene(anchorPane);
				        stage.setTitle("Search Patient");
				        stage.setScene(scene);
				        stage.show();
			
			}catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error occured in view: ");
					e.printStackTrace();
				}
	}
	
	//--------------------------------------//
	
	public void DoctorSearchPatientDetails(ActionEvent a)
	{
		System.out.println(" DoctorHomeController --> DoctorSearchPatientDetails ");
		
		String patient_id = txt_patient_id.getText();
		if(patient_id.isEmpty())
		{
			lbl_search_patient_alert.setText("Please enter the patient id.");
			return;
		}
		
		PatientDAO Pdao = new PatientDAO();
		DoctorDAO Ddao = new DoctorDAO();
		
		System.out.println("Patient ID is : "+ patient_id);
		Patient patient;
		Prescription prescription;
		
		patient = Pdao.findPatientInfo(patient_id);
		prescription = Ddao.viewPreviousPrescription(patient_id, LoginController.getLogin().getUsername());
		
		if(patient == null)
		{
			lbl_search_patient_alert.setText(" Invalid patient id.");
			return;
		}

		if(prescription == null)
		{
		try{
			Stage stage = new Stage();
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/fp/itmd523/view/DoctorPatientDetails.fxml"));
				        AnchorPane anchorPane = loader.load();

				        // Get the Controller from the FXMLLoader
				        BaseDoctorController controller = loader.getController();
				        // Set data in the controller
				        controller.setLbl_fname(patient.getF_name());
				        controller.setLbl_lname(patient.getL_name());
				        controller.setLbl_gender(patient.getGender());
				        controller.setLbl_dob(patient.getDob());
				        controller.setLbl_email_id(patient.getE_mail());
				        controller.setLbl_mobile_no(patient.getMobile());
				        controller.setLbl_blood_group(patient.getBlood_group());
				        controller.setLbl_weight(patient.getWeight());
				        
				        if(prescription == null)
				        {
				        controller.setLbl_no_history("No previous history found!");
				        }
				        Scene scene = new Scene(anchorPane);
				        stage.setTitle("Search Patient Details");
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
			try{
				Stage stage = new Stage();
							FXMLLoader loader = new FXMLLoader(getClass().getResource("/fp/itmd523/view/DoctorPatientDetails.fxml"));
					        AnchorPane anchorPane = loader.load();

					        // Get the Controller from the FXMLLoader
					        BaseDoctorController controller = loader.getController();
					        // Set data in the controller
					        controller.setLbl_fname(patient.getF_name());
					        controller.setLbl_lname(patient.getL_name());
					        controller.setLbl_gender(patient.getGender());
					        controller.setLbl_dob(patient.getDob());
					        controller.setLbl_email_id(patient.getE_mail());
					        controller.setLbl_mobile_no(patient.getMobile());
					        controller.setLbl_blood_group(patient.getBlood_group());
					        controller.setLbl_weight(patient.getWeight());
					        controller.setLbl_last_visited_date(prescription.getPrescription_date());
					        controller.setTxtarea_pres_given(prescription.getPrescription());
					        controller.setTxtarea_comments_given(prescription.getComments());
					        
					        controller.setPatient_id(patient.getPatient_id());
					        
					        Scene scene = new Scene(anchorPane);
					        stage.setTitle("Patient Details");
					        stage.setScene(scene);
					        stage.show();
				
				}catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Error occured in view: ");
						e.printStackTrace();
				}
		}
	
	}
	
	//---------------------------------------------//
	
	public void gotoDoctorHome(ActionEvent a)
	{
		try{
			Stage stage = new Stage();
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/fp/itmd523/view/DoctorHome.fxml"));
				        AnchorPane anchorPane = loader.load();
				        Scene scene = new Scene(anchorPane);
				        stage.setScene(scene);
				        stage.setTitle("Doctor Home");
				        stage.show();
			
			}catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error occured in view: ");
					e.printStackTrace();
				}
	}
	
	//-------------------------------------------------//
	
	public void viewAppointments(ActionEvent a)
	{
		
		
		
		try{
			Stage stage = new Stage();
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/fp/itmd523/view/DoctorViewAppointment.fxml"));
				        AnchorPane anchorPane = loader.load();
				        Scene scene = new Scene(anchorPane);
				        stage.setScene(scene);
				        stage.setTitle("Doctor Home");
				        stage.show();
			
			}catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error occured in view: ");
					e.printStackTrace();
				}
	}
	
	//----------------------------------------------------//
	public void gotoLogin(ActionEvent a)
	{
		try{
			Stage stage = new Stage();
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/fp/itmd523/view/Login.fxml"));
				        AnchorPane anchorPane = loader.load();
				        Scene scene = new Scene(anchorPane);
				        stage.setScene(scene);
				        stage.setTitle("Doctor Home");
				        stage.show();
			
			}catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error occured in view: ");
					e.printStackTrace();
				}
	}
	
		
}
