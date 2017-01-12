

public class Connection {

    private Node toNode;
    private Colour connectionType;

    public Connection(Node toNode, Colour connectionType) {
        this.toNode = toNode;
        this.connectionType = connectionType;
    }

    public Node getToNode() {
        return toNode;
    }

    public Colour getConnectionType() {
        return connectionType;
    }
}
