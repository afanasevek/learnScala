import scala.collection.mutable
import scala.io.StdIn

object PhoneBook extends App {

  private val mapPhones = mutable.Map.empty[String, String]

  def start: Unit = {
    while (true) {
      println("Введите команду:")
      val cmd = StdIn.readLine()
      val masStr = cmd.split(" ")
      masStr(0) match {
        case "add" => if (masStr.length != 3) println("wrong command") else add(masStr(1), masStr(2))
        case "delete" => if (masStr.length != 2)println("wrong command")  else delete(masStr(1))
        case "find" => if (masStr.length != 2) println("wrong command") else find(masStr(1))
        case "findAll" => if (masStr.length != 1) println("wrong command")else findAll()
        case "change" => if (masStr.length != 3) println("wrong command") else change(masStr(1), masStr(2))
        case "help" => if (masStr.length != 1) println("wrong command") else help()
        case _ => "wrong command"
      }
    }
  }


  private def findAll() = for (init <- mapPhones)
    println("phone - " + init._1 + ", " + "name - " + init._2)

  private def add(phone: String, name: String) = if (mapPhones.contains(phone))
    println("phone exists")
  else mapPhones.addOne(phone, name)

  private def change(phone: String, name: String): Unit = if (mapPhones.contains(phone))
    mapPhones.addOne(phone, name)
  else println("phone not exists")

  private def delete(phone: String) = if (mapPhones.contains(phone))
    mapPhones.remove(phone)
  else println("phone not exists")

  private def help() = println("add (phone) (name) - добавить новый контакт \n" +
    " delete (number) - удалить контакт \n" +
    " find (number) - найти контакт по номеру \n" +
    " findAll - показать все контакты \n" +
    " change (number) (name) - изменить данные контакта")

  private def find(any: String) = {
    //регулярка, но зачем столько ковычек
    val reg = """\d+""".r
    any match {
      case reg() => getByNumber(any)
      case _ => getAllByName(any)
    }
  }

  private def getAllByName(name: String): Unit = {
    for ((k, v) <- mapPhones if (v == name)) println("phone - " + k + "\n" + "name - " + v)
  }

  private def getByNumber(phone: String) = println("phone - " + phone + "\n" + "name - " + mapPhones.get(phone).getOrElse("not found"))

  private def isCorrect(x:(String,String)) = {
    val reg = """^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$ """.r
    x._1 match {
      case reg() => println("is correct")
    }
  }
}
