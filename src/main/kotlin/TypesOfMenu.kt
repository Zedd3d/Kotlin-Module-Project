enum class TypesOfMenu {
    ARCHIVES,
    NOTES,
    NOTE,
    VALUENOTE;

    fun getTitle(): String =
        when (this) {
            ARCHIVES -> "Список архивов"
            NOTES -> "Список заметок в архиве"
            NOTE -> "Действия с заметкой"
            VALUENOTE -> "Содержимое заметки"
        }
    fun getNextType(): TypesOfMenu =
        when (this) {
            ARCHIVES -> NOTES
            NOTES -> NOTE
            NOTE -> VALUENOTE
            VALUENOTE -> VALUENOTE
        }
    fun getTitleCommand_new(): String =
        when (this) {
            ARCHIVES -> "Добавить новый архив"
            NOTES -> "Добавить новую заметку"
            NOTE -> "Добавить строку в заметку"
            VALUENOTE -> ""
        }
    fun getTextCommand_new(): String =
        when (this) {
            ARCHIVES -> "Введине название нового архива"
            NOTES -> "Введите название новой заметки"
            NOTE -> "Напишите новую строку текста для заметки"
            VALUENOTE -> ""
        }

}