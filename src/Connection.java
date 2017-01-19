/**
 * Class that represents a connection between nodes
 */
public class Connection {

    private Node toNode;
    private Colour connectionType;

    /**
     * Constructor for a connection object which is saved in a node object.
     * @param toNode The node to which the node is connected.
     * @param connectionType The colour of the connection
     */
    public Connection(Node toNode, Colour connectionType) {
        this.toNode = toNode;
        this.connectionType = connectionType;
    }

    // Getters
    public Node getToNode() {
        return toNode;
    }

    public Colour getConnectionType() {
        return connectionType;
    }
}
