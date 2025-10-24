package co.edu.uco.nose.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.dto.UserDto;

public interface UserFacade {
	public interface UserBusiness {
		
		void registerNewUserInformation(UserDto userDto);
		void dropUserInformation(UUID id);
		void updateUserInformation(UUID id,UserDto userDomain);;
		List<UserDto> findAllUsers();
		List<UserDto> findUsersByFilter(UserDto  userFilters);
		UserDto findSpecificUser(UUID id);
	}
}
