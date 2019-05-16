package backend.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Users {
	@Id
	public String _id;
	public String firstName;
	public String lastName;
	public String email;
	public String password;
	public String role;
	public String creationDate;
	public String creationTime;
	public boolean loginActive;
	public boolean activatedAccount;
	
	public Users(String firstName, String lastName, String email, String password, String role, String creationDate, String creationTime, boolean loginActive, boolean activatedAccount) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.creationDate = creationDate;
		this.creationTime = creationTime;
		this.loginActive = loginActive;
		this.activatedAccount = activatedAccount;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public boolean isLoginActive() {
		return loginActive;
	}

	public void setLoginActive(boolean loginActive) {
		this.loginActive = loginActive;
	}

	public boolean isActivatedAccount() {
		return activatedAccount;
	}

	public void setActivatedAccount(boolean activatedAccount) {
		this.activatedAccount = activatedAccount;
	}
	
}