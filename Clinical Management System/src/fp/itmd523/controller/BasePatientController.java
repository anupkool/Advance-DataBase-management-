package fp.itmd523.controller;



import fp.itmd523.dao.AppointmentDAO;
import fp.itmd523.dao.PatientDAO;
import fp.itmd523.model.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BasePatientController {

	@FXML
	private Label lbl_fname;
	
	@FXML
	private Label lbl_lname;
	
	@FXML
	private Label lbl_gender;
	
	@FXML
	private Label lbl_dob;

	@FXML
	private Label lbl_email_id;
	
	@FXML
	private Label lbl_mobile_no;
	
	@FXML
	private Label lbl_blood_group;
	
	@FXML
	private Label lbl_weight;
	
	//-------------
	
	@FXML
	private TextField txt_fname;
	
	@FXML
	private TextField txt_lname;

	@FXML
	private TextField txt_email_id;
	
	@FXML
	private TextField txt_mobile_no;

	
	@FXML
	private TextField txt_weight;

	@FXML
	private Label lbl_update_patient_alert;

	public void setLbl_fname(String lbl_fname) {
		this.lbl_fname.setText(lbl_fname);
	}
	
	public void setLbl_lname(String lbl_lname) {
		this.lbl_lname.setText(lbl_lname);
	}

	public void setLbl_gender(String lbl_gender) {
		this.lbl_gender.setText(lbl_gender);
	}

	public void setLbl_dob(String lbl_dob) {
		this.lbl_dob.setText(lbl_dob);
	}

	public void setLbl_email_id(String lbl_email_id) {
		this.lbl_email_id.setText(lbl_email_id);
	}

	public void setLbl_mobile_no(String lbl_mobile_no) {
		this.lbl_mobile_no.setText(lbl_mobile_no);
	}

	public void setLbl_blood_group(String lbl_blood_group) {
		this.lbl_blood_group.setText(lbl_blood_group);
	}

	public void setLbl_weight(String lbl_weight) {
		this.lbl_weight.setText(lbl_weight);
	}
	
	//-----------------
	
	public void setTxt_fname(String txt_fname) {
		this.txt_fname.setText(txt_fname);
	}

	public void setTxt_lname(String txt_lname) {
		this.txt_lname.setText(txt_lname);
	}

	public void setTxt_email_id(String txt_email_id) {
		this.txt_email_id.setText(txt_email_id);
	}

	public void setTxt_mobile_no(String txt_mobile_no) {
		this.txt_mobile_no.setText(txt_mobile_no);
	}

	public void setTxt_weight(String txt_weight) {
		this.txt_weight.setText(txt_weight);
	}

	
	//-----------------------------------//
	
	@FXML
	private Label lbl_no_history;
	
	@FXML
	private Label lbl_appointment_dt;
	
	@FXML
	private Label lbl_doctor_name;
	
	@FXML
	private TextArea txtarea_prescription; 
	
	
	public void setLbl_no_history(String lbl_no_history) {
		this.lbl_no_history.setText(lbl_no_history);
	}

		public void setLbl_appointment_dt(String lbl_appointment_dt) {
			this.lbl_appointment_dt.setText(lbl_appointment_dt);
		}
			
		public void setLbl_doctor_name(String lbl_doctor_name) {
				this.lbl_doctor_name.setText(lbl_doctor_name);
		}
				
		public void setTxtarea_prescription(String txtarea_prescription) {
					this.txtarea_prescription.setText(txtarea_prescription);
		}		
	
	
	
	
	// Back Button points to PatientHome
	public void BacktoPatientHome(ActionEvent a)
	{		
			try{
			
				Stage stage = new Stage();	
					 Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("/fp/itmd523/view/PatientHome.fxml"));
					 Scene scene = new Scene(root);
						//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setTitle("Patient Home");	
						stage.setScene(scene);
						stage.show();
			
			}catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error occured in view: ");
					e.printStackTrace();
				}
			}
	//-----------------------------------------------------------//
	
	public void BaseUpdatePatientInfo(ActionEvent a)
	{		
		
		String username = LoginController.getLogin().getUsername();
		String fname = txt_fname.getText();
		String lname = txt_lname.getText();
		String email_id = txt_email_id.getText();
		String mobile_no = txt_mobile_no.getText();
		String weight = txt_weight.getText();
		
		System.out.println("In BasePatientController --> BaseUpdatePatientInfo");	
		
		if(fname.isEmpty() || lname.isEmpty() || email_id.isEmpty() || mobile_no.isEmpty() || weight.isEmpty())
		{
			lbl_update_patient_alert.setText(" Empty fields are not accepted! ");
		}
		
		
		else{
		
		PatientDAO dao = new PatientDAO();
		dao.updatePatientInfo(username, fname, lname, email_id, mobile_no, weight);
		
		
			
			try{
			
				Stage stage = new Stage();	
					 Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("/fp/itmd523/view/PatientHome.fxml"));
					 Scene scene = new Scene(root);
						//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setTitle("Patient Home");	
						stage.setScene(scene);
						stage.show();
			
			}catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error occured in view: ");
					e.printStackTrace();
				}
			}
	}
	
	//----------------------------------------------------------------------------------------//
	
	
	@FXML
	private Label lbl_apt_date;
	
	@FXML
	private Label lbl_apt_time;
	
	@FXML
	private Label lbl_doctor_id;
	
	@FXML
	private TextField txt_purpose;
	
	@FXML
	private Label lbl_book_apt;
	
	@FXML
	private Label lbl_purpose;
	


	public void setLbl_apt_date(String lbl_apt_date) {
		this.lbl_apt_date.setText(lbl_apt_date);
	}

	public void setLbl_apt_time(String lbl_apt_time) {
		this.lbl_apt_time.setText(lbl_apt_time);
	}

	public void setLbl_doctor_id(String lbl_doctor_id) {
		this.lbl_doctor_id.setText(lbl_doctor_id);
	}
	
	public void setLbl_purpose(String lbl_purpose) {
		this.lbl_purpose.setText(lbl_purpose);
	}

	public void bookAppointment(ActionEvent a)
	{
		String purpose = txt_purpose.getText();
		String doctor_id = lbl_doctor_id.getText();
		String date = lbl_apt_date.getText();
		String time = lbl_apt_time.getText();
		
		if(txt_purpose.getText().isEmpty())
		{
			lbl_book_apt.setText("Enter purpose of scheduling an appointment");
			return;
		}
		else
		{
		AppointmentDAO Adao = new AppointmentDAO();
		Adao.bookAppointment(doctor_id, date, time, purpose);
		
		try{
			
			Stage stage = new Stage();	
				 Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("/fp/itmd523/view/PatientHome.fxml"));
				 Scene scene = new Scene(root);
					//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					stage.setTitle("Patient Home");	
					stage.setScene(scene);
					stage.show();
		
		}catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Error occured in view: ");
				e.printStackTrace();
			}
		}

	}
	
	//--------------------------------------------------------------------------------------------//
	
	
	public void cancelAppointment(ActionEvent a)
	{		
			
			AppointmentDAO Adao = new AppointmentDAO();
			Adao.cancelAppointment(LoginController.getLogin().getUsername());
			try{
			
				Stage stage = new Stage();	
					 Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("/fp/itmd523/view/PatientHome.fxml"));
					 Scene scene = new Scene(root);
						//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setTitle("Patient Home");	
						stage.setScene(scene);
						stage.show();
			
			}catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error occured in view: ");
					e.printStackTrace();
				}
			}
	
	//--------------------------------------------------------------------------------------------//
	
	// Back Button points to SearchBookAppointment
	public void BacktoSearchBookAppointment(ActionEvent a)
	{		
			try{
			
				Stage stage = new Stage();	
					 Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("/fp/itmd523/view/SearchBookAppointment.fxml"));
					 Scene scene = new Scene(root);
						//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setTitle("Search / Book Appointment");	
						stage.setScene(scene);
						stage.show();
			
			}catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error occured in view: ");
					e.printStackTrace();
				}
			}

	//-----------------------------------------------------------------------------//
	
	
}
