package co.edu.uco.nose.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.business.domain.IdTypeDomain;
import co.edu.uco.nose.business.domain.assembler.dto.DTOAssembler;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.IdTypeDto;

public final class IdTypeDTOAssembler implements DTOAssembler<IdTypeDto,IdTypeDomain> {
	private static final DTOAssembler<IdTypeDto, IdTypeDomain> instance = new IdTypeDTOAssembler();
	private IdTypeDTOAssembler() {
		
	}
	public static DTOAssembler<IdTypeDto, IdTypeDomain> getIdentificationTypeDTOAssembler() {
		return instance;
	}
	@Override
	public IdTypeDto toDTO(final IdTypeDomain domain) {
		var domainTmp=ObjectHelper.getDefault(domain, new IdTypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new IdTypeDto(domainTmp.getId(),domainTmp.getName());
	}
	@Override
	public IdTypeDomain toDomain(final IdTypeDto dto) {
var dtoTmp=ObjectHelper.getDefault(dto, new IdTypeDto());
return new IdTypeDomain(dtoTmp.getId(),dtoTmp.getName());
	}
	@Override
	public List<IdTypeDto> toDTO(List<IdTypeDomain> domainList) {
		var idTypeDtoList=new ArrayList<IdTypeDto>();
		
		for(var IdTypeDomain: domainList) {
			idTypeDtoList.add(toDTO(IdTypeDomain));
		}
				
		
		return idTypeDtoList;
	}
	
	

}
