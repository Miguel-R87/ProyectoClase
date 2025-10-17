package co.edu.uco.nose.dto;


import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class StateDto extends Dto {
	private String name;
	private CountryDto country;
	
	public StateDto() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setCountry(CountryDto.getDefaultValue());
	}
	public StateDto(final UUID id, final String name, final CountryDto country) {
		super(id);
		setName(name);
		setCountry(country);
	}	
	public StateDto(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setCountry(CountryDto.getDefaultValue());
	}	
	static StateDto getDefaultValue() {
        return new StateDto();
    }

	public void setName(final String name) {
		this.name=TextHelper.getDefaultWithTrim(name);
	}
	public void setCountry(final CountryDto country) {
		this.country=ObjectHelper.getDefault(country,CountryDto.getDefaultValue());
	}
	

}