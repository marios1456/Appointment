package de.hessen.mcht.appointments.Entities.Doctor;

import de.hessen.mcht.appointments.Entities.Doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
