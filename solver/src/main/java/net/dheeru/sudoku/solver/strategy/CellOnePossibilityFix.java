package net.dheeru.sudoku.solver.strategy;

import net.dheeru.sudoku.solver.Board;
import net.dheeru.sudoku.solver.Cell;

/**
 * Fix value if there is only one possibility in a cell.
 */
public class CellOnePossibilityFix implements FixValueStrategy {
  @Override
  public boolean fixValue(Board board) {
    final Cell[][] cells = board.getCells();
    boolean fixedAValue = false;

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        fixedAValue = cells[i][j].fixIfOnlyOnePossibleValue() || fixedAValue;
      }
    }

    return fixedAValue;
  }
}
