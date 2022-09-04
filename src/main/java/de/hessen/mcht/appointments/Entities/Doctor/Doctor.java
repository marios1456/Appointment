package de.hessen.mcht.appointments.Entities.Doctor;

import de.hessen.mcht.appointments.Entities.Apointment.Appointment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "doctor")
@Table(name = "doctor")
//@NaturalIdCache
//@Cache(
//        usage = CacheConcurrencyStrategy.READ_WRITE
//)
public class Doctor {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "doctor",
                cascade = CascadeType.ALL,
                orphanRemoval = true ,
                fetch = FetchType.LAZY)
    private List<Appointment> apointments = new ArrayList<>();

    private String forname;
    private String familyName;
    private String medicalSpecialty;

    public Doctor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMedicalSpecialty() {
        return medicalSpecialty;
    }

    public void setMedicalSpecialty(String medicalSpecialty) {
        this.medicalSpecialty = medicalSpecialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor tag = (Doctor) o;
        return Objects.equals(id, tag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", forname='" + forname + '\'' +
                ", familyName='" + familyName + '\'' +
                ", medicalSpecialty='" + medicalSpecialty + '\'' +
                '}';
    }
}
