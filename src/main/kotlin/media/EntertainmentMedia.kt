package media

import media.model.MediaData
import media.model.ReviewData
import utility.title
import utility.titleAndInputValue

const val synopsis1 = "Michael Corleone, héroe de guerra e hijo menor de un poderoso jefe de la mafia \n" +
        "neoyorquina, decide unirse a la organización cuando su padre sufre un atentado."
const val synopsis2 = "Tras aceptar un soborno descomunal, una poderosa corporación televisiva \n" +
        "intenta mejorar con mentiras la imagen de un notorio político corrupto."
const val synopsis3 = "Cuando la guerra asola Nigeria, un miembro del equipo SEAL de la Marina \n" +
        "deberá rescatar a una médica refugiada en la jungla y a toda la gente bajo \n" +
        "su cuidado."
const val synopsis4 = "En un mundo post-apocalíptico, Katniss y Peeta representan a su distrito en una \n" +
        "competencia televisada en la que cada participante lucha contra la muerte."
const val synopsis5 = "En una misión para recuperar a una hermosa princesa de las garras de un dragón feroz, \n" +
        "un ogro gruñón forma un equipo con un burro ocurrente."
const val synopsis6 = "Un parque temático de dinosaurios busca atraer turistas con una emocionante \n" +
        "exhibición, pero su criatura más terrible logra escapar y desata el caos en la isla."

open class EntertainmentMedia(
    var media: MutableList<MediaData>? = null
) {

    open fun infoMedia() {}

    fun getReviewUser(): MutableList<ReviewData> {
        val list = mutableListOf<ReviewData>()
        list.add(0, ReviewData("Jhovany", "Muy buena la recomiendo al 100%."))
        list.add(1, ReviewData("Pedro", "Me gustó más el comienzo, después se me hizo aburrido."))
        list.add(2, ReviewData("Juan", "Ojala tenga continuación."))

        return list
    }
    open fun getMediaAll(): MutableList<MediaData> {
        val list = mutableListOf<MediaData>()
        list.add(0, MediaData("El Padrino", "166min", "Acción", synopsis1, getReviewUser()))
        list.add(1, MediaData("La Dictadura Perfecta", "120min", "Cine Mexicano", synopsis2, getReviewUser()))
        list.add(2, MediaData("Lagrimas Del Sol", "90min", "Acción", synopsis3, getReviewUser()))
        list.add(3, MediaData("Los Juegos Del Hambre", "90min", "Suspenso", synopsis4, getReviewUser()))
        list.add(4, MediaData("Shrek", "100min", "Infantil", synopsis5, getReviewUser()))
        list.add(5, MediaData("Jurassic World", "85min", "Aventura", synopsis6, getReviewUser()))

        return list
    }
    open fun showMediaAll() {
        title("Todas las películas")
        var count = 1
        media?.forEach {
            println("${count++} ${it.title}")
        }
        mediaMenu()
    }


    fun mediaMenu() {
        title("OPCIONES")
        val option = titleAndInputValue("INGRESE EL NOMBRE DE LA PELÍCULA O NÚMERO PARA VER SUS DETALLES: ")

        when(option?.lowercase()) {
            "1", "el padrino" -> {
                media?.get(0)?.let { Movies(it).infoMedia() }
            }

            "2", "la dictadura perfecta" -> {
                media?.get(1)?.let { Movies(it).infoMedia() }
            }

            "3", "lagrimas del sol" -> {
                media?.get(2)?.let { Movies(it).infoMedia() }
            }

            "4", "los juegos del hambre" -> {
                media?.get(3)?.let { Movies(it).infoMedia() }
            }

            "5", "shrek" -> {
                media?.get(4)?.let { Movies(it).infoMedia() }
            }

            "6", "jurassic world" -> {
                media?.get(5)?.let { Movies(it).infoMedia() }
            }

            else -> {
                println("NO SE ENCONTRÓ LA PELÍCULA SELECCIONADA")
                showMediaAll()
            }
        }
    }
}