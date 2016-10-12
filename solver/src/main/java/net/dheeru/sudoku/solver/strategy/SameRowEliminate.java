package net.dheeru.sudoku.solver.strategy;

import net.dheeru.sudoku.solver.Board;
import net.dheeru.sudoku.solver.Cell;

/**
 * Remove elements from the same row.
 */
public class SameRowEliminate implements EliminateStrategy {
  @Override
  public boolean runStrategy(Board board) {
    final Cell[][] cells = board.getCells();
    boolean eliminateSomething = false;

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (cells[i][j].hasFixedValue()) {
          eliminateSomething = eliminate(cells, i, j) || eliminateSomething;
        }
      }
    }

    return eliminateSomething;
  }

  private boolean eliminate(Cell[][] cells, int x, int y) {
    boolean eliminateSomething = false;
    for (int j = 0; j < 9; j++) {
      if (j != y) {
        eliminateSomething = cells[x][j].removePossibility(cells[x][y].getValue()) || eliminateSomething;
      }
    }

    return eliminateSomething;
  }
}
