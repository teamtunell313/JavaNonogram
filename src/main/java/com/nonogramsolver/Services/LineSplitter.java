package com.nonogramsolver.Services;

import com.nonogramsolver.Models.Line;
import com.nonogramsolver.Models.Opening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineSplitter {

  @Autowired
  OpeningSolver openingSolver;

  public Line split(Line line){
    Opening[] openings = line.splitOpenings();
    
    // Assign hints to lines.
    
    // Solve each opening
    for (Opening opening : openings) {
      opening = openingSolver.solve(opening);
    }
    line.combineOpenings(openings);
    line.isComplete = true;
    return line;
  }
}
