data class Comment(
    val noteId: Int,
    val commentId: Int,
    val ownerId: Int,
    val replyTo: Int,
    val message: String,
    val guid: String,
)