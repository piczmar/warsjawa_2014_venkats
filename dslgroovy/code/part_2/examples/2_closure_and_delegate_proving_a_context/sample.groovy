def greet = { name ->
  println "${salutation()} $name"
}

class GreetSalutation {
  def salutation() { 'hello' }
}

greet.delegate = new GreetSalutation()
greet('Sam')

class CasualSalutation {
  def salutation() { 'dude'}
}

greet.delegate = new CasualSalutation()
greet('Sam')