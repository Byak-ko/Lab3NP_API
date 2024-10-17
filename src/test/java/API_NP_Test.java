import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class API_NP_Test {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.novaposhta.ua/v2.0/json/";
    }
    // Сценарій 1: Перевірка створення нового ресурсу (отримання міст)
    @Test
    public void createResourceTest() {
        String requestBody = "{"
                + "\"apiKey\": \"55056fa5affcb8e2e1fb975d51066a89\","
                + "\"modelName\": \"Address\","
                + "\"calledMethod\": \"getCities\","
                + "\"methodProperties\": {}"
                + "}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/")
                .then()
                .statusCode(200)
                .body("success", equalTo(true))
                .log().all();
    }
    // Сценарій 2: Перевірка статус-коду
    @Test
    public void checkStatusCode() {
        String requestBody = "{"
                + "\"apiKey\": \"55056fa5affcb8e2e1fb975d51066a89\","
                + "\"modelName\": \"Address\","
                + "\"calledMethod\": \"getCities\","
                + "\"methodProperties\": {}"
                + "}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/")
                .then()
                .statusCode(200)
                .log().all();
    }
    // Сценарій 3: Перевірка валідації даних (некоректний запит)
    @Test
    public void invalidDataValidationTest() {
        String invalidRequestBody = "{"
                + "\"apiKey\": \"55056fa5affcb8e2e1fb975d51066a89\","
                + "\"modelName\": \"InvalidModel\","
                + "\"calledMethod\": \"getCities\","
                + "\"methodProperties\": {}"
                + "}";

        given()
                .contentType("application/json")
                .body(invalidRequestBody)
                .when()
                .post("/")
                .then()
                .statusCode(200)
                .body("success", equalTo(false))
                .log().all();
    }
    // Сценарій 4: Перевірка фільтрації (пошук по місту)
    @Test
    public void searchCityByNameTest() {
        String requestBody = "{"
                + "\"apiKey\": \"55056fa5affcb8e2e1fb975d51066a89\","
                + "\"modelName\": \"Address\","
                + "\"calledMethod\": \"getCities\","
                + "\"methodProperties\": {\"FindByString\": \"Київ\"}"
                + "}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/")
                .then()
                .statusCode(200)
                .body("data[0].Description", equalTo("Київ"))
                .log().all();
    }
    // Сценарій 5: Перевірка аутентифікації (правильний ключ API)
    @Test
    public void authenticationTest() {
        String requestBody = "{"
                + "\"apiKey\": \"55056fa5affcb8e2e1fb975d51066a89\","
                + "\"modelName\": \"Address\","
                + "\"calledMethod\": \"getCities\","
                + "\"methodProperties\": {}"
                + "}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/")
                .then()
                .statusCode(200)
                .body("success", equalTo(true))
                .log().all();
    }

    // Сценарій 6: Перевірка HTTP-методів (POST для отримання ресурсів)
    @Test
    public void checkHttpMethods() {
        String requestBody = "{"
                + "\"apiKey\": \"55056fa5affcb8e2e1fb975d51066a89\","
                + "\"modelName\": \"Address\","
                + "\"calledMethod\": \"getCities\","
                + "\"methodProperties\": {}"
                + "}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/")
                .then()
                .statusCode(200)
                .body("success", equalTo(true))
                .log().all();
    }
}