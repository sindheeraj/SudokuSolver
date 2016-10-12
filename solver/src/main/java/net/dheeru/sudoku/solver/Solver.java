package net.dheeru.sudoku.solver;

import net.dheeru.sudoku.solver.strategy.EliminateStrategy;
import net.dheeru.sudoku.solver.strategy.FixValueStrategy;
import net.dheeru.sudoku.solver.strategy.Strategies;

/**
 * Used to solve the sudoku.
 */
public class Solver {
  public static void main(String args[]) throws Exception {
    final Board board = new Board();
    if (args.length == 0) {
      board.readInputFromStdin();
    } else {
      board.readInputFromFile(args[0]);
    }

    solve(board);
  }

  private static void solve(final Board board) {
    final EliminateStrategy[] eliminationStrategies = Strategies.getEliminationStrategies();
    final FixValueStrategy[] fixValueStrategies = Strategies.getFixValueStrategies();
    board.print();

    boolean changed = true;
    while (changed && !board.isSolved()) {
      boolean changedThisRound = false;
      for (EliminateStrategy eliminateStrategy : eliminationStrategies) {
        changedThisRound = eliminateStrategy.runStrategy(board) || changedThisRound;
      }

      for (FixValueStrategy fixValueStrategy : fixValueStrategies) {
        changedThisRound = fixValueStrategy.fixValue(board) || changedThisRound;
        board.print();
      }

      changed = changedThisRound;
    }

    if (board.isSolved()) {
      System.out.println("Solved board.");
      board.print();
    } else {
      System.out.println("Unsolved board.");
      board.print();
    }
  }
}
