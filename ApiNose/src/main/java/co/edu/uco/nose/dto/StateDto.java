package co.edu.uco.nose.dto;


import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;


public final class StateDto  {
	private String name;
	private CountryDto country;
	private UUID id;
	
	public StateDto() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setCountry(CountryDto.getDefaultValue());
	}
	public StateDto(final UUID id, final String name, final CountryDto country) {
		setId(id);
		setName(name);
		setCountry(country);
	}	
	public StateDto(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setCountry(CountryDto.getDefaultValue());
	}	
	static StateDto getDefaultValue() {
        return new StateDto();
    }
	public String getName() {
		return name;
	}
	public CountryDto getCountry() {
		return country;
	}
	

	public void setName(final String name) {
		this.name=TextHelper.getDefaultWithTrim(name);
	}
	public void setCountry(final CountryDto country) {
		this.country=ObjectHelper.getDefault(country,CountryDto.getDefaultValue());
	}
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	

}