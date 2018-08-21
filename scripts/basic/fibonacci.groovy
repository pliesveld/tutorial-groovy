current = 1
next = 1

10.times { i ->
	next_next = next + current
	current = next
	next = next_next

	println(next_next)
}