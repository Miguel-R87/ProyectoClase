package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.entity.UserEntity;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;

public class UserEntityAssembler implements EntityAssembler<UserEntity, UserDomain> {

    private static final IdTypeEntityAssembler idTypeAssembler = new IdTypeEntityAssembler();

    @Override
    public UserEntity toEntity(UserDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new UserDomain());
        return new UserEntity(
            domainTmp.getId(),
            domainTmp.getFirstName(),
            domainTmp.getLastName(),
            idTypeAssembler.toEntity(domainTmp.getIdType())
        );
    }

    @Override
    public UserDomain toDomain(UserEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new UserEntity());
        return new UserDomain(
            entityTmp.getId(),
            entityTmp.getFirstName(),
            entityTmp.getLastName(),
            idTypeAssembler.toDomain(entityTmp.getIdType())
        );
    }
}
