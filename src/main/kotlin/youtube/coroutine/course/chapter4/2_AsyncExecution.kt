package youtube.coroutine.course.chapter4

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main()  = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    val timeTaken = measureTimeMillis {
        val msgOne: Deferred<String> = async { getMsgOne() }
        val msgTwo: Deferred<String> = async { getMsgTwo() }
        println("Result: ${msgOne.await() + msgTwo.await()}")
    }

    println("Time taken $timeTaken in ms") // now it will take only 1 second because execution is concurrent using async

    println("Main program ends: ${Thread.currentThread().name}")
}