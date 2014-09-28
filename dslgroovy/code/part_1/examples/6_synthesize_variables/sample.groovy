def propertyMissing(propName) { propName }

def greet = ''
def say(greeting) {
  greet = greeting
  this
}

def to(name) {
  println "$greet $name"
}

say hello to Szymon
//say(propertyMissing(hello)).to(propertyMissing(Szymon))