package youtube.coroutine.course.chapter3.timeouts

import kotlinx.coroutines.*

fun main() = runBlocking {

    println("Main program starts: ${Thread.currentThread().name}")

    val result: String? = withTimeoutOrNull(2000) {
        // After timeout reaches, it will return null
        for (counter in 0..10) {
            print("$counter, ")
            delay(500)
        }
        "SUCCESS"// if not timeout then this will be returned
    }

    println("Result: $result")

    println("\nMain program ends: ${Thread.currentThread().name}")
}