import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Appointment {
  id?: number;
  patientName: string;
  doctorName: string;
  email: string;
  appointmentDate: string;
  status?: string;
}

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  private apiUrl = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) {}

  bookAppointment(appointment: Appointment): Observable<Appointment> {
    return this.http.post<Appointment>(`${this.apiUrl}/patient/appointment/book`, appointment);
  }

  acceptAppointment(id: number): Observable<string> {
    return this.http.put<string>(`${this.apiUrl}/admin/appointment/${id}/accept`, {});
  }

  completeAppointment(id: number): Observable<string> {
    return this.http.put<string>(`${this.apiUrl}/admin/appointment/${id}/complete`, {});
  }

  cancelAppointment(id: number): Observable<string> {
    return this.http.put<string>(`${this.apiUrl}/admin/appointment/${id}/cancel`, {});
  }
}
