Feature: actualizar datos de registro
  como un usuario registrado del sistema
  necesito actualizar el campo trabajo asignado a mi nombre

  Scenario: Registro actualizado completamente
    Given el usuario está en la página de actualización de trabajo con el nombre usuario "morpheus" y el campo trabajo que desea actualizar "zion resident"
    When cuando el usuario hace una petición de actualizacion
    Then el usuario deberá ver un codigo de respuesta éxitoso y los datos actualizados