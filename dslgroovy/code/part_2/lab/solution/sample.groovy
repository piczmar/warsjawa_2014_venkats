class PizzaShop {
  def theSize
  def theCrust
  def theToppings
  def theAddress
  
  def size(pizzaSize) {
    theSize = pizzaSize
  }
  
  def crust(pizzaCrust) {
    theCrust = pizzaCrust
  }
  
  def toppings(String[] pizzaToppings) {
    theToppings = pizzaToppings
  }
  
  def address(deliverTo) {
    theAddress = deliverTo
  }
  
  static void order(closure) {
    PizzaShop shop = new PizzaShop()
    shop.with closure
    println 'placing order for Pizza'
    println shop.theSize
    println "${shop.theCrust} crust"
    println "toppings ${shop.theToppings.join(", ")}"
    println "address ${shop.theAddress}"
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
