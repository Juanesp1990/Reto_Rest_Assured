Feature: crear un nuevo registro
  como un usuario de la página quiero crear un nuevo registro
  asignando un nombre de usuario y un  trabajo

  Scenario: Creación de registro
    Given el usuario está en la página de creacion de un nuevo registro e ingresa el nombre "morpheus" y el campo trabajo "leader"
    When cuando el usuario hace una petición de creación de registro
    Then el usuario deberá ver un codigo de respuesta éxitoso y los datos creados