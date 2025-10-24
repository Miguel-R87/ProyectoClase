
package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;



public final class CountryDto  {
	private String name;
	private UUID id;

	
	public CountryDto() {
		setName(TextHelper.getDefault());
	}
	
	public CountryDto(final UUID id,final String name) {
		setName(name);
		setId(id);
	}
	public CountryDto(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());

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
	
	static CountryDto  getDefaultValue() {
		return new CountryDto();
		}
	static CountryDto  getDefaultValue(final CountryDto country) {
		return ObjectHelper.getDefault(country, CountryDto.getDefaultValue());
		};

}
