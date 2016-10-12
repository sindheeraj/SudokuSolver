package net.dheeru.sudoku.solver.strategy;

import net.dheeru.sudoku.solver.Board;
import net.dheeru.sudoku.solver.Cell;

/**
 * Same column eliminate.
 */
public class SameColumnEliminate implements EliminateStrategy {
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
    for (int i = 0; i < 9; i++) {
      if (i != x) {
        cells[i][y].removePossibility(cells[x][y].getValue());
      }
    }
  }
}
