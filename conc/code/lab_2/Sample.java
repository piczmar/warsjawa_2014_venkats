import java.io.File;
import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Sample {
  public static void main(String[] args) throws InterruptedException {
      final String PATH = "...";

      countSequential(PATH);
      countConcurrent(PATH);
  }

    private static long countFiles(final String path) {
        long count = 0;
        File file = new File(path);
        final File[] files = file.listFiles();
        if(files != null) {
            for (File child : files) {
                if (child.isFile())
                    count++;
                else
                    count += countFiles(child.getPath());
            }
        }

        return count;
    }

    private static void countSequential(final String path) {
        long start = System.nanoTime();

        System.out.println(countFiles(path));

        long end = System.nanoTime();
        System.out.println("Time taken: " + (end - start)/1.0e9);
    }

    private static void countConcurrent(final String path) {
      //Your code goes here.
        long start = System.nanoTime();

        ActorSystem actorSystem = ActorSystem.create();

        ActorRef collector = actorSystem.actorOf(Props.create(MyCollector.class));
        collector.tell(path,collector);

        actorSystem.awaitTermination(10, TimeUnit.MINUTES);

        long end = System.nanoTime();
        System.out.println("Time taken: " + (end - start)/1.0e9);
    }
}
