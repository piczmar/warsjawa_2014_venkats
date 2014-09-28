def propertyMissing(propName) {
  propName
}

def move(direction) {
  println "moving $direction"
  this
}

def and(ignore) {
  this
}

def turn(direction) {
  println "turning $direction"
}

def jump(action1, action2) {
  println "jumping $action1 and $action2"
  this
}

move forward and then turn left
//moving forward
//turning left

jump fast, forward and then turn right
//jumping fast and forward
//turning right
