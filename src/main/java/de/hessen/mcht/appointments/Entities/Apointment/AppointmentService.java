package de.hessen.mcht.appointments.Entities.Apointment;

import de.hessen.mcht.appointments.Entities.Doctor.Doctor;
import de.hessen.mcht.appointments.Entities.Doctor.DoctorRepository;
import de.hessen.mcht.appointments.Entities.Patient.Patient;
import de.hessen.mcht.appointments.Entities.Patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    private AppointmentRepository ar;
    private PatientRepository pr;
    private DoctorRepository dr;
    @Autowired
    public AppointmentService(AppointmentRepository ar, PatientRepository pr, DoctorRepository dr) {
        this.ar = ar;
        this.pr = pr;
        this.dr = dr;
    }

    public List<Appointment> getAppointments(){

        return ar.findAll();
    }
    public void newAppointment(Appointment appointment){
        Optional<Patient> patient = pr.findById(appointment.getId().getAmka());
        Optional<Doctor> doctor = dr.findById(appointment.getId().getDoctorId());
        if (patient.isPresent() && doctor.isPresent()){
            appointment.setPatient(patient.get());
            appointment.setDoctor(doctor.get());
            ar.save(appointment);
        } else if (patient.isEmpty()) {
            throw new IllegalStateException("Patient not found");
        } else if (doctor.isEmpty()) {
            throw new IllegalStateException("Doctor not found");
        }

    }

}
