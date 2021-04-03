import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger

fun main() {
	val listPool = listOf(
		Executors.newFixedThreadPool(10),
		Executors.newFixedThreadPool(30),
		Executors.newFixedThreadPool(20)
	)
	val results = mutableMapOf<Int, Long>()
	var pool = 1
	listPool.forEach {
		it.submit(Callable {
			val start = System.nanoTime()
			val i = AtomicInteger(0)
			while (i.get() < 1000000) {
				i.incrementAndGet()
			}
			System.nanoTime() - start
		}).also { res -> results[pool++] = res.get() }
		it.shutdown()
	}
	results.toList().sortedBy { it.second }.forEach {
		println("Pool ${it.first} : ${it.second} nanosecond")
	}
}