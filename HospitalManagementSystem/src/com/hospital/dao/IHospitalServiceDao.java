package com.hospital.dao;

import java.util.List;

import com.hospital.model.Appointment;

public interface IHospitalServiceDao {
	Appointment getAppointmentById(int appointmentId);
	void scheduleAppointment(Appointment appointment);
    void updateAppointment(String description, int appointmentId);
    void cancelAppointment(int appointmentId);
    List<Appointment> getAppointmentsForPatient(int patientId);
    List<Appointment> getAppointmentsForDoctor(int doctorId);
}
