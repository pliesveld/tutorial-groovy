def benchmark(repeat, Closure worker) {
    start = System.currentTimeMillis()
    repeat.times{ worker(it) }
    stop = System.currentTimeMillis()
    return stop - start
}

slow = benchmark(10000) { (int) it / 2 }
fast = benchmark(10000) { it.intdiv(2) }

assert fast * 15 > slow
