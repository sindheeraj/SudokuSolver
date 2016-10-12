package net.dheeru.sudoku.solver.strategy.eliminate;

import net.dheeru.sudoku.solver.Board;

/**
 * Interface for implementing any net.dheeru.sudoku.solver.strategy to eliminate choices.
 */
public interface EliminateStrategy {
  boolean runStrategy(Board board);
}
