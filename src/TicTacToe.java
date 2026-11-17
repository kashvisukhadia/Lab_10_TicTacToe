import java.util.Scanner;
public class TicTacToe {
    private static final int ROWS=3;
    private static final int COLS =3;
    private static String board[][] = new String [ROWS][COLS];
    private static String currentPlayer = "X";
    private static void clearBoard(){
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = " ";
            }
        }
    }
    private static void display() {
        System.out.println();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(" " + board[row][col] + " ");
                if (col < COLS - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < ROWS - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }
    private static boolean isValidMove (int row, int col){
        if(board[row][col].equals(" ")){
            return true;
        }
        return false;
    }
    private static boolean isWin(String player){
        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player)){
            return true;
        }
        return false;
    }
    private static boolean isColWin(String player) {
        for (int col = 0; col < COLS; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }
    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROWS; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }
    private static boolean isDiagonalWin(String player) {
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true;
        }

        return false;
    }
    private static boolean isTie() {
        // Check all rows
        for (int row = 0; row < ROWS; row++) {
            if (!isBlocked(board[row][0], board[row][1], board[row][2])) {
                return false;
            }
        }

        // Check all columns
        for (int col = 0; col < COLS; col++) {
            if (!isBlocked(board[0][col], board[1][col], board[2][col])) {
                return false;
            }
        }

        // Check first diagonal
        if (!isBlocked(board[0][0], board[1][1], board[2][2])) {
            return false;
        }

        // Check second diagonal
        if (!isBlocked(board[0][2], board[1][1], board[2][0])) {
            return false;
        }

        return true;
    }
    private static boolean isBlocked(String a, String b, String c) {
        boolean hasX = a.equals("X") || b.equals("X") || c.equals("X");
        boolean hasO = a.equals("O") || b.equals("O") || c.equals("O");

        return hasX && hasO;
    }


    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        boolean playAgain;

        // PSEUDOCODE:
        // Clear the board.
        // Set the current player to X.
        // Get the player's row and column.
        // Convert the coordinates to array indexes.
        // Check if the move is valid.
        // Place the player's symbol on the board.
        // Display the updated board.
        // Check for a win or tie.
        // Switch players if the game is not over.
        // Ask players if they want to play again.

        do {
            clearBoard();
            currentPlayer = "X";
            boolean done = false;
            System.out.println("\nWelcome to Tic Tac Toe!");
            System.out.println("Player X goes first!");

            while (!done) {
                display();
                int row, col;
                String rowPrompt, colPrompt;
                while (true) {
                    rowPrompt = "Player " + currentPlayer + " enter row move (1-3): ";
                    colPrompt = "Player " + currentPlayer + " enter column move (1-3): ";
                    row = SafeInput.getRangedInt(in, rowPrompt, 1, ROWS) - 1;
                    col = SafeInput.getRangedInt(in, colPrompt, 1, COLS) - 1;

                    if (isValidMove(row, col)) {
                        board[row][col] = currentPlayer;
                        break;
                    }
                    else {
                        System.out.println("Enter a valid move.");
                    }
                }
                if (isWin(currentPlayer)) {
                    display();
                    System.out.println("Player " + currentPlayer + " WINS!");
                    done = true;
                }
                else if (isTie()) {
                    display();
                    System.out.println("The game is a TIE!");
                    done = true;
                }
                else {
                    if (currentPlayer.equals("X")) {
                        currentPlayer = "O";
                    }
                    else {
                        currentPlayer = "X";
                    }
                }
            }
            playAgain = SafeInput.getYNConfirm(in, "Would you like to play again? (Y/N): ");

        } while (playAgain);
        System.out.println("Thank you for playing Tic Tac Toe!");
        in.close();
    }
}
