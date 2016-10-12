package net.dheeru.sudoku.solver.strategy;

import net.dheeru.sudoku.solver.Board;
import net.dheeru.sudoku.solver.Cell;

/**
 * Remove elements from the same row.
 */
public class SameRowEliminate implements EliminateStrategy {
  @Override
  public void runStrategy(Board board) {
    final Cell[][] cells = board.getCells();

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (cells[i][j].hasFixedValue()) {
          eliminate(cells, i, j);
        }
      }
    }
  }

  private void eliminate(Cell[][] cells, int x, int y) {
    for (int j = 0; j < 9; j++) {
      if (j != y) {
        cells[x][j].removePossibility(cells[x][y].getValue());
      }
    }
  }
}
