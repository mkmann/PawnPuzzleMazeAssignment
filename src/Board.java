import java.util.LinkedList;
import java.util.List;

public class Board {

    private static Node nodeOne, nodeTwo;

    public String getSolution() {
        setupBoard();
        LinkedList<State> solution = dfs(new State(nodeOne, nodeTwo));
        String result = "Solution with finish node number 23: \nStarting state: " + solution.getFirst() + " -> \n";
        int moveNumber = 0;

        for (State state : solution) {

            if (!state.equals(solution.getFirst()) && !state.equals(solution.getLast())) {
                result += "Move " + moveNumber + ": " + state + " -> \n";
            }

            if (state.equals(solution.getLast())) {
                result += "Move " + moveNumber + ": " + state + " (Finish reached)";
            }

            moveNumber++;

        }

        return result;
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

        // Starting nodes
        nodeOne = new Node(1, Colour.PURPLE);
        nodeTwo = new Node(2, Colour.BLACK);

        // All other nodes
        Node nodeThree = new Node(3, Colour.GREEN);
        Node nodeFour = new Node(4, Colour.GREEN);
        Node nodeFive = new Node(5, Colour.GREEN);
        Node nodeSix = new Node(6, Colour.ORANGE);
        Node nodeSeven = new Node(7, Colour.ORANGE);
        Node nodeEight = new Node(8, Colour.PURPLE);
        Node nodeNine = new Node(9, Colour.PURPLE);
        Node nodeTen = new Node(10, Colour.BLACK);
        Node nodeEleven = new Node(11, Colour.ORANGE);
        Node nodeTwelve = new Node(12, Colour.PURPLE);
        Node nodeThirteen = new Node(13, Colour.ORANGE);
        Node nodeFourteen = new Node(14, Colour.GREEN);
        Node nodeFifteen = new Node(15, Colour.ORANGE);
        Node nodeSixteen = new Node(16, Colour.GREEN);
        Node nodeSeventeen = new Node(17, Colour.GREEN);
        Node nodeEighteen = new Node(18, Colour.BLACK);
        Node nodeNineteen = new Node(19, Colour.ORANGE);
        Node nodeTwenty = new Node(20, Colour.GREEN);
        Node nodeTwentyOne = new Node(21, Colour.BLACK);
        Node nodeTwentyTwo = new Node(22, Colour.BLACK);
        Node nodeTwentyThree = new Node(23, Colour.BLUE);

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
        nodeFifteen.addConnection(new Connection(nodeTwentyTwo, Colour.GREEN));

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
