package co.edu.uco.nose.crosscuting.messagescatalog;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public enum MessagesEnum {
	
USER_ERROR_SQL_CONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada vacia","La conexión requerida para llevar a cabo la operacion contra la fuente de información deseada esta vacia.Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación."),

TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada nula","La conexión requerida para llevar a cabo la operacion contra la base de datos llego nula");


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