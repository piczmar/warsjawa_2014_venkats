class Processor {
  def playersAndScore = [:]

  def methodMissing(String name, args) {
    playersAndScore."$name" = args[0]
  }

  def getWinner() {
    println "The winner is:"

    def winner = playersAndScore.max { entry -> entry.value }
    println "$winner.key with score $winner.value"
  }
  
  static void process(dsl) {
    Processor processor = new Processor()
    
    def code = """
      processor.with {
        $dsl
      }
    """
  
    def binding = new Binding()
    binding.setProperty('processor', processor)
    new GroovyShell(binding).evaluate(code)
    
    //rather than printing inside the shell, we can
    //also do work outside, because the process has all
    //the stuff it needs here.
    //println processor.playersAndScore
  }
}




