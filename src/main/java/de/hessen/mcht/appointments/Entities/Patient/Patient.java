package de.hessen.mcht.appointments.Entities.Patient;

import de.hessen.mcht.appointments.Entities.Apointment.Appointment;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity(name = "patient")
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue
    private Long amka;

    @OneToMany(mappedBy = "patient",
                cascade = CascadeType.ALL,
                orphanRemoval = true ,
                fetch = FetchType.LAZY)
    private List<Appointment> apointments;

    private String forname;
    private String familyName;

    private LocalDate dob;

    public Patient() {
    }

    public Long getAmka() {
        return amka;
    }

    public void setAmka(Long amka) {
        this.amka = amka;
    }

    public List<Appointment> getApointments() {
        return apointments;
    }

    public void setApointments(List<Appointment> apointments) {
        this.apointments = apointments;
    }

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient tag = (Patient) o;
        return Objects.equals(amka, tag.amka);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amka);
    }


}
