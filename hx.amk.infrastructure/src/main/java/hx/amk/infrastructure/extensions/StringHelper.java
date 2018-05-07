package hx.amk.infrastructure.extensions;

public class StringHelper {

    public static boolean isNullOrEmpty(String source){
        return source==null || source.length()==0;
    }

    public static boolean isNullOrWhitespace(String source) {
        return source == null || isWhitespace(source);

    }
    private static boolean isWhitespace(String source) {
        int length = source.length();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(source.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
