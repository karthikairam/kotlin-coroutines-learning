package youtube.coroutine.course.chapter2_coroutine_builders

import kotlinx.coroutines.*

// runBlocking coroutine builder shouldn't be used in actual application code due to its blocking nature.
// But one of it usage is,
//      1. Unit testing
suspend fun doSomeLongProcessing() {
    delay(1000)
}
