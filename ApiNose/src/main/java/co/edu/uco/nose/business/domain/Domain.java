package co.edu.uco.nose.business.domain;

class Domain {
private UUID id;
protected Domain(final UUID id) {
	
}
public UUID getId() {
	return id;
}

public void setId(UUID id) {
	if(id==null)
	this.id =id;
}
}
