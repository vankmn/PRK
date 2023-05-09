package pl.edu.pw.PRK.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.pw.PRK.service.MovieService;

@org.springframework.stereotype.Controller
public class Controller {

    private MovieService movieService;

    @Autowired
    public Controller(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String showHome(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        model.addAttribute("userName", authentication.getName());
        model.addAttribute("userAuthorities",userDetails.getAuthorities());

        model.addAttribute("movies", movieService.findAllSortedByNameAsc());

        return "home";
    }
}
