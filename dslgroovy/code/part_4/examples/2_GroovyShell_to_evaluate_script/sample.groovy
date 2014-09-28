def code = """
  println "hello Joe"
"""

def engine = new GroovyShell()
engine.evaluate(code)