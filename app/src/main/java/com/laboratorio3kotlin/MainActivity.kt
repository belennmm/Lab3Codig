package com.laboratorio3kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.laboratorio3kotlin.ui.theme.Laboratorio3KotlinTheme


// clase food - 1
abstract class Food(val name: String, val price: Double){
    abstract fun cook(): String
}

// subclase burguer - 2.1
class Burguer(name: String, price:Double) : Food(name, price){
    override fun cook(): String {
        return "Grill the burger until it's well done."
    }
}

// subclase pizza - 2.2
class Pizza(name: String, price:Double) : Food(name, price){
    override fun cook(): String {
        return "Bake the pizza in the oven until the cheese melts."
    }
}

// intarfaz Dessert - 3
interface Dessert {
    fun eat(): String
}


// clase dessert para iceCream  - 4
class IceCream(name:String, price: Double) : Food(name, price), Dessert {
    override fun cook(): String {
        return "Leave the ice cream in the freezer until it's frozen."
    }

    override fun eat(): String {
        return "Enjoy the ice cream with a happy face."
    }
}

// clase abstracta drink - 5
abstract class Drink(name: String, price:Double) : Food(name, price) {
    abstract fun pour(): String
}

// subclase juice - 6
class Juice(name: String, price: Double) : Drink(name, price) {
    override fun pour():  String {
        return "Pour the juice in a glass."
    }


    override fun cook(): String {
        return "Squeeze the juice from an orange."
    }
}

// extension discountedPrice() para food - 7
fun Food.discountedPrice(discountPercentage: Double): Double{
    return price - (price * discountPercentage / 100)
}


// main - instancias de alimentos - 8
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        val burger = Burguer("Cheeseburger", 5.99)
        val pizza = Pizza("Margherita", 8.99)
        val iceCream = IceCream("Vanilla Ice Cream", 3.99)
        val juice = Juice("Orange Juice", 4.99)

        // los mensajes de cómo cocinar
        val burgerMessage = burger.cook()
        val pizzaMessage = pizza.cook()
        val iceCreamCookMessage = iceCream.cook()
        val iceCreamEatMessage = iceCream.eat()
        val juiceCookMessage = juice.cook()
        val juicePourMessage = juice.pour()

        // Calcular precio con descuento
        val discountedBurgerPrice = burger.discountedPrice(10.0)

        setContent {
            Laboratorio3KotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)){
                        Greeting(name = "Aux")
                        BurgerMessage(message = burgerMessage)
                        PizzaMessage(message = pizzaMessage)
                        IceCreamCookMessage(message = iceCreamCookMessage)
                        IceCreamEatMessage(message = iceCreamEatMessage)
                        JuiceCookMessage(message = juiceCookMessage)
                        JuicePourMessage(message = juicePourMessage)
                        DiscountedPriceMessage(price = discountedBurgerPrice)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier){
    Text(
        text = "Hello $name!",
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun BurgerMessage(message: String, modifier: Modifier = Modifier){
    Text(
        text = message,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun PizzaMessage(message: String, modifier: Modifier = Modifier){
    Text(
        text = message,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun IceCreamCookMessage(message: String, modifier: Modifier = Modifier){
    Text(
        text = message,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun IceCreamEatMessage(message: String, modifier: Modifier = Modifier){
    Text(
        text = message,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun JuiceCookMessage(message: String, modifier: Modifier = Modifier){
    Text(
        text = message,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun JuicePourMessage(message: String, modifier: Modifier = Modifier){
    Text(
        text = message,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun DiscountedPriceMessage(price: Double, modifier: Modifier = Modifier){
    // precio de la discounted burger - 10
    Text(
        text = "Discounted Burger Price: $$price",
        modifier = modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(){
    Laboratorio3KotlinTheme{
        Column {
            Greeting(name = "Aux")
            BurgerMessage(message = "Grill the burger until it's well done.")
            PizzaMessage(message = "Bake the pizza in the oven until the cheese melts.")
            IceCreamCookMessage(message = "Leave the ice cream in the freezer until it's frozen.")
            IceCreamEatMessage(message = "Enjoy the ice cream with a happy face.")
            JuiceCookMessage(message = "Squeeze the juice from an orange.")
            JuicePourMessage(message = "Pour the juice in a glass.")

            DiscountedPriceMessage(price = 5.39)
        }
    }
}
