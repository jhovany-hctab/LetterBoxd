package user

import launcher
import media.EntertainmentMedia
import media.model.ReviewData
import utility.title
import utility.titleAndInputValue

class User {

    val nameUser = "User"

    companion object {
        fun userMenu() {
            val option = titleAndInputValue(
                """
                    ELIJE UNA OPCION:
                    1.- VER PELÍCULAS
                    2.- CERRAR SESIÓN
                """.trimIndent()
            )

            if (option.equals("1")){
                var list = mutableListOf<ReviewData>()
                list.add(0, ReviewData("Jhovany", "Muy buena la recomiendo al 100%."))
                list.add(1, ReviewData("Pedro", "Me gustó más el comienzo, después se me hizo aburrido."))
                list.add(2, ReviewData("Juan", "Ojala tenga continuación."))

                EntertainmentMedia("Soy Robot", "135 min", "Acción", "Pelicula futurista", list)
                    .infoMedia()
            }
            else if (option.equals("2"))
                launcher()
            else {
                title("La opción seleccionada no existe, RECUERDE opciones disponibles: 1  y  2")
                userMenu()
            }
        }
    }
}