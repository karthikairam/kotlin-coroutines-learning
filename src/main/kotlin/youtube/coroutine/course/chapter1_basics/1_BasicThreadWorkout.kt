package youtube.coroutine.course.chapter1_basics

import kotlin.concurrent.thread

fun main() {
    println("Main program starts: ${Thread.currentThread().name}")

    thread {
        println("A thread starts: ${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("A thread ends: ${Thread.currentThread().name}")
    }

    println("Main program ends: ${Thread.currentThread().name}")
}