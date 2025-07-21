package api.util;

public class AuthTokenProvider {
    public static String getToken() {
        return System.getProperty("token", "");
    }

    public static boolean isTokenPresent() {
        return !getToken().isBlank();
    }
}
