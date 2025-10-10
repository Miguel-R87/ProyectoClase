package co.edu.uco.nose.crosscuting.messagescatalog;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public enum MessagesEnum {
	
USER_ERROR_SQL_CONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada vacia","La conexión requerida para llevar a cabo la operacion contra la fuente de información deseada esta vacia.Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación."),

TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada nula","La conexión requerida para llevar a cabo la operacion contra la base de datos llego nula"),


USER_ERROR_SQL_CONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada","La conexión requerida para llevar a cabo la operacion contra la fuente de información deseada esta cerrada.Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación."),

TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada","La conexión requerida para llevar a cabo la operacion contra la base de datos esta cerrada"),
		
USER_ERROR_SQL_CONNECTION_UNEXCEPTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado validando el estado de la conexion contra la fuente de datos deseada","Se ha presentado un problema inesperado tratando de validar el estado de la conexion requerida para llevar a cabo la operación contra la fuente de información deseada.por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación."),

TECHNICAL_ERROR_SQL_CONNECTION_UNEXCEPTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validando si la conexión contra la base de datos estaba abierta","Se presento un error de tipo SQLException al validar si la conexion contra la base de datos esta o no abierta,por favor valide la consola de errores para revisar con detalle el problema presentado");
private String title;
private String content;
private MessagesEnum(final String title, final String content) {

	setTitle(title);
	setContent(content);
}
public String getTitle() {
	return title;
}
public void setTitle(final String title) {
	this.title = TextHelper.getDefaultWithTrim(title);
}
public String getContent() {
	return content;
}
public void setContent(final String content) {
	this.content = TextHelper.getDefaultWithTrim(content);
}



	
}