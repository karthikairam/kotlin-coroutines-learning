package youtube.coroutine.course.chapter3.exception_handling

import kotlinx.coroutines.*

fun main() = runBlocking {

    println("Main program starts: ${Thread.currentThread().name}")

    val job: Job = launch(Dispatchers.Default) {// Run on Main thread because it inherits from parent coroutine.
        try {
            println("Coroutine program starts: ${Thread.currentThread().name}")
            for (i in 0..10) {
                print("$i, ")
                delay(2) // for simulation purpose only, we can't use delay because it will check for cancel
            }
        } catch (ex: CancellationException) {
            print("\nException caught: ${ex.message}") // custom message passed in cancel() fun will be printed here
        } finally {
            //delay(10)  Don't use delay() directly in finally as it will throw the cancellation exception
            withContext(NonCancellable) {// It creates separate coroutine
                delay(10)
                print("\nClose resources! Thread ${Thread.currentThread().name}")
            }
        }
    }

    delay(10)

    job.cancel("My own crash message") // for customer message
    job.join()

    println()
    println("Main program ends: ${Thread.currentThread().name}")
}