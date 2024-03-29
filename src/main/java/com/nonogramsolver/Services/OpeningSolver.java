package com.nonogramsolver.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.nonogramsolver.Models.Opening;

@Service
public class OpeningSolver {
  public Opening solve (Opening opening){
    System.out.println(opening);
    
    // no hints, fill with false
    if (opening.hints.size() == 0) {
      Arrays.fill(opening.state, false);
      return opening;
    }
    
    int determined = opening.hints.stream().reduce(0, Integer::sum) + opening.hints.size() - 1;
    int wiggle = opening.state.length - determined;
    
    // hints dictate all spaces
    if (wiggle == 0){
      int position = 0;
      for (int h = 0; h < opening.hints.size(); h++){
        if(position > 0){
          opening.state[position] = false;
          position ++;
        }
        for (int i = 0; i < opening.hints.get(h); i++){
          opening.state[position + i] = true;
        }
        position += opening.hints.get(h);
      }
    }

    // hints don't dictate every space
    else {
      // opening is clean
      if (opening.dotProfile.size() == 0){
        int position = 0;
        for (int h = 0; h < opening.hints.size(); h++){
          if (opening.hints.get(h) > wiggle){
            for (int i = wiggle; i < opening.hints.get(h); i++){
              opening.state[position + i] = true;
            }
          }
          position += opening.hints.get(h);
          position++;
        }
      }
      // the opening has dots
      else {
        calculateHintCoverage(opening, wiggle);

      }
      
    }
    
    return opening;
  }

  private void calculateHintCoverage(Opening opening, int wiggle){
    // just one hint
    if (opening.hints.size() == 1){
      // add up the total dot span, and compare to hint size.
      if (opening.dotProfile.size() == 1){
        Integer firstDot = opening.dotProfile.get(0).get(0);
        Integer lastDot = firstDot + opening.dotProfile.get(0).get(1) - 1;
      } else {
        List<Integer> lastSeries = opening.dotProfile.get(opening.dotProfile.size() - 1);

      }
      // fill in internal dots.
      // fill in more dots if wiggle allows
      // fill in xs if wiggle dictates. 
    }
    else {

    }
  }
}
