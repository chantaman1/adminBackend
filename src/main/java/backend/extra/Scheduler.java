package backend.extra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import backend.services.UsersService;

@Component
public class Scheduler implements Runnable {
	@Autowired
	private UsersService usersService;
	
	@Scheduled(fixedRate = 60000)
	public void run() {
		//se llama al/los metodos que se quieren ejecutar cada X tiempo.
	}
}
