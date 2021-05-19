#Feature: CEX, Modulo de Registro
Feature: G3 Modulo de Registro
  Modulo que consiste en registrarse en la pagina de automationpractice

  @cex
  Scenario: Registrarse
    Given que soy un usuario e ingreso a la web "automationpractice"
    When Apreto en Sign in
    And Ingreso el correo y hago click en Create an account
    And Me identifico como Mr. o Mrs.
    And Completo nombre y apellido
    And Ingreso mi correo y contraseña
    And Ingreso mi fecha de nacimiento
    And Hago el check de los dos checkbox para recibir ofertas
    And Completo los datos de la direccion
    And Ingreso mi numero de telefono y celular
    And Hago click en registrar
    Then Comprobamos que nos registramos en la pagina con exito



