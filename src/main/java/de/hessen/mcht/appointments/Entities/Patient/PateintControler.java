package de.hessen.mcht.appointments.Entities.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient/")
public class PateintControler {
    private PatientService ps;
    @Autowired
    public PateintControler(PatientService ps) {
        this.ps = ps;
    }
    @GetMapping(path = "patients/")
    public List<Patient> getPatients(){
        return ps.getPatients();
    }
    @PostMapping(path = "new/")
    public void newPatient(@RequestBody Patient patient){
        ps.newPatient(patient);
    }
}
