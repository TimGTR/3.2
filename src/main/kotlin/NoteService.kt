object NoteService {
    private var notes = mutableMapOf <Note, MutableList<Comment?>>()
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
            }
        }



    }


}