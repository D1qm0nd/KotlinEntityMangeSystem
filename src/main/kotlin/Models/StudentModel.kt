package Models

import Exceptions.ValidationException
import Models.DataLayer.Context
import Models.DataLayer.Model
import Models.DataLayer.ModelScanner

class StudentModel(context : Context<Student>, scanner : ModelScanner<Student>) : Model<Student>(context, scanner)
{
    override fun Add(obj: Student): Boolean {
        obj.Id = Context.Entities.size+1;
        return Context.Entities.add(obj)
    }

    override fun Get(index: Int): Student? {
        return Context.Entities.get(index);
    }

    override fun Add(): Boolean {
        try
        {
            val student = _scanner.Scan()
            Add(student!!)
        }
        catch (ex : Exception)
        {
            println(ex.message)
            return false
        }
        return true
    }

    override fun Remove(index: Int): Student? {
        return if (index < Context.Entities.count() || Context.Entities.count() > index)
            Context.Entities.removeAt(index)
        else null
    }
    override fun Remove(obj: Student): Boolean {
        return Context.Entities.remove(obj)
    }
}