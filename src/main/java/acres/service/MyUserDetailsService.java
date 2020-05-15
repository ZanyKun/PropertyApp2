//package acres.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import acres.dto.UserInfo;
//import acres.elastic.UserDocumentRepo;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService{
//	
//	@Autowired	UserDocumentRepo userRepo;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<UserInfo> user = userRepo.findById(username);
//		if(!user.isPresent()) {
//			throw new UsernameNotFoundException("Username was not located in the database.");
//		}
//		UserInfo retUser = user.get();
//		
//		return new User(retUser.getUsername(), retUser.getPassword1(), retUser.getAuthorities());
//	}
//}
