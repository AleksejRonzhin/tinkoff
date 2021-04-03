class MyRun : Runnable {
	override fun run() {
		println("Runnable: ${Thread.currentThread().name}")
	}
}