package net.dheeru.sudoku.solver.strategy;

import net.dheeru.sudoku.solver.Board;

/**
 * Interface for implementing any net.dheeru.sudoku.solver.strategy to eliminate choices.
 */
public interface EliminateStrategy {
  public void runStrategy(Board board);
}
