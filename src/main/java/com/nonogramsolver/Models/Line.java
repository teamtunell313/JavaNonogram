package com.nonogramsolver.Models;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Line {
  public List<Integer> hints;
  public Boolean[] state;
  public boolean isComplete = true;

  public Line(int[] hints, Boolean[] state){
    this.hints = Arrays.stream(hints).mapToObj(Integer::valueOf).collect(Collectors.toList());
    this.state = state;
    for (Boolean value : state){
      if (value == null){
        isComplete = false;
      }
    }
  }

  public List<Opening> splitOpenings(){
    List<Opening> openings = new ArrayList<Opening>();
    int startIndex = -1;
    for (int i = 0; i < state.length; i++){
      if (Boolean.FALSE.equals(state[i]) && startIndex >= 0) {
        // create an opening
        Boolean[] openingValues = new Boolean[i-startIndex];
        for (int j = 0; j < i - startIndex; j++){
          openingValues[j] = state[startIndex + j];
        }
        openings.add(new Opening(null, openingValues, startIndex, i-1));
        startIndex = -1;
      } 
      if (!Boolean.FALSE.equals(state[i]) && startIndex < 0) {
        startIndex = i;
      }
    }
    if (startIndex >= 0){
      Boolean[] openingValues = new Boolean[state.length-startIndex];
      for (int j = 0; j < state.length - startIndex; j++){
        openingValues[j] = state[startIndex + j];
      }
      openings.add(new Opening(null, openingValues, startIndex, state.length-1));
    }
    return openings;
  }


  public void combineOpenings(Opening[] openings){
    isComplete = true;
    for (Opening opening : openings){
      for (int i = 0; i < opening.state.length; i++){
        state[i + opening.startIndex] = opening.state[i];
      }
      if (!opening.isComplete){
        isComplete = false;
      }
    }

  }


  @Override
  public String toString(){
    return String.format("Hints: %-9s  State: %-31s  Complete: %b", Arrays.toString(hints.toArray()), Arrays.toString(state), isComplete);
  }
}
