
/*
    A closure separates the definition of of a method from its execution.

    Whenever you see the curly braces of a closure, think: new Closure(){}
 */
{ person -> new Letter(person).send() }

/*
    A closure is an object, and a reference to a closure can be assigned to a variable.
 */
Closure envelope = { person -> new Letter(person).send() }
/*
    A closure is executed when invoking the method call.
 */
envelope.call("Trisha")

class Letter {
    String person

    Letter(person) {
        this.person = person
    }

    void send() {
        println "Sending letter to ${this.person}"
    }
}

def addressBook = ['Tom', 'Tim', 'Terry']

/*
    A groovy array has a method each, that accepts a closure as an argument:
        public List<T> each(Closure closure) {}
 */

addressBook.each (envelope)

// The closure_notation can be simplified into the following notation:
addressBook.each { new Letter(it).send() }

// Groovy's type-less language features allow the following closure short-hand notation:
def clos = { name -> println "hello ${name}!"}
clos.call('Peter')

/*
    A method can have a Closure as an argument:
 */
def postmaster(Closure closure, String... names) {
    println "\nPostmaster sending to ${names.size()}"
    names.each(closure)
    println "\n"
}

postmaster(envelope, "Trisha")
postmaster(envelope, "Trisha", "Tim")

/*
    postmaster2 has closure as the last argument:
 */
def postmaster2(List names, Closure closure) {
    println "\nPostmaster sending to ${names.size()}"
    names.each(closure)
    println "\n"
}

/*
    Closures can be passed as arguments to the method invocation
 */
postmaster2(["Pipper"], { name -> println "Sending letter to ${name}"})
/*
    The short-hand notation moves the argument outside of the parentheses ()
 */
postmaster2(["Paul"]) { name -> println "Sending letter to ${name}"}


