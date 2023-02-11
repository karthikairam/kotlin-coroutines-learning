package basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        repeat(100_000) {
            launch {
                delay(5000L)
                print(".")
            }
        }
    }

    /*
    If you write the same program using threads (remove runBlocking, replace launch with thread,
    and replace delay with Thread.sleep), it will likely consume too much memory and
    throw an out-of-memory error.
    */
}