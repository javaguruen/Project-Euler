class HelloWorld(){
  def hello() : Unit = {
    println ("Hello world!")
  }
}

object HelloWorld{
  def main(args: Array[String]) : Unit = {
    val hw = new HelloWorld()
    hw.hello
  }
}