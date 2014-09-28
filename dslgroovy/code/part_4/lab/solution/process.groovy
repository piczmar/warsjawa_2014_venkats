class ExpenseProcessor {
  def expenses = [:]
  
  def methodMissing(String name, args) {
    if(args.size() != 1 || !(args[0] instanceof BigDecimal)) {
      println "$name ${args.join(',')} is invalid"
    } else {
      if(expenses."$name") {
        expenses."$name" += args[0]
      } else {
        expenses."$name" = args[0]
      }
    }
  }
  
  static void process(dsl) {
    def code = """
      processor.with { 
        $dsl
      }
    """
    
    ExpenseProcessor processor = new ExpenseProcessor()
    def binding = new Binding()
    binding.setProperty('processor', processor)
    new GroovyShell(binding).evaluate(code)
    
    def total = processor.expenses.values().sum()
    println "Total expense is \$$total"
    
    println "Itemized expenses:"
    println "Item\tAmount"
    
    processor.expenses.each { entry ->
      println "$entry.key\t$entry.value"
    }
  }
}

def dsl = new File('expenses.dsl').text
ExpenseProcessor.process(dsl)

/*
cab a is invalid
Total expense is $691.72
Itemized expenses:
Item                 Amount
train                20.25
airfare              523.42
cab                  15.29
meal                 25.48
*/