package youtube.coroutine.course.chapter3.cancellation

import kotlinx.coroutines.*

fun main() = runBlocking {

    println("Main program starts: ${Thread.currentThread().name}")

    val job: Job = launch(Dispatchers.Default) {// Run on Main thread because it inherits from parent coroutine.
        println("Coroutine program starts: ${Thread.currentThread().name}")
        for (i in 0..10) {
            if(!isActive) {
                return@launch
            }
            print("$i, ")
            Thread.sleep(2) // for simulation purpose only, we can't use delay because it will check for cancel
        }
    }

    delay(10)

    job.cancelAndJoin()

    println()
    println("Main program ends: ${Thread.currentThread().name}")
}