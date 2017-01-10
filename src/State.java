import java.util.ArrayList;
import java.util.List;

/**
 * Created by mattijs on 22/12/2016.
 */
public class State {

    private Node node1, node2;

    public State(Node node1, Node node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

    public List<State> getNeighbours() {
        List<State> neighbours = new ArrayList<>();

        for (Connection connection : node1.getConnections()) {

            if (node2.getNodeType().equals(connection.getConnectionType())) {

                neighbours.add(new State(connection.getToNode(), node2));

            }

        }

        for (Connection connection : node2.getConnections()) {

            if (node1.getNodeType().equals(connection.getConnectionType())) {

                neighbours.add(new State(node1, connection.getToNode()));

            }

        }

        return neighbours;
    }

    @Override
    public String toString() {
        return "State: " + node1.getNumber() + "/" + node2.getNumber();
    }
}
