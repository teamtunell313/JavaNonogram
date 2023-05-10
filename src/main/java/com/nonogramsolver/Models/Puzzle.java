package com.nonogramsolver.Models;
import java.util.Arrays;

public class Puzzle {
  public int[][] columns;
  public int[][] rows;

  public Puzzle(int[][] columns, int[][] rows){
    this.columns = columns;
    this.rows = rows;
  }

  @Override
  public String toString() {
    return "columns: " + Arrays.deepToString(columns) + "\nrows:    " + Arrays.deepToString(rows);
  }
}
