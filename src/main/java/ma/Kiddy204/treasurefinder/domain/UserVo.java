package ma.Kiddy204.treasurefinder.domain;

public class UserVo {
	private Long id;
	private String username;
	private String mail;
	private String password;
	
	public UserVo() {
		super();
	}
	public UserVo(Long id, String username, String mail, String password) {
		super();
		this.id = id;
		this.username = username;
		this.mail = mail;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	
	
}
