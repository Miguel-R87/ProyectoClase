package co.edu.uco.nose.data.dao.entity;

import co.edu.uco.nose.data.dao.CreateDAO;
import co.edu.uco.nose.data.dao.UpdateDAO;
import co.edu.uco.nose.data.dao.DeleteDAO;
import co.edu.uco.nose.data.dao.RetrieveDAO;
import co.edu.uco.nose.entity.CityEntity;
import java.util.UUID;

public interface CityDAO extends CreateDAO <CityEntity>,
        RetrieveDAO <CityEntity, UUID>,
        UpdateDAO<CityEntity>, DeleteDAO<UUID> {

}