package exercise1

/* This task has no tests. It is an exercise for you to write different class structures.
 * 
 a) Создать класс Animal, который имеет следующие поля:
 *      - name: String (название)
 *      - species: String (вид)
 *      - food: String
 * 
 *    Синтаксис: class MyClass(val publicField: Int, privateField: String) {
 *              // остальные поля и методы
 *            }
 * 
 * b) Создайте объект-компаньон для класса Animal и добавьте следующие сущности как поля:
 *      - cat, mammal, meat
 *      - parrot, bird, vegetables
 *      - goldfish, fish, plants
 * 
 *    Синтаксис: object MyClass {
 *              // статические поля и методы
 *            }
 * 
 * c) Добавьте следующие метод в Animals:
 *      def eats(food: String): Boolean
 *    
 *     который проверяет ест ли животное определенную пищу
 */
class AnimalClass(val name: String, val species: String, val food: String)
{
  def eats(food: String): Boolean = food == this.food
}
object AnimalClass
{
  val mammal = new AnimalClass("cat", "mammal", "meat")
  val parrot = new AnimalClass("parrot", "bird", "vegetables")
  val goldfish = new AnimalClass("goldfish", "fish", "plants")
}
/* d) Переопределите ваш класс Animal как трейт и создайте объекты класса-образца для Mammals, Birds и Fishs.
*    Вам все еще нужно поле `species`?
*/
trait Animal
{
  val name: String
  val food: Food
}
case class Mammal(val name: String, val food: Food) extends Animal
case class Bird(val name: String, val food: Food) extends Animal
case class Fish(val name: String, val food: Food) extends Animal
/* e) Добавьте следующие функции в объект-компаньон Animal:
*      def knownAnimal(name: String): Boolean  // true если это имя одного из трех животных из (b)
*      def apply(name: String): Option[Animal] // возвращает одно из трех животных в соответствии с именем (Some) или ничего (None), см. ниже
*/
object Animal {
  def knownAnimal(name: String): Boolean = {
    var flag: Boolean = name == "mammal" | name ==  "parrot"| name == "goldfish"
    return flag
  }

  def apply(name: String): Option[Animal] = {
    name match {
      case "cat" => Some(Mammal("cat", Meat))
      case "parrot" => Some(Bird("parrot", Vegetables))
      case "goldfish" => Some(Fish("goldfish", Plants))
      case _ => None
    }
  }
}
/* f) Создайте трейт Food со следующими классами-образцами:
*      - Meat
*      - Vegetables
*      - Plants
*   и добавьте это в определение Animal. Так же добавьте объект-компаньон с методом apply():
*      def apply(food: String): Option[Food]
*/
trait Food
case object Meat extends Food
case object Vegetables extends Food
case object Plants extends Food

object Food {
  def apply(food: String): Option[Food] = {
    food match {
      case "meat" => Some(Meat)
      case "vegetables" => Some(Vegetables)
      case "plants" => Some(Plants)
      case isEmpty => None
    }
  }
}
// Для главного метода
object Main {
  def main(args: Array[String]) = {
    println(Animal.knownAnimal("mammal"))
    println(Animal.knownAnimal("dog"))

    println(Animal.apply("cat"))
    println(Animal.apply("dog"))
  }
}
/*БЫЛО В МЕТОДИЧКЕ
sealed trait Option[A] {
  def isEmpty: Boolean
}
case class Some[A](a: A) extends Option[A] {
  val isEmpty = false
}
case class None[A]()     extends Option[A] {
  val isEmpty = true
}
 */

