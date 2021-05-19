#Feature: Grupo 3, Modulo de Hoteles, Busqueda Hotel Con Filtros
Feature: G3 Modulo de Hoteles
  Buscar un hotel aplicando dos filtros y elegir el primer hotel arrojado
  por el buscador con los filtros aplicados

  @G3 @BootCamp @Media
  Scenario: Busqueda hotel con filtros
    Given que soy un usuario e ingreso a la web "JetSmart"
    When Ingreso al formulario de Hoteles
    And Ingreso el destino
    And Agrego un niño
    And Hago click en busqueda smart
    And Aplico filtros de busqueda
    And Selecciono el primer hotel disponible
    Then Comprobamos que estamos en la pagina que queremos con los filtros seleccionados

#Feature: Grupo 3, Modulo de Hoteles, Validacion Posicion Previa Reservacion
#Feature: G3 Modulo de Hoteles Validar Posicion Previa Reservacion
#  Buscar un hotel, rellenar los datos y validar la posicion previa a la
#  reservacion de un apartamento

  @G3 @BootCamp @Alta
  Scenario: Hoteles Validar Posicion Previa Reservacion
    Given que soy un usuario e ingreso a la web "JetSmart"
    When Ingreso al formulario de Hoteles
    And Ingreso el destino
    And Hago click en busqueda smart
    And Selecciono el primer hotel disponible
    And Selecciono los habitantes del apartamento y hago click en reservar
    And Lleno todos los datos personales
    Then Comprobamos que estamos en la pagina que queremos

#Feature: Grupo 3, Modulo de Hoteles, Busqueda Hotel Resultado Correcto
#Feature: G3 Modulo de Hoteles Busqueda de Hotel Resultado Correcto
#  Comparar el resultado de la búsqueda de un hotel con la opcion sugerida por el buscador.

  @G3 @BootCamp @Baja
  Scenario: Busqueda hotel resultado correcto
    Given que soy un usuario e ingreso a la web "JetSmart"
    When Ingreso al formulario de Hoteles
    And Ingreso el destino
    And Agrego un niño
    And Hago click en busqueda smart
    And Selecciono el primer hotel disponible
    Then Aparece el hotel seleccionado
