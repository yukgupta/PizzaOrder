package pizza

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.io.StdIn.readLine
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import java.io.File
import java.io.PrintWriter

import scala.collection.mutable
import scala.io.Source
import scala.util.control.Breaks.{break, breakable}

object Main {


  def main(args: Array[String]): Unit = {

    var isNew: Boolean = true
    var addr= "None"
    //get customer data file
    val json = Source.fromFile("CustomerData.json")
    val mapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    var CustomerData = mapper.readValue[Map[String, List[Map[String,String]]]](json.reader())

    print(CustomerData.getClass.toString)
    println("Welcome")

    println("Enter Crust Size:")
    var crustSize =readLine()

    println("Enter Crust Type:")
    var crustType =readLine()



      println("Enter your Name:")
      var name = readLine()

      println("Enter Number:")
      var number = readLine()

    breakable{
      for(c <- CustomerData){
        var x = c._2 //list
        for(m <- x){ //maps

          if(m("Name")== name && m("Phone") == number){
            isNew=false
            addr = m("Address")
            break
          }
        }
      }
    }


    if(isNew){
          println("Enter Address:")
          addr= readLine()
//          for(c <- CustomerData){
//            var l = c._2
//            l :+ Map("Name"->name,"Phone"->number,"Address"->addr)
//          }

    }

    val address = new Address(addr:String)
    val customer = new Customer(name,number,address)

    val pizza = new Pizza(crustSize,crustType,ArrayBuffer("Cheese","Onions"))



    val o = new Order(
      ArrayBuffer(pizza),
      customer
    )

    o.printOrder()

  }

}
