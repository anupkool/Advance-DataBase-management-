package fp.itmd523.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fp.itmd523.dao.DoctorDAO;
import fp.itmd523.model.Prescription;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BaseDoctorController {

	String patient_id;
	
	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}
	
	//------------------//
	

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
	
	//---------------------//
	
	@FXML
	private Label lbl_no_appointment;
	
	@FXML
	private Label lbl_no_history;
	
	@FXML
	private Label lbl_last_visited_date;
	
	@FXML
	private TextArea txtarea_pres_given;
	
	@FXML
	private TextArea txtarea_comments_given;
	
	@FXML
	private TextArea txtarea_new_pres;
	
	@FXML
	private TextArea txtarea_new_comments;
	
	@FXML
	private Label lbl_pres_alert;
	
	//---------------------//
	
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
	
	//---------------------------//
	
	public void setLbl_no_history(String lbl_no_history) {
		this.lbl_no_history.setText(lbl_no_history);
	}
	
	public void setLbl_last_visited_date(String lbl_last_visited_date) {
		this.lbl_last_visited_date.setText(lbl_last_visited_date);
	}

	public void setTxtarea_pres_given(String txtarea_pres_given) {
		this.txtarea_pres_given.setText(txtarea_pres_given);
	}

	public void setTxtarea_comments_given(String txtarea_comments_given) {
		this.txtarea_comments_given.setText(txtarea_comments_given);
	}

	public void setTxtarea_new_pres(String txtarea_new_pres) {
		this.txtarea_new_pres.setText(txtarea_new_pres);
	}

	public void setTxtarea_new_comments(String txtarea_new_comments) {
		this.txtarea_new_comments.setText(txtarea_new_comments);
	}
	
	//---------------------------//
	




	public void backtoDoctorSearchPatient(ActionEvent a)
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


	//--------------------------------------------------//
	
	public void addPrescription(ActionEvent a) throws SQLException
	{
		
		Date today = new Date();
		String str_today;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		str_today = dateFormat.format(today);
		
		if( txtarea_new_pres.getText().isEmpty() || txtarea_new_comments.getText().isEmpty())
		{
			lbl_pres_alert.setText("Prescription and Comments can not be empty.");
			return;
		}
		
		System.out.println("p_id "+getPatient_id()+" d_id "+ LoginController.getLogin().getUsername() + " new pres "+txtarea_new_pres.getText()+ "new comment: "+txtarea_new_comments.getText()+" today: "+str_today);
		
		DoctorDAO Ddao = new DoctorDAO();
		Ddao.addPrescription(getPatient_id(), LoginController.getLogin().getUsername(), txtarea_new_pres.getText(), txtarea_new_comments.getText(), str_today);
		
		try{
			Stage stage = new Stage();
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/fp/itmd523/view/DoctorHome.fxml"));
				        AnchorPane anchorPane = loader.load();
				        Scene scene = new Scene(anchorPane);
				        stage.setTitle("Doctor Home");
				        stage.setScene(scene);
				        stage.show();
			
			}catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error occured in view: ");
					e.printStackTrace();
				}
	}


	
}
