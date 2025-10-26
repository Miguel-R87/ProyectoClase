package co.edu.uco.nose.data.dao.entity.postgresql;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.StateEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class   StatePostgreSqlDAO extends SqlConnection implements StateDAO {

	public StatePostgreSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<StateEntity> findAll() {
		 final var sql = new StringBuilder();
		    final var states = new ArrayList<StateEntity>(); // 
		
		var state=new StateEntity();
		sql.append("SELECT ");
		sql.append("  d.\"id\" AS \"idDepartamento\", ");
		sql.append("  d.\"nombre\" AS \"nombreDepartamento\", ");
		sql.append("  p.\"id\" AS \"idPais\", ");
		sql.append("  p.\"nombre\" AS \"nombrePais\" ");
		sql.append("FROM \"Departamento\" AS d ");
		sql.append("INNER JOIN \"Pais\" AS p ");
		sql.append("  ON d.\"pais\" = p.\"id\" ");

	    
	    try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

	       

	        try (var resultSet = preparedStatement.executeQuery()) {

	            if (resultSet.next()) {

	                var country = new CountryEntity();
	                country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idPais")));
	                country.setName(resultSet.getString("nombrePais"));

	                state.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idDepartamento")));
	                state.setName(resultSet.getString("nombreDepartamento"));
	                state.setCountry(country);
	                states.add(state); 

	            }
	        }

	    } catch (final SQLException exception) {
	        var userMessage = MessagesEnum.USER_ERROR_SEARCH_STATE_FAILED_SQL_EXCEPTION.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_USER_FAILED_SQL_EXCEPTION.getContent()    + exception.getMessage();
	        throw NoseException.create(exception, userMessage, technicalMessage);

	    } catch (final Exception exception) {
	        var userMessage =MessagesEnum.USER_ERROR_SEARCH_STATE_FAILED.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_USER_FAILED.getContent() +exception.getMessage();
	        throw NoseException.create(exception, userMessage, technicalMessage);
	    }

	    return states;

		
	}

	@Override
	public List<StateEntity> findByFilter(StateEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
		public StateEntity findById(final UUID id) {
return findByFilter(new StateEntity(id)).stream().findFirst().orElse(new StateEntity());

	
	}

}
	
	
	
	

