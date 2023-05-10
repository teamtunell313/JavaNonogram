package com.nonogramsolver.Controllers;

import com.nonogramsolver.Models.Puzzle;
import java.util.Arrays;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class controller {
  @GetMapping()
  public String index(){
    return "hello!";
  }
  
  @PostMapping(consumes="application/json")
  public Puzzle post(@RequestBody Puzzle puzzle){
    System.out.println(puzzle);
    return puzzle;
  }
}
