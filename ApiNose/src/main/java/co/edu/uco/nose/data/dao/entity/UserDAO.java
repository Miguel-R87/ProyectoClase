		package co.edu.uco.nose.data.dao.entity;	
import java.util.UUID;


public interface UserDAO extends CreateDAO<UserEntity>,
        RetrieveDAO<UserEntity, UUID>,
        UpdateDAO<UserEntity>,
        DeleteDAO<UUID> {
}
