import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * The board class contains nodes who all have connections to one another.
 * A depth First Search is executed to find a path for the pawns from start to one of the reaches
 * the finish state
 */
public class Board {

    //The position of the two nodes
    private static Node nodeOne, nodeTwo;
    //set for visited states
    HashSet<State> visitedStates;
    /**
     * The method sets up the board, and starts the depthFirstSearch from the starting position.
     * The result of this depth first is then formatted and displayed for the user.
     * @return A string displaying the different states from start to finish.
     */
    public String getSolution() {
        setupBoard(); //Creates the board with it's nodes and connections
        visitedStates = new HashSet<>();
        //Start the search
        LinkedList<State> solution = depthFirstSearch(new State(nodeOne, nodeTwo), visitedStates);
        //Make the string that will be displayed for the user
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

    /**
     * Recursive method that performs a depth first search through the graph. When the end
     * state is reached, the method traveses back adding the states along the way.
     * @param start that the method should perform depth first search on.
     * @param visited HashSet that contains all visisted nodes in the current search, used for cycle detection
     * @return the solution in a list of the different states
     */
    private LinkedList<State> depthFirstSearch(State start, HashSet<State> visited) {

        LinkedList<State> solution;
        visited.add(start);
        if (start.goalStateReached()) { //Goal has been reached
            //Instantiate the LinkedList with the final state and return
            solution = new LinkedList<>();
            solution.add(start);
            return solution;
        } else { //Goal not reached so continue the search
            //Get all of the neighbours
            List<State> neighbours = start.getNeighbours();
            for (State neighbour : neighbours) {//Iterate through
                if(!visited.contains(neighbour)) {
                    //For each state make a recursive call
                    solution = depthFirstSearch(neighbour, visited);
                    if (isGoalReached(solution)) { //If goal reached add start first and return
                        solution.addFirst(start);
                        return solution;
                    }
                }
            }
        }
        visited.remove(start);
        //No possible solutions so return empty LinkedList
        return new LinkedList<State>();
    }

    /**
     * Checks if any off the states in the list has reached the finish state
     * @param states that should be checked for reaching the end state
     * @return true if goal is reached. False if otherwise
     */
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

        //Add connections to the different nodes
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
