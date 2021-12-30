package co.com.sofka.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;


import static io.restassured.RestAssured.given;


public class PeticionesStepDefinition extends ReqresIn {
    private RequestSpecification requestCreate;
    private Response responseCreate;

    private RequestSpecification requestUpdate;
    private Response responseUpdate;
    private static final Logger LOGGER = Logger.getLogger(PeticionesStepDefinition.class);

    @Given("el usuario está en la página de creacion de un nuevo registro e ingresa el nombre {string} y el campo trabajo {string}")
    public void elUsuarioEstAEnLaPaginaDeCreacionDeUnNuevoRegistroEIngresaElNombreYElCampoTrabajo (String nombre, String categoriaTrabajo) {
        try {
            generalSetup();
            requestCreate = given().body("{\n" +
                    "    \"name\": \"" + nombre + "\",\n" +
                    "    \"job\": \"" + categoriaTrabajo + "\"\n" +
                    "}");

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();

        }


    }

    @When("cuando el usuario hace una petición de creación de registro")
    public void cuandoElUsuarioHaceUnaPeticionDeCreacionDeRegistro () {
        try {
            responseCreate = requestCreate.post(RESOURCE_CREATE);

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();

        }

    }

    @Then("el usuario deberá ver un codigo de respuesta éxitoso y los datos creados")
    public void elUsuarioDeberaVerUnCodigoDeRespuestaExitosoYLosDatosCreados () {
        try {
            String mensaje = responseCreate
                    .then()
                    .extract()
                    .asString();

            Assertions.assertEquals("\"name\":\"morpheus\",\"job\":\"leader\"", mensaje.substring(1, 33));

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();

        }


    }

    @Given("el usuario está en la página de actualización de trabajo con el nombre usuario {string} y el campo trabajo que desea actualizar {string}")
    public void elUsuarioEstaEnLaPaginaDeActualizacionDeTrabajoConElNombreUsuarioYElCampoTrabajoQueDeseaActualizar (String nombre, String categoriaTrabajo) {
        try {
            generalSetup();
            requestUpdate = given().body("{\n" +
                    "    \"name\": \"" + nombre + "\",\n" +
                    "    \"job\": \"" + categoriaTrabajo + "\"\n" +
                    "}");

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();

        }

    }

    @When("cuando el usuario hace una petición de actualizacion")
    public void cuandoElUsuarioHaceUnaPeticionDeActualizacion () {
        try {
            responseCreate = requestUpdate.put(RESOURCE_UPDATE);

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();

        }


    }

    @Then("el usuario deberá ver un codigo de respuesta éxitoso y los datos actualizados")
    public void elUsuarioDeberaVerUnCodigoDeRespuestaExitosoYLosDatosActualizados () {
        try {
            String mensaje = responseCreate
                    .then()
                    .extract()
                    .asString();

            Assertions.assertEquals("\"name\":\"morpheus\",\"job\":\"zion resident\"", mensaje.substring(1, 40));

        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();

        }


    }
}
