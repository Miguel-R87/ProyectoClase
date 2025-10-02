package co.edu.uco.nose.business.domain;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CountryDomain extends Domain{
	
private String name;

public CountryDomain(final UUID id,final String name) {
	super(id);
	this.name = name;
}
public CountryDomain() {
	super(UUIDHelper.getUUIDHelper().getDefault());
	setName(TextHelper.getDefault())
}
public String getName() {
	return name;
}
public void setName(final String name) {
	this.name=TextHelper.getDefaultWithTrim(name);
}

}
