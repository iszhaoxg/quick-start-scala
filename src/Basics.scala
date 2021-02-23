package top.amfun.example

/**
 * 基本语法示例：
 * 1.常量
 * 2.变量
 * 3.方法
 * 4.方法
 * 5.类
 * 6.样例类
 * 7.对象
 * 8.特质
 * @author zhaoxg
 * @date 2021/2/23 16:13
 */
object Basics {
  def main(args: Array[String]): Unit ={
    exampleValue()
    exampleVariable()
    exampleFunction()
    exampleMethod()
    exampleClass()
    exampleCaseClass()
    exampleObject()
    exampleTrait()
  }

  /**
   * 1.使用关键字【val】定义常量，常量值不能够修改
   */
  def exampleValue(): Unit = {
    val value = 1
    println(value)
  }

  /**
   * 2.使用关键字【var】定义变量
   */
  def exampleVariable(): Unit = {
    var variable: Int = 1
    variable = variable +1
    println(variable)
  }

  /**
   * 3.函数
   */
  def exampleFunction(): Unit = {
    // 定义匿名函数并将函数赋值给一个变量
    val addOne = (x: Int) => x + 1
    println(addOne(1))
    val add = (x: Int, y: Int) => x * y
    println(add(2, 4))
    val getTheAnswer = () => 13
    println(getTheAnswer())
  }

  /**
   * 4.方法
   * 方法体的最后一个表达式就是方法的返回值。
   */
  def exampleMethod(): Unit ={
    def  add(x: Int, y: Int): Int = x + y
    println(add(2, 1))
    // 接收多参数的方法
    def addThenMultiply(x: Int, y: Int)(multiply: Int): Long = (x + y) * multiply
    println(addThenMultiply(2, 3)(4))

    // 没有参数的方法
    def name: String = System.getProperty("user.name")
    println("Hello," + name + "!")
  }

  /**
   * 5.类
   */
  def exampleClass(): Unit = {
    class Greeter(prefix: String, suffix: String) {
      def greet(name: String): Unit ={
        println(prefix + name + suffix)
      }
    }
    val greeter = new Greeter("Hello,", "!")
    greeter.greet("Scala Developer")
  }

  /**
   * 6.样例类
   * 默认情况下，样例类一般用于不可变对象，并且可作值比较。
   * 可以使用case class关键字来定义样例类。
   * 不适用new关键字直接使用
   */
  def exampleCaseClass(): Unit = {
    case class Point(x: Int, y: Int)
    val point = Point(1, 2)
    val anotherPoint = Point(1, 2)
    val yetAnotherPoint = Point(2, 2)

    if (point == anotherPoint) {
      println(point + " and " + anotherPoint + " are the same.")
    } else {
      println(point + " and " + anotherPoint + " are different.")
    } // Point(1,2) and Point(1,2) are the same.

    if (point == yetAnotherPoint) {
      println(point + " and " + yetAnotherPoint + " are the same.")
    } else {
      println(point + " and " + yetAnotherPoint + " are different.")
    } // Point(1,2) and Point(2,2) are different.
  }

  /**
   * 7.对象
   * 对象是它们自己定义的单实例，你可以把它看作它自己的类的单例。
   */
  def exampleObject(): Unit = {
    object IdFactory {
      private var counter = 0
      def create(): Int = {
        counter += 1
        counter
      }
    }
    // 直接通过名称引用
    val newId: Int = IdFactory.create()
    println(newId) // 1
    println(IdFactory.create()) // 2
  }

  /**
   * 8.特质
   * 特质是包含某些字段和方法的类型。
   * 可以组合多个特质。
   * 可以使用trait关键字定义特质。
   */
  def exampleTrait(): Unit = {
    // 定义特质
    trait Greeter {
      def greet(name: String): Unit
    }
    // 特质也可以有默认实现
    trait GreeterDefault {
      def greet(name: String): Unit ={
        println("Hello," + name + "!")
      }
    }
    // 使用extends关键字继承特质
    class ExtendsGreeterDefault extends GreeterDefault
    val defaultGreeter = new ExtendsGreeterDefault
    defaultGreeter.greet("Scala Developer")
    class ImplementGreeter(prefix: String, suffix: String) extends Greeter {
      override def greet(name: String): Unit = {
        println(prefix + name + suffix)
      }
    }
    val implementGreeter = new ImplementGreeter("How are you,", "?")
    implementGreeter.greet("Scala Developer")
  }
}
