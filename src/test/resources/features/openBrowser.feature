Feature: Abrir el navegador

  @abrirNavegador
  Scenario: Abrir el navegador
    Given abra la pagina de Bancolombia
    When hago clic en "Continuar"
    Then se me presenta la pregunta "¿Sabes cuánto dinero necesitas?"
    When doy clic en la opción "Sí"
    And ingreso un monto aleatorio entre 1.000.000 y 500.000.000
    And ingreso un plazo en meses aleatorio entre 48 y 84
    And doy click en el campo fecha de naciemiento
    And doy click en el boton año
    And doy click en el año
    And doy click en el mes
    And doy click en el dia
    And doy click en el boton simular