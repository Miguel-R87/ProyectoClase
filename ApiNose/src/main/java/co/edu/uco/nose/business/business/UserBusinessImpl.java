package co.edu.uco.nose.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.data.dao.factory.DAOFactory;

public class UserBusinessImpl implements UserBusiness {

	@Override
	public void registerNewUserInformation(UserDomain userDomain) {
private DAOFactory daoFactory;
public 	UserBusinessImpl(final DAOFactory daoFactory) {
	this.daoFactory=daoFactory;
	
	//1.Validar que lainformacion sea consistente a nivel de tipo de dato,longitud,obligatoriedad,formato,rango,reglas propias del objeto
   //2.validar que no exista previamente otro usuario con el mismo tipo y numero de identificacion
	//3.validar que no exista previamente otro usuario con el mismo correo electronico
	//4-validar que no exista previamente otro usuario con el mismo numero de telefono celular
	//5generar un identificador para el nuevo usuario,
	}

	@Override
	public void dropUserInformation(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserInformation(UUID id, UserDomain userDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserDomain> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDomain> findUsersByFilter(UserDomain userFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDomain findSpecificUser(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
