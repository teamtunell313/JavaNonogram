package com.nonogramsolver.Nonogram;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.nonogramsolver.Models.Opening;
import com.nonogramsolver.Services.OpeningSolver;

@SpringBootTest
public class FreshOpeningSolverTests {
  
  @InjectMocks 
  OpeningSolver openingSolver;

	Opening given = new Opening(new int[] {}, new Boolean[] {null, null, null, null, null}, 0, 4);
	Opening expected = new Opening(new int[] {}, new Boolean[] {null, null, null, null, null}, 0, 4);


  // No wiggle null state
  @Test
	public void nullState_0Wiggle() {
		List<Map<String, Object>> tests = new ArrayList<Map<String, Object>>(Arrays.asList(
			Map.of(	"hint", new int[] {},				"state", new Boolean[] {false, false, false, false, false}),
			Map.of(	"hint", new int[] {5},				"state", new Boolean[] {true, true, true, true, true}), 
			Map.of(	"hint", new int[] {3, 1},		"state", new Boolean[] {true, true, true, false, true}),
			Map.of(	"hint", new int[] {1, 3},		"state", new Boolean[] {true, false, true, true, true}),
			Map.of(	"hint", new int[] {2, 2},		"state", new Boolean[] {true, true, false, true, true}),
			Map.of(	"hint", new int[] {1, 1, 1},	"state", new Boolean[] {true, false, true, false, true})
		));
		for (Map<String, Object> test : tests){
			Opening newOpening = new Opening((int[]) test.get("hint"), new Boolean[] {null, null, null, null, null}, 0, 4);
			Opening actual = openingSolver.solve(newOpening);
			assertArrayEquals((Boolean[]) test.get("state"), actual.state);
		}
	}
	
  // null state 1 Wiggle
  @Test
	public void nullState_1Wiggle() {
		List<Map<String, Object>> tests = new ArrayList<Map<String, Object>>(Arrays.asList(
			Map.of(	"hint", new int[] {4},				"state", new Boolean[] {null, true, true, true, null}),
			Map.of(	"hint", new int[] {2, 1},		"state", new Boolean[] {null, true, null, null, null}), 
			Map.of(	"hint", new int[] {1, 2},		"state", new Boolean[] {null, null, null, true, null})
		));
		for (Map<String, Object> test : tests){
			Opening newOpening = new Opening((int[]) test.get("hint"), new Boolean[] {null, null, null, null, null}, 0, 4);
			Opening actual = openingSolver.solve(newOpening);
			assertArrayEquals((Boolean[]) test.get("state"), actual.state, test.get("hint").toString());
		}
	}
	

  // null state 2 Wiggle
  @Test
	public void nullState_2Wiggle_3Hint() {
		given.hints = new int[] {3};		
		Opening expected = new Opening(new int[] {}, new Boolean[] {null, null, true, null, null}, 0, 4);
    Opening actual = openingSolver.solve(given);
		assertArrayEquals(actual.state, expected.state, actual.state.toString());
	}
  @Test
	public void nullState_2Wiggle_2Hint() {
		given.hints = new int[] {1, 1};		
		Opening expected = new Opening(new int[] {}, new Boolean[] {null, null, null, null, null}, 0, 4);
    Opening actual = openingSolver.solve(given);
		assertArrayEquals(actual.state, expected.state, actual.state.toString());
	}
	
  // null state 3 Wiggle
  @Test
	public void nullState_3Wiggle_2Hint() {
		given.hints = new int[] {2};		
		Opening expected = new Opening(new int[] {}, new Boolean[] {null, null, null, null, null}, 0, 4);
    Opening actual = openingSolver.solve(given);
		assertArrayEquals(actual.state, expected.state, actual.state.toString());
	}
  // null state 4 Wiggle
  @Test
	public void nullState_4Wiggle_1Hint() {
		given.hints = new int[] {1};		
		Opening expected = new Opening(new int[] {}, new Boolean[] {null, null, null, null, null}, 0, 4);
    Opening actual = openingSolver.solve(given);
		assertArrayEquals(actual.state, expected.state, actual.state.toString());
	}

  // 1 state 1 wiggle
  // 1 state 2 wiggle
  // 1 state 3 wiggle
  // 1 state 4 wiggle

}
