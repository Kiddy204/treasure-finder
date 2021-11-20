package ma.Kiddy204.treasurefinder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	public void setId(Long id) {
		this.id = id;
	}

	private String username;
	private String mail;
	private String password;
	
	
	public User() {
		super();
	}
	
	public User(String username, String mail, String password) {
		super();
		this.username = username;
		this.mail = mail;
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", mail=" + mail + "]";
	}
	
	
	

}
