import java.lang.Exception
import java.util.Scanner

object MenuHandler{
    var current_Menu: ListCommandElements? = CreateMenu(TypesOfMenu.ARCHIVES, null)

    fun showCurrentMenu(){
        println(current_Menu!!.typeOfMenu.getTitle())
        for (element in current_Menu!!.listMenus){
            println("${element.key} - ${element.value.name}")

            if (current_Menu!!.typeOfMenu.equals(TypesOfMenu.NOTE) and (element.key == 2)){
                break
            }
        }
    }

    fun CreateMenu(type:TypesOfMenu, parent: ListCommandElements?):ListCommandElements{
        val menu = ListCommandElements(type, parent)

        if (current_Menu == null) {
            current_Menu = menu
        }

        return menu
    }

    fun addNewElement(typeOfMenu:TypesOfMenu,menuList:ListCommandElements) {
        var newTitle = ""
        while (newTitle == ""){
            println(typeOfMenu.getTextCommand_new())
            newTitle = Scanner(System.`in`).nextLine()
            if (newTitle == ""){
                continue
            }
            var newMenu: ListCommandElements? = null
            if (typeOfMenu != TypesOfMenu.NOTE){
                newMenu = ListCommandElements(typeOfMenu.getNextType(), menuList)
            }
            menuList.listMenus.put(menuList.listMenus.size,
                MenuElement(newTitle,
                    function = {-> SetCurrent_Menu(newMenu)})
            )
        }
    }

    fun SetCurrent_Menu(menu:ListCommandElements?){
        current_Menu = menu
    }

    fun getCommand(commandText: String): MenuElement? {
        var commandInt = -1
        try {
            commandInt = commandText.toInt()
        }catch (e:Exception){
            println("Необходимо вводить только цифры")
            return null
        }

        if (current_Menu!!.listMenus.contains(commandInt)
            and !((current_Menu!!.typeOfMenu == TypesOfMenu.NOTE) and (commandInt > 2))) {
            return current_Menu!!.listMenus.get(commandInt)
        } else {
            println("Не найден пункт меню - $commandText")
            return null
        }
    }

    fun canExit(): Boolean {
        return current_Menu == null
    }

    fun showNote() {
        println("======================Начало заметки=====================")
        for (element in current_Menu!!.listMenus){
            if (element.key <= 2) continue

            println(element.value.name)
        }
        println("======================Конец заметки======================")
    }
}

