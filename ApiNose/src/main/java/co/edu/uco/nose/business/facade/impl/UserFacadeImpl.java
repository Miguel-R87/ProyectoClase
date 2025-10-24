package co.edu.uco.nose.business.facade.impl;

import co.edu.uco.nose.business.facade.UserFacade;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.data.dao.factory.DAOFactory;

public final class UserFacadeImpl implements UserFacade {
	private DAOFactory daoFactory;
	
	public UserFacadeImpl() {
		daoFactory=DAOFactory.getFactory();
	}
public void registerNewUserInformation(final UserDTO userDto) {
	var daoFactory=DAOFactory.getFactory();
	var business=new UserBussinesImpl(daoFactory);

	try {
		daoFactory.initTransaction():
			var domain=UserDTOAssembler.getUserDTOAssembler().toDomain(userDto);
			business.registerNewUserInformation(domain);
			
			daoFactory.commitTransaction();
		daoFactory.commitTransaction();
	}catch (final NoseException exception) {
	daoFactory.rollbackTransaction();
	throw exception;
}catch (final Exception exception) {
	daoFactory.rollbackTransaction();

	
	var userMsg="";
	var techMsg="";
	
	throw NoseException.create(exception,userMessage,technicalMessage)
}finally{
{daoFactory.closeConnection();
	
	}
	
	}
	public void dropUserInformation(UUID id) {


	

}
