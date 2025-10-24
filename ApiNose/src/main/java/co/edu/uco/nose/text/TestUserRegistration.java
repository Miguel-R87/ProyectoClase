package co.edu.uco.nose.text;

import co.edu.uco.nose.crosscuting.exception.NoseException;

public class TestUserRegistration {
	public static void main(String[] args) {
		try {
		var user=new UserDTO();
		
		//colocar todos los parametros menos el id
		
		var facade=new UserFacadeImpl();
		facade.registerNewUserInformation(user);
		
		System.out.println("Gane el semestre");
	}catch (NoseException e) {
		System.out.println(e.getUserMessage());
		System.out.println(e.getTechnicalMessage());
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}

	}

}
