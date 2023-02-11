package youtube.coroutine.course.chapter4

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main()  = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    val timeTaken = measureTimeMillis {
        val msgOne: Deferred<String> = async(start = CoroutineStart.LAZY) { getMsgOne() }
        val msgTwo: Deferred<String> = async(start = CoroutineStart.LAZY) { getMsgTwo() }
        println("Result: ${msgOne.await() + msgTwo.await()}") // Now it executes in a sequential manner
    }

    // it will take 2+ seconds because execution is lazy (on demand) and almost sequential
    println("Time taken $timeTaken in ms")

    println("Main program ends: ${Thread.currentThread().name}")
}