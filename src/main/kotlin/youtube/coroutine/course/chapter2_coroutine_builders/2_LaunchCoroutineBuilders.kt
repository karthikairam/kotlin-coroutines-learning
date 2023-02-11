package youtube.coroutine.course.chapter2_coroutine_builders

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    val job: Job = launch {    // Run on Main thread because it inherits from parent coroutine.
        println("A coroutine starts: ${Thread.currentThread().name}")
        delay(1000) // Note we used delay to make it non-blocking unlike Thread.sleep()
        println("A coroutine ends: ${Thread.currentThread().name}")
    }

    // Since coroutine runs in the background and it is daemon thread, we need to make the main thread wait
    // Instead of delay(1300) we can use join from job
    job.join()
    println("Main program ends: ${Thread.currentThread().name}")
}