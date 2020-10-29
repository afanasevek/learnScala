class Dog(name:Option[String]) extends Animal {
  //Option - либо  None либо Some
  var DogName = name
//override
  override def say(): String = {
    var say = "Гав!"
    say
  }
}
// класс саппортер
object Dog {
  //конструктор по умолчанию
  def apply(): Dog = new Dog(None)
  //Конструктор со значением
  def apply(name:String): Dog = new Dog(Option.apply(name))
}