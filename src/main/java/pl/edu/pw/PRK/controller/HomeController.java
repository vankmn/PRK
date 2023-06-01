package pl.edu.pw.PRK.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.pw.PRK.service.ScheduleOfMoviesService;

@Controller
public class HomeController {

    private ScheduleOfMoviesService scheduleOfMoviesService;

    @Autowired
    public HomeController(ScheduleOfMoviesService scheduleOfMoviesService) {
        this.scheduleOfMoviesService = scheduleOfMoviesService;
    }

    @GetMapping("/home")
    public String showHome(Model model){

        //send authorities to main page
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("userName", authentication.getName());
        if(authentication.getName().equals("anonymousUser")){
            model.addAttribute("userAuthorities","none");
        }else {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("userAuthorities", userDetails.getAuthorities());
        }

        //show all scheduled movies
        model.addAttribute("scheduledMovies", scheduleOfMoviesService.findAll());

        return "home";
    }

}
