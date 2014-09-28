import com.agiledeveloper.MyCounter;

/**
 * STM example
 * You should us this pattern when you have infrequent collisions, many rights/reads
 *
 */
public class Sample {
  public static void main(String[] args) throws Exception {
    final MyCounter myCounter = new MyCounter();

    System.out.println(myCounter.getCount());

    myCounter.increase(100);

    Thread.sleep(1000);
    System.out.println(myCounter.getCount());

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          myCounter.increase(100);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          myCounter.increase(200);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }).start();

    Thread.sleep(1000);
    System.out.println(myCounter.getCount());
  }
}
