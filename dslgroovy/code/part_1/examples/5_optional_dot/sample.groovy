def create(str) {
  new StringBuilder(str)
}

def result1 = create("foo").append("bar")
println result1

def result2 = create "foo" append "bar"
println result2