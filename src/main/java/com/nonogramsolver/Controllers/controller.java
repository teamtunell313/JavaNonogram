package com.nonogramsolver.Controllers;

import com.nonogramsolver.Models.Puzzle;
import com.nonogramsolver.Models.Solution;
import com.nonogramsolver.Services.LineCycler;

import java.util.Arrays;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class controller {
  
  @Autowired
  LineCycler lineCycler;

  @GetMapping()
  public String index(){
    return "hello!";
  }
  
  @PostMapping(consumes="application/json")
  public Solution post(@RequestBody Puzzle puzzle){
    System.out.println(puzzle);
    return lineCycler.solve(puzzle);
  }
}
