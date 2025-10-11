package co.edu.uco.nose.data.dao.factory.Sqlserver;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.IdTypeDAO;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.CitySqlServerDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.CountrySqlServerDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.IdTypeSqlServerDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.StateSqlServerDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.UserSqlServerDAO;
import co.edu.uco.nose.data.dao.factory.DAOFactory;

public final class SqlServerDAOFactory extends  DAOFactory{
	
	@Override

	protected void openConnection() {
		this.connection =DriverManager.getConnection("\"jdbc:postgresql://localhost:5432/nose\", \"postgres\", \"admin\"");
	}catch (final SQLException exception){
	var userMessage="";
	 var technicalMessage="";
	 throw NoseException.create(exception,userMessage,technicalMessage);
  }catch (final Exception exception){
	  var userMessage="";
	  var technicalMessage="";
	  throw NoseException.create(exception,userMessage,technicalMessage);
  }
		
	}
	@Override
	public CityDAO getCityDAO() {
		// TODO Auto-generated method stub
		return new CitySqlServerDAO(connection);
	}

	@Override
	public CountryDAO getCountryDAO() {
		return new CountrySqlServerDAO(connection);
		// TODO Auto-generated method stub
	
	}

	@Override
	public IdTypeDAO getIdTypeDAO() {
		return new IdTypeSqlServerDAO(connection);
		// TODO Auto-generated method stub
		
	}

	@Override
	public StateDAO getStateDAO() {
		return new StateSqlServerDAO(connection);
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDAO getUserDAO() {
		// TODO Auto-generated method stub
		return new UserSqlServerDAO(connection);
	}

	

}
