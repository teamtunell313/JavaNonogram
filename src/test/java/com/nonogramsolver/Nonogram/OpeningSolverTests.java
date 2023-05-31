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

  @Test
	public void nullStateNoHint() {
		Opening newNoWiggle = new Opening(new int[] {}, new Boolean[] {null, null, null, null, null}, 0, 4);
		Opening expected = new Opening(new int[] {}, new Boolean[] {false, false, false, false, false}, 0, 4);
    Opening solved = openingSolver.solve(newNoWiggle);
		assertArrayEquals(solved.state, expected.state, solved.state.toString());
	}

  @Test
	public void nullStateFiveHint() {
		Opening newNoWiggle = new Opening(new int[] {5}, new Boolean[] {null, null, null, null, null}, 0, 4);
		Opening expected = new Opening(new int[] {5}, new Boolean[] {true, true, true, true, true}, 0, 4);
    Opening solved = openingSolver.solve(newNoWiggle);
		assertArrayEquals(solved.state, expected.state, solved.state.toString());
	}

  @Test
	public void nullStateFourHint() {
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
	public void nullStateThreeHint() {
		Opening newNoWiggle = new Opening(new int[] {1, 1, 1}, new Boolean[] {null, null, null, null, null}, 0, 4);
		Opening expected = new Opening(new int[] {}, new Boolean[] {true, false, true, false, true}, 0, 4);
    Opening solved = openingSolver.solve(newNoWiggle);
		assertArrayEquals(solved.state, expected.state, solved.state.toString());
	}
}
