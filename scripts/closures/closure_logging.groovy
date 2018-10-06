def configurator = { format, filter, line ->
    filter(line) ? format(line) : null
}

def appender = { config, append, line ->
    def out = config(line)
    if (out) append(out)
}

def dateFormatter            = { line -> "${new Date()}: $line" }
def debugFilter              = { line -> line.contains('debug') }
def consoleAppender          = { line -> println line }

def myConf = configurator.curry(dateFormatter, debugFilter)
def myLog = appender.curry(myConf, consoleAppender)

myLog('here is some debug message')
myLog('this will not be printed')

