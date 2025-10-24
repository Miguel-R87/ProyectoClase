package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public class IdTypeDto {
	
	private String name;
	private UUID id;
	
	public IdTypeDto() {
		setName(TextHelper.getDefault());
		setId(UUIDHelper.getUUIDHelper().getDefault());
	}
	
	public IdTypeDto(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
	}
	

	public IdTypeDto(final UUID id, final String name) {
		setId(id);
		this.name = name;
	}
	
	static IdTypeDto getDefaultValue() {
		return new IdTypeDto();
	}
	
	static IdTypeDto getDefaultValue(final IdTypeDto identifiactionType) {
		return ObjectHelper.getDefault(identifiactionType, getDefaultValue());
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	

}