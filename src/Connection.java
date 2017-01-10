/**
 * Created by mattijs on 22/12/2016.
 */
public class Connection {

    private Node toNode;
    private Board.Colour connectionType;

    public Connection(Node toNode, Board.Colour connectionType) {
        this.toNode = toNode;
        this.connectionType = connectionType;
    }

    public Node getToNode() {
        return toNode;
    }

    public Board.Colour getConnectionType() {
        return connectionType;
    }
}
