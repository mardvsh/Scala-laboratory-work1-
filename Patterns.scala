package exercise1

/** Напишите решение в виде функции. 
  * 
  * Синтаксис:
  *   val a: Int = ???
  * 
  *   a match {
  *     case 0 => true
  *     case _ => false
  *   }
  */
object PatternMatching {

  sealed trait Hand
  case object Rock    extends Hand
  case object Paper   extends Hand
  case object Scissor extends Hand

  sealed trait Result
  case object Win  extends Result
  case object Lose extends Result
  case object Draw extends Result

  sealed trait Food
  case object Meat       extends Food
  case object Vegetables extends Food
  case object Plants     extends Food

  sealed trait Animal {
    val name: String
    val food: Food
  }
  case class Mammal(name: String, food: Food, weight: Int) extends Animal
  case class Fish(name: String, food: Food)                extends Animal
  case class Bird(name: String, food: Food)                extends Animal



  /* a) Напишите функцию, которая ставит в соответствие числу строку слудеющим образом:
   * Если:
   *     1 => "it is one"
   *     2 => "it is two"
   *     3 => "it is three"
   *     иначе => "what's that"
   */
  def IntToString(in: Int): String = {
    in match {
      case 1 => "It is one"
      case 2 => "It is two"
      case 3 => "It is three"
      case _ => "What's that?"
    }
  }
  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  //def testIntToString(value: Int): String = value.toString
  def testIntToString(value: Int): String = IntToString(value)

  /* b) Напишите функцию которая возвращает true если переменная `value` принимает значение:
   *     "max" или "Max
   *     "moritz" или "Moritz"
   */
  def IsMaxAndMoritz(in: String): Boolean = {
    in match {
      case "max" => true
      case "Max" => true
      case "moritz" => true
      case "Moritz" => true
      case _ => false
    }
  }


  // примените функции из пункта (b) здесь, не изменяя сигнатуру
  //def testIsMaxAndMoritz(value: String): Boolean = false
  def testIsMaxAndMoritz(value: String): Boolean = IsMaxAndMoritz(value)

  // c) Напишите функцию проверки является ли `value` четным
  def IsEven(in: Int): Boolean = {
    var res: Int = in % 2
    res match {
      case 0 => true
      case 1 => false
    }
  }


  // примените функции из пункта (c) здесь, не изменяя сигнатуру
  //def testIsEven(value: Int): Boolean = false
  def testIsEven(value: Int): Boolean = IsEven(value)


  
  /* d) Напишите функцию, моделирующую игру в Камень ножницы бумага 
   *     1. камень побеждает ножницы
   *     2. ножницы побеждают бумагу
   *     3. бумага побеждает камень
   *    Выиграет ли игрок `a`?
   */
  def WinsA(a: Hand, b: Hand): Result = {
    (a, b) match {
      case (Scissor, Paper) | (Paper, Rock) | (Rock, Scissor) => Win
      case (Rock, Rock) | (Scissor, Scissor) | (Paper, Paper) => Draw
      case _ => Lose
    }
  }

  // примените вашу функцию из пункта (d) здесь, не изменяя сигнатуру
  //def testWinsA(a: Hand, b: Hand): Result = Draw
  def testWinsA(a: Hand, b: Hand): Result = WinsA(a, b)



  // Примечание: используйте определение Animals

  // e) Верните вес (weight: Int) объекта Mammal, иначе верните -1.
  def ExtractCatWeight(animal: Animal): Int = {
    animal match {
      case animal: Mammal => animal.weight
      case _ => -1
    }
  }

  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  //def testExtractMammalWeight(animal: Animal): Int = 0
  def testExtractCatWeight(animal: Animal): Int = ExtractCatWeight(animal)


  // f) Измените поле еда объектов классов Fishes и Birds на Plants, класс Mammels оставьте неизмененным.
  def UpdateFood(animal: Animal): Animal = {
    animal match {
      case animal : Mammal => animal
      case _ => {
        animal.food == Plants
        return animal
      }
    }
  }


  // примените функцию из пункта (f) здесь, не изменяйте сигнатуру
  //def testUpdateFood(animal: Animal): Animal = animal
  def testUpdateFood(animal: Animal): Animal = UpdateFood(animal)

  // Точка входа в программу
  def main(args: Array[String]) = {
    println("Task (a)")
    println(testIntToString(1))
    println(testIntToString(2))
    println(testIntToString(3))
    println(testIntToString(100))

    println("\nTask (b)")
    println(testIsMaxAndMoritz("Max"))
    println(testIsMaxAndMoritz("moritz"))
    println(testIsMaxAndMoritz("test?"))

    println("\nTask (c)")
    println(testIsEven(10))
    println(testIsEven(15))

    println("\nTask (d)")
    println(testWinsA(Rock, Scissor))
    println(testWinsA(Rock, Rock))
    println(testWinsA(Paper, Scissor))

    println("\nTask (e)")
    val cat = new Mammal("Cat", Meat, 7)
    val bird = new Bird("Parrot", Vegetables)
    println(testExtractCatWeight(cat))
    println(testExtractCatWeight(bird))

    println("\nTask (f)")
    println(testUpdateFood(bird).food)
    println(testUpdateFood(cat).food)
  }
}
