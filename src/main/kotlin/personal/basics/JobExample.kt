package personal.basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun main() {

    runBlocking {
        val job = launch {
            printWorld()
        }
        println("Hello")
        job.join() // Wait until the world is printed otherwise Done will be printed immediately after Hello.
        println("Done")
    }
    println("Outside run blocking!")
}

private suspend fun printWorld() {
    delay(1.toDuration(DurationUnit.SECONDS))
    println("World!")
}