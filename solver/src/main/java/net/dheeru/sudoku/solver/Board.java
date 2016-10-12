package net.dheeru.sudoku.solver;

import java.util.Scanner;

/**
 * Represents the sudoku board.
 */
public class Board {
  private final Cell[][] cells = new Cell[9][9];

  public Board() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        cells[i][j] = Cell.newCell();
      }
    }
  }

  public void readInputFromStdin() {
    final Scanner in = new Scanner(System.in);
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int next = in.nextInt();
        if (next != -1) {
          cells[i][j].fixValue(next);
        }
      }
    }
  }

  public Cell[][] getCells() {
    return this.cells;
  }

  public boolean isSolved() {
    for (Cell[] rowCells : this.cells) {
      for (Cell cell : rowCells) {
        if (!cell.hasFixedValue()) {
          return false;
        }
      }
    }

    return true;
  }

  public void print() {
    for (Cell[] rowCells : this.cells) {
      for (Cell cell : rowCells) {
        System.out.print(cell.getValue() + " ");
      }
      System.out.println();
    }

  }
}
