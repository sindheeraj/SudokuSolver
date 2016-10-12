package net.dheeru.sudoku.solver.strategy;

import net.dheeru.sudoku.solver.strategy.eliminate.DuetsEliminate;
import net.dheeru.sudoku.solver.strategy.eliminate.EliminateStrategy;
import net.dheeru.sudoku.solver.strategy.eliminate.SameColumnEliminate;
import net.dheeru.sudoku.solver.strategy.eliminate.SameRowEliminate;
import net.dheeru.sudoku.solver.strategy.eliminate.SameSubBoardEliminate;
import net.dheeru.sudoku.solver.strategy.fixvalue.CellOnePossibilityFix;
import net.dheeru.sudoku.solver.strategy.fixvalue.FixValueStrategy;
import net.dheeru.sudoku.solver.strategy.fixvalue.OnlyPossibilityInColumnFix;
import net.dheeru.sudoku.solver.strategy.fixvalue.OnlyPossibilityInRowFix;
import net.dheeru.sudoku.solver.strategy.fixvalue.OnlyPossibilityInSubBoardFix;

/**
 * Strategies to eliminate choices.
 */
public class Strategies {
  private Strategies() {
  }

  public static EliminateStrategy[] getEliminationStrategies() {
    return new EliminateStrategy[] {
        new SameColumnEliminate(),
        new SameRowEliminate(),
        new SameSubBoardEliminate(),
        new DuetsEliminate(),
    };
  }

  public static FixValueStrategy[] getFixValueStrategies() {
    return new FixValueStrategy[] {
        new CellOnePossibilityFix(),
        new OnlyPossibilityInColumnFix(),
        new OnlyPossibilityInRowFix(),
        new OnlyPossibilityInSubBoardFix(),
    };
  }
}
