class Letter {

    String person
    Letter(person) {
        this.person = person
    }

    void send() {
        println "Sending letter to ${this.person}"
    }
}

def addressBook = []
addressBook.push('Tom')
addressBook.push('Tim')
addressBook.push('Terry')

Closure envelope = { person -> new Letter(person).send() }
addressBook.each (envelope)

// The closure can be simplified into the following notation:
addressBook.each { new Letter(it).send() }

// Closure short-hand
def clos = { name -> println "hello ${name}!"}
println clos.class
clos.call('Peter')
