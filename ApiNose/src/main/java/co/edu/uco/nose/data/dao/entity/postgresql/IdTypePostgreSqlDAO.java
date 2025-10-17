package co.edu.uco.nose.data.dao.entity.postgresql;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.IdTypeDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.IdTypeEntity;
import java.util.UUID;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

public final class IdTypePostgreSqlDAO extends SqlConnection implements IdTypeDAO {

	public IdTypePostgreSqlDAO(Connection connection) {
		super(connection);
	}
	@Override
	public List<IdTypeEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IdTypeEntity> findByFilter(IdTypeEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdTypeEntity findById(UUID id) {
		final var IdTypeEntity = new IdTypeEntity();
		final var sql = new StringBuilder();
		
		sql.append("SELECT ");
		sql.append("  t.id, ");
		sql.append("  t.nombre, ");
		sql.append("  from \"Tipolidentificacion\" as t ");
		sql.append("  where t.id = ? ");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			preparedStatement.setObject(1, id);
			
			try(var resultSet = preparedStatement.executeQuery()){
				
				if(resultSet.next()) {
					
					IdTypeEntity.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
					IdTypeEntity.setName(resultSet.getString("nombre"));
					
				}
				
			}

		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_IDENTIFICATIONTYPE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_IDENTIFICATIONTYPE + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}catch(final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_IDENTIFICATIONTYPE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_IDENTFICATIONTYPE.getContent() + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return IdTypeEntity;
	}
    
}
