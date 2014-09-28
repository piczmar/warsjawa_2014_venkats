import java.lang.Integer;

public class MyCollector extends UntypedActor {

    ActorRef explorer;
    int pendingWork
    int counter; // isolated mutable variable,no other thread can touch it

    @Override
    public void preStart() {
        explorer = getContext().actorOf(Props.create(ExploreFile.class).withRouter(new RoundRobinPool(100)));
    }

    @Override
    public void onReceive(final Object message) {
        if (message instanceof String) {
            pendingWork++;
            explorer.tell(message, self())
        } else if (message instanceof Integer) {
            int filesCount = (Integer) message;
            counter += filesCount;
            pendingWork--;
            if (pendingWork == 0) {
                System.out.println("Totel files: " + counter);
                getContext().system().shutdown();
            }
        }

    }
}
