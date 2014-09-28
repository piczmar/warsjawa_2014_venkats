class Processor {
  def expenses = [:]

  def methodMissing(String name, args) {
	try{
		float v = Float.valueOf(args[0])
		expenses."$name" = v
	}catch(e){
		println "$name ${args[0]} is invalid"
	}
    
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

	def sum = processor.expenses.values().sum()
	println "Total expense is  \$${sum}"
	println "Itemized expenses:"
	processor.expenses.each{k,v->
		println "$k $v"
	}
   }
}




