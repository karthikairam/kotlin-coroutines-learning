package youtube.coroutine.course.chapter2_coroutine_builders

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class RunBlockingCoroutineBuildersKtTest {

    @Test
    fun `test the suspending fun using runBlocking`() = runBlocking {
        doSomeLongProcessing()
        assert(value = true) {
            "Failed to evaluate the call"
        }
    }
}