package login

import utility.title
import utility.titleAndInputValue

class Login {

    private var userName: String? = null
    private var password: String? = null
    private var status = false

    private val users = mapOf(
        "kotlin@bedu.org" to "Kotlindesarrollo",
        "daniel@cliente.com" to "Cliente123",
        "Fernando@empresa.mx" to "F3R2472",
        "admin" to "admin"
    )

    fun login(): Boolean {

        title("Login")
        userName = titleAndInputValue("INGRESE EL USUARIO")
        password = titleAndInputValue("INGRESE LA CONTRASEÑA")

        users.forEach {
            if (userName.equals(it.key) && password.equals(it.value)) status = true
        }

        val message =
            if (status) "¡Inicio de sesión exitoso!"
            else "¡Usuario o contraseña incorrecto! VUELVA A INTENTAR"

        title(message)

        return status
    }
}