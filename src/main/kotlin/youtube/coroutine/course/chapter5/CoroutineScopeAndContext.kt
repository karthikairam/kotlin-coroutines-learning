package youtube.coroutine.course.chapter5

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    var threadLocal = ThreadLocal.withInitial { "test" }
    runBlocking {
        println("Coroutine program starts: ${Thread.currentThread().name}")
        println("Main scope: $this, context: $coroutineContext")

        launch {
            processing(name = "C1", context = coroutineContext)
            launch(context = coroutineContext) {
                processing(name = "C1.1", context = coroutineContext)
            }
        }

        async {
            processing(name = "CA1", context = coroutineContext)
        }

        launch(context = Dispatchers.Default) {
            processing(name = "C2", context = coroutineContext)
            launch(context = coroutineContext) {
                processing(name = "C2.1", context = coroutineContext)
            }
        }

        launch(context = Dispatchers.Unconfined) {
            processing(name = "C3", context = coroutineContext)

            launch(context = Dispatchers.IO) {
                processing(name = "C3.1", context = coroutineContext)
            }
        }

        launch(context = Dispatchers.IO) {
            processing(name = "C4", context = coroutineContext)

            launch(context = coroutineContext) {
                processing(name = "C4.1", context = coroutineContext)
            }
        }

        launch(context = Dispatchers.IO) {
            processing(name = "C5", context = coroutineContext)

            launch(context = coroutineContext) {
                processing(name = "C5.1", context = coroutineContext)
            }
        }

        launch(context = coroutineContext) {
            processing(name = "C6", context = coroutineContext)
        }

        println("Thread Local: ${threadLocal.get()}")

        newFixedThreadPoolContext(4, "CustomPool").use {
            // We can add multiple context elements below. Note: All context elements are subtype of CoroutineContext
            launch(context = Dispatchers.IO + threadLocal.asContextElement("modified")) {
                println("Thread Local: ${threadLocal.get()}")
                processing(name = "C7", context = coroutineContext)
                coroutineContext.job
            }
        }

        // customPool.close() // Should be closed after using! Only applicable for "ExecutorCoroutineDispatcher" type

        println("Coroutine program ends: ${Thread.currentThread().name}")
    }
}

suspend fun processing(name: String, context: CoroutineContext) {
    println("$name - context: $context starts - ${Thread.currentThread().name}")
    delay(100)
    println("$name - context: $context ends - ${Thread.currentThread().name}")
}