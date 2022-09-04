package de.hessen.mcht.appointments.Entities.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository dr;
    @Autowired
    public DoctorService(DoctorRepository dr) {
        this.dr = dr;
    }
    public List<Doctor> getDoctors(){
        return dr.findAll();
    }

    public void newDoctor(Doctor doctor){
        dr.save(doctor);
    }
}
