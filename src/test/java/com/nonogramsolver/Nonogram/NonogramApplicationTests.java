package com.nonogramsolver.Nonogram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.nonogramsolver.Models.Line;
import com.nonogramsolver.Models.Opening;
import com.nonogramsolver.Services.LineSplitter;
import com.nonogramsolver.Services.OpeningSolver;

@SpringBootTest
class NonogramApplicationTests {

	@Mock
	OpeningSolver openingSolver;

	@InjectMocks
	LineSplitter lineSplitter;

	@Test
	public void correctlySplitsLinesToOpenings() {
		ArgumentCaptor<Opening> openingCaptor = ArgumentCaptor.forClass(Opening.class);
		int[] hints = {1,1};
		Boolean[] state = {null, false, true, null, false};
		Line problemLine = new Line(hints, state);
		lineSplitter.split(problemLine);
		verify(openingSolver, times(2)).solve(openingCaptor.capture());
		List<Opening> capturedOpenings = openingCaptor.getAllValues();
		Boolean[] stateOne = {null};
		assertEquals(capturedOpenings.get(0).startIndex, 0);
		assertEquals(capturedOpenings.get(0).endIndex, 0);
		assertEquals(capturedOpenings.get(0).isComplete, false);
		System.out.println(capturedOpenings.get(0).toString());
		// assertEquals(Arrays.equals(capturedOpenings.get(0).state, stateOne));
		Boolean[] stateTwo = {true, null};
		assertEquals(capturedOpenings.get(1).startIndex, 2);
		assertEquals(capturedOpenings.get(1).endIndex, 3);
		assertEquals(capturedOpenings.get(1).isComplete, false);
		System.out.println(capturedOpenings.get(1).toString());
		// assertEquals(Arrays.equals(capturedOpenings.get(1).state, stateTwo));
		// create a line
		// call lineSplitter.line(line)
	}

}
