package de.hessen.mcht.appointments.Entities.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository pr;
    @Autowired
    public PatientService(PatientRepository pr) {
        this.pr = pr;
    }

    public List<Patient> getPatients(){
        return pr.findAll();
    }

    public void newPatient(Patient patient){
        pr.save(patient);
    }
}
