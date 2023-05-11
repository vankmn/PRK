package pl.edu.pw.PRK.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.PRK.entity.Hall;
import pl.edu.pw.PRK.entity.Movie;
import pl.edu.pw.PRK.entity.Ticket;
import pl.edu.pw.PRK.service.HallService;
import pl.edu.pw.PRK.service.MovieService;
import pl.edu.pw.PRK.service.TicketService;

@Controller
@RequestMapping("/administration")
public class AdministrationController {

    private MovieService movieService;
    private HallService hallService;
    private TicketService ticketService;

    @Autowired
    public AdministrationController(MovieService movieService, HallService hallService, TicketService ticketService) {
        this.movieService = movieService;
        this.hallService = hallService;
        this.ticketService = ticketService;
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

    //----------------tickets
    @GetMapping("/menu/tickets")
    public String showTickets(Model model){
        model.addAttribute("tickets", ticketService.findAllSortedByNumberAsc());
        return "administration/tickets";
    }

    @GetMapping("/menu/tickets/showFormForAddTicket")
    public String showFormForAddTicket(Model model){
        model.addAttribute("ticket",new Ticket());
        return "administration/addNewTicket";
    }

    @PostMapping("/menu/tickets/saveTicket")
    public String saveTicket(@ModelAttribute("ticket") Ticket ticket){
        ticketService.save(ticket);
        return "redirect:/administration/menu/tickets";
    }

    @GetMapping("/menu/tickets/showFormForUpdateTicket")
    public String showFormForUpdateTicket(@RequestParam("ticketId") int ticketId, Model model){
        Ticket ticket = ticketService.findById(ticketId);
        model.addAttribute("ticket",ticket);
        return "administration/showFormForUpdateTicket";
    }

    @GetMapping("/menu/tickets/deleteTicket")
    public String deleteTicket(@RequestParam("ticketId") int ticketId){
        ticketService.deleteById(ticketId);
        return "redirect:/administration/menu/tickets";
    }
}
