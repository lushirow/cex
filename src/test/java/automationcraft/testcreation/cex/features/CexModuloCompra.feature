#Feature: CEX, Modulo de Compra
Feature: G3 Modulo de Compra
  Modulo que consiste en comprar 4 productos

  @cex
  Scenario: Compra productos varios
    Given que soy un usuario e ingreso a la web "automationpractice"
    When Apreto en Women
    And Agrego al carrito Faded Short Sleeve T-shirts y sigo comprando
    And Agrego al carrito Blouse y sigo comprando
    And Agrego al carrito Printed dress y sigo comprando
    And Agrego al carrito Printed Summer Dress
    And Ingreso mi fecha de nacimiento
    And Hago el check de los dos checkbox para recibir ofertas
    And Completo los datos de la direccion
    And Ingreso mi numero de telefono y celular
    And Hago click en registrar
    Then Comprobamos que nos registramos en la pagina con exito



