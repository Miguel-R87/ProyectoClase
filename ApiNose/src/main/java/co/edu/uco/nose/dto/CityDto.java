package co.edu.uco.nose.dto;


import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.StateEntity;

public final class CityDto extends Dto{
	private String name;
	private StateDto state;
	
	public CityDto() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());  
	}
	public CityDto(final UUID id,final String name,final StateDto state) {
		super(id);
		setName(name);	
		setState(state);	
		
	}
	
	static CityDto  getDefaultValue() {
		return new CityDto(); 

}
	public String getName() {
		return name;
	}

		
	public void setName(final String name) {
		this.name=TextHelper.getDefaultWithTrim(name);
	}
	public void setState(final StateDto state) {
		this.state=ObjectHelper.getDefault(state , StateDto.getDefaultValue());
	}
	
}
	
