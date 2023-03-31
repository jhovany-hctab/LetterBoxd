package media

import kotlinx.coroutines.*
import media.model.MediaData
import media.model.ReviewData
import user.User.Companion.userMenu
import utility.title
import utility.titleAndInputValue

class Movies(val movie: MediaData) :
    EntertainmentMedia() {
    override fun infoMedia() {
        title("Detalles")
        val info = """
            Nombre -> ${movie.title}
            Duración: ${movie.duration}
            Genero:   ${movie.gender}
                
            Sipnosis:
            ${movie.synopsis}
                
            """.trimIndent()

        println(info)
        title("Reseñas de usuarios de ${movie.title}")
        movie.reviews?.forEach {
            println(":)️ ${it.nameUser}")
            println(it.review)
            println()
        }
        moviesMenu()
    }

    fun moviesMenu() {
        title("OPCIONES")
        val option = titleAndInputValue(
            """
                ELIJA UNA OPCIÓN
                1.- DESCARGAR PELÍCULA
                2.- AGREGAR RESEÑA
                3.- VOLVER AL MENÚ PRINCIPAL
            """.trimIndent()
        )
        when(option) {
            "1" -> downloadMovie()
            "2" -> addReview()
            "3" -> userMenu()
            else -> {
                title("La opción seleccionada no existe, RECUERDE opciones disponibles: 1,2 y 3")
                moviesMenu()
            }
        }

    }

    private fun addReview() {
        var option = titleAndInputValue("Ingrese su reseña:")
        movie.reviews?.add(movie.reviews.size, ReviewData("ThisUser", option.toString()))
        title("Reseña agregada")
        infoMedia()
    }

    fun downloadMovie() = runBlocking {
        withTimeout(10_000L) {
            repeat(100) {
                println("Descargando ${movie.title} $it% ...")
                delay(10L)
                if (it == 99) {
                    title("Se descargó: ${movie.title}")
                    infoMedia()
                }
            }
        }
    }

}