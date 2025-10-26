package co.edu.uco.nose.crosscuting.messagescatalog;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public enum MessagesEnum {
	USER_ERROR_SQL_CONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada vacía", "La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está vacía. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada nula", "La conexión requerida para llevar a cabo la operación contra la base de datos llegó nula."),
	USER_ERROR_SQL_CONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada", "La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está cerrada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada", "La conexión requerida para llevar a cabo la operación contra la base de datos llegó cerrada."),
	USER_ERROR_SQL_CONNECTION_UNEXCEPTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado validando el estado de la conexión contra la fuente de datos deseada", "Se ha presentado un problema inesperado tratando de validar el estado de la conexión requerida para llevar a cabo la operación contra la fuente de información deseada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXCEPTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validando si la conexión contra la base de datos estaba abierta", "Se presentó un error de tipo SQLException al validar si la conexión contra la base de datos está o no abierta."),
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado validando el estado de la conexión contra la fuente de datos deseada", "Se ha presentado un problema inesperado tratando de validar el estado de la conexión requerida para llevar a cabo la operación contra la fuente de información deseada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validando si la conexión contra la base de datos estaba abierta", "Se presentó un error de tipo SQLException al validar si la conexión contra la base de datos estaba o no abierta."),
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Error inesperado validando el estado de la transacción", "Ocurrió un problema inesperado al validar si la transacción contra la fuente de información deseada estaba iniciada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_STARTED("Error SQL validando si la transacción estaba iniciada", "Se presentó un error de tipo SQLException mientras se verificaba si la transacción en la conexión con la base de datos había sido iniciada."),
	TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_CONNECTION_STATUS("Error SQL validando el estado de la conexión contra la base de datos", "Se presentó una excepción de tipo SQLException al intentar validar si la conexión contra la base de datos se encontraba activa o disponible."),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Error inesperado validando si la transacción estaba iniciada", "Se presentó un problema inesperado al intentar validar si la transacción contra la base de datos había sido iniciada. No fue una SQLException, sino un error no controlado en el proceso de validación."),
	
	
	USER_ERROR_TRANSACTION_IS_STARTED( "", "Ya hay una transacción activa. Finalice la transacción antes de iniciar una nueva."),
	TECHNICAL_ERROR_TRANSACTION_IS_STARTED( "Transacción ya iniciada", "El modo de auto-commit está desactivado, lo que indica que ya hay una transacción activa."	),

	
	
	USER_ERROR_FACTORY_NOT_INITIALIZED("La fuente de informacion sobre la cual se va ir a realizar la transacción seleccionada no esta disponible en el sistema", "No se ha inicializado la fábrica de DAO. Por favor contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_FACTORY_NOT_INITIALIZED("La factoria que me pidieron no existe", "No se ha inicializado la fábrica de DAO."),
	
	
	
	
	// MENSAJES EXCEPCIONES USUARIO
    // create
    USER_ERROR_REGISTRATION_FAILED_SQL_EXCEPTION(" Se ha presentado un problema tratando de registrar la información de un nuevo usuario"," por favor intente de nuevo si el problema persiste contacte al administrador del sistema"),
    TECHNICAL_ERROR_REGISTRATION_SQL_EXCEPTION("Se ha presentado un error inesperado al registrar la información del nuevo usuario", 
        "Se presentó una excepción SQL al intentar registrar al nuevo usuario. Esto puede ser causado por problemas con la base de datos, como una violación de restricción de clave o problemas de conexión."),

    USER_ERROR_REGISTRATION_FAILED(" Se ha presentado un problema inesperado tratando de registrar la información del nuevo usuario por favor intente de nuevo"," si el problema persiste por favor contacte al administrador del sistema."),
    TECHNICAL_ERROR_REGISTRATION_FAILED("Se ha presentado un problema inesperado al tratar de ejecutar el registro de un nuevo usuario ","Se ha presentado un problema al intentar regisrar un nuevo usuario no es un SQL Exception"),

    // consultas
    USER_ERROR_SEARCH_USER_FAILED_SQL_EXCEPTION("Se ha presentado un problema tratando de consultar la información de un usuario"," por favor intente de nuevo si el  problema persiste por favor contacte al administrador del sistema"),
    TECHNICAL_ERROR_SEARCH_USER_FAILED_SQL_EXCEPTION("Error SQL durante la operación de consulta de la información de un usuario", "Se ha presentado un problema de tipo SQLException durante la ejecución de la operación de consulta de la información de un usuario."),
    USER_ERROR_SEARCH_USER_FAILED("Se ha presentado un problema inesperado tratando de consultar la información de un usuario por favor intente de nuevo"," Si el problema persiste por favor contacte al administrador del sistema"),
    TECHNICAL_ERROR_SEARCH_USER_FAILED( "Se ha presentado un problema inesperado al tratar de ejecutar el proceso de consulta del usuario ","Se ha presentado un problema inesperado durante la ejecución de la operación de consulta de la información de un usuario. No fue una SQLException, sino un error no controlado en el proceso de registro."),

    // update
    USER_ERROR_UPDATE_USER_FAILED_SQL_EXCEPTION("Se ha presentado un problema tratando de actualizar la información de un usuario por favor intente de nuevo"," Si el problema persiste por favor contacte al administrador del sistema"),
    TECHNICAL_ERROR_UPDATE_USER_FAILED_SQL_EXCEPTION("Se ha presentado un problema inesperado al tratar de ejecutar la actualización de un usuario ","verifique que si este conectado a la base de datos"),
    USER_ERROR_UPDATE_USER_FAILED("Se ha presentado un problema inesperado tratando de actualizar la información de un usuario por favor intente de nuevo"," Si el problema persiste por favor contacte al administrador del sistema"),
    TECHNICAL_ERROR_UPDATE_USER_FAILED( "Se ha presentado un problema inesperado al tratar de ejecutar el proceso de actualizacion de un  usuario ","verifique que si este conectado a la base de datos"),

    // delete 
    USER_ERROR_DELETE_USER_FAILED_SQL_EXCEPTION("Se ha presentado un problema tratando de eliminar un usuario por favor intente de nuevo.","Si el problema persiste por favor contacte al administrador del sistema"),
    TECHNICAL_ERROR_DELETE_USER_FAILED_SQL_EXCEPTION("Se ha presentado un problema inesperado al tratar de ejecutar el proceso de eliminar un usuario","verifique que si este conectado a la base de datos"),
    USER_ERROR_DELETE_USER_FAILED("Se ha presentado un problema inesperado tratando eliminar  un usuario por favor intente de nuevo"," Si el problema persiste por favor contacte al administrador del sistema"),
    TECHNICAL_ERROR_DELETE_USER_FAILED( "Se ha presentado un problema inesperado al tratar de ejecutar el proceso de eliminacion de un usuario ","verifique que si este conectado a la base de datos"),
	
    //MENSAJES EXCEPCIONES DEPARTAMENTO
    // consultas
    USER_ERROR_SEARCH_STATE_FAILED_SQL_EXCEPTION("Se ha presentado un problema tratando de consultar la información de un departamento"," por favor intente de nuevo si el  problema persiste por favor contacte al administrador del sistema"),
    TECHNICAL_ERROR_STATE_USER_FAILED_SQL_EXCEPTION("Se ha presentado un problema inesperado al tratar de ejecutar el proceso de consulta del departamento","se ha presentado un problema al intentar realizar la consulta de un departamento"),
    USER_ERROR_SEARCH_STATE_FAILED("Se ha presentado un problema inesperado tratando de consultar la información de un departamrento por favor intente de nuevo","Por favor intente de nuevo Si el problema persiste por favor contacte al administrador del sistema"),
    TECHNICAL_ERROR_STATE_USER_FAILED( "Se ha presentado un problema inesperado al tratar de ejecutar el proceso de consulta del departamento ","se ha presentado un problema al intentar realizar la consulta de un departamento no es un SQL Exception el problema"),

	//MENSAJES PARA ERRORES TipoID

    //MENSAJES EXCEPCIONES IDTYPE
    // consultas
    USER_ERROR_SEARCH_ID_FAILED_SQL_EXCEPTION("Se ha presentado un problema tratando de consultar la información de un tipo de identificador"," por favor intente de nuevo si el  problema persiste por favor contacte al administrador del sistema"),
    TECHNICAL_ERROR_ID_USER_FAILED_SQL_EXCEPTION("Se ha presentado un problema inesperado al tratar de ejecutar el proceso de consulta del tipo de identificador","se ha presentado un problema al intentar realizar la consulta de un tipo de identificador"),
    USER_ERROR_SEARCH_ID_FAILED("Se ha presentado un problema inesperado tratando de consultar la información de un tipo de identificador por favor intente de nuevo","Por favor intente de nuevo Si el problema persiste por favor contacte al administrador del sistema"),
    TECHNICAL_ERROR_ID_USER_FAILED( "Se ha presentado un problema inesperado al tratar de ejecutar el proceso de consulta de un tipo de identificador ","se ha presentado un problema al intentar realizar la consulta de un departamento no es un SQL Exception el problema"),

	
  //MENSAJES PARA ERRORES CIUDAD

    // consultas
    USER_ERROR_SEARCH_CITY_FAILED_SQL_EXCEPTION("Se ha presentado un problema tratando de consultar la información de una ciudad"," por favor intente de nuevo si el  problema persiste por favor contacte al administrador del sistema"),
    TECHNICAL_ERROR_CITY_USER_FAILED_SQL_EXCEPTION("Se ha presentado un problema inesperado al tratar de ejecutar el proceso de consulta de una ciudad","se ha presentado un problema al intentar realizar la consulta de una ciudad"),
    USER_ERROR_SEARCH_CITY_FAILED("Se ha presentado un problema inesperado tratando de consultar la información de una ciudad por favor intente de nuevo","Por favor intente de nuevo Si el problema persiste por favor contacte al administrador del sistema"),
    TECHNICAL_ERROR_CITY_USER_FAILED( "Se ha presentado un problema inesperado al tratar de ejecutar el proceso de consulta de una ciudad ","se ha presentado un problema al intentar realizar la consulta de una ciudad no es un SQL Exception el problema"),

  // MENSAJES EXCEPCIONES PAÍS
    // consultas
    USER_ERROR_SEARCH_COUNTRY_FAILED_SQL_EXCEPTION("Se ha presentado un problema tratando de consultar la información de un país"," por favor intente de nuevo si el  problema persiste por favor contacte al administrador del sistema"),
    TECHNICAL_ERROR_COUNTRY_USER_FAILED_SQL_EXCEPTION("Se ha presentado un problema inesperado al tratar de ejecutar el proceso de consulta de un país","se ha presentado un problema al intentar realizar la consulta de un país"),
    USER_ERROR_SEARCH_COUNTRY_FAILED("Se ha presentado un problema inesperado tratando de consultar la información de un país por favor intente de nuevo","Por favor intente de nuevo Si el problema persiste por favor contacte al administrador del sistema"),
    TECHNICAL_ERROR_COUNTRY_USER_FAILED( "Se ha presentado un problema inesperado al tratar de ejecutar el proceso de consulta de un país ","se ha presentado un problema al intentar realizar la consulta de un país no es un SQL Exception el problema"),

	
	
	USER_ERROR_TRANSACTION_IS_NOT_STARTED("Transacción no iniciada", "No se ha iniciado la transacción contra la fuente de información deseada. Por favor intente de nuevo."),
	TECHNICAL_ERROR_TRANSACTION_IS_NOT_STARTED( "Transacción no iniciada", "La conexión indica que el modo de auto-commit está activado, por lo tanto no se ha iniciado la transacción."),
	TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error inesperado validando si el autocommit contra la base de datos estaba desactivado", "Se presentó un error de tipo SQLException al validar si el autocommit habia sido desactivado ."),
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error inesperado validando el manejo de operaciones contra la fuente de datos", "Ocurrió un problema inesperado tratando de validar el estado de manejo de operaciones"),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error inesperado validando si el autocommit contra la base de datos estaba desactivado", "Se presentó un problema inesperado al validar si el autocommit habia sido desactivado. No fue una SQLException, sino un error no controlado en el proceso de validación."), 
	//mensajes para errores en el registro de un usuario
	USER_ERROR_UNEXPECTED_EXCEPTION_REGISTERING_USER("Error inesperado durante el registro de un nuevo usuario", "Se ha presentado un problema inesperado durante la operación de registro de un nuevo usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_REGISTERING_USER("Error inesperado durante la operación de registro de un nuevo usuario", "Se ha presentado un problema inesperado durante la operación de registro de un nuevo usuario. No fue una SQLException, sino un error no controlado en el proceso de registro."),

	//mensajes de validaciones en validaciones de obligatoriedad en el registro de un nuevo usuario
	USER_ERROR_WHEN_REGISTERING_USER_NULL_USER(
		    "No se ha podido procesar la información del usuario porque no fue proporcionada",
		    "Por favor complete la información del usuario e intente nuevamente"),
		TECHNICAL_ERROR_WHEN_REGISTERING_USER_NULL_USER(
		    "El objeto UserDomain es nulo al intentar registrar un usuario",
		    "Se recibió un objeto UserDomain nulo, no se pudo continuar con la operación"),

		USER_ERROR_WHEN_REGISTERING_USER_NULL_IDENTIFICATION_TYPE(
		    "El tipo de identificación del usuario no ha sido proporcionado",
		    "Por favor seleccione un tipo de identificación válido"),
		TECHNICAL_ERROR_WHEN_REGISTERING_USER_NULL_IDENTIFICATION_TYPE(
		    "El campo identificationType de UserDomain es nulo",
		    "Se intentó registrar un usuario sin asignar identificationType"),

		USER_ERROR_WHEN_REGISTERING_USER_NULL_CITY(
		    "La ciudad de residencia del usuario no ha sido proporcionada",
		    "Por favor seleccione la ciudad de residencia del usuario"),
		TECHNICAL_ERROR_WHEN_REGISTERING_USER_NULL_CITY(
		    "El campo residenceCity de UserDomain es nulo",
		    "No se pudo registrar la ciudad de residencia del usuario, valor nulo recibido"),

		USER_ERROR_WHEN_REGISTERING_USER_INVALID_IDENTIFICATION_NUMBER(
		    "El número de identificación del usuario es inválido o excede 25 caracteres",
		    "Por favor ingrese un número de identificación válido con máximo 25 caracteres"),
		TECHNICAL_ERROR_WHEN_REGISTERING_USER_INVALID_IDENTIFICATION_NUMBER(
		    "El campo identificationNumber está vacío o su longitud es mayor a 25 caracteres",
		    "El número de identificación del usuario no cumple con las restricciones de validación"),

		USER_ERROR_WHEN_REGISTERING_USER_INVALID_FIRST_NAME(
		    "El primer nombre del usuario es inválido o excede 20 caracteres",
		    "Por favor ingrese un primer nombre válido con máximo 20 caracteres"),
		TECHNICAL_ERROR_WHEN_REGISTERING_USER_INVALID_FIRST_NAME(
		    "El campo firstName está vacío o su longitud es mayor a 20 caracteres",
		    "Se detectó un primer nombre inválido para el registro del usuario"),

		USER_ERROR_WHEN_REGISTERING_USER_INVALID_MIDDLE_NAME(
		    "El segundo nombre del usuario es inválido o excede 20 caracteres",
		    "Por favor ingrese un segundo nombre válido con máximo 20 caracteres"),
		TECHNICAL_ERROR_WHEN_REGISTERING_USER_INVALID_MIDDLE_NAME(
		    "El campo middleName está vacío o su longitud es mayor a 20 caracteres",
		    "Se detectó un segundo nombre inválido para el registro del usuario"),

		USER_ERROR_WHEN_REGISTERING_USER_INVALID_LAST_NAME(
		    "El primer apellido del usuario es inválido o excede 20 caracteres",
		    "Por favor ingrese un primer apellido válido con máximo 20 caracteres"),
		TECHNICAL_ERROR_WHEN_REGISTERING_USER_INVALID_LAST_NAME(
		    "El campo lastName está vacío o su longitud es mayor a 20 caracteres",
		    "Se detectó un primer apellido inválido para el registro del usuario"),

		USER_ERROR_WHEN_REGISTERING_USER_INVALID_SECOND_LAST_NAME(
		    "El segundo apellido del usuario es inválido o excede 20 caracteres",
		    "Por favor ingrese un segundo apellido válido con máximo 20 caracteres"),
		TECHNICAL_ERROR_WHEN_REGISTERING_USER_INVALID_SECOND_LAST_NAME(
		    "El campo secondLastName está vacío o su longitud es mayor a 20 caracteres",
		    "Se detectó un segundo apellido inválido para el registro del usuario"),

		USER_ERROR_WHEN_REGISTERING_USER_INVALID_EMAIL(
		    "El correo electrónico del usuario es inválido o excede 250 caracteres",
		    "Por favor ingrese un correo electrónico válido con máximo 250 caracteres"),
		TECHNICAL_ERROR_WHEN_REGISTERING_USER_INVALID_EMAIL(
		    "El campo email es inválido o excede 250 caracteres",
		    "El correo electrónico proporcionado no cumple con el formato o longitud esperada"),

		USER_ERROR_WHEN_REGISTERING_USER_INVALID_CELL_PHONE_NUMBER(
		    "El número de celular del usuario es inválido o excede 20 caracteres",
		    "Por favor ingrese un número de celular válido con máximo 20 caracteres"),
		TECHNICAL_ERROR_WHEN_REGISTERING_USER_INVALID_CELL_PHONE_NUMBER(
		    "El campo cellPhoneNumber es inválido o excede 20 caracteres",
		    "El número de celular proporcionado no cumple con el formato o longitud esperada"),
	//mensajes para usuarios duplicados
	USER_ERROR_WHILE_REGISTERING_USER_DUPLICATED_CELL_PHONE_NUMBER("El número de teléfono ya se encuentra registrado", "No es posible registrar al usuario, ya que el teléfono ingresado por el usuario ya se encuentra en uso"),
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_CELL_PHONE_NUMBER("El número de teléfono ya se encuentra registrado", "No es posible registrar al usuario, ya que el teléfono ingresado por el uusario ya se encuentra registrado dentro de la fuente de datos"),
	USER_ERROR_WHILE_REGISTERING_USER_DUPLICATED_IDENTIFICATION("El tipo y número de documento del usuario ya se encuentra registrado", "No es posible registrar al usuario, ya que el tipo de documento y el número de documento ingresado por el usuario ya se encuentra en uso"),
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_IDENTIFICATION("El tipo y número de documento del usuario ya se encuentra registrado", "No es posible registrar al usuario, ya que el tipo y número de documento del usuario ya se encuentra registrado dentro de la fuente de datos"),
	USER_ERROR_WHILE_REGISTERING_USER_DUPLICATED_EMAIL("El correo electrónico ya se encuentra registrado", "No es posible registrar al usuario, ya que el correo electrónico ingresado por el usuario ya se encuentra en uso"),
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_EMAIL("El correo electrónico ya se encuentra registrado", "No es posible registrar al usuario, ya que el correo electrónico ingresado por el uusario ya se encuentra registrado dentro de la fuente de datos");
	


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