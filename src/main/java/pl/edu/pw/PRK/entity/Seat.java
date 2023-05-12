package pl.edu.pw.PRK.entity;

import jakarta.persistence.*;

@Entity
@Table(name="seats")
public class Seat {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="column_nr")
	private int number;

	@Column(name="row_nr")
	private int row;

	@Column(name = "is_occupied")
	private boolean occupied;

	@Column(name = "hall_id")
	private int hallId;

	// define constructors

	public Seat() {
		this.occupied =false;
	}

	public Seat(int id, int number, int row, int hallId) {
		this.id = id;
		this.number = number;
		this.row = row;
		this.hallId = hallId;
		this.occupied =false;
	}


	public Seat(int number, int row, int hallId) {
		this.number = number;
		this.row = row;
		this.hallId=hallId;
		this.occupied =false;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public boolean getOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public int getHallId() {
		return hallId;
	}

	public void setHallId(int hallId) {
		this.hallId = hallId;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", number=" + number + ", row=" + row +", is occupied="+ occupied +", hallId="+hallId+"]";
	}

}











