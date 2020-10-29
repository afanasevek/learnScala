import java.util.Scanner

import scala.io.StdIn

object Main extends App{

  //Создание переменной non-final
  var integer: Int = 1
  var double: Double = 1.1
  var strng:String = "String"
  //Создание переменной final
   val finalStrng: String = "final"
  //создание функции в переменной
  var fnc = (i:Int) => i+1
  var result = fnc(1)
  println(result)
  /*
  методы
   */
  //void
  def voidMethod: Unit = {
    println("new void method")
  }
  //return
  def returnMethod (str:String):String={
    var newStr = str + " World!"
    newStr
  }
  println(returnMethod("Hello"))
  //проверка Создания объекта без параметра
  var Petya = Dog()
  println(Petya.DogName)
  //проверка Создания объекта с параметром
  var Dima = Dog("Dima")
  println(Dima.DogName.get)

}
