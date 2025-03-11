import { Component } from '@angular/core';
import { NgIf, NgFor } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AppointmentService } from '../../appointment.service';

@Component({
  selector: 'app-appointment',
  standalone: true,
  imports: [NgIf, NgFor, FormsModule, HttpClientModule, RouterModule],
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css'],
  providers: [AppointmentService]
})
export class AppointmentComponent {
  appointment = {
    patientName: '',
    doctorName: '',
    email: '',
    appointmentDate: '',
    appointmentTime: ''
  };

  message: string = '';

  constructor(private appointmentService: AppointmentService) {}

  bookAppointment() {
    console.log('Appointment Data:', this.appointment);

    if (
      this.appointment.patientName &&
      this.appointment.doctorName &&
      this.appointment.email &&
      this.appointment.appointmentDate &&
      this.appointment.appointmentTime
    ) {
      const fullDateTime = `${this.appointment.appointmentDate}T${this.appointment.appointmentTime}:00`;

      const appointmentData = {
        ...this.appointment,
        appointmentDate: fullDateTime,
      };

      this.appointmentService.bookAppointment(appointmentData).subscribe({
        next: (response) => {
          this.message = `Appointment booked with ID: ${response.id}`;
        },
        error: () => {
          this.message = 'Failed to book appointment';
        }
      });
    } else {
      this.message = 'Please fill in all fields.';
    }
  }
}
