package youtube.coroutine.course.chapter3.cancellation

import kotlinx.coroutines.*

fun main() = runBlocking {

    println("Main program starts: ${Thread.currentThread().name}")

    val job: Job = launch {    // Run on Main thread because it inherits from parent coroutine.
        println("Coroutine program starts: ${Thread.currentThread().name}")
        for (i in 0..10) {
            print("$i, ")
            yield() // if we don't want delay use yield()
        }
    }

    delay(10)

    job.cancelAndJoin()

    println()
    println("Main program ends: ${Thread.currentThread().name}")
}