package youtube.coroutine.course.chapter1_basics

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    println("Main program starts: ${Thread.currentThread().name}")

    GlobalScope.launch {
        println("A coroutine starts: ${Thread.currentThread().name}")
        delay(1000) // Note we used delay to make it non-blocking unlike Thread.sleep()
        println("A coroutine ends: ${Thread.currentThread().name}")
    }

    println("Main program ends: ${Thread.currentThread().name}")

    // Since coroutine runs in the background and it is daemon thread, we need to make the main thread wait
    Thread.sleep(1300)
}