package backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import backend.models.Users;
import backend.repositories.UsersRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class UsersService{
  @Autowired
  private UsersRepository userRepository;

  public Users create(String firstName, String lastName, String email, String password, String role, String urlPic) {
	  LocalTime localTime = LocalTime.now();
	  LocalDate localDate = LocalDate.now();
	  String date = localDate.format(DateTimeFormatter.ofPattern("EEEE dd, MM, yyyy"));
	  String time = localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	  return userRepository.save(new Users(firstName, lastName, email, password, role, date, time, urlPic));
  }
  
  public List<Users> getAll(){
	  return userRepository.findAll();
  }
  
  public Users getByEmail(String email) {
	  return userRepository.findByEmail(email);
  }
  
  public List<Users> getById(String _id) {
	  return userRepository.findBy_id(_id);
  }
  
  public Users updatePassword(String email, String password) {
	  Users user = userRepository.findByEmail(email);
	  user.setPassword(password);
	  return userRepository.save(user);
  }

  public Users updateProfilePic(String email, String pic){
  	Users user = userRepository.findByEmail(email);
  	if(user != null){
  		user.setProfilePic(pic);
  		return userRepository.save(user);
	}
  	return null;
  }
}
