/**
 * Application class containing the main method that calls the Board class and outputs the found solution.
 */
public class Application {

    public static void main(String[] args) {

        System.out.println("Welcome to the Pawn Puzzle Maze-solver");
        System.out.println("The following steps will result in one of the pawns reaching the finish: \n");

        System.out.println(new Board().getSolution());
    }

}
