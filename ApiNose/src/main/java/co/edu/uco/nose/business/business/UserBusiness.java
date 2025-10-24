package co.edu.uco.nose.business.business;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.business.domain.UserDomain;
public interface UserBusiness {
	void registerNewUserInformation(UserDomain userDomain);
	var id=UUIDHelper.registerNewUserInformation(UserDomain userDomain){
		var userEntity=userEntityAssembler.getUserEntityAssembler().toEntity
	}
	var userEntity=UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain)
	void dropUserInformation(UUID id);
	void updateUserInformation(UUID id,UserDomain userDomain);
	List<UserDomain> findAllUsers();
	List<UserDomain> findAllUsers();
	List<UserDomain> findUsersByFilter(UserDomain userFilters);
	UserDomain findSpecificUser(UUID id);
	void confirmMobilNumber(UUID id);
	void confirmEmail(UUID id);
	void sendMobileNumberConfirmation(UUID id);
	void sendEmailConfirmation(UUID id);
	
}
