package pl.edu.pw.PRK.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Users")
public class Users {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Email")
	private String email;
	
		
	// define constructors
	
	public Users() {
		
	}

	public Users(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String firstName) {
		this.username = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String lastName) {
		this.password = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// define toString

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + username + ", lastName=" + password + ", email=" + email + "]";
	}
		
}











