package co.edu.uco.nose.data.dao.entity.postgresql;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.StateEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class   StatePostgreSqlDAO extends SqlConnection implements StateDAO {

	public StatePostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<StateEntity> findAll() {
		return findByFilter(new StateEntity());

		
	}

	@Override
	public List<StateEntity> findByFilter(StateEntity filterEntity) {
	
		var parametersList= new ArrayList<Object>();
		final var sql= createSentenceFindByFilter(filterEntity, parametersList);
		try (var preparedStatement= this.getConnection().prepareStatement(sql)){
			for (int i=0; i< parametersList.size(); i++) {
				preparedStatement.setObject(i+1, parametersList.get(i));
			}
			return executeSentenceFindByFilter(preparedStatement);
		} catch (final NoseException exception) {
			throw exception;
		} catch (final SQLException exception) {
			var userMessage= MessagesEnum.USER_ERROR_SEARCH_STATE_FAILED_SQL_EXCEPTION.getContent();
			var technicalMessage= MessagesEnum.TECHNICAL_ERROR_STATE_USER_FAILED_SQL_EXCEPTION.getContent() + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage= MessagesEnum.USER_ERROR_SEARCH_STATE_FAILED.getContent();
			var technicalMessage= MessagesEnum.TECHNICAL_ERROR_STATE_USER_FAILED.getContent() + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
	}
    private String createSentenceFindByFilter(final StateEntity filterEntity, final List<Object> parametersList) {
        final var sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  d.\"id\" AS \"idDepartamentoCiudadResidencia\", ");
        sql.append("  d.\"nombre\" AS \"nombreDepartamentoCiudadResidencia\", ");
        sql.append("  p.\"id\" AS \"idPaisDepartamentoCiudadResidencia\", ");
        sql.append("  p.\"nombre\" AS \"nombrePaisDepartamentoCiudadResidencia\" ");
        sql.append("FROM \"Departamento\" AS d ");
        sql.append("INNER JOIN \"Pais\" AS p ");
        sql.append("  ON d.\"pais\" = p.\"id\" ");

        createWhereClauseFindByFilter(sql, parametersList, filterEntity);

        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList,
            final StateEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new StateEntity());

        final var conditions = new ArrayList<String>();

        addCondition(conditions, parametersList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "d.\"id\" = ", filterEntityValidated.getId());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
                "d.\"nombre\" = ", filterEntityValidated.getName());
        
        addCondition(conditions, parametersList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getCountry().getId()),
                "d.\"pais\" = ", filterEntityValidated.getCountry().getId());

        if (!conditions.isEmpty()) {
            sql.append(" WHERE ");
            sql.append(String.join(" AND ", conditions));
        }
    }

    private void addCondition(final List<String> conditions, final List<Object> parametersList, final boolean condition,
            final String clause, final Object value) {
        if (condition) {
            conditions.add(clause + " ?");
            parametersList.add(value);
        }
    }

    private List<StateEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        final var states = new ArrayList<StateEntity>();

        try (var resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                var state = new StateEntity();
                var country = new CountryEntity();

                var idState = resultSet.getString("idDepartamentoCiudadResidencia");
                var nameState = resultSet.getString("nombreDepartamentoCiudadResidencia");

                var idCountry = resultSet.getString("idPaisDepartamentoCiudadResidencia");
                var nameCountry = resultSet.getString("nombrePaisDepartamentoCiudadResidencia");

                state.setId(UUIDHelper.getUUIDHelper().getFromString(idState));
                state.setName(nameState);

                country.setId(UUIDHelper.getUUIDHelper().getFromString(idCountry));
                country.setName(nameCountry);

                state.setCountry(country);

                states.add(state);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SEARCH_STATE_FAILED_SQL_EXCEPTION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_USER_FAILED_SQL_EXCEPTION.getContent() + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SEARCH_STATE_FAILED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_USER_FAILED.getContent() + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

        return states;
	}


	@Override
		public StateEntity findById(final UUID id) {
	return findByFilter(new StateEntity(id)).stream().findFirst().orElse(new StateEntity());

	
	}

}