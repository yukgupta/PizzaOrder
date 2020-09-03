package pizza

import scala.collection.mutable.ArrayBuffer

class Order (
              val pizzas: ArrayBuffer[Pizza],
              var customer: Customer
            ) {

  def addPizza(p: Pizza): Unit = {
    pizzas += p
  }

  def removePizza(p: Pizza): Unit = {
    pizzas -= p
  }

  // need to implement these

  def getTotalPrice(): Int = {
    var TotPrice=0
    for( p <- pizzas){
      TotPrice+= p.getPrice()
    }
    return TotPrice
  }

  def printOrder(): Unit = {
    println("Name:" + customer.name)
    println("Address:" + customer.address.street1)
    for (p <- pizzas) {
      println(p)
    }

    println("Total: Rs." + getTotalPrice())
  }


}