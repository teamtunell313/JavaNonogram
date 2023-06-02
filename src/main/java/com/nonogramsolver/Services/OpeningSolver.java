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
    if (opening.hints.length == 0) {
      Arrays.fill(opening.state, false);
      return opening;
    }

    int determined = IntStream.of(opening.hints).sum() + opening.hints.length - 1;
    int wiggle = opening.state.length - determined;

    // hints dictate all spaces
    if (wiggle == 0){
      int position = 0;
      for (int h = 0; h < opening.hints.length; h++){
        if(position > 0){
          opening.state[position] = false;
          position ++;
        }
        for (int i = 0; i < opening.hints[h]; i++){
          opening.state[position + i] = true;
        }
        position += opening.hints[h];
      }
    }
    
    // hints don't dictate every space
    if (wiggle > 0){
      int position = 0;
      for (int h = 0; h < opening.hints.length; h++){
        if (opening.hints[h] > wiggle){
          for (int i = wiggle; i < opening.hints[h]; i++){
            opening.state[position + i] = true;
          }
          position += opening.hints[h];
        } else {
          position += opening.hints[h];
        }
        position++;
      }
    }
    return opening;
  }
}
