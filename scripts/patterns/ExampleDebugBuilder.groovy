class DebugBuilder extends groovy.util.BuilderSupport {
    def result = ''<<''
    def indent = ' ' * 4
    int indentCount = -1

    def createNode(name) {
        indentCount++
        return check(name)
    }

    def createNode(name, value) {
        return check(createNode(name) << format(value))
    }

    def createNode(name, Map attributes) {
        return check(createNode(name) << format(attributes))
    }

    def createNode(name, Map attributes, value) {
        return check(createNode(name, attributes) << format(value))
    }

    @Override
    protected void setParent(Object parent, Object child) {
        result << "\n" << indent*indentCount << child.toString()
    }

    private check(descr) {
        if (!current) result << descr
        return descr
    }

    private format(value) {
        return '(' << value.toString() << ')'
    }

    private format(Map attributes) {
        StringBuffer formatted = '' << '['
        attributes.each { key, value ->
            formatted << key << ':' << value << ', '
        }
        formatted.length = formatted.size() - 2
        formatted << ']'
        return formatted
    }
}

def builder = new DebugBuilder()
builder.foo() {
    bar()
    baz('x') { map(a:1) }
}

println builder.result

println '*' * 80

builder = new DebugBuilder(result: new PrintWriter(System.out))

builder.prechecks() {
    stage('workspace')
    stage('k8s')
    stage('env vars')
}

builder.compile() {
    stage('download dependencies')
    stage('execute compiler') {
        [1,2,3,4]
    }

}

builder.test() {
    stage('validate artifact')
}

builder.result.flush()