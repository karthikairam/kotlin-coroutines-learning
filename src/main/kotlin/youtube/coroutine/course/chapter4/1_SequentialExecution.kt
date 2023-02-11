package youtube.coroutine.course.chapter4

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

fun main()  = runBlocking {
    // By default, the coroutine executes in a sequential manner

    println("Main program starts: ${Thread.currentThread().name}")

    val timeTaken = measureTimeMillis {
        val msgOne: String = getMsgOne()
        val msgTwo: String = getMsgTwo()
        println("Result: ${msgOne + msgTwo}")
    }

    println("Time taken $timeTaken in ms") // It will take 2 seconds as each getMsg*() has delay of 1 second.

    println("Main program ends: ${Thread.currentThread().name}")
}