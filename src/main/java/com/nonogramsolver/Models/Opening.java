package com.nonogramsolver.Models;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Opening {
  public int[] hints;
  public Boolean[] state;
  public int startIndex;
  public int endIndex;
  public Boolean isComplete = true;
  public List<List<Integer>> dotProfile = new ArrayList<>(new ArrayList<>());
  
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
    calculateDotProfile();

  }
  
  /**
   * Calculates the set of arrays that profile where series of dots start, and how long they are.
   * e.g. (3, 5) indicates that at index 3 there's a series of 5 dots.
   * @return
   */
  public void calculateDotProfile(){
    Integer seriesLength = 0;
    Integer startIndex = -1;
    for (int i = 0; i < this.state.length; i++){
      if (this.state[i] == null || this.state[i] == false){
        if (seriesLength > 0){
          this.dotProfile.add(new ArrayList<>(List.of(startIndex, seriesLength)));
          startIndex = -1;
          seriesLength = 0;
        }
      } else {
        if (startIndex == -1){
          startIndex = i;
        }
        seriesLength++;
      }
    }
    if (seriesLength > 0){
      dotProfile.add(new ArrayList<>(List.of(startIndex, seriesLength)));
    }
  }


  @Override
  public String toString(){
    return String.format("Hint: %2s  State: %-31s", Arrays.toString(hints), Arrays.toString(state));
  }
}


