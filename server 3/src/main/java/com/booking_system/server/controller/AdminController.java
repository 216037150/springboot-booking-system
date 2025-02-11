package com.booking_system.server.controller;



import com.booking_system.server.AppointmentStatus;
import com.booking_system.server.model.Appointment;
import com.booking_system.server.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin/appointment")
public class AdminController {

    @Autowired
    private AppointmentService appointmentService;

    @PutMapping("/{id}/accept")
    public ResponseEntity<String> acceptAppointment(@PathVariable Long id) {
        Optional<Appointment> updatedAppointment = appointmentService.updateStatus(id, AppointmentStatus.ACCEPTED);
        return updatedAppointment.isPresent() ?
                ResponseEntity.ok("Appointment accepted") :
                ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<String> completeAppointment(@PathVariable Long id) {
        Optional<Appointment> updatedAppointment = appointmentService.updateStatus(id, AppointmentStatus.COMPLETED);
        return updatedAppointment.isPresent() ?
                ResponseEntity.ok("Appointment completed") :
                ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<String> cancelAppointment(@PathVariable Long id) {
        Optional<Appointment> updatedAppointment = appointmentService.updateStatus(id, AppointmentStatus.CANCELED);
        return updatedAppointment.isPresent() ?
                ResponseEntity.ok("Appointment canceled") :
                ResponseEntity.notFound().build();
    }
}
