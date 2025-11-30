#Author: Esteban Correa - Juan Lopez
    #Language: en

Feature: Loguearme en la tienda online con mi usuario
  Como usuario necesito loguearme en la pagina para poder tener funciones de usuario logueado

  Scenario: Login correcto
    Given estoy en la vista de login de la tienda online
    When pongo mi usuario y contraseña correctos
    Then me logueo correctamente

  Scenario: Usuario vacío
    Given estoy en la vista de login de la tienda online
    When dejo el campo de usuario vacío y pongo una contraseña correcta
    Then veo un mensaje visual de error indicando que el usuario es obligatorio

  Scenario: Contraseña vacía
    Given estoy en la vista de login de la tienda online
    When pongo mi usuario correcto y dejo el campo de contraseña vacío
    Then veo un mensaje visual de error indicando que la contraseña es obligatoria