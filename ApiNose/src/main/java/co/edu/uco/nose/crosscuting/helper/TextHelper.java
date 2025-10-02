package co.edu.uco.nose.crosscuting.helper;

public final class TextHelper {
	private TextHelper() {
		private static final String EMPTY="";
		
	}
	public static boolean getDefault() {
		return EMPTY;
	}
	public static String fetDefault(final String value) {
		return ObjectHelper.getDefault(value,getDefault());
		
	}
	
	public static String getDefaultWithTrim(final String value) {
		return getDefault(value).trim();
	}
}
