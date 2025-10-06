package co.edu.uco.nose.data.dao.entity;

import co.edu.uco.nose.data.dao.RetrieveDAO;
import co.edu.uco.nose.data.dao.CreateDAO;
import co.edu.uco.nose.data.dao.UpdateDAO;
import co.edu.uco.nose.data.dao.DeleteDAO;
import co.edu.uco.nose.entity.IdTypeEntity;
import java.util.UUID;


public interface IdTypeDAO extends CreateDAO <IdTypeEntity>,
        RetrieveDAO <IdTypeEntity, UUID>,
        UpdateDAO<IdTypeEntity>, DeleteDAO<UUID> {

}
