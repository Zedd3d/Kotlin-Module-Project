import java.util.Scanner

fun main(args: Array<String>) {

    println("Запущена программа \"Заметки\"")
    println("Система принимает ввод команд в виде цифры, указанной слева от названия команды")
    while (true) {
        MenuHandler.showCurrentMenu()

        val command = MenuHandler.getCommand(Scanner(System.`in`).nextLine())

        if (command != null){
            //println("Выполним функцию "+command.name)
            command.function.invoke()
        }

        if (MenuHandler.canExit()){
            println("Работа с программой завершена")
            break
        }
    }

}