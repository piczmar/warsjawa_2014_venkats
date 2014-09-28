String greet = 'hello'

println greet
println greet.class

String.metaClass.getLength = { -> length() }

println greet.length