package de.hessen.mcht.appointments.Entities.Apointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/appointment/")
public class AppointmentController {
    private AppointmentService as;
    @Autowired
    public AppointmentController(AppointmentService as) {
        this.as = as;
    }

//    @GetMapping(path = "appointments/")
//    public List<Appointment> getAppointments(){
//        return as.getAppointments();
//    }

    @GetMapping(path = "appointments/")
    public String getAppointments(Model model){
        List<Appointment> appointments = as.getAppointments();
        model.addAttribute("something","this is comming from the controler");
        model.addAttribute("appointments", appointments);
        System.out.println(appointments.size());
        return "appointment";
    }

    @GetMapping(path = "newAppointment/")
    public String newAppointment(Model model){
        return "newAppointment";
    }

    @GetMapping(path = "login/")
    public String login(Model model){
        return "loginForm";
    }

    @PostMapping(path = "new/")
    public void newAppointment(@RequestBody Appointment appointment){
        as.newAppointment(appointment);
    }
}
