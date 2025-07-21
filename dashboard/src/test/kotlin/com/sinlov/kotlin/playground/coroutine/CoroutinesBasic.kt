package com.sinlov.kotlin.playground.coroutine

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * doc list:
 * [Coroutines guide](https://kotlinlang.org/docs/coroutines-guide.html)
 * [Coroutines basics](https://kotlinlang.org/docs/coroutines-basics.html)
 * [Coroutines and channels − tutorial](https://kotlinlang.org/docs/coroutines-and-channels.html)
 */
class CoroutinesBasic : FunSpec({

    test("first coroutine") {
        var foo = 0
        runBlocking {
            launch {
                delay(1000L)
                println("World!")
                foo++
                foo shouldBe 1
            }
            println("Hello,")
            foo shouldBe 0
        }
    }

    test("run suspend") {
        var foo = 0
        suspend fun doWorld() {
            delay(1000L)
            foo++
            println(", coroutines!!")
            foo shouldBe 1
        }
        async { doWorld() }
        foo shouldBe 0
    }

    test("coroutine context") {
        var foo = 0

        /**
         * Its function is to create a [coroutineScope], execute the coroutines inside it,
         * and exit after all coroutines have been executed.
         * The first parameter is the [kotlin.coroutines.CoroutineContext] specified for the coroutine to run.
         */
        suspend fun doWorld() = coroutineScope {  // this: CoroutineScope
            launch(Dispatchers.Default) {
                delay(1000L)
                foo++
                println(", coroutines!!")
                foo shouldBe 1
            }
            println("Hello")
        }
        async { doWorld() }
        foo shouldBe 0
    }

    test("coroutine withContext") {
        var foo = 0

        /**
         * more info see [withContext](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines/with-context.html)
         */
        suspend fun doWorld() = coroutineScope {  // this: CoroutineScope
            launch {
                withContext(Dispatchers.Default) {
                    delay(1000L)
                    foo++
                    println(", coroutines!!")
                    foo shouldBe 1
                }
            }
            println("Hello")
        }
        async { doWorld() }
        foo shouldBe 0
    }

    test("concurrently executes both sections") {
        var foo = 0

        /**
         * We here have pseudo-concurrency;
         * we have not specified any threads, and both coroutines are running within the main thread by [Thread.currentThread].
         * However, they do not interfere with each other, nor do they cause any blocking.
         * They are indeed "running simultaneously."
         */
        suspend fun doWorld() = coroutineScope { // this: CoroutineScope
            launch {
                delay(2000L)
                foo++
                println(", coroutine #2, comes later!")
                foo shouldBe 2
            }
            launch {
                delay(1000L)
                foo++
                println(", coroutine #1, here I am!")
                foo shouldBe 1
            }
            print("Hello")
        }
        async { doWorld() }
        foo shouldBe 0
    }

    test("concurrently Controllability") {
        var foo = 0

        /**
         * Deferred is a subclass of Job, with the unique feature of obtaining the return result of a coroutine.
         * Through its [kotlinx.coroutines.Deferred.await] function, it can "synchronously wait" for the coroutine result to return.
         * launch can wait for the coroutine to complete through Job, but cannot obtain the coroutine's return result.
         * This is the biggest difference between [launch] and [async].
         */
        suspend fun doWorld() = coroutineScope {
            val job = launch {
                delay(2000L)
                foo++
                println(" and coroutine #2")
                foo shouldBe 2
            }
            launch {
                delay(1000L)
                foo++
                println("from coroutine #1 !")
                foo shouldBe 1
            }
            println("Hello")
            job.join()
            println("All jobs done.")
            foo shouldBe 2
        }

        async { doWorld() }
        foo shouldBe 0
    }
})