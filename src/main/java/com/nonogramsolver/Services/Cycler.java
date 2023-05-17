package com.nonogramsolver.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nonogramsolver.Models.Line;
import com.nonogramsolver.Models.Puzzle;
import com.nonogramsolver.Models.Solution;

@Service
public class Cycler {

  @Autowired
  LineSplitter lineSplitter;

  public Solution solve(Puzzle puzzle){
    Solution solution = new Solution(puzzle.columns.length, puzzle.rows.length);
    boolean solved = false;

    while (!solved) {
      solved = true;

      // Loop through columns
      for (int c = 0; c < solution.columns; c++){
        Line column = new Line(puzzle.columns[c], solution.getColumn(c));
        Line solvedColumn = lineSplitter.split(column);
        solution.setColumn(c, solvedColumn.state);
        if (!solvedColumn.isComplete) {
          solved = false;
        }
      }
      // Loop thorugh rows
      for (int r = 0; r < solution.rows; r++){
        Line row = new Line(puzzle.rows[r], solution.getRow(r));
        Line solvedRow = lineSplitter.split(row);
        solution.setRow(r, solvedRow.state);        
        if (!solvedRow.isComplete) {
          solved = false;
        }
      }
    }

    return solution;
  }
}
