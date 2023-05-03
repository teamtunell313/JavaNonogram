package com.nonogramsolver.Controllers;

import com.nonogramsolver.Models.Puzzle;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class controller {
  @GetMapping("/")
  public String index(){
    return "hello!";
  }
  
  @PostMapping("/")
  public String post(Puzzle puzzle){
    return "posted!";
  }
}
