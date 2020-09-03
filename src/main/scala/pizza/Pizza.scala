package pizza
import scala.collection.mutable.ArrayBuffer

class Pizza(
             var CrustSize:String,
             var CrustType:String,
             var toppings: ArrayBuffer[String]
           ) {


  override def toString(): String = {
    val toppingsString = for (t <- toppings) yield t
    s"""Pizza:
       |  Crust Size: $CrustSize
       |  Crust Type: $CrustType
       |  $toppingsString
         """.stripMargin
  }


  def getPrice(): Int = {
    var price = Price.priceCrustType(CrustType) + Price.priceCrustSize(CrustSize)
    for(x <- toppings){
      price+= Price.priceToppings(x)
    }
    price
  }
}

object Price{
  var priceCrustType :Map[String,Int]= Map(
    "RegularCrustType"-> 20,
    "ThinCrustType"-> 30,
    "ThickCrustType"-> 40,

  )

  var priceCrustSize :Map[String,Int]= Map(
    "SmallCrustSize"-> 20,
    "MediumCrustSize"-> 30,
    "LargeCrustSize"-> 40,

  )

  var priceToppings :Map[String,Int]= Map(
    "Cheese"-> 20,
    "Onions"-> 30,
    "Tomatoes"-> 40,

  )
}
