package net.dheeru.sudoku.solver;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents each cell in a sudoku.
 */
public class Cell {
  private final List<Integer> possibleChoices = new ArrayList<>();
  private int value = -1;

  private Cell() {
    for (int i = 1; i <= 9; i++) {
      possibleChoices.add(i);
    }
  }

  public static Cell newCell() {
    return new Cell();
  }

  public void fixValue(int val) {
    possibleChoices.clear();
    possibleChoices.add(value);
    value = val;
  }

  public boolean fixIfOnlyOnePossibleValue() {
    if (possibleChoices.size() == 1 && this.value == -1) {
      this.value = possibleChoices.get(0);
      return true;
    }
    return false;
  }

  public int getValue() {
    return this.value;
  }

  public boolean removePossibility(int value) {
    if (this.possibleChoices.size() == 1 && this.possibleChoices.get(0) == value) {
      throw new RuntimeException("Trying to remove only remaining possibility.");
    }
    return this.possibleChoices.remove((Integer) value);
  }

  public boolean valuePossible(Integer value) {
    return this.possibleChoices.contains(value);
  }

  public boolean hasFixedValue() {
    return this.value != -1;
  }

  public void print() {
    System.out.println(possibleChoices.toString() + " " + this.value);
  }

  @Override
  public String toString() {
    if (this.value != -1) {
      return this.value + "";
    }
    return possibleChoices.toString();
  }
}
