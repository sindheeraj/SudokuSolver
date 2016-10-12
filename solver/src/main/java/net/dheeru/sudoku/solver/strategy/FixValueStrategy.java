package net.dheeru.sudoku.solver.strategy;

import net.dheeru.sudoku.solver.Board;

/**
 * Different strategies to fix value of a cell.
 */
public interface FixValueStrategy {
  // Return true if a value is actually fixed, else false.
  boolean fixValue(Board board);
}
