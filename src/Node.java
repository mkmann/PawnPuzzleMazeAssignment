import java.util.ArrayList;

/**
 * Class of a node on the board of the puzzle
 */
public class Node {

    private int number;
    private Colour nodeType;
    private ArrayList<Connection> connections;

    /**
     * Constructor of a Node object
     * @param number The number of the node
     * @param nodeType The colour of the node (Colour enumeration)
     */
    public Node(int number, Colour nodeType) {
        this.number = number;
        this.nodeType = nodeType;
        connections = new ArrayList<>();
    }

    /**
     * Adds a connection to this node
     * @param connection The connection to be added
     */
    public void addConnection(Connection connection) {
        connections.add(connection);
    }

    public int getNumber() {
        return number;
    }

    public Colour getNodeType() {
        return nodeType;
    }

    public ArrayList<Connection> getConnections() {
        return connections;
    }
}
