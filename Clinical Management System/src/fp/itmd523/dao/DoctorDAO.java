package fp.itmd523.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fp.itmd523.model.Patient;
import fp.itmd523.model.Prescription;

public class DoctorDAO extends DataSource{

	public Prescription viewPreviousPrescription(String patient_id, String doctor_id) {
		Prescription prescription = null;
		
		String query = "select t.patient_ID, t.doctor_ID, t.prescription, t.comments, t.prescription_date from 510labs.cms_prescription t inner join ( select patient_ID, max(prescription_date) as MaxDate from 510labs.cms_prescription  where patient_ID = ? and doctor_ID = ? group by patient_ID, doctor_ID) tm on t.patient_ID = tm.patient_id and t.prescription_date = tm.MaxDate";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, patient_id);
            statement.setString(2, doctor_id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
            	prescription = new Prescription(
            			resultSet.getString("patient_id"),
            			resultSet.getString("doctor_id"),
            			resultSet.getString("prescription"),
            			resultSet.getString("comments"),
            			resultSet.getString("prescription_date")
            			);
            	
            }
        } catch(SQLException e){
            System.out.println("Error Finding User (findUser)" + e);
        }
        return prescription;
    }
	
	//----------------------------------------------------------------------------//
	
	public void addPrescription(String patient_id, String doctor_id, String prescription, String comments, String date) throws SQLException
	{
		System.out.println("inside doctorDAO addPRes");
		System.out.println("p_id: "+patient_id+ "d_id: "+doctor_id+"pres: "+prescription+" com: "+comments+"date: "+date);
		String query = "INSERT INTO 510labs.cms_prescription (patient_ID, doctor_ID, prescription, comments, prescription_date) VALUES ('"+ patient_id+"', '"+doctor_id+"', '"+prescription+"', '"+comments+"', '"+date+"');";
    	Statement statement = connection.createStatement(); 
        
    	statement.executeUpdate(query);
    	System.out.println("Prescription is added");
    	
		String query1 = " delete from 510labs.cms_appointment where patient_id = '"+ patient_id+"' ;";
		Statement statement1 = connection.createStatement();
    	statement1.executeUpdate(query1);
    	System.out.println("Appointment is deleted");
		
	}
	
	
}
