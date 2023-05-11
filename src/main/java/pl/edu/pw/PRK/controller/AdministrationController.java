package pl.edu.pw.PRK.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.PRK.entity.Hall;
import pl.edu.pw.PRK.entity.Movie;
import pl.edu.pw.PRK.service.HallService;
import pl.edu.pw.PRK.service.MovieService;

@Controller
@RequestMapping("/administration")
public class AdministrationController {

    private MovieService movieService;
    private HallService hallService;

    @Autowired
    public AdministrationController(MovieService movieService, HallService hallService) {
        this.movieService = movieService;
        this.hallService = hallService;
    }
    //-------------menu
    @GetMapping("/menu")
    public String showMenu(){
        return "administration/administrationMenu";
    }

    //----------------movies
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
        movieService.save(movie);
        return "redirect:/administration/menu/movies";
    }

    @GetMapping("/menu/movies/showFormForUpdateMovie")
    public String showFormForUpdateMovie(@RequestParam("movieId") int movieId, Model model){
        Movie movie = movieService.findById(movieId);
        model.addAttribute("movie",movie);
        return "administration/showFormForUpdateMovie";
    }

    @GetMapping("/menu/movies/deleteMovie")
    public String deleteMovie(@RequestParam("movieId") int movieId){
        movieService.deleteById(movieId);
        return "redirect:/administration/menu/movies";
    }

    //----------------cinema halls
    @GetMapping("/menu/cinemaHalls")
    public String showCinemaHalls(Model model){
        model.addAttribute("halls", hallService.findAllSortedByNumberAsc());
        return "administration/cinemaHalls";
    }

    @GetMapping("/menu/cinemaHalls/showFormForAddHall")
    public String showFormForAddCinemaHall(Model model){
        model.addAttribute("hall",new Hall());
        return "administration/addNewCinemaHall";
    }

    @PostMapping("/menu/cinemaHalls/saveHall")
    public String saveCinemaHall(@ModelAttribute("hall") Hall hall){
        hallService.save(hall);
        return "redirect:/administration/menu/cinemaHalls";
    }

    @GetMapping("/menu/cinemaHalls/showFormForUpdateHall")
    public String showFormForUpdateHall(@RequestParam("hallId") int hallId, Model model){
        Hall hall = hallService.findById(hallId);
        model.addAttribute("hall",hall);
        return "administration/showFormForUpdateHall";
    }

    @GetMapping("/menu/cinemaHalls/deleteHall")
    public String deleteHall(@RequestParam("hallId") int hallId){
        hallService.deleteById(hallId);
        return "redirect:/administration/menu/cinemaHalls";
    }

}
