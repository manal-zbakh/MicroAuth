package fst.lsi.authentification;

import org.springframework.context.annotation.ComponentScan;

import lombok.Data;

@Data
public class AuthenticationResponse {

	private String response;

	public AuthenticationResponse(String response) {
		super();
		this.response = response;
	}
	
	
}
