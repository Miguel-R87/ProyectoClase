package co.edu.uco.nose.data.dao.factory.postgresql;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.IdTypeDAO;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.CityPostgreSqlDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.CountryPostgreSqlDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.IdTypePostgreSqlDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.StatePostgreSqlDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.UserPostgreSqlDAO;
import co.edu.uco.nose.data.dao.factory.DAOFactory;

public final  class PostgreSqlDaoFactory extends DAOFactory {
	
	public PostgreSqlDaoFactory() {
		openConnection();
	}
	@Override
    protected void openConnection() {
        try {
            // 🧠 Conexión a la base de datos postgres
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres"; // tu usuario
            String password = "miguelo74"; // cámbiala

            this.connection = DriverManager.getConnection(url, user, password);

            // 👇 Indicar que quieres trabajar dentro del esquema "proyectoclase"
            this.connection.createStatement().execute("SET search_path TO proyectoclase");
            
	}catch(final SQLException exception) {
		var userMessage="";
		var technicalMessage="";
		throw NoseException.create(exception,userMessage,technicalMessage);
	}catch(final Exception exception) {
		var userMessage="";
		var technicalMessage="";
		throw NoseException.create(exception,userMessage,technicalMessage);
	}
		
	}
	
	@Override
	public CityDAO getCityDAO() {
		// TODO Auto-generated method stub
		return new CityPostgreSqlDAO(connection);
	}

	@Override
	public CountryDAO getCountryDAO() {
		// TODO Auto-generated method stub
		return new CountryPostgreSqlDAO(connection);
	}

	@Override
	public IdTypeDAO getIdTypeDAO() {
		// TODO Auto-generated method stub
		return new IdTypePostgreSqlDAO(connection);
	}

	@Override
	public StateDAO getStateDAO() {
		// TODO Auto-generated method stub
		return new StatePostgreSqlDAO(connection);
	}

	@Override
	public UserDAO getUserDAO() {
		// TODO Auto-generated method stub
		return new UserPostgreSqlDAO(connection);
	}


}
