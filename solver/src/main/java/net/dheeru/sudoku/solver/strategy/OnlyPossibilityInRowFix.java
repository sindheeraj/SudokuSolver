package net.dheeru.sudoku.solver.strategy;

import net.dheeru.sudoku.solver.Board;
import net.dheeru.sudoku.solver.Cell;

/**
 * If there is only one cell in a row that can have a number.
 */
public class OnlyPossibilityInRowFix implements FixValueStrategy {
  @Override
  public boolean fixValue(Board board) {
    final Cell[][] cells = board.getCells();

    boolean fixedAValue = false;
    for (int value = 1; value <= 9; value++) {
      for (int i = 0; i < 9; i++) {
        int numChoices = 0;
        boolean alreadyPresent = false;
        int lastJ = -1;
        for (int j = 0; j < 9; j++) {
          if (!cells[i][j].hasFixedValue()) {
            if (cells[i][j].valuePossible(value)) {
              numChoices++;
              lastJ = j;
            }
          } else if (cells[i][j].getValue() == value) {
            alreadyPresent = true;
          }
        }

        if (numChoices == 1 && !alreadyPresent) {
          cells[i][lastJ].fixValue(value);
          fixedAValue = true;
        }
      }
    }

    return fixedAValue;
  }
}
