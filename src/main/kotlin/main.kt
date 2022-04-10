fun main() {
    var service = NoteService
    val note = Note (1,"1", "1", 1, "1", "1")
    val comment = Comment(1, 1, 1, 1, "1+1", "1")
    service.add(note)
    service.createComment(comment)
    println(service.notes.toString())
    val result = service.edit(1,"121", "1454", "232", "464")
    println(result)
    println(service.notes.toString())


}