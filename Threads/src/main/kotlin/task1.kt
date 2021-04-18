import kotlin.concurrent.thread

fun main() {
	Thread {
		println("Thread: ${Thread.currentThread().name}")
	}.start()
	Thread(MyRun()).start()
	thread {
		println("DSL: ${Thread.currentThread().name}")
	}
	thread(isDaemon = true) {
		println("Daemon: " + Thread.currentThread().name)
	}
	val thread1 = thread(start = false, priority = 3) {
		println("Priority 3: ${Thread.currentThread().name}")
	}
	val thread2 = thread(start = false, priority = 2) {
		println("Priority 2: ${Thread.currentThread().name}")
	}
	val thread3 = thread(start = false, priority = 1) {
		println("Priority 1: ${Thread.currentThread().name}")
	}
	thread3.start()
	thread2.start()
	thread1.start()
}