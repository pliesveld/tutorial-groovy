import groovy.json.*

def json = JsonOutput.toJson(
        [
                [name: 'John Doe', age: 42],
                [name: 'Jane Doe', age: 35],
        ]
)

println json
