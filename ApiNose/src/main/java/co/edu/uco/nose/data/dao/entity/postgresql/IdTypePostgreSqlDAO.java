package co.edu.uco.nose.data.dao.entity.postgresql;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.IdTypeDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.IdTypeEntity;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class IdTypePostgreSqlDAO extends SqlConnection implements IdTypeDAO {

    public IdTypePostgreSqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<IdTypeEntity> findAll() {
        return findByFilter(new IdTypeEntity());
    }

    @Override
    public List<IdTypeEntity> findByFilter(final IdTypeEntity filterEntity) {
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
            var userMessage = MessagesEnum.USER_ERROR_SEARCH_ID_FAILED_SQL_EXCEPTION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ID_USER_FAILED_SQL_EXCEPTION.getContent() + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SEARCH_ID_FAILED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ID_USER_FAILED.getContent() + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    private String createSentenceFindByFilter(final IdTypeEntity filterEntity, final List<Object> parametersList) {
        final var sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  ti.\"id\" AS \"idTipoIdentificacion\", ");
        sql.append("  ti.\"nombre\" AS \"nombreTipoIdentificacion\" ");
        sql.append("FROM \"TipoIdentificacion\" AS ti ");

        createWhereClauseFindByFilter(sql, parametersList, filterEntity);

        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList,
            final IdTypeEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new IdTypeEntity());
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parametersList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "ti.\"id\" = ", filterEntityValidated.getId());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
                "ti.\"nombre\" = ", filterEntityValidated.getName());

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

    private List<IdTypeEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        final var idTypes = new ArrayList<IdTypeEntity>();

        try (var resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                var idType = new IdTypeEntity();
                idType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idTipoIdentificacion")));
                idType.setName(resultSet.getString("nombreTipoIdentificacion"));

                idTypes.add(idType);
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
    public IdTypeEntity findById(UUID id) {
        return findByFilter(new IdTypeEntity(id)).stream().findFirst().orElse(new IdTypeEntity());
    }

}