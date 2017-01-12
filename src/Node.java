import java.util.ArrayList;


public class Node {

    private int number;
    private Colour nodeType;
    private ArrayList<Connection> connections;

    public Node(int number, Colour nodeType) {
        this.number = number;
        this.nodeType = nodeType;
        connections = new ArrayList<>();
    }

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
