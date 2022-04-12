
package fst.lsi.authentification;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fst.lsi.entities.Message;
import fst.lsi.entities.UserModel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("connexion")
public class AuthController {

	@Autowired
	private userRepository UserRepository;
	

	@Autowired
	private UserService userService;
	

	@Autowired
	private AuthenticationManager authenticationManager ;
	

	@Autowired
	private jwtutil jwtUtil ;
	@CrossOrigin(origins = "http://localhost:4200")

	@PostMapping(value="/subs")
	private String subscribe (@RequestBody AuthenticationRequest authenticationRequest){
		
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		String email = authenticationRequest.getEmail();
		
		UserModel userModel = new UserModel();
		userModel.setUsername(username);
		userModel.setPassword(password);
		userModel.setEmail(email);
		
		try {
			UserRepository.save(userModel);
			
		} catch (Exception e) {

			return "erreur";
		}
	
		
		
		return "Success subscribtion";
	}
	
	
	@GetMapping("/home")
	public String home() {
		return "hello everyone";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/auth")
    private Message authentification (@RequestBody AuthenticationRequest  authenticationRequest){
		
		Message msg=new Message();
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		} catch (Exception e) {
			 msg.setMessage("Erreur authentication");
		return	msg;
		
		}
		UserDetails loadedUser = userService.loadUserByUsername(username);
        String generetedToken= jwtUtil.generateToken(loadedUser);
		 msg.setMessage(generetedToken);
		 msg.setUser(loadedUser);
		return msg;
	}
}
