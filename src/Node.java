import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class Node implements Serializable {
    private int id;
    private int weight;
    private List<Node> deps;

    public Node(int id) {
        this.id = id;
        this.weight = 0;
        this.deps = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public List<Node> getDeps() {
        return deps;
    }

    public void setTime(int time) {
        this.weight = time;
    }

    public void addDep(Node dep) {
        deps.add(dep);
    }
}
