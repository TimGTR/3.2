data class Comment(
    val comment_id: Int,
    val owner_id: Int,
    val reply_to: Int,
    val message: String,
    val guid: String,
)