import java.util.LinkedList;
import java.util.List;

/**
 * Created by mattijs on 22/12/2016.
 */
public class Board {

    public enum Colour {PURPLE, ORANGE, BLACK, GREEN, BLUE}

    private Node nodeOne, nodeTwo, nodeThree, nodeFour, nodeFive, nodeSix, nodeSeven, nodeEight, nodeNine, nodeTen, nodeEleven, nodeTwelve, nodeThirteen,
            nodeFourteen, nodeFifteen, nodeSixteen, nodeSeventeen, nodeEighteen, nodeNineteen, nodeTwenty, nodeTwentyOne, nodeTwentyTwo, nodeTwentyThree;


    public static void main(String[] args) {

        Board board = new Board();
        board.setupBoard();

        State state1 = new State(board.nodeThirteen, board.nodeSeventeen);
        System.out.println(state1.getNeighbours());

    }

    private LinkedList<State> dfs(State start) {

        LinkedList<State> solution;

        if (start.goalStateReached()) { //Goal has been reached
            //Instantiate the LinkedList with the final state and return
            solution = new LinkedList<>();
            solution.add(start);
            return solution;
        } else { //Goal not reached so continue the search
            //Get all of the neighbours
            List<State> neighbours = start.getNeighbours();
            for (State neighbour : neighbours) {//Iterate through
                //For each state make a recursive call
                solution = dfs(neighbour);
                assert solution != null: "The state met a dead end";
                if (isGoalReached(solution)) { //If goal reached add start first and return
                    solution.addFirst(start);
                    return solution;
                }
            }
        }
        //No possible solutions so return empty LinkedList
        return new LinkedList<State>();
    }

    private boolean isGoalReached(LinkedList<State> states) {
        for (State state : states) {
            if (state.goalStateReached()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Creates all of the nodes and adds the connections they have to each other
     */
    private void setupBoard() {

        nodeOne = new Node(1, Colour.PURPLE);
        nodeTwo = new Node(2, Colour.BLACK);
        nodeThree = new Node(3, Colour.GREEN);
        nodeFour = new Node(4, Colour.GREEN);
        nodeFive = new Node(5, Colour.GREEN);
        nodeSix = new Node(6, Colour.ORANGE);
        nodeSeven = new Node(7, Colour.ORANGE);
        nodeEight = new Node(8, Colour.PURPLE);
        nodeNine = new Node(9, Colour.PURPLE);
        nodeTen = new Node(10, Colour.BLACK);
        nodeEleven = new Node(11, Colour.ORANGE);
        nodeTwelve = new Node(12, Colour.PURPLE);
        nodeThirteen = new Node(13, Colour.ORANGE);
        nodeFourteen = new Node(14, Colour.GREEN);
        nodeFifteen = new Node(15, Colour.ORANGE);
        nodeSixteen = new Node(16, Colour.GREEN);
        nodeSeventeen = new Node(17, Colour.GREEN);
        nodeEighteen = new Node(18, Colour.BLACK);
        nodeNineteen = new Node(19, Colour.ORANGE);
        nodeTwenty = new Node(20, Colour.GREEN);
        nodeTwentyOne = new Node(21, Colour.BLACK);
        nodeTwentyTwo = new Node(22, Colour.BLACK);
        nodeTwentyThree = new Node(23, Colour.BLUE);

        nodeOne.addConnection(new Connection(nodeFour, Colour.PURPLE));
        nodeOne.addConnection(new Connection(nodeFive, Colour.BLACK));

        nodeTwo.addConnection(new Connection(nodeSix, Colour.GREEN));
        nodeTwo.addConnection(new Connection(nodeTwelve, Colour.PURPLE));

        nodeThree.addConnection(new Connection(nodeOne, Colour.ORANGE));
        nodeThree.addConnection(new Connection(nodeFour, Colour.ORANGE));

        nodeFour.addConnection(new Connection(nodeThirteen, Colour.BLACK));

        nodeFive.addConnection(new Connection(nodeNine, Colour.ORANGE));

        nodeSix.addConnection(new Connection(nodeNine, Colour.GREEN));
        nodeSix.addConnection(new Connection(nodeTen, Colour.PURPLE));

        nodeSeven.addConnection(new Connection(nodeTwo, Colour.GREEN));

        nodeEight.addConnection(new Connection(nodeThree, Colour.PURPLE));

        nodeNine.addConnection(new Connection(nodeFour, Colour.GREEN));
        nodeNine.addConnection(new Connection(nodeFourteen, Colour.BLACK));

        nodeTen.addConnection(new Connection(nodeFifteen, Colour.GREEN));

        nodeEleven.addConnection(new Connection(nodeTen, Colour.PURPLE));
        nodeEleven.addConnection(new Connection(nodeTwelve, Colour.GREEN));

        nodeTwelve.addConnection(new Connection(nodeSeven, Colour.GREEN));

        nodeThirteen.addConnection(new Connection(nodeEight, Colour.GREEN));
        nodeThirteen.addConnection(new Connection(nodeEighteen, Colour.GREEN));

        nodeFourteen.addConnection(new Connection(nodeTwenty, Colour.ORANGE));
        nodeFourteen.addConnection(new Connection(nodeTwentyThree, Colour.GREEN));

        nodeFifteen.addConnection(new Connection(nodeTwentyThree, Colour.PURPLE));
        nodeFifteen.addConnection(new Connection(nodeTwentyTwo, Colour.BLACK));

        nodeSixteen.addConnection(new Connection(nodeFifteen, Colour.GREEN));

        nodeSeventeen.addConnection(new Connection(nodeEleven, Colour.BLACK));
        nodeSeventeen.addConnection(new Connection(nodeTwelve, Colour.PURPLE));
        nodeSeventeen.addConnection(new Connection(nodeSixteen, Colour.BLACK));

        nodeEighteen.addConnection(new Connection(nodeNine, Colour.ORANGE));
        nodeEighteen.addConnection(new Connection(nodeTwenty, Colour.ORANGE));

        nodeNineteen.addConnection(new Connection(nodeEighteen, Colour.GREEN));

        nodeTwenty.addConnection(new Connection(nodeNineteen, Colour.BLACK));
        nodeTwenty.addConnection(new Connection(nodeTwentyOne, Colour.ORANGE));

        nodeTwentyOne.addConnection(new Connection(nodeTwentyTwo, Colour.ORANGE));
        nodeTwentyOne.addConnection(new Connection(nodeTwentyThree, Colour.BLACK));

        nodeTwentyTwo.addConnection(new Connection(nodeSeventeen, Colour.ORANGE));


    }

}
