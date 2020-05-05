package acres.service;

import java.util.Optional;

import acres.dto.UserInfo;

public interface UserAuthService {
	Optional<UserInfo> getUserDetails(String username);
	boolean isUserPresent(String username);
	void registerUser(UserInfo user);
}
