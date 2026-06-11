//Matsane
//Gugulethu
//4376487
import java.io.*;
import java.util.*;

class CoinsPuzzle {

    // State class representing each board state
    static class State implements Comparable<State> {
        String board;
        int heuristic;
        int moves;
        State parent;

        // Constructor for creating a new state
        State(String board, int heuristic, int moves, State parent) {
            this.board = board;
            this.heuristic = heuristic;
            this.moves = moves;
            this.parent = parent;
        }

        // Override compareTo method for PriorityQueue sorting based on heuristic
        @Override
        public int compareTo(State other) {
            return Integer.compare(this.heuristic, other.heuristic);
        }
    }

    // Main method
    public static void main(String[] args) throws IOException {
        String startState;

        // Reading the start state from the input file
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            startState = br.readLine().trim(); // Read the start state as a string
        }

        String goalState = "BBB0RRR";
        bestFirstSearch(startState, goalState, "output.txt");
    }

    // Best-First Search algorithm to find the solution to the coin puzzle
    private static void bestFirstSearch(String start, String goal, String outputFile) throws IOException {
        PriorityQueue<State> pq = new PriorityQueue<>();
        Set<String> visited = new HashSet<>();
        pq.add(new State(start, heuristic(start, goal), 0, null));

        // write the output to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            while (!pq.isEmpty()) {
                State current = pq.poll();
                
                if (visited.contains(current.board)) continue;
                visited.add(current.board);

                writer.write("h=" + current.heuristic + " " + current.board + "\n");
                System.out.println("h=" + current.heuristic + " " + current.board);

                // If the goal state is reached, print the result and terminate
                if (current.board.equals(goal)) {
                    writer.write("Moves taken: " + current.moves + "\n");
                    System.out.println("Moves taken: " + current.moves);
                    return;
                }

                for (String nextBoard : getSuccessors(current.board)) {
                    if (!visited.contains(nextBoard)) {
                        pq.add(new State(nextBoard, heuristic(nextBoard, goal), current.moves + 1, current));
                    }
                }
            }
        }
    }

    private static int heuristic(String state, String goal) {
        int misplaced = 0;
        for (int i = 0; i < state.length(); i++) {
            if (state.charAt(i) != goal.charAt(i) && state.charAt(i) != '0') {
                misplaced++;
            }
        }
        return misplaced;
    }

    private static List<String> getSuccessors(String board) {
        List<String> successors = new ArrayList<>();
        char[] arr = board.toCharArray();
        int emptyIndex = board.indexOf('0');

        int[] moves = {-1, 1, -2, 2};
        for (int move : moves) {
            int newIndex = emptyIndex + move;
            if (newIndex >= 0 && newIndex < board.length()) {
                char[] newBoard = arr.clone();
                newBoard[emptyIndex] = newBoard[newIndex];
                newBoard[newIndex] = '0';
                successors.add(new String(newBoard));
            }
        }
        return successors;
    }
}