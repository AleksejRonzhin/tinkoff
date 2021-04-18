import kotlin.concurrent.thread

fun main() {
	val commonData = CommonData()
	repeat(5) {
		thread(name = "Increment") {
			println("${Thread.currentThread().name}: ${++commonData.i}")
		}
		thread(name = "Reader 1") {
			println("${Thread.currentThread().name}: ${commonData.i}")
		}
		thread(name = "Reader 2") {
			println("${Thread.currentThread().name}: ${commonData.i}")
		}
		thread(name = "Reader 3") {
			println("${Thread.currentThread().name}: ${commonData.i}")
		}
	}
}