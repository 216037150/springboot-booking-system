package com.booking_system.server.model;

import com.booking_system.server.AppointmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private String doctorName;
    private String email;
    private LocalDateTime appointmentDate;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status = AppointmentStatus.PENDING;


    public Appointment() {}


    public Appointment(String patientName, String doctorName, String email, LocalDateTime appointmentDate) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.email = email;
        this.appointmentDate = appointmentDate;
        this.status = AppointmentStatus.PENDING;
    }
    
}
