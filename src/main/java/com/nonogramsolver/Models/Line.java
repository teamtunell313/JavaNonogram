package com.nonogramsolver.Models;
import java.util.Arrays;

public class Line {
  public int[] hints;
  public Boolean[] state;
  public boolean isComplete = true;

  public Line(int[] hints, Boolean[] state){
    this.hints = hints;
    this.state = state;
    for (Boolean value : state){
      if (value == null){
        isComplete = false;
      }
    }
  }

  @Override
  public String toString(){
    return String.format("Hints: %-9s  State: %-31s  Complete: %b", Arrays.toString(hints), Arrays.toString(state), isComplete);
  }
}
