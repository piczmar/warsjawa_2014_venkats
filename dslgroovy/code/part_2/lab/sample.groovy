//YOUR CODE GOES HERE

class PizzaShop{
	def size(size){ println "$size"}
	def crust(crust){ println "$crust crust"}
	def toppings(String[] toppings){ 
		print "with toppings "
/*
		toppings.eachWithIndex{ e,i ->
			print e
			if(i < toppings.size()-1)
				print ","
		}
*/
		println toppings.join(", ")

	}
	def address(address){ println "$address"}
	
	static def order(closure){
		println "placing order for Pizza:"
		PizzaShop pShop = new PizzaShop()
		pShop.with closure
	}
	def propertyMissing(propName) { propName }
}
PizzaShop.order {
  size large
  crust thin
  toppings Olives, Onions, Bell_Pepper
  address "101 Main St., ..."
}
/*
placing order for Pizza:
large
thin crust
with toppings Olives, Onions, Bell Peppers
to address 101 Main St., ...
*/
