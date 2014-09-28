//Java like
public class Mailer {
  public void from(String addr) {
    System.out.println("from"); }

  public void to(String addr) {
    System.out.println("to"); }

  public void sub(String line) {
    System.out.println("sub"); }

  public void body(String msg) {
    System.out.println("body"); }
    
  public void send() { System.out.println("sending..."); }
}

Mailer mailer = new Mailer();
mailer.from("build@agiledeveloper.com");
mailer.to("venkats@agiledeveloper.com");
mailer.sub("Your code sucks");
mailer.body("....");
mailer.send();