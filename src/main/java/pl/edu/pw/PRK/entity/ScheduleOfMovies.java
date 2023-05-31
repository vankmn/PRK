package pl.edu.pw.PRK.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="schedule_of_movies")
public class ScheduleOfMovies {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="date")
	private Date date;

	@Column(name="time")
	private Time time;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="movie_id")
	private Movie movie_id;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="hall_ID")
	private Hall hall_id;


	// define constructors

	public ScheduleOfMovies() {

	}

	public ScheduleOfMovies(Date date, Time time) {
		this.date = date;
		this.time = time;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Movie getMovie_id() {
		return movie_id;
	}

	public String getMovieName(){
		return movie_id.getName();
	}

	public int getHallNumber(){
		return hall_id.getNumber();
	}
	public void setMovie_id(Movie movie_id) {
		this.movie_id = movie_id;
	}

	public Hall getHall_id() {
		return hall_id;
	}

	public void setHall_id(Hall hall_id) {
		this.hall_id = hall_id;
	}
		
}











