package pl.edu.pw.PRK.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Movies")
public class Movies {

	// define fields

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="Name")
	private String name;

	@Column(name="Description")
	private String description;

	@Column(name="Duration")
	private int duration;


	// define constructors

	public Movies() {

	}

	public Movies(String name, String description, int duration) {
		this.name = name;
		this.description = description;
		this.duration = duration;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
		
}











