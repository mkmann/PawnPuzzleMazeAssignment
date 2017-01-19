import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a State object, which consists of the combination of two nodes (pawns)
 */
public class State {

    private Node node1, node2;

    /**
     * Constructor for the State class
     * @param node1 The first node of the state
     * @param node2 The second node of the state
     */
    public State(Node node1, Node node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    /**
     * getNeighbours method that can be called to get all possible following states.
     * @return List with State object which are all possible states following this one.
     */
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

    /**
     * Method to check if this state reached the goal Node
     * @return True if goal node is reached, false otherwise
     */
    public boolean goalStateReached() {

        return (node1.getNumber() == 23 || node2.getNumber() == 23);

    }

    // Getters
    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

    /**
     * Overrides toString to give a readable output for the State object.
     * @return String containing the useful information about this State.
     */
    @Override
    public String toString() {
        return node1.getNumber() + "/" + node2.getNumber();
    }
}
