def code = """
  println "hello " + name
"""

def binding = new Binding()
binding.setProperty('name', 'Joe')
def engine = new GroovyShell(binding)
engine.evaluate(code)

binding.setProperty('name', 'Sara')
engine.evaluate(code)