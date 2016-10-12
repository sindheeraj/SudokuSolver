package net.dheeru.sudoku.solver.strategy.eliminate;

import net.dheeru.sudoku.solver.Board;
import net.dheeru.sudoku.solver.Cell;

/**
 * If two cells have the same possible values, then all other cells in the same row/col can't have those possible
 * values.
 */
public class DuetsEliminate implements EliminateStrategy {
  @Override
  public boolean runStrategy(Board board) {
    final Cell[][] cells = board.getCells();
    boolean eliminated = false;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        eliminated = checkWithOtherCells(cells, i, j) || eliminated;
      }
    }
    return eliminated;
  }

  private boolean checkWithOtherCells(Cell[][] cells, int x, int y) {
    boolean eliminated = false;
    // Find duets in the same column
    for (int i = 0; i < 9; i++) {
      if (i != x && cells[x][y].isDuetWith(cells[i][y])) {
        eliminated = removeRowDuetValues(i, x, y, cells) || eliminated;
      }
    }

    // Find duets in the same row
    for (int j = 0; j < 9; j++) {
      if (j != y && cells[x][y].isDuetWith(cells[x][j])) {
        eliminated = removeColDuetValues(x, y, j, cells) || eliminated;
        break;
      }
    }

    // Find duets in the same sub board
    final int startX = (x / 3) * 3;
    final int startY = (y / 3) * 3;
    for (int i = startX; i < startX + 3; i++) {
      for (int j = startY; j < startY + 3; j++) {
        if (i != x || j != y) {
          if (cells[x][y].isDuetWith(cells[i][j])) {
            eliminated = removeSameSubBoardDuetValues(x, y, i, j, cells);
          }
        }
      }
    }

    return eliminated;
  }

  private boolean removeSameSubBoardDuetValues(int x1, int y1, int x2, int y2, Cell[][] cells) {
    boolean eliminated = false;
    final int startX = (x1 / 3) * 3;
    final int startY = (y1 / 3) * 3;
    for (int i = startX; i < startX + 3; i++) {
      for (int j = startY; j < startY + 3; j++) {
        if (!((i == x1 && j == y1) || (i == x2 && j == y2))) {
          eliminated = cells[i][j].removePossibility(cells[x1][y1]) || eliminated;
        }
      }
    }

    return eliminated;
  }

  private boolean removeColDuetValues(int x, int y1, int y2, Cell[][] cells) {
    boolean eliminated = false;
    for (int j = 0; j < 9; j++) {
      if (j != y1 && j != y2) {
        eliminated = cells[x][j].removePossibility(cells[x][y1]) || eliminated;
      }
    }

    return eliminated;
  }

  private boolean removeRowDuetValues(int x1, int x2, int y, Cell[][] cells) {
    boolean eliminated = false;
    for (int i = 0; i < 9; i++) {
      if (i != x1 && i != x2) {
        eliminated = cells[i][y].removePossibility(cells[x1][y]) || eliminated;
      }
    }

    return eliminated;
  }
}
