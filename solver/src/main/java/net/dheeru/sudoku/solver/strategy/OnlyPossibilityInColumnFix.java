package net.dheeru.sudoku.solver.strategy;

import net.dheeru.sudoku.solver.Board;
import net.dheeru.sudoku.solver.Cell;

/**
 * If only one cell can have a value in a column.
 */
public class OnlyPossibilityInColumnFix implements FixValueStrategy {
  @Override
  public boolean fixValue(Board board) {
    final Cell[][] cells = board.getCells();

    boolean fixedAValue = false;
    for (int value = 1; value <= 9; value++) {
      for (int j = 0; j < 9; j++) {
        int numChoices = 0;
        int lastI = -1;
        for (int i = 0; i < 9; i++) {
          if (!cells[i][j].hasFixedValue()) {
            if (cells[i][j].valuePossible(value)) {
              numChoices++;
              lastI = i;
            }
          }
        }

        if (numChoices == 1) {
          cells[lastI][j].fixValue(value);
          fixedAValue = true;
        }
      }
    }

    return fixedAValue;
  }
}
