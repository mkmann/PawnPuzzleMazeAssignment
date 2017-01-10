/**
 * Created by mattijs on 22/12/2016.
 */
public class Connection {

    private Node fromNode, toNode;
    private Board.Colour connectionType;

    public Connection(Node fromNode, Node toNode, Board.Colour connectionType) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.connectionType = connectionType;
    }

    public Node getFromNode() {
        return fromNode;
    }

    public Node getToNode() {
        return toNode;
    }

    public Board.Colour getConnectionType() {
        return connectionType;
    }
}
