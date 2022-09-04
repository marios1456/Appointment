package de.hessen.mcht.appointments.Entities.Apointment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentID> {
}
