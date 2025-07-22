package api;

import api.model.Pet;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetApiTest {

    static {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @ParameterizedTest
    @MethodSource("api.data.PetProvider#providePets")
    public void createPet(Pet pet) {
        given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .body("id", equalTo((int) pet.id))
                .body("name", equalTo(pet.name))
                .body("status", equalTo(pet.status));
    }
}
