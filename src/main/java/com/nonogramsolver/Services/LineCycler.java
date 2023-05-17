package com.nonogramsolver.Services;

import org.springframework.stereotype.Service;
import com.nonogramsolver.Models.Puzzle;
import com.nonogramsolver.Models.Solution;

@Service
public class LineCycler {
  public Solution solve(Puzzle puzzle){
    Solution solution = new Solution(puzzle.columns.length, puzzle.rows.length);
    return solution;
  }
}
