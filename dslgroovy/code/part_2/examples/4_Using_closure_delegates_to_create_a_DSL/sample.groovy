 class Mailer {
   void from(String addr) { println'from' }

   void to(String addr) { println'to' }

   void sub(String line) { println'sub' }

   void body(String msg) { println'body' }
    
   static void send(closure) {
    Mailer mailer = new Mailer()
    mailer.with closure
    
    println'sending...' 
  }
}

Mailer.send {
  from 'build@agiledeveloper.com'
  to 'venkats@agiledeveloper.com'
  sub 'Your code sucks'
  body '....'
}
