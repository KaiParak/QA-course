package api.util;

public class AuthTokenProvider {
    public static String getToken() {
        String token = System.getProperty("token", "");
        System.out.println("[DEBUG] TOKEN: " + (token.isBlank() ? "NOT SET" : token));
        return token;
    }

    public static boolean isTokenPresent() {
        return !getToken().isBlank();
    }
}
