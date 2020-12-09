import java.util.List;
import java.util.ArrayList;
import parcs.*;

public class DFS implements AM {
    public void run(AMInfo info) {
        Node n = (Node)info.parent.readObject();
        System.out.println("[" + n.getId() + "] Build started.");

        List<point> points = new ArrayList<>();
        List<channel> chans = new ArrayList<>();
        for (Node d: n.getDeps()) {
            point p = info.createPoint();
            channel c = p.createChannel();
            p.execute("DFS");
            c.write(d);
            points.add(p);
            chans.add(c);
        }

        long sumWeight = n.getWeight();
        long maxChW = 0L;
        long chWeight;
        for (channel c: chans) {
            chWeight = c.readLong();
            if(chWeight > maxChW){
                maxChW = chWeight;
            }
        }
        sumWeight += maxChW;

        try {
            Thread.sleep(n.getWeight());
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("[" + n.getId() + "] Build finished.");
        info.parent.write(sumWeight);
    }
}
