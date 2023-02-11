package youtube.coroutine.course.chapter4

import kotlinx.coroutines.delay

suspend fun getMsgOne(): String {
    delay(1000)
    return "Hello, "
}

suspend fun getMsgTwo(): String {
    delay(1000)
    return "World"
}