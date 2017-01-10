import java.util.ArrayList;

/**
 * Created by mattijs on 22/12/2016.
 */
public class Node {

    private int number;
    private Board.Colour nodeType;
    private ArrayList<Connection> connections;

    public Node(int number, Board.Colour nodeType) {
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

    public Board.Colour getNodeType() {
        return nodeType;
    }

    public ArrayList<Connection> getConnections() {
        return connections;
    }
}
