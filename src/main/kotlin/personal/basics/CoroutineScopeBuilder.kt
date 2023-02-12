package personal.basics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun main() {

    runBlocking {
        printHelloWorld()
    }
    println("Outside run blocking!")
}

//coroutineScope { } also a scope builder. It differs from runBlocking { } as later blocks the current Thread,
// and it is not a suspend function
private suspend fun printHelloWorld() = coroutineScope {
    launch {
        printWorld()
    }
    println("Hello")
}

private suspend fun printWorld() {
    delay(1.toDuration(DurationUnit.SECONDS))
    println("World!")
}