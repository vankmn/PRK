package pl.edu.pw.PRK.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.PRK.entity.Hall;
import pl.edu.pw.PRK.entity.Movie;
import pl.edu.pw.PRK.entity.Seat;
import pl.edu.pw.PRK.entity.Ticket;
import pl.edu.pw.PRK.service.HallService;
import pl.edu.pw.PRK.service.MovieService;
import pl.edu.pw.PRK.service.SeatService;
import pl.edu.pw.PRK.service.TicketService;

@Controller
@RequestMapping("/administration")
public class AdministrationController {

    private final MovieService movieService;
    private final HallService hallService;
    private final TicketService ticketService;
    private final SeatService seatService;

    @Autowired
    public AdministrationController(MovieService movieService, HallService hallService, TicketService ticketService, SeatService seatService) {
        this.movieService = movieService;
        this.hallService = hallService;
        this.ticketService = ticketService;
        this.seatService = seatService;
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
        return "administration/movie/movies";
    }

    @GetMapping("/menu/movies/showFormForAddMovie")
    public String showFormForAddMovie(Model model){
        model.addAttribute("movie",new Movie());
        return "administration/movie/addNewMovie";
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
        return "administration/movie/showFormForUpdateMovie";
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
        return "administration/hall/cinemaHalls";
    }

    @GetMapping("/menu/cinemaHalls/showFormForAddHall")
    public String showFormForAddCinemaHall(Model model){
        model.addAttribute("hall",new Hall());
        return "administration/hall/addNewCinemaHall";
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
        return "administration/hall/showFormForUpdateHall";
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
        return "administration/ticket/tickets";
    }

    @GetMapping("/menu/tickets/showFormForAddTicket")
    public String showFormForAddTicket(Model model){
        model.addAttribute("ticket",new Ticket());
        return "administration/ticket/addNewTicket";
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
        return "administration/ticket/showFormForUpdateTicket";
    }

    @GetMapping("/menu/tickets/deleteTicket")
    public String deleteTicket(@RequestParam("ticketId") int ticketId){
        ticketService.deleteById(ticketId);
        return "redirect:/administration/menu/tickets";
    }

    //----------------seats
    @GetMapping("/menu/seats")
    public String showSeats(Model model){
        model.addAttribute("seats", seatService.findAllSortedByHallIdAsc());
        return "administration/seat/seats";
    }

    @GetMapping("/menu/seats/showFormForAddSeat")
    public String showFormForAddSeat(Model model){
        model.addAttribute("seat",new Seat());
        return "administration/seat/addNewSeat";
    }

    @PostMapping("/menu/seats/saveSeat")
    public String saveSeat(@ModelAttribute("seat") Seat seat){
        System.out.println(seat.getId());
        System.out.println(seat.getNumber());
        System.out.println(seat.getRow());
        System.out.println(seat.getOccupied());
        System.out.println(seat.getHallId());
        seatService.save(seat);
        return "redirect:/administration/menu/seats";
    }

    @GetMapping("/menu/seats/showFormForUpdateSeat")
    public String showFormForUpdateSeat(@RequestParam("seatId") int seatId, Model model){
        Seat seat = seatService.findById(seatId);
        model.addAttribute("seat",seat);
        return "administration/seat/showFormForUpdateSeat";
    }

    @GetMapping("/menu/seats/deleteSeat")
    public String deleteSeat(@RequestParam("seatId") int seatId){
        seatService.deleteById(seatId);
        return "redirect:/administration/menu/seats";
    }
}
