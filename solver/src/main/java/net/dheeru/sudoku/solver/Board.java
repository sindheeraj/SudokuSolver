package net.dheeru.sudoku.solver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

  public void readInputFromFile(String file) throws FileNotFoundException {
    final Scanner in = new Scanner(new FileInputStream(file));
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
        System.out.print(format(cell.toString()));
      }
      System.out.println();
    }
    System.out.println();
  }

  private String format(String s) {
    String str = s;
    for (int i = s.length(); i < 20; i++) {
      str = str + " ";
    }

    return str;
  }
}
