import { Routes } from '@angular/router';
import { AppointmentComponent } from './components/appointment/appointment.component';
import { HomeComponent } from './components/home/home.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'appointment', component: AppointmentComponent },
  { path: '**', redirectTo: '', pathMatch: 'full' }
];
