package co.edu.uco.nose.crosscuting.helper;

import java.util.UUID;

public final class UUIDHelper {
	private static final UUIDHelper INSTANCE = new UUIDHelper();
	private static final String UUID_DEFAULT_AS_STRING="00000000-0000-0000-0000-000000000000";
	
	private UUIDHelper() {	
	}

	public static UUIDHelper getUUIDHelper() {
		return INSTANCE;
		
	}
	public UUIDHelper getUUIDHelper() {
		return UUID.fromString(UUID_DEFAULT_AS_STRING);
	}
	public UUID getDefault() {
		return getFromString(UUID_DEFAULT_AS_STRING);
	}
	public UUID getDefault(final UUID value) {
		return ObjectHelper.getDefault(value,getDefault());
	}
	
	
	
	public UUID getUUID getFtomString(final String uuidAsString) {
		
	}
}
