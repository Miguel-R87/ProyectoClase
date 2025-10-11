package co.edu.uco.nose.data.dao.entity.postgresql;

import co.edu.uco.nose.data.dao.entity.IdTypeDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.IdTypeEntity;
import java.util.UUID;
import java.util.List;
import java.sql.Connection;

public final class IdTypeSqlServerDAO extends SqlConnection implements IdTypeDAO {

	public IdTypeSqlServerDAO(Connection connection) {
		super(connection);
	}
	@Override
	public List<IdTypeEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IdTypeEntity> findByFilter(IdTypeEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdTypeEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
