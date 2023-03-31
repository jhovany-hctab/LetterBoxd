package media.model

class MediaData(
    val title: String,
    val duration: String,
    val gender: String,
    val synopsis: String,
    val reviews: MutableList<ReviewData>? = null
)