class ListCommandElements(val typeOfMenu:TypesOfMenu,
                               val parent: ListCommandElements?){

    val listMenus = mutableMapOf<Int,MenuElement>()

    init {
        listMenus.put(
            0,
            MenuElement("Выход", function = { -> MenuHandler.SetCurrent_Menu(parent) })
        )
        listMenus.put(
            1,
            MenuElement(typeOfMenu.getTitleCommand_new(),
                function = { -> MenuHandler.addNewElement(typeOfMenu,this) })
        )

        if (typeOfMenu.equals(TypesOfMenu.NOTE)){
            listMenus.put(
                2,
                MenuElement("Просмотреть заметку",
                    function = { -> MenuHandler.showNote() })
            )
        }
    }
}

class MenuElement(val name: String,val function: () -> Unit)  {}
