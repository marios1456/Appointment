package de.hessen.mcht.appointments.Entities.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor/")
public class DoctorControler {
    private final DoctorService ds;

    @Autowired
    public DoctorControler(DoctorService ds) {
        this.ds = ds;
    }

    @GetMapping(path = "doctors/")
    public List<Doctor> getDoctors(){
        return ds.getDoctors();
    }

    @PostMapping(path = "new/")
    public void newDoctor(@RequestBody Doctor doctor){
        ds.newDoctor(doctor);
    }

}
