package co.edu.uco.nose.data.dao.entity.postgresql;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.IdTypeDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.IdTypeEntity;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

public final class IdTypePostgreSqlDAO extends SqlConnection implements IdTypeDAO {

	public IdTypePostgreSqlDAO(Connection connection) {
		super(connection);
	}
@Override
public List<IdTypeEntity> findAll() {
    final var idTypes = new ArrayList<IdTypeEntity>();
    final var sql = new StringBuilder();

    sql.append("SELECT ");
    sql.append("  t.\"id\", ");
    sql.append("  t.\"nombre\" ");
    sql.append("FROM \"TipoIdentificacion\" AS t ");

    try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

        try (var resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                var idType = new IdTypeEntity();
                idType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
                idType.setName(resultSet.getString("nombre"));
                idTypes.add(idType);
            }
        }

    } catch (final SQLException exception) {
        var userMessage = MessagesEnum.USER_ERROR_SEARCH_ID_FAILED_SQL_EXCEPTION.getContent();
        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ID_USER_FAILED_SQL_EXCEPTION.getContent() + exception.getMessage();
        throw NoseException.create(exception, userMessage, technicalMessage);
    } catch (final Exception exception) {
        var userMessage = MessagesEnum.USER_ERROR_SEARCH_ID_FAILED.getContent();
        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ID_USER_FAILED.getContent() + exception.getMessage();
        throw NoseException.create(exception, userMessage, technicalMessage);
    }

    return idTypes;
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
		sql.append("  t.\"id\", ");
		sql.append("  t.\"nombre\" ");
		sql.append("FROM \"TipoIdentificacion\" AS t ");
		sql.append("WHERE t.\"id\" = ? ");

		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			preparedStatement.setObject(1, id);
			
			try(var resultSet = preparedStatement.executeQuery()){
				
				if(resultSet.next()) {
					
					IdTypeEntity.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
					IdTypeEntity.setName(resultSet.getString("nombre"));
					
				}
				
			}

		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_SEARCH_ID_FAILED_SQL_EXCEPTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ID_USER_FAILED_SQL_EXCEPTION.getContent() + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}catch(final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SEARCH_ID_FAILED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ID_USER_FAILED.getContent() + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return IdTypeEntity;
	}
    
}
