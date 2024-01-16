#language:es

Característica: Buscar en Wikipedia

  Escenario: Buscar un término con artículo existente
    Dado un usuario que se encuentra en la pagina principal de Wikipedia
    Cuando el usuario navega a la seccion en espanol
    Y realiza la busqueda del termino "Selenium"
    Entonces se muestra el titulo "Selenium"
    Y se muestra el titulo de la imagen "Selenium"

  Esquema del escenario: Buscar un término con artículo existente
    Dado un usuario que se encuentra en la pagina principal de Wikipedia
    Cuando el usuario navega a la seccion en espanol
    Y realiza la busqueda del termino <terminoDeBusqueda>
    Entonces se muestra el titulo <tituloEsperado>
    Y se muestra el titulo de la imagen <tituloImagenEsperado>
    Ejemplos:
      |terminoDeBusqueda|tituloEsperado|tituloImagenEsperado|
      |"Selenium"       |"Selenium"    |"Selenium"          |
      | "idioma español"|"Idioma español"|"Español / Castellano" |