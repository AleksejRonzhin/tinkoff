import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.atomic.AtomicInteger

fun main() {
	val listPool = listOf(
		Executors.newFixedThreadPool(10),
		Executors.newFixedThreadPool(20),
		Executors.newFixedThreadPool(30)
	)
	val results = mutableMapOf<Int, Long>()
	listPool.forEach { executor ->
		val size = (executor as ThreadPoolExecutor).corePoolSize
		val i = AtomicInteger(0)
		var allTime: Long = 0
		repeat(size) {
			executor.submit(Callable {
				val start = System.nanoTime()
				while (i.get() < 1000000) {
					i.incrementAndGet()
				}
				System.nanoTime() - start
			}).also { res -> allTime += res.get() }
		}
		results[size] = allTime
		executor.shutdown()
	}
	results.toList().sortedBy { it.second }.forEach {
		println("Pool ${it.first} : ${it.second} nanosecond")
	}
}