package utility

fun title(title: String) {
    println("-----------------------------------> $title")
}

fun titleAndInputValue(title: String): String? {
    println("**$title")
    return readlnOrNull()
}