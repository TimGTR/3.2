object NoteService {
    private var notes = mutableMapOf<Note, MutableList<Comment?>>()
    private var id = 1

    fun add(note: Note): Int {
        note.noteId = id
        id++
        notes.put(note, mutableListOf())
        return id
    }

    fun createComment(comment: Comment): Int {
        for (note in notes) {
            if (comment.noteId == note.key.noteId) {
                note.value.add(comment)
                return comment.commentId
            }
        }
        return 0
    }

    fun delete(noteId: Int): Boolean {
        for (note in notes) {
            if (noteId == note.key.noteId) {
                notes.remove(note.key)
                return true
            }
        }
        return false
    }

    fun deleteComment(commentID: Int, ownerId: Int) {
        for (value in notes.values) {
            for (comment in value) {
                if (comment != null) {
                    if (comment.commentId == commentID) {
                        value.remove(comment)
                    }
                }
            }
        }

    }

    fun edit(noteId: Int, title: String, text: String, privacyView: String, privacyComment: String) {
        for (note in notes) {
            if (noteId == note.key.noteId) {
                note.key.title = title
                note.key.text = text
                note.key.privacyView = privacyView
                note.key.privacyComment = privacyComment

            }
        }
    }

    fun editComment(commentID: Int, ownerId: Int, message: String, ) {
        for (value in notes.values) {
            for (comment in value) {
                if (comment != null) {
                    if (comment.commentId == commentID) {
                        comment.message = message
                    }
                }
            }
        }
    }


}