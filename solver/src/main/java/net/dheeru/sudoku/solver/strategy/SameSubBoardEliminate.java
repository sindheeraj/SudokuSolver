package net.dheeru.sudoku.solver.strategy;

import net.dheeru.sudoku.solver.Board;
import net.dheeru.sudoku.solver.Cell;

/**
 * Eliminate things in the same 3X3 sub board.
 */
public class SameSubBoardEliminate implements EliminateStrategy {
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
    final int startX = (x / 3) * 3;
    final int endX = startX + 3;
    final int startY = (y / 3) * 3;
    final int endY = startY + 3;
    for (int i = startX; i < endX; i++) {
      for (int j = startY; j < endY; j++) {
        if (i != x || j != y) {
          cells[i][j].removePossibility(cells[x][y].getValue());
        }
      }
    }
  }
}
