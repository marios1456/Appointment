package de.hessen.mcht.appointments.Entities.Apointment;

import de.hessen.mcht.appointments.Entities.Doctor.Doctor;
import de.hessen.mcht.appointments.Entities.Patient.Patient;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Apointment")
@Table(name = "Apointment")
public class Appointment {

    @EmbeddedId
    private AppointmentID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("doctorId")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("amka")
    private Patient patient;

    private String description;

//    @Column(name = "date")
//    private LocalDate date;

    public Appointment(AppointmentID id, Doctor doctor, Patient patient, String description) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.description =description;
    }

    public Appointment() {
    }
    //Getters and setters omitted for brevity

    public AppointmentID getId() {
        return id;
    }

    public void setId(AppointmentID id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Appointment that = (Appointment) o;
        return Objects.equals(doctor, that.doctor) &&
                Objects.equals(patient, that.patient);// &&
                //Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctor, patient);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", patient=" + patient +
                '}';
    }
}