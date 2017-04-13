package fp.itmd523.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fp.itmd523.model.Login;
import fp.itmd523.model.Patient;

public class PatientDAO extends DataSource {
	
	public Patient findPatientInfo(String patient_id) {
		Patient patient = null;
		
		String query = "select * from 510labs.cms_patient where patient_id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, patient_id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
            	patient = new Patient(
            			resultSet.getString("patient_ID"),
            			resultSet.getString("fname"),
            			resultSet.getString("lname"),
            			resultSet.getString("Gender"),
            			resultSet.getString("DOB"),
            			resultSet.getString("e_mail"),
            			resultSet.getString("Mobile"),
            			resultSet.getString("BloodGroup"),
            			resultSet.getString("Weight")
            			);
            	
            }
        } catch(SQLException e){
            System.out.println("Error Finding User (findUser)" + e);
        }
        return patient;
    }
	
	//-----------------------------------------------------------------------------------------//
	
	public void updatePatientInfo(String patient_id, String fname, String lname, String email_id, String mobile_no, String weight)
	{
		String query = "update 510labs.cms_patient set fname = '" + fname + "', lname = '"+ lname+"', e_mail = '"+ email_id+"', mobile = '"+ mobile_no +"', weight = '"+ weight +"' where patient_id = '"+ patient_id +"'";
        try{
        	Statement statement = connection.createStatement(); 
            
        	statement.executeUpdate(query);
        	System.out.println("Patient is updated");
            
            
        } catch(SQLException e){
            System.out.println("Error Updating Patient (updatePatientInfo)" + e);
        }
		
	}
	
}

