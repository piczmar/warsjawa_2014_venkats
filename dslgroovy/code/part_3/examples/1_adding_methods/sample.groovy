String greet = 'hello'

println greet
println greet.class

String.metaClass.shout = { -> toUpperCase() }

println greet.shout()