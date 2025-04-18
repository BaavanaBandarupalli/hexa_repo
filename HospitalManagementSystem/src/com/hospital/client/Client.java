package com.hospital.client;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.hospital.dao.HospitalServiceDaoImpl;
import com.hospital.dao.IHospitalServiceDao;
import com.hospital.model.Appointment;

public class Client {
	public static void main(String[] args) {
		//Appointment appointment1 = new Appointment(1, 101, 201, LocalDate.of(2025, 4, 20), "Regular Checkup");
        //Appointment appointment2 = new Appointment(2, 102, 202, LocalDate.of(2025, 4, 21), "Dental Checkup");
        //Appointment appointment3 = new Appointment(3, 103, 203, LocalDate.of(2025, 4, 23), "Eye Checkup");
        //Appointment appointment4 = new Appointment(4, 104, 204, LocalDate.of(2025, 4, 25), "Blood Test");
        Appointment appointment5 = new Appointment(6, 106, 206, LocalDate.of(2025, 4, 26), "Regular Checkup");
      
        
        IHospitalServiceDao hospitalService = new HospitalServiceDaoImpl();
        
//        hospitalService.scheduleAppointment(appointment1);
//        hospitalService.scheduleAppointment(appointment2);
//        hospitalService.scheduleAppointment(appointment3);
//        hospitalService.scheduleAppointment(appointment4);
        hospitalService.scheduleAppointment(appointment5);
        
        Appointment appointment = hospitalService.getAppointmentById(2);
        if (appointment != null) {
            System.out.println("Appointment Found ");
            System.out.println("Appointment Details");
            System.out.println("Appointment ID: " + appointment.getAppointmentId());
            System.out.println("Patient ID: " + appointment.getPatientId());
            System.out.println("Appointment Date: " + Date.valueOf(appointment.getAppointmentDate()));
            System.out.println("Appointment Description: " + appointment.getDescription());
        } else {
            System.out.println("Appointment not found!");
        }
        
        hospitalService.updateAppointment("Regular Checkup", 2);
        
        hospitalService.cancelAppointment(4);
        
        List<Appointment> appointments = hospitalService.getAppointmentsForPatient(102);
        for (Appointment appoint : appointments) {
            System.out.println(appoint);
        }
        
        appointments = hospitalService.getAppointmentsForPatient(108);
        for (Appointment appoint : appointments) {
            System.out.println(appoint);
        }
	}
}
