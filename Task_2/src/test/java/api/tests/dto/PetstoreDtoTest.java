package api.tests.dto;

import api.dto.PetDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import api.util.AuthTokenProvider;

public class PetstoreDtoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        RestAssured.filters((reqSpec, resSpec, ctx) -> {
            if (AuthTokenProvider.isTokenPresent()) {
                reqSpec.header("Authorization", "Bearer " + AuthTokenProvider.getToken());
            }
            return ctx.next(reqSpec, resSpec);
        });
    }

    @Test
    void testCreatePetWithDto() {
        PetDto pet = new PetDto();
        pet.id = 123456789;
        pet.name = "DtoDog";
        pet.photoUrls = Collections.singletonList("http://example.com/photo");
        pet.status = "available";

        assert System.getProperty("token").equals("123456");

        given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .body("name", equalTo(pet.name))
                .body("status", equalTo(pet.status));
    }
}