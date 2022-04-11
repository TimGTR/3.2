import org.junit.Assert.*
import org.junit.Test

class NoteServiceTest2 {


    @Test
    fun add() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        val result = service.add(note)
        assertEquals(1, result)
    }

    @Test
    fun addCrash() {
        val service = NoteService()
        val note = Note(1, 5, "1", "1", 1, "1", "1")
        val result = service.add(note)
        assertNotEquals(5, result)
    }


    @Test
    fun createComment() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        val comment = Comment(1, 1, 1, 1, "1+1", "1")
        service.add(note)
        val result = service.createComment(comment)
        assertEquals(1, result)
    }

    @Test
    fun noCreateComment() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        val comment = Comment(1, 5, 1, 1, "1+1", "1")
        service.add(note)
        val result = service.createComment(comment)
        assertEquals(0, result)
    }

    @Test
    fun delete() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        service.add(note)
        val result = service.delete(1)
        assertTrue(result)

    }

    @Test
    fun cantDelete() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        service.add(note)
        val result = service.delete(5)
        assertFalse(result)

    }

    @Test
    fun deleteComment() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        val comment = Comment(1, 1, 1, 1, "1+1", "1")
        service.add(note)
        service.createComment(comment)
        val result = service.deleteComment(1, 1)
        assertTrue(result)
    }

    @Test(expected = CommentNoFoundException::class)
    fun cantDeleteComment() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        val comment = Comment(1, 1, 1, 1, "1+1", "1")
        service.add(note)
        service.createComment(comment)
        val result = service.deleteComment(3, 1)

    }


    @Test
    fun edit() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        service.add(note)
        val result = service.edit(1, "121", "1454", "232", "464")
        assertTrue(result)
    }


    @Test
    fun editFalse() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        service.add(note)
        val result = service.edit(2, "121", "1454", "232", "464")
        assertFalse(result)
    }

    @Test
    fun editComment() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        val comment = Comment(1, 1, 1, 1, "1+1", "1")
        service.add(note)
        service.createComment(comment)
        val result = service.editComment(1, 1, "12121")
        assertTrue(result)
    }

    @Test
    fun cantEditComment() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        val comment = Comment(5, 1, 1, 1, "1+1", "1")
        service.add(note)
        service.createComment(comment)
        val result = service.editComment(1, 1, "12121")
        assertFalse(result)
    }

    @Test
    fun get() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        val note2 = Note(1, 2, "1", "1", 1, "1", "1")
        service.add(note)
        service.add(note2)
        val result = service.get(arrayListOf(1, 2), 1, 1, 1, 1)
        assertEquals(arrayListOf(note, note2), result)
    }

    @Test
    fun getNo() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        val note2 = Note(2, 2, "1", "1", 1, "1", "1")
        service.add(note)
        service.add(note2)
        val result = service.get(arrayListOf(1, 2), 1, 1, 1, 1)
        assertNotEquals(arrayListOf(note, note2), result)
    }

    @Test
    fun getById() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        val note2 = Note(1, 2, "1", "1", 1, "1", "1")
        service.add(note)
        service.add(note2)
        val result = service.getById(2, 1)
        assertEquals(note2, result)
    }


    @Test
    fun getNoById() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        val note2 = Note(1, 2, "1", "1", 1, "1", "1")
        service.add(note)
        service.add(note2)
        val result = service.getById(5, 1)
        assertNotEquals(note2, result)
    }

    @Test
    fun getComments() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        val note2 = Note(1, 2, "1", "1", 1, "1", "1")
        service.add(note)
        service.add(note2)
        val comment = Comment(1, 1, 1, 1, "1+1", "1")
        val comment2 = Comment(2, 1, 1, 1, "1+1", "1")
        service.createComment(comment)
        service.createComment(comment2)
        val result = service.getComments(1, 1, false, 1, 1)
        assertEquals(mutableListOf(comment, comment2), result)
    }

    @Test
    fun getNoComments() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        val note2 = Note(1, 2, "1", "1", 1, "1", "1")
        service.add(note)
        service.add(note2)
        val comment = Comment(1, 1, 1, 1, "1+1", "1")
        val comment2 = Comment(2, 2, 1, 1, "1+1", "1")
        service.createComment(comment)
        service.createComment(comment2)
        val result = service.getComments(1, 1, false, 1, 1)
        assertNotEquals(mutableListOf(comment, comment2), result)
    }

    @Test
    fun restoreComment() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        val note2 = Note(1, 2, "1", "1", 1, "1", "1")
        service.add(note)
        service.add(note2)
        val comment = Comment(1, 1, 1, 1, "1+1", "1", true)
        val comment2 = Comment(2, 1, 1, 1, "1+1", "1")
        service.createComment(comment)
        service.createComment(comment2)
        val result = service.restoreComment(1, 1)
        assertTrue(result)
    }

    @Test(expected = CommentNoFoundException::class)
    fun noRestoreComment() {
        val service = NoteService()
        val note = Note(1, 1, "1", "1", 1, "1", "1")
        val note2 = Note(1, 2, "1", "1", 1, "1", "1")
        service.add(note)
        service.add(note2)
        val comment = Comment(1, 1, 1, 1, "1+1", "1", false)
        val comment2 = Comment(2, 1, 1, 1, "1+1", "1")
        service.createComment(comment)
        service.createComment(comment2)
        service.restoreComment(5, 1)
    }
}