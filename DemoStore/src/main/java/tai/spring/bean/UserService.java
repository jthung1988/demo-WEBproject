package tai.spring.bean;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepo;
	
	public User getUser(String username) {
		return userRepo.findByUsername(username).get(0);
	}
	
	public List<User> getAll(){
		List<User> userlist = userRepo.findAll();
		for(User user :userlist) {
			System.out.println(user.getUsername()+":"+user.getPassword());
		}
		return userRepo.findAll();
	}
	
	public User putUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username).get(0);
		return user;
	}
}
