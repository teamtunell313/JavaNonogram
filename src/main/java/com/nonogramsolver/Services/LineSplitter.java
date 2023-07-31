package com.nonogramsolver.Services;

import com.nonogramsolver.Models.Line;
import com.nonogramsolver.Models.Opening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineSplitter {

  @Autowired
  OpeningSolver openingSolver;

  public Line split(Line line){
    List<Opening> openings = line.splitOpenings();
    
    // Assign hints to lines.
    // openings = 1
    if (openings.size() == 1){
      openings.get(0).hints = line.hints;
    } else {
      // assigned hints depend on size of openings and dots in the openings.
      // calculate wiggle
            
      Iterator<Opening> itr = openings.iterator();
      int hintStartIndex = 0;
      while (itr.hasNext()){
        Opening opening = itr.next();
        if (opening.isComplete) {
          // this opening is full of dots matching a hint, so remove hint and skip opening.
          line.hints.remove(0);
          itr.remove();
        } else {
          // collect possible hint sets from startIndex
          int hintSum = 0;
          Stack<Integer> currentHintSet = new Stack<>();
          for (int i = hintStartIndex; i < line.hints.size(); i++){
            hintSum += line.hints.get(i) + i;
            currentHintSet.push(line.hints.get(i));
            if (hintSum >= opening.state.length){
              opening.possibleHintSets.push(currentHintSet);
            } else {
              // update the hintStartIndex
            }
          }
        }

      }
    }

    // Solve each opening
    for (Opening opening : openings) {
      if (!opening.isComplete){
        opening = openingSolver.solve(opening);
      }
    }
    line.combineOpenings(openings.toArray(new Opening[0]));
    line.isComplete = true;
    return line;
  }
}
