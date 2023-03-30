import login.Login
import user.User

fun main() {
    launcher()
}

fun launcher() {
    if (Login().login()) User.userMenu() else main()
}
