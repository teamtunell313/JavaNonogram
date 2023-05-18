package com.nonogramsolver.Models;
import java.util.Arrays;

public class Opening {
  public int[] hints;
  public Boolean[] state;
  public int startIndex;
  public int endIndex;
  public Boolean isComplete = true;
  
  public Opening(int[] hints, Boolean[] state, int startIndex, int endIndex){
    this.hints = hints;
    this.state = state;
    this.startIndex = startIndex;
    this.endIndex = endIndex;
    for (int i = 0; i < state.length; i++){
      if (state[i] == null){
        this.isComplete = false;
      }
    }
  }
  
  @Override
  public String toString(){
    return String.format("Hint: %2s  State: %-31s", Arrays.toString(hints), Arrays.toString(state));
  }
  
}


