class Person {
  def methodMissing(String name, args) {
    println "I like to $name"
  }
}

def sam = new Person()
sam.sing()