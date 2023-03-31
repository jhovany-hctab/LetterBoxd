package user

import launcher
import media.EntertainmentMedia
import utility.title
import utility.titleAndInputValue

class User {

    val nameUser = "User"

    companion object {
        fun userMenu() {
            title("Menú principal")
            val option = titleAndInputValue(
                """
                    ELIJE UNA OPCION:
                    1.- VER PELÍCULAS
                    2.- CERRAR SESIÓN
                """.trimIndent()
            )

            if (option.equals("1")){
                val listMedia = EntertainmentMedia().getMediaAll()
                EntertainmentMedia(media = listMedia)
                    .showMediaAll()
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