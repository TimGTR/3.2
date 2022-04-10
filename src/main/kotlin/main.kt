fun main() {
    val service = NoteService
    val note = Note (1,"1", "1", 1, "1", "1")
    service.add(note)
    val result = service.edit(1,"121", "1454", "232", "464")
    println(result)


}