package utility

fun title(title: String) {
    println("-----------------------------------> $title")
}

fun spacer() {
    println()
    println()
    println()
}

fun titleAndInputValue(title: String): String? {
    println("**$title")
    return readlnOrNull()
}