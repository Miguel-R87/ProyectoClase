package co.edu.uco.nose.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.nose.controller.dto.Response;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.dto.UserDto;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	
@GetMapping	
public ResponseEntity<Response<List<UserDto>>>findAllUsers() {
	
	Response<UserDto> responseObjectData=
	Response<List<UserDto>> responseObjectData=Response.createSuccededResponse();
	try {
	var facade=newUserFacadeImpl();
	responseObjectData.setData(facade.findAllUsers());
	responseObjectData.addMessage("All users filtered succesfully!");
	responseUsersList.addMessage("All users filtered succesfully!");
	
throw new RuntimeException("Algo paso del negocio!!");

}catch (final NoseException exception) {
	responseObjectData=Response.createFailedResponse();
	responseObjectData.addMessage(exception.getUserMessage());
	ResponseStatusCode=HttpStatus.BAD_REQUEST;
	exception.printStackTrace();
	}catch (Exception exception) {
		responseObjectData=Response.createFailedResponse();
		responseObjectData.addMessage((exception.getUserMessage());
		ResponseStatusCode=HttpStatus.INTERNAL_SERVER_ERROR;
		exception.printStackTrace();
		
	}
	
	return new ResponseEntity<Response<UserDto>>(responseObjectData,null);
}

@PostMapping
public String RegisterNewUserInformation(@PathVariable UUID id,@RequestBody UserDto user) {
	return "POST:User registered!";
	
}

@PutMapping
public String UpdateUserInformation() {
	return "UPDATE:User updated!";
	
}
@DeleteMapping
public String DropUserInformation() {
	return "Delete:User deleted!";
	
}
}