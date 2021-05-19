#Feature: Grupo 3, Modulo de  Vuelos, Busqueda Smart Fallida por Codigo Promocional
Feature: G3 Modulo de Vuelos
  Archivo Gherkin que contiene la casuistica del Modulo de Vuelos de la web JetSmart
  este escenario esta basado en el punto de vista del usuario final y trata de validar que sucede cuando
  un usuario ingresa un codigo promocional no valido.

  @G3 @BootCamp @Baja
  Scenario: Busqueda Smart que falla
    Given que soy un usuario e ingreso a la web "JetSmart"
    When ingreso al formulario de Vuelos
    And ingreso Origen "Santiago"
    And ingreso Destino "Buenos Aires"
    And selecciono la opcion de viaje solo ida
    And ingreso la "fecha" de ida en el Calendario
    And ingreso un "codigo" promocional
    And presiono el boton Busqueda Smart
    Then aparece alerta de codigo promocional no valido

#    #Feature: Grupo 3, Modulo de Vuelos, HappyPath
#Feature: G3 Modulo de Vuelos casi reserva
#  Archivo Gherkin que contiene la causistica del Modulo de Vuelos de la web JetSmart
#  este escenario esta basado en el punto de vista del usuario final y trata de validar
#  el avance de un usuario rellenando la reservación hasta el punto justo antes de reservar.

  @G3 @BootCamp @Alta
  Scenario: rellenar formulario de vuelos hasta casi reservarlo
    Given que soy un usuario e ingreso a la web "JetSmart"
    When ingreso al formulario de Vuelos
    And ingreso Origen "Santiago"
    And ingreso Destino "Buenos Aires"
    And selecciono la opcion de viaje solo ida
    And ingreso la "fecha" de ida en el Calendario
    And presiono el boton Busqueda Smart
    And selecciono el paquete mas barato
    And relleno los datos del pasajero con el "Nombre y Apellido" y la "Fecha de Nacimiento"
    And selecciono el equipaje
    And presiono el boton No quiero elegir Asientos
    And selecciono llevar tarjeta de Embargue
    Then aparece el formulario de pago

#    #Feature: Grupo 3, Modulo de Vuelos, Alerta de Modificacion de Reserva
#Feature: G3 Modulo de Vuelos Modificar Reserva
#  Archivo Gherkin que contiene la causistica del modulo de vuelos de la web JetSmart
#  este escenario esta basado en el punto de vista del usuario final y trata de validar
#  que la funcion de modificacion de reserva este disponible para el usuario.

  @G3 @BootCamp @Media
  Scenario: rellenar formulario e intentar modificar la reserva
    Given que soy un usuario e ingreso a la web "JetSmart"
    When ingreso al formulario de Vuelos
    And ingreso Origen "Santiago"
    And ingreso Destino "Buenos Aires"
    And selecciono la opcion de viaje solo ida
    And ingreso la "fecha" de ida en el Calendario
    And presiono el boton Busqueda Smart
    And selecciono el paquete mas barato
    And relleno los datos del pasajero con el "Nombre y Apellido" y la "Fecha de Nacimiento"
    Then aparece la opcion de modificar la reserva