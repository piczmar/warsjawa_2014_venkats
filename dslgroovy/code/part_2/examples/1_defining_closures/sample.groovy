def list = [1, 2, 3, 4, 5, 6]

list.each { e -> println e }

def printIt = { e -> println e }

list.each printIt

list.each { println it }