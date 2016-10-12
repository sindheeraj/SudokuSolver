package net.dheeru.sudoku.solver.strategy;

import net.dheeru.sudoku.solver.Board;
import net.dheeru.sudoku.solver.Cell;

/**
 * Same column eliminate.
 */
public class SameColumnEliminate implements EliminateStrategy {
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
    boolean eliminateSth = false;
    for (int i = 0; i < 9; i++) {
      if (i != x) {
        eliminateSth = cells[i][y].removePossibility(cells[x][y].getValue()) || eliminateSth;
      }
    }

    return eliminateSth;
  }
}
