package net.dheeru.sudoku.solver.strategy;

/**
 * Strategies to eliminate choices.
 */
public class Strategies {
  private Strategies() {
  }

  public EliminateStrategy[] getEliminationStrategies() {
    return new EliminateStrategy[] {
        new SameColumnEliminate(),
        new SameRowEliminate(),
        new SameSubBoardEliminate()
    };
  }

  public FixValueStrategy[] getFixValueStrategies() {
    return new FixValueStrategy[] {
        new CellOnePossibilityFix(),
        new OnlyPossibilityInColumnFix(),
        new OnlyPossibilityInRowFix()
    };
  }
}
