package co.edu.uco.nose.business.domain;


import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CityDomain extends Domain{
	private String name;
	private StateDomain state;
	
	public CityDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());  
	}
	public CityDomain(final UUID id,final String name,final StateDomain state) {
		super(id);
		this.name=name;
		this.state=state;
	}
	
	static CityDomain  getDefaultValue() {
		return new CityDomain(); 

}
	public String getName() {
		return name;
	}

		
	public void setName(final String name) {
		this.name=TextHelper.getDefaultWithTrim(name);
	}
	
	
}
	
