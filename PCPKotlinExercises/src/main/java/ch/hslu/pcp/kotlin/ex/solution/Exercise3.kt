package ch.hslu.pcp.kotlin.ex.solution

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlin.coroutines.EmptyCoroutineContext

private fun waitPrintAndReturnX(value: Long): Long {
    try {
        Thread.sleep(value)
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
    print(value)
    return value
}

fun main(args: Array<String>) {
    val longLastingTaskFuture= CoroutineScope(EmptyCoroutineContext).async { waitPrintAndReturnX(3000) }
    val evenLongerLastingTaskFuture= CoroutineScope(EmptyCoroutineContext).async { waitPrintAndReturnX(6000) }
    CoroutineScope(EmptyCoroutineContext).async {
        val val1 = longLastingTaskFuture.await()
        val val2 = evenLongerLastingTaskFuture.await()
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        print("was waiting for " + (val1 + val2 + 2000) + "ms")
    }
    println("-> Now waiting for things to happen!")
    for (i in 0..19) {
        print(".")
        try {
            Thread.sleep(500)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
    println("\n-> Done.")
}