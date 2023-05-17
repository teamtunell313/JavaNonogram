package com.nonogramsolver.Services;

import com.nonogramsolver.Models.Line;
import org.springframework.stereotype.Service;

@Service
public class LineSplitter {
  public Line split(Line line){
    line.isComplete = true;
    System.out.println(line);
    return line;
  }
}
