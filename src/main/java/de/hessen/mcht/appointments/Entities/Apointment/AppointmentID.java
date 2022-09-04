package de.hessen.mcht.appointments.Entities.Apointment;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class AppointmentID implements Serializable {
    @Column(name = "doctorId")
    private Long doctorId;
    @Column(name = "amka")
    private Long amka;
    @Column(name = "date")
    private LocalDateTime date;


    public AppointmentID() {
    }

    public AppointmentID(Long doctorId, Long amka, LocalDateTime date) {
        this.doctorId = doctorId;
        this.amka = amka;
        this.date = date;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getAmka() {
        return amka;
    }

    public void setAmka(Long amka) {
        this.amka = amka;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        AppointmentID that = (AppointmentID) o;
        return Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(amka, that.amka) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, amka, date);
    }

}
