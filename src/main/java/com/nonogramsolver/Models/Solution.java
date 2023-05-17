package com.nonogramsolver.Models;
import java.util.Arrays;

public class Solution {
  public Boolean[][] solution;
  public int columns;
  public int rows;
  
  public Solution(int columns, int rows){
    this.solution = new Boolean[rows][columns];
    this.columns = columns;
    this.rows = rows;
  }

  public Boolean[] getColumn(int index){
    Boolean[] column = new Boolean[columns];
    for (int r = 0; r < rows; r++){
      column[r] = solution[r][index];
    }
    return column;
  }

  public void setColumn(int index, Boolean[] values){
    for (int r = 0; r < rows; r++){
      solution[r][index] = values[r];
    }
  }
  
  public Boolean[] getRow(int index){
    return solution[index];
  }
  
  public void setRow(int index, Boolean[] values){
    solution[index] = values;
  }

  @Override
  public String toString() {
    String output = "";
    for (int r = 0; r < this.solution.length; r++){
      output = output + Arrays.toString(this.solution[r]) + "\n";
    }
    return output;
  }
}
