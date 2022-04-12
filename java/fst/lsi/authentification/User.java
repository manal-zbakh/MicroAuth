package fst.lsi.authentification;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class User implements Serializable , UserDetails{
	
	
	    private Integer userId;
	    private String username;
	    private String password;
	    private String email;
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		}
		public Integer getUserId() {
			return userId;
		}
		public String getEmail() {
			return email;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public void setEmail(String email) {
			this.email= email;
		}
		
		
		
	    
	    
}
