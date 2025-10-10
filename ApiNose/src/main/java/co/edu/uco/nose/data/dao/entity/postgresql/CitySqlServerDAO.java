package co.edu.uco.nose.data.dao.entity.postgresql;
import java.sql.Connection;

import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.CityEntity;

import java.util.UUID;



import java.util.List;

public final class CitySqlServerDAO extends SqlConnection implements CityDAO {
	
public CitySqlServerDAO(final Connection connection) {
		super(connection);
	}
	@Override
	public List<CityEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityEntity> findByFilter(CityEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
