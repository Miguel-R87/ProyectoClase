package co.edu.uco.nose.text;

import java.util.UUID;

import co.edu.uco.nose.business.facade.impl.UserFacadeImpl;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.dto.CityDto;
import co.edu.uco.nose.dto.IdTypeDto;
import co.edu.uco.nose.dto.UserDto;

public class TestUserRegistration {

    public static void main(String[] args) {

        try {
       
            var user = new UserDto();

       
            user.setIdentificationType(
                new IdTypeDto(UUID.fromString("44444444-4444-4444-4444-444444444444"))
            );
            user.setResidenceCity(
                new CityDto(UUID.fromString("33333333-3333-3333-3333-333333333333"))
            );

            
           
            user.setIdentificationNumber("1040874401afs");  
            user.setFirstName("Alejo");              
            user.setMiddleName("a");                
            user.setLastName("Quintero");                  
            user.setSecondLastName("Lopez");          
            user.setEmail("alejocool12o@example.com");  
            user.setCellPhoneNumber("3122159291");      
            user.setEmailConfirmed(false);
            user.setCellPhoneNumberConfirmed(false);

         
            var facade = new UserFacadeImpl();
            facade.registerNewUserInformation(user);

            
            System.out.println("Usuario registrado correctamente. ¡Gané el semestre!");

        } catch (NoseException e) {
            System.out.println("⚠️ Error de negocio:");
            System.out.println("Mensaje usuario: " + e.getUserMessage());
            System.out.println("Mensaje técnico: " + e.getTechnicalMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("⚠️ Error inesperado:");
            e.printStackTrace();
        }
    }
}
