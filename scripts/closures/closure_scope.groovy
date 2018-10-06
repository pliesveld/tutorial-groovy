

class Mother {
    int field = 1
    int foo() {
        return 2
    }

    Closure birth (param) {
        def local = 3
        def closure = { caller ->
            [this, field, foo(), local, param, caller, this]
        }
        return closure
    }
}

Mother julia = new Mother()

closure = julia.birth(4)

context = closure.call(this)

println context[0].class.name

assert context[1..4] == [1,2,3,4]
assert context[5] instanceof Script
assert context[6] instanceof Mother

firstClosure = julia.birth(4)
secondClosure = julia.birth(4)

assert false == firstClosure.is(secondClosure)
