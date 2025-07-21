    package api.tests.restassured;

    import io.restassured.RestAssured;
    import io.restassured.http.ContentType;
    import org.junit.jupiter.api.BeforeAll;
    import org.junit.jupiter.api.Test;

    import api.util.AuthTokenProvider;

    import static io.restassured.RestAssured.given;
    import static org.hamcrest.Matchers.*;

    public class PetstoreApiTest {

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
        void testCreatePet() {
            String requestBody = """
                    {
                      "id": 987654,
                      "name": "RestAssuredDoggo",
                      "photoUrls": [],
                      "status": "available"
                    }
                    """;

            given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .when()
                    .post("/pet")
                    .then()
                    .statusCode(200)
                    .body("name", equalTo("RestAssuredDoggo"))
                    .body("status", equalTo("available"));
        }

        @Test
        void testGetPetById() {
            long petId = 1;

            given()
                    .pathParam("petId", petId)
                    .when()
                    .get("/pet/{petId}")
                    .then()
                    .statusCode(200)
                    .body("id", equalTo((int) petId));
        }
    }
