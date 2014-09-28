playersAndScore = [:]

def methodMissing(String name, args) {
  playersAndScore."$name" = args[0]
}

def getWinner() {
  println "The winner is:"
  
  def winner = playersAndScore.max { entry -> entry.value }
  println "$winner.key with score $winner.value"
}

John 5
Sara 14
Bill 10
winner