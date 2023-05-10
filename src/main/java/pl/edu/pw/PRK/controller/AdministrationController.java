package pl.edu.pw.PRK.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.PRK.entity.Movie;
import pl.edu.pw.PRK.service.MovieService;

@Controller
@RequestMapping("/administration")
public class AdministrationController {

    private MovieService movieService;

    @Autowired
    public AdministrationController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/menu")
    public String showMenu(){


        return "administration/administrationMenu";
    }

    @GetMapping("/menu/movies")
    public String showMovies(Model model){
        model.addAttribute("movies", movieService.findAllSortedByNameAsc());
        return "administration/movies";
    }

    @GetMapping("/menu/movies/showFormForAddMovie")
    public String showFormForAddMovie(Model model){
        model.addAttribute("movie",new Movie());
        return "administration/addNewMovie";
    }

    @PostMapping("/menu/movies/saveMovie")
    public String saveMovie(@ModelAttribute("movie") Movie movie){
        System.out.println(movie.getName()  );
        System.out.println(movie.getId());
//        movie.setId(3);
        movieService.save(movie);
        return "redirect:/administration/menu/movies";
    }
}
