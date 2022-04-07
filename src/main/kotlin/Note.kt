data class Note(
    public var noteId: Int,
    val title: String,
    val text: String,
    val privacy: Int,
    val privacyView: String,
    val privacyComment: String
//    val commentPrivacy: String,
//    val note_ids: String,
//    val user_id: Int,
//    val offset: Int,
//    val count: Int,
//    val sort: Int,
//    val need_wiki: Boolean
)