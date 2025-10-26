package co.edu.uco.nose.data.dao.entity.postgresql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.CityEntity;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.StateEntity;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public final class CityPostgreSqlDAO extends SqlConnection implements CityDAO {

    public CityPostgreSqlDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public List<CityEntity> findAll() {
        return findByFilter(new CityEntity());
    }

    @Override
    public CityEntity findById(UUID id) {
       return findByFilter(new CityEntity(id)).stream().findFirst().orElse(new CityEntity());
    }

    @Override
    public List<CityEntity> findByFilter(CityEntity filterEntity) {
        
        var parametersList = new ArrayList<Object>();
        final var sql = createSentenceFindByFilter(filterEntity, parametersList);

        try (var preparedStatement = this.getConnection().prepareStatement(sql)) {
            for (int i = 0; i < parametersList.size(); i++) {
                preparedStatement.setObject(i + 1, parametersList.get(i));
            }

            return executeSentenceFindByFilter(preparedStatement);
        } catch (final NoseException exception) {
            throw exception;
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SEARCH_CITY_FAILED_SQL_EXCEPTION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_USER_FAILED_SQL_EXCEPTION.getContent() + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SEARCH_CITY_FAILED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_USER_FAILED.getContent() + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }
        private String createSentenceFindByFilter(final CityEntity filterEntity, final List<Object> parametersList) {
            final var sql = new StringBuilder();
            sql.append("SELECT ");
            sql.append("  c.\"id\" AS \"idCiudadResidencia\", ");
            sql.append("  c.\"nombre\" AS \"nombreCiudadResidencia\", ");
            sql.append("  d.\"id\" AS \"idDepartamentoCiudadResidencia\", ");
            sql.append("  d.\"nombre\" AS \"nombreDepartamentoCiudadResidencia\", ");
            sql.append("  p.\"id\" AS \"idPaisDepartamentoCiudadResidencia\", ");
            sql.append("  p.\"nombre\" AS \"nombrePaisDepartamentoCiudadResidencia\" ");
            sql.append("FROM \"Ciudad\" AS c ");
            sql.append("INNER JOIN \"Departamento\" AS d ");
            sql.append("  ON c.\"departamento\" = d.\"id\" ");
            sql.append("INNER JOIN \"Pais\" AS p ");
            sql.append("  ON d.\"pais\" = p.\"id\" ");

            createWhereClauseFindByFilter(sql, parametersList, filterEntity);

            return sql.toString();
        }

        private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList,
                final CityEntity filterEntity) {

            var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new CityEntity());

            final var conditions = new ArrayList<String>();

            addCondition(conditions, parametersList,
                    !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                    "c.\"id\" = ", filterEntityValidated.getId());

            addCondition(conditions, parametersList,
                    !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
                    "c.\"nombre\" = ", filterEntityValidated.getName());
            
            addCondition(conditions, parametersList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getState().getId()),
                    "c.\"departamento\" = ", filterEntityValidated.getState().getId());

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

        private List<CityEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
            final var cities = new ArrayList<CityEntity>();

            try (var resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    var city = new CityEntity();
                    
                    var state = new StateEntity();
                    var country = new CountryEntity();

                    var idCity = resultSet.getString("idCiudadResidencia");
                    var nameCity = resultSet.getString("nombreCiudadResidencia");

                    var idState = resultSet.getString("idDepartamentoCiudadResidencia");
                    var nameState = resultSet.getString("nombreDepartamentoCiudadResidencia");

                    var idCountry = resultSet.getString("idPaisDepartamentoCiudadResidencia");
                    var nameCountry = resultSet.getString("nombrePaisDepartamentoCiudadResidencia");

                    city.setId(UUIDHelper.getUUIDHelper().getFromString(idCity));
                    city.setName(nameCity);

                    state.setId(UUIDHelper.getUUIDHelper().getFromString(idState));
                    state.setName(nameState);

                    country.setId(UUIDHelper.getUUIDHelper().getFromString(idCountry));
                    country.setName(nameCountry);

                    state.setCountry(country);
                    city.setState(state);

                    cities.add(city);
                }
            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_SEARCH_CITY_FAILED_SQL_EXCEPTION.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_USER_FAILED_SQL_EXCEPTION.getContent() + exception.getMessage();
                throw NoseException.create(exception, userMessage, technicalMessage);
            } catch (final Exception exception) {
                var userMessage = MessagesEnum.USER_ERROR_SEARCH_CITY_FAILED.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_USER_FAILED.getContent() + exception.getMessage();
                throw NoseException.create(exception, userMessage, technicalMessage);
            }

            return cities;
    
}
}