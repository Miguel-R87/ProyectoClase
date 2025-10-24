package co.edu.uco.nose.data.dao.factory;
import co.edu.uco.nose.data.dao.entity.IdTypeDAO;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.data.dao.factory.postgresql.PostgreSqlDaoFactory;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAOFactory {
    protected Connection connection;
    protected static FactoryEnum factory = FactoryEnum.POSTGRESQL;

    public static DAOFactory getFactory() {
       switch(factory) {
       case POSTGRESQL:{
		  return new PostgreSqlDaoFactory();
       }
       default:
		   var userMessage=MessagesEnum.USER_ERROR_FACTORY_NOT_INITIALIZED.getContent();
		   var technicalMessage=MessagesEnum.TECHNICAL_ERROR_FACTORY_NOT_INITIALIZED.getContent();
		   throw NoseException.create(userMessage, technicalMessage);
        }
}
    public abstract CityDAO getCityDAO();
    public abstract CountryDAO getCountryDAO();
    public abstract IdTypeDAO getIdTypeDAO();
    public abstract StateDAO getStateDAO();
    public abstract UserDAO getUserDAO();
    protected abstract void openConnection();

    protected final void initTransaction(){

    	try {
	connection.setAutoCommit(false);
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
    public final void commitTransaction(){
    	SqlConnectionHelper.ensureTransactionIsStarted(connection);
    	try {
    		connection.commit();
    	} catch (final SQLException exception){
			var userMessage="";
			var technicalMessage="";
			throw NoseException.create(userMessage, technicalMessage);
    	}catch (final Exception exception){
    		var userMessage="";
    		var technicalMessage="";
    		throw NoseException.create(userMessage, technicalMessage);
    	}
    
    	
    }


    public final void rollbackTransaction(){
    	SqlConnectionHelper.ensureTransactionIsStarted(connection);
try {
	connection.rollback();
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

    public final  void closeConnection(){
 SqlConnectionHelper.ensureConnectionIsOpen(connection);
 try {
	 connection.close();
	 
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
}
