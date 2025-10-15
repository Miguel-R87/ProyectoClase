package co.edu.uco.nose.data.dao.entity;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;

public abstract class SqlConnection {

    private Connection connection;

    protected SqlConnection(final Connection connection) {	
        setConnection(connection);
    }

    protected Connection getConnection() {
        return connection;
    }

    private void setConnection(final Connection connection) {
    	SqlConnectionHelper.ensureConnectionIsOpen(connection);
    	this.connection = connection;
        }
        
        try {
            if (connection.isClosed()) {
                var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
                throw NoseException.create(userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXCEPTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXCEPTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw NoseException.create(exception,userMessage, technicalMessage);
        }
        this.connection = connection;
    }
}

	
	


