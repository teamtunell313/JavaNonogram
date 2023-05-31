package com.nonogramsolver.Nonogram;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.nonogramsolver.Models.Opening;
import com.nonogramsolver.Services.OpeningSolver;

@SpringBootTest
public class OpeningSolverTests {
  
  @InjectMocks 
  OpeningSolver openingSolver;


  // No wiggle null state tests

  @Test
	public void nullState_0Wiggle_0Hint() {
		Opening newNoWiggle = new Opening(new int[] {}, new Boolean[] {null, null, null, null, null}, 0, 4);
		Opening expected = new Opening(new int[] {}, new Boolean[] {false, false, false, false, false}, 0, 4);
    Opening solved = openingSolver.solve(newNoWiggle);
		assertArrayEquals(solved.state, expected.state, solved.state.toString());
	}

  @Test
	public void nullState_0Wiggle_5Hint() {
		Opening newNoWiggle = new Opening(new int[] {5}, new Boolean[] {null, null, null, null, null}, 0, 4);
		Opening expected = new Opening(new int[] {5}, new Boolean[] {true, true, true, true, true}, 0, 4);
    Opening solved = openingSolver.solve(newNoWiggle);
		assertArrayEquals(solved.state, expected.state, solved.state.toString());
	}

  @Test
	public void nullState_0Wiggle_4Hint() {
		Opening newNoWiggle = new Opening(new int[] {3, 1}, new Boolean[] {null, null, null, null, null}, 0, 4);
		Opening expected = new Opening(new int[] {}, new Boolean[] {true, true, true, false, true}, 0, 4);
    Opening solved = openingSolver.solve(newNoWiggle);
		assertArrayEquals(solved.state, expected.state, solved.state.toString());

		newNoWiggle = new Opening(new int[] {1, 3}, new Boolean[] {null, null, null, null, null}, 0, 4);
		expected = new Opening(new int[] {}, new Boolean[] {true, false, true, true, true}, 0, 4);
    solved = openingSolver.solve(newNoWiggle);
		assertArrayEquals(solved.state, expected.state, solved.state.toString());

		newNoWiggle = new Opening(new int[] {2, 2}, new Boolean[] {null, null, null, null, null}, 0, 4);
		expected = new Opening(new int[] {}, new Boolean[] {true, true, false, true, true}, 0, 4);
    solved = openingSolver.solve(newNoWiggle);
		assertArrayEquals(solved.state, expected.state, solved.state.toString());
	}

  @Test
	public void nullState_0Wiggle_3Hint() {
		Opening newNoWiggle = new Opening(new int[] {1, 1, 1}, new Boolean[] {null, null, null, null, null}, 0, 4);
		Opening expected = new Opening(new int[] {}, new Boolean[] {true, false, true, false, true}, 0, 4);
    Opening solved = openingSolver.solve(newNoWiggle);
		assertArrayEquals(solved.state, expected.state, solved.state.toString());
	}

  // null state 1 Wiggle
  // null state 2 Wiggle
  // null state 3 Wiggle
  // null state 4 Wiggle

  // 1 state 1 wiggle
  // 1 state 2 wiggle
  // 1 state 3 wiggle
  // 1 state 4 wiggle

}
