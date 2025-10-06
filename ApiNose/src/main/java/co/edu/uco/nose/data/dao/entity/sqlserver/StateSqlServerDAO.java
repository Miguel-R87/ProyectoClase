package co.edu.uco.nose.data.dao.entity.sqlserver;

import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.entity.StateEntity;

import java.util.List;
import java.util.UUID;

public final class StateSqlServerDAO implements StateDAO {
    @Override
    public void create(StateEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<StateEntity> findAll() {
        return null;
    }

    @Override
    public List<StateEntity> findByFilter(StateEntity filterEntity) {
        return null;
    }

    @Override
    public StateEntity findById(UUID uuid) {
        return null;
    }

    @Override
    public void update(StateEntity entity) {

    }
}
