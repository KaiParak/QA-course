package api.tests.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import api.util.AuthTokenProvider;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PetstoreApiTest {

    private final HttpClient client = HttpClient.newHttpClient();
    private final String baseUrl = "https://petstore.swagger.io/v2";

    @Test
    void testGetPetById() throws IOException, InterruptedException {
        long petId = 1;

        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/pet/" + petId))
                .GET();

        if (AuthTokenProvider.isTokenPresent()) {
            requestBuilder.header("Authorization", "Bearer " + AuthTokenProvider.getToken());
        }

        HttpRequest request = requestBuilder.build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode(), "GET /pet/{petId} should return 200");
        assertTrue(response.body().contains("\"id\":" + petId), "Response should contain the correct pet ID");
    }

    @Test
    void testCreatePet() throws IOException, InterruptedException {
        String jsonBody = """
                {
                  "id": 123456,
                  "name": "Fluffy",
                  "photoUrls": [],
                  "status": "available"
                }
                """;

        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/pet"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody));

        if (AuthTokenProvider.isTokenPresent()) {
            requestBuilder.header("Authorization", "Bearer " + AuthTokenProvider.getToken());
        }

        HttpRequest request = requestBuilder.build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode(), "POST /pet should return 200");
        assertTrue(response.body().contains("\"name\":\"Fluffy\""), "Response should contain the pet name");
    }
}
