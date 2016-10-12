package net.dheeru.sudoku.solver.strategy.fixvalue;

import net.dheeru.sudoku.solver.Board;
import net.dheeru.sudoku.solver.Cell;

/**
 * Fix the value if that value has only one possibility in a 3X3 sub board.
 */
public class OnlyPossibilityInSubBoardFix implements FixValueStrategy {
  @Override
  public boolean fixValue(Board board) {
    final Cell[][] cells = board.getCells();
    int starts[] = {0, 3, 6};

    boolean fixedAValue = false;
    for (int value = 1; value <= 9; value++) {
      for (int idxX = 0; idxX < 2; idxX++) {
        int numChoices = 0;
        boolean alreadyPresent = false;
        int lastI = -1;
        int lastJ = -1;

        for (int idxY= 0; idxY < 2; idxY++) {
          for (int i = starts[idxX]; i < starts[idxX] + 3; i++) {
            for (int j = starts[idxY]; j < starts[idxY] + 3; j++) {
              if (!cells[i][j].hasFixedValue()) {
                if (cells[i][j].valuePossible(value)) {
                  numChoices++;
                  lastI = i;
                  lastJ = j;
                }
              } else if (cells[i][j].getValue() == value) {
                alreadyPresent = true;
              }
            }
          }

          if (numChoices == 1 && !alreadyPresent) {
            cells[lastI][lastJ].fixValue(value);
            fixedAValue = true;
          }
        }
      }
    }

    return fixedAValue;
  }
}
