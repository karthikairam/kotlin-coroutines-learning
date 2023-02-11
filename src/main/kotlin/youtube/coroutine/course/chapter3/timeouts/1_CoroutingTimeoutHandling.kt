package youtube.coroutine.course.chapter3.timeouts

import kotlinx.coroutines.*

fun main() = runBlocking {

    println("Main program starts: ${Thread.currentThread().name}")

    withTimeout(2000) {// After timeout reaches, it will throw TimeoutCancellationException
        try {
            for (counter in 0..10) {
                print("$counter, ")
                delay(500)
            }
        } catch (ex: TimeoutCancellationException) {
            println("\nException: ${ex.message}")
        } finally {
            println("\nClean")
        }

    }

    println("\nMain program ends: ${Thread.currentThread().name}")
}