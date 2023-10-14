package UI

import Exceptions.MenuExistingException

open class ManageSystem(protected var menu : Menu?) {
    fun startManage()
    {
        if (menu == null)
            throw MenuExistingException()

        var action : String? = ""
        while (action?.lowercase() != "exit")
        {
            menu!!.show()
            action = readlnOrNull()
            if (action == null)
                break
            if (action.isEmpty() || action == "exit")
            {
                continue
            }

            menu!!.DoAction(action)
        }
    }
}