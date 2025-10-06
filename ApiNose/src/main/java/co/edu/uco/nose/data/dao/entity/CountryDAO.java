package co.edu.uco.nose.data.dao.entity;

import co.edu.uco.nose.data.dao.CreateDAO;
import co.edu.uco.nose.data.dao.UpdateDAO;
import co.edu.uco.nose.data.dao.DeleteDAO;
import co.edu.uco.nose.data.dao.RetrieveDAO;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.IdTypeEntity;

import java.util.UUID;

public interface CountryDAO extends CreateDAO<CountryEntity>,
        RetrieveDAO <CountryEntity, UUID>,
        UpdateDAO<CountryEntity>, DeleteDAO<UUID> {

}
