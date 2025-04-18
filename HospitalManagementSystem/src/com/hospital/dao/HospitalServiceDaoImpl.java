package com.hospital.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hospital.exception.PatientNumberNotFoundException;
import com.hospital.model.Appointment;
import com.hospital.util.DbConnectionUtil;

public class HospitalServiceDaoImpl implements IHospitalServiceDao {
	static Connection connection;

	@Override
	public Appointment getAppointmentById(int appointmentId) {
		// TODO Auto-generated method stub
		connection = DbConnectionUtil.getConnection();
		
        String sql = "SELECT * FROM Appointment WHERE appointmentId = ?";
        
        PreparedStatement statement = null;
        Appointment appointment = null;
        
        try {
        	statement = connection.prepareStatement(sql);
        	
            statement.setInt(1, appointmentId);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {  
                   int appointmentid = rs.getInt("appointmentId");
                   int patientid = rs.getInt("patientId");
                   int doctorid = rs.getInt("doctorId");
                   LocalDate appointmentdate = rs.getDate("appointmentDate").toLocalDate();
                   String desc = rs.getString("description");
                   
                   appointment = new Appointment(appointmentid, patientid, doctorid, appointmentdate, desc);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
		} finally {
			try {
				 statement.close();
				 connection.close();
			 } catch (SQLException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }	
		}
		return appointment;
	}

	@Override
	public void scheduleAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		connection = DbConnectionUtil.getConnection();
		
        String sql = "INSERT INTO Appointment (appointmentId, patientId, doctorId, appointmentDate, description) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement statement = null;
        try {
        	statement = connection.prepareStatement(sql);
        	
            statement.setInt(1, appointment.getAppointmentId());
            statement.setInt(2, appointment.getPatientId());
            statement.setInt(3, appointment.getDoctorId());
            statement.setDate(4, Date.valueOf(appointment.getAppointmentDate()));
            statement.setString(5, appointment.getDescription());

            statement.execute();
            System.out.println("Appointment scheduled successfully.");
        } catch (SQLException e) {
        	// TODO Auto-generated catch block
     	    e.printStackTrace();
            System.out.println("Error scheduling appointment");
        } finally {
        	try {
			    statement.close();
			    connection.close();
		    } catch (SQLException e) {
		 	     // TODO Auto-generated catch block
		 	     e.printStackTrace();
		    }
        }
	}

	@Override
	public void updateAppointment(String description, int appointmentId) {
		// TODO Auto-generated method stub
        connection = DbConnectionUtil.getConnection();
		
		String sql = "UPDATE Appointment SET description = ? WHERE appointmentId = ?";

	        PreparedStatement statement = null;
	        try  {
	        	statement = connection.prepareStatement(sql);
	        	
	        	statement.setString(1, description);
	        	statement.setInt(2, appointmentId);
	        	
	        	statement.execute();
	        	System.out.println("Appointment updated successfully.");
	        } catch (SQLException e) {
	    	    // TODO Auto-generated catch block
	     	    e.printStackTrace();
		    } finally {
			    try {
				    statement.close();
				    connection.close();
			    } catch (SQLException e) {
			 	     // TODO Auto-generated catch block
			 	     e.printStackTrace();
			    }
		    }
	}

	@Override
	public void cancelAppointment(int appointmentId) {
		// TODO Auto-generated method stub
        connection = DbConnectionUtil.getConnection();
		
		String sql = "DELETE FROM Appointment WHERE appointmentId = ?";

	        PreparedStatement statement = null;
	        try  {
	        	statement = connection.prepareStatement(sql);
	        	
	        	statement.setInt(1, appointmentId);
	        	
	        	statement.execute();
	        	System.out.println("Appointment deleted successfully.");
	        } catch (SQLException e) {
	    	    // TODO Auto-generated catch block
	     	    e.printStackTrace();
		    } finally {
			    try {
				    statement.close();
				    connection.close();
			    } catch (SQLException e) {
			 	     // TODO Auto-generated catch block
			 	     e.printStackTrace();
			    }
		    }
	}

	@Override
	public List<Appointment> getAppointmentsForPatient(int patientId) {
		// TODO Auto-generated method stub
		connection = DbConnectionUtil.getConnection();
		
        String sql = "SELECT * FROM Appointment WHERE patientId = ?";
        
        PreparedStatement statement = null;
        List<Appointment> appointments = new ArrayList<>();
        try  {
        	statement = connection.prepareStatement(sql);
        	
            statement.setInt(1, patientId);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                    int appointmentid = rs.getInt("appointmentId");
                    int patientid = rs.getInt("patientId");
                    int doctorid = rs.getInt("doctorId");
                    LocalDate appointmentdate = rs.getDate("appointmentDate").toLocalDate();
                    String desc = rs.getString("description");
                    Appointment appointment = new Appointment(appointmentid, patientid, doctorid, appointmentdate, desc);
                    appointments.add(appointment);
            }
            if (appointments.isEmpty()) {
                throw new PatientNumberNotFoundException("No appointments found for patient ID: " + patientId);
            }
        } catch (PatientNumberNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
				 statement.close();
				 connection.close();
			 } catch (SQLException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }
        }
        return appointments;
	}

	@Override
	public List<Appointment> getAppointmentsForDoctor(int doctorId) {
		// TODO Auto-generated method stub
		return null;
	}

}
