package com.nonogramsolver.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    // hints fully define
    if (determined == opening.state.length){
      // List<Boolean> solution = new ArrayList<Boolean>();
      int position = 0;
      while (position < opening.state.length){
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
    }
    
    return opening;
  }
}
