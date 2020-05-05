package acres.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acres.dto.UserInfo;
import acres.elastic.UserDocumentRepo;

@Service
public class UserAuthServiceImpl implements UserAuthService{
	
	@Autowired	UserDocumentRepo uRep;
	
	@Override
	public Optional<UserInfo> getUserDetails(String username) {
		return uRep.findById(username);
	}

	@Override
	public boolean isUserPresent(String username) {
		return uRep.existsById(username);
	}

	@Override
	public void registerUser(UserInfo user) {
		uRep.save(user);
	}

}
