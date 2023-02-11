package basics

import kotlinx.coroutines.*
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.FutureTask
import java.util.concurrent.RecursiveTask
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun main() {

    runBlocking {
        launch {
            printWorld()
        }
        println("Hello")
        coroutineScope {
            val a: Deferred<Int> = async {
                1+1
            }
            val b: Deferred<Int> = async {
                1+1
            }

            println(a.await() + b.await())
        }
    }
    println("Outside run blocking!")
}

//To call any suspending function you need to invoked from another suspending fun.
// runBlocking is a bridge between blocking and non-blocking codes (written using coroutines).
// So, in real applications we rarely use runBlocking because we lose the benefit of non-blocking.
// Ex: In Reactive programming, runBlocking generally called from the top of the application framework.
private suspend fun printWorld() {
    delay(1.toDuration(DurationUnit.SECONDS))
    println("World!")
}