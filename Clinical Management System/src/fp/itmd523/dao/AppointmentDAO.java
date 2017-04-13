package fp.itmd523.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import fp.itmd523.controller.LoginController;
import fp.itmd523.model.Appointment;
import fp.itmd523.model.Patient;

public class AppointmentDAO extends DataSource{

	
	public String searchAppointment(String patient_id, String doctor_id, String date, String time) {
		String isAvailable = "";
		
		String query = "select patient_id from 510labs.cms_appointment where patient_id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, patient_id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
            	isAvailable = "alreadyBooked";
            }
        }
            catch(SQLException e){
                System.out.println("Error Finding User (findUserInfo)" + e);
            }
		
        if(isAvailable == "alreadyBooked")
        {
        	return isAvailable;
        }
        else
        {
		String query1 = "select * from 510labs.cms_appointment where doctor_id = ? and dateofappointment = ? and time = ?;";
        try(PreparedStatement statement1 = connection.prepareStatement(query1)){
            statement1.setString(1, doctor_id);
            statement1.setString(2, date);
            statement1.setString(3, time);
            ResultSet resultSet1 = statement1.executeQuery();
            if(resultSet1.next()) {
            	isAvailable = "noAvailable";
            }
            else
            {
            	isAvailable = "yesAvailable";
            }
            System.out.println("searchAppointment status : "+ isAvailable);
        } catch(SQLException e){
            System.out.println("Error Finding User (findUserInfo)" + e);
        }
        
        return isAvailable;
        }
    }
	
	
	//------------------------------------------------------------------------------------------------//
	
	
	public void bookAppointment(String doctor_id, String date, String time, String purpose) {
		String patient_id = LoginController.getLogin().getUsername();

		String query = "insert into 510labs.cms_appointment values ('"+ patient_id +"','" + doctor_id+ "', '"+ date+"', '"+ time+"','"+ purpose+"');";
		try{
        	Statement statement = connection.createStatement(); 
            
        	statement.executeUpdate(query);
        	//ResultSet resultSet = statement.executeQuery();
        	System.out.println("Appointment is booked");
            
            
        } catch(SQLException e){
            System.out.println("Error booking an appointment" + e);
        }
            
        }
    
	
	//--------------------------------------------------------------------------------------------------------//
	
	public Appointment viewBookedAppointment(String patient_id) {
		Appointment appointment = new Appointment("","", "", "", "");
		
		String query = "select * from 510labs.cms_appointment where patient_id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, patient_id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
            	appointment = new Appointment(
            			resultSet.getString("patient_ID"),
            			resultSet.getString("doctor_id"),
            			resultSet.getString("dateofappointment"),
            			resultSet.getString("time"),
            			resultSet.getString("purpose")
            			);
            	
            }
            System.out.println("appoint data: "+appointment);
        } catch(SQLException e){
            System.out.println("Error Finding User (findUser)" + e);
        }
        return appointment;
    }
	
	//-------------------------------------------------------------------------------------------------------//
	
	public void cancelAppointment(String patient_id) {

		String query = "delete from 510labs.cms_appointment where patient_id = '"+ patient_id+"';";
		try{
        	Statement statement = connection.createStatement(); 
            
        	statement.executeUpdate(query);
        	//ResultSet resultSet = statement.executeQuery();
        	System.out.println("Appointment is cancelled");
            
            
        } catch(SQLException e){
            System.out.println("Error calceling an appointment" + e);
        }
            
        }
	
	//-------------------------------------------------------------------------------------------------------//
	
	public String checkAppointmentHistory( String patient_id)
	{
		String appmt_history = "No";
		String query = "select * from 510labs.cms_prescription where patient_id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, patient_id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
            	appmt_history = "Yes";            	
            }
            System.out.println("appoint data: "+appmt_history);
        } catch(SQLException e){
            System.out.println("Error Finding checkAppointmentHistory" + e);
        }
        return appmt_history;
		
	}
	
	//-----------------------------------------------------------------------------------------------------//
	
	public String[] showAppointmentHistory(String patient_id)
	{
		String[] historyList = new String[3];
		
		String query = "select t.patient_ID, t.doctor_ID, t.prescription, t.comments, t.prescription_date from 510labs.cms_prescription t inner join ( select patient_ID, max(prescription_date) as MaxDate from 510labs.cms_prescription where patient_ID = ?  group by patient_ID ) tm on t.patient_ID = tm.patient_id and t.prescription_date = tm.MaxDate";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, patient_id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
            	        historyList[0] = resultSet.getString("prescription_date");
            	        historyList[1] = resultSet.getString("doctor_ID");
            	        historyList[2] = resultSet.getString("prescription");
            }
            System.out.println("data history: "+ historyList.toString());    
        } catch(SQLException e){
            System.out.println("Error Finding checkAppointmentHistory" + e);
        }
        
        
        String query1 = "select dname from 510labs.cms_doctor where doctor_ID = ?;";
        try(PreparedStatement statement = connection.prepareStatement(query1)){
            statement.setString(1, historyList[1]);
            ResultSet resultSet1 = statement.executeQuery();
            if(resultSet1.next()) {
            	historyList[1] = resultSet1.getString("dname");            	
            }
            System.out.println("doc name: "+ historyList[1]);
        } catch(SQLException e){
            System.out.println("Error Finding checkAppointmentHistory" + e);
        }

	return historyList;
	}
	
	//-----------------------------------------------------------------------//
	

	
	//----------------------------------------------//
	

}

