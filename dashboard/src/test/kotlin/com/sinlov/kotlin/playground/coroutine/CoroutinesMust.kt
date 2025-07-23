package com.sinlov.kotlin.playground.coroutine

import io.kotest.core.spec.style.FunSpec
import kotlinx.coroutines.launch
import kotlinx.coroutines.async

class CoroutinesMust : FunSpec({
    test("CoroutineContext") {
        /**
         * The method [launch]/[async] for creating coroutines has a total of 3 parameters,
         * with the last one being the coroutine code block,
         * and the other two parameters are used to control the coroutine.
         */

        /**
         * [kotlin.coroutines.CoroutineContext] is a collection, the specific element type is [kotlin.coroutines.CoroutineContext.Element]
         * Specific elements have four types.
         * [kotlinx.coroutines.Job]：协程的句柄，或者说唯一标识，用以具体控制每个协程的（cancel和join等），具有树形关系
         * [kotlinx.coroutines.CoroutineDispatcher]：用以指定协程的运行线程
         * [kotlinx.coroutines.CoroutineName]：给协程取个名字，方便调试
         * [kotlinx.coroutines.CoroutineExceptionHandler]：指定协程的异常处理器，用以处理未被捕获的异常
         */
    }
})