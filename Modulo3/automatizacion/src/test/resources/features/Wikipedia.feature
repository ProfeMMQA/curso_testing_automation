#language:es

Característica: Buscar términos en Wikipedia

  Antecedentes:
    Dado que el usuario se encuentra en la pagina principal de wikipedia

  Escenario: Buscar un término en Wikipedia
    Cuando el usuario ingresa a la sección en español
    Y realiza la búsqueda de "Selenium"
    Entonces observa que el título del artículo es "Selenium"
    Y observa que el título de la imagen es "Selenium"

  Esquema del escenario:
    Cuando el usuario ingresa a la sección en español
    Y realiza la búsqueda de <terminoDeBusqueda>
    Entonces observa que el título del artículo es <tituloEsperado>
    Y observa que el título de la imagen es <tituloDeImagenEsperado>
    Ejemplos:
      | terminoDeBusqueda | tituloEsperado   | tituloDeImagenEsperado |
      | "Selenium"        | "Selenium"       | "Selenium"             |
      | "idioma español"  | "Idioma español" | "Español / Castellano" |

