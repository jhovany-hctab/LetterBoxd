package media

import media.model.ReviewData
import user.User
import utility.spacer
import utility.title
import utility.titleAndInputValue

class EntertainmentMedia(
    val title: String,
    val duration: String,
    val gender: String,
    val synopsis: String,
    var reviews: MutableList<ReviewData>? = null
) {

    fun infoMedia() {
        title(title)
        val info = """
            Duración: $duration
            Genero:   $gender
            
            Sipnosis: 
            $synopsis
            
            Reseñas: 
            
        """.trimIndent()

        println(info)
        if (reviews != null){
            reviews?.forEach {
                println(":-) ${it.nameUser}")
                println("${it.review}")
                println()
            }
        } else {"no hay reseñas"}

        spacer()
        mediaMenu()
    }

    fun mediaMenu() {
        val option = titleAndInputValue(
            """
                    ELIJE UNA OPCION:
                    1.- CREAR RESEÑA
                    2.- GUARDAR EN FAVORITOS
                    3.- VOLVER AL MENÚ PRINCIPAL
                """.trimIndent()
        )

        if (option.equals("1"))

        else if (option.equals("2"))
            //launcher()
        else {
            title("La opción seleccionada no existe, RECUERDE opciones disponibles: 1, 2 y 3")
            mediaMenu()
        }
    }
}