package com.nonogramsolver.Models;
import java.util.Arrays;

public class Solution {
  public Boolean[][] solution;
  
  public Solution(int columns, int rows){
    this.solution = new Boolean[rows][columns];
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
