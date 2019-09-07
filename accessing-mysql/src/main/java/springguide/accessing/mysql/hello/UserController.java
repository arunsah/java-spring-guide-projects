package springguide.accessing.mysql.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	private UserRepo userRepo;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewUser(@RequestParam String name,
			@RequestParam String email) {
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		
		userRepo.save(user);
		return "saved record for " + name;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers(){
		return userRepo.findAll();
	}
	
}
