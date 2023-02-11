package basics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun main() {

    //runBlocking executes the coroutines (or statements) in sequential
    runBlocking {
        launch {
            delay(1000L)
            println("Test1")
        }
        launch {
            delay(1000L)
            println("Test2")
        }
        printHelloWorld()
        println("Executes after printHelloWorld()") // third stmt runs in sequential after above
    }
    println("Outside run blocking!")
}

// Whereas coroutineScope executes each of its child coroutines in parallel.
private suspend fun printHelloWorld() = coroutineScope {
    launch {
        printWorld("World1")
    }
    launch {
        printWorld("World2")
    }
    println("Hello")
}

private suspend fun printWorld(word: String) {
    delay(1.toDuration(DurationUnit.SECONDS))
    println("$word!")
}