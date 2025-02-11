package com.booking_system.server.controller;




import com.booking_system.server.AppointmentStatus;
import com.booking_system.server.dto.AppointmentRequest;
import com.booking_system.server.model.Appointment;
import com.booking_system.server.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patient/appointment")
public class PatientController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity<Appointment> bookAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        // Convert AppointmentRequest DTO to Appointment entity
        Appointment appointment = new Appointment();
        appointment.setPatientName(appointmentRequest.getPatientName());
        appointment.setDoctorName(appointmentRequest.getDoctorName());
        appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());
        appointment.setEmail(appointmentRequest.getEmail());

        // Set default status to PENDING when booking
        appointment.setStatus(AppointmentStatus.PENDING);

        // Save the appointment using the service layer
        Appointment createdAppointment = appointmentService.bookAppointment(appointment);

        // Return the created appointment as response
        return ResponseEntity.ok(createdAppointment);
    }
}


