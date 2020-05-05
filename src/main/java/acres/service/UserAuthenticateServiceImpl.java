//package acres.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import acres.dao.UserJpaRepository;
//import acres.dto.UserInfo;
//
//@Service
//public class UserAuthenticateServiceImpl implements UserAuthenticationService {
//
//	@Autowired UserJpaRepository userRep;
//	
//	@Override
//	public boolean registerNewUser(UserInfo user) {
//		return userRep.save(user) != null;
//	}
//
//	@Override
//	public boolean authenticateUser(UserInfo user) {
//		return userRep.findByUsername(user.getUsername()).isPresent();
//	}
//
//	@Override
//	public Optional<UserInfo> retrieveUser(UserInfo user) {
//		return userRep.findByUsername(user.getUsername());
//	}
//
//}
