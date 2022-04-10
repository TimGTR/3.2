import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun add() {
        val service = NoteService
        val note = Note (1,"1", "1", 1, "1", "1")
        val result = service.add(note)
        assertNotEquals(1, result)

    }

    @Test
    fun createComment() {
        val service = NoteService
        val note = Note (1,"1", "1", 1, "1", "1")
        val comment = Comment(1, 1, 1, 1, "1+1", "1")
        service.add(note)
        val result = service.createComment(comment)
        assertNotEquals(1, result)
    }

    @Test
    fun delete() {
        val service = NoteService
        val note = Note (1,"1", "1", 1, "1", "1")
        service.add(note)
        val result = service.delete(1)
        assertTrue(result)

    }

    @Test
    fun deleteComment() {
        val service = NoteService
        val note = Note (1,"1", "1", 1, "1", "1")
        val comment = Comment(1, 1, 1, 1, "1+1", "1")
        service.add(note)
        service.createComment(comment)
        val result = service.edit(1, "2", "2>1", "1", "1")
        assertTrue(result)
    }

    @Test
    fun edit() {
        val service = NoteService
        val note = Note (1,"1", "1", 1, "1", "1")
        service.add(note)
        val result = service.edit(1,"121", "1454", "232", "464")
        assertEquals(true, result)
    }

    @Test
    fun editFalse() {
        val service = NoteService
        val note = Note (1,"1", "1", 1, "1", "1")
        service.add(note)
        val result = service.edit(2,"121", "1454", "232", "464")
        assertFalse(result)
    }

    @Test
    fun editComment() {
        val service = NoteService
        val note = Note (1,"1", "1", 1, "1", "1")
        val comment = Comment(1, 1, 1, 1, "1+1", "1")
        service.add(note)
        service.createComment(comment)
        val result = service.editComment(1,1, "12121")
        assertTrue(result)
    }

    @Test
    fun get() {
        val service = NoteService
        val note = Note (1,"1", "1", 1, "1", "1")
        val note2 = Note (2,"1", "1", 1, "1", "1")
        service.add(note)
        service.add(note2)
        val result = service.get(arrayListOf(1,2), 1, 1, 1, 1)
        assertNotEquals(mutableListOf(1,2), result)
    }

    @Test
    fun getById() {
        val service = NoteService
        val note = Note (1,"1", "1", 1, "1", "1")
        val note2 = Note (2,"1", "1", 1, "1", "1")
        service.add(note)
        service.add(note2)
        val result = service.getById(2, 1)
        assertNotEquals(note2, result)
    }

    @Test
    fun getComments() {
        val service = NoteService
        val note = Note (1,"1", "1", 1, "1", "1")
        val note2 = Note (2,"1", "1", 1, "1", "1")
        service.add(note)
        service.add(note2)
        val comment = Comment(1, 1, 1, 1, "1+1", "1")
        val comment2 = Comment(2, 1, 1, 1, "1+1", "1")
        service.createComment(comment)
        service.createComment(comment2)
        val result = service.getComments(1, 1, false, 1, 1 )
        assertNotEquals(mutableListOf(comment, comment2), result)
    }

    @Test
    fun restoreComment() {
        val service = NoteService
        val note = Note (1,"1", "1", 1, "1", "1")
        val note2 = Note (2,"1", "1", 1, "1", "1")
        service.add(note)
        service.add(note2)
        val comment = Comment(1, 1, 1, 1, "1+1", "1", true)
        val comment2 = Comment(2, 1, 1, 1, "1+1", "1")
        service.createComment(comment)
        service.createComment(comment2)
        val result = service.restoreComment(1, 1)
        assertTrue(result)
    }
}