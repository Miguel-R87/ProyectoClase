package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.domain.IdTypeDomain;
import co.edu.uco.nose.business.domain.assembler.entity.EntityAssembler;
import co.edu.uco.nose.entity.IdTypeEntity;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public class IdTypeEntityAssembler implements EntityAssembler <IdTypeEntity, IdTypeDomain> {

	private static final EntityAssembler<IdTypeEntity, IdTypeDomain> instance = new IdTypeEntityAssembler();
	private IdTypeEntityAssembler() {
		
	}
	
	public static EntityAssembler<IdTypeEntity, IdTypeDomain> getIdentificationTypeEntityAssembler() {
		return instance;
	}
	@Override
	public IdTypeEntity toEntity(IdTypeDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new IdTypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new IdTypeEntity(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public IdTypeDomain toDomain(IdTypeEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new IdTypeEntity());
		return new IdTypeDomain(entityTmp.getId(), entityTmp.getName());
	}


}

