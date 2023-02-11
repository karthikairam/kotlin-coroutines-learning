package youtube.coroutine.course.chapter1_basics

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    launch {    // Run on Main thread because it inherits from parent coroutine.
        println("A coroutine starts: ${Thread.currentThread().name}")
        delay(1000) // Note we used delay to make it non-blocking unlike Thread.sleep()
        println("A coroutine ends: ${Thread.currentThread().name}")
    }

    // Since coroutine runs in the background and it is daemon thread, we need to make the main thread wait
    delay(1300)

    println("Main program ends: ${Thread.currentThread().name}")
}