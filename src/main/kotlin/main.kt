fun main() {
    val service = NoteService()
    val note = Note (1,1,"1", "1", 1, "1", "1")
    val note2 = Note (1,2,"1", "1", 1, "1", "1")
    service.add(note)
    service.add(note2)
    val comment = Comment(1, 1, 1, 1, "1+1", "1", true)
    val comment2 = Comment(2, 1, 1, 1, "1+1", "1")
    service.createComment(comment)
    service.createComment(comment2)
    val result = service.restoreComment(1, 1)


}