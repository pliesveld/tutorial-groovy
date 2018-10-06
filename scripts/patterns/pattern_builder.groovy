class TestBuilder extends groovy.util.BuilderSupport {
    @Override
    protected void setParent(Object parent, Object child) {
    }

    @Override
    protected Object createNode(Object name) {
        return null
    }

    @Override
    protected Object createNode(Object name, Object value) {
        return null
    }

    @Override
    protected Object createNode(Object name, Map attributes) {
        return null
    }

    @Override
    protected Object createNode(Object name, Map attributes, Object value) {
        return null
    }

    def methodMissing(String name, def args) {return null}

    def propertyMissing(String name) {return null}

    def propertyMissing(String name, def arg) {}
}

def builder = new TestBuilder();

builder()
builder('x')
builder(a:1)
builder(a:1, 'x')

builder.foo() {
    bar(a:1)
}

