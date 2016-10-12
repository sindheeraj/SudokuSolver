package net.dheeru.sudoku.solver;

/**
 * Used to solve the sudoku.
 */
public class Solver {
  public static void main(String args[]) {
    final Board board = new Board();
    board.readInputFromStdin();

    solve(board);
  }

  private static void solve(final Board board) {

  }
}
