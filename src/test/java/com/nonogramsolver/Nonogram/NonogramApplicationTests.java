package com.nonogramsolver.Nonogram;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
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
	
	ArgumentCaptor<Opening> openingCaptor = ArgumentCaptor.forClass(Opening.class);

	Line oneOpeningLine = new Line(new int[] {2}, new Boolean[] {false, false, true, null, false});
	Opening[] oneExpectedOpening = {
		new Opening(null, new Boolean[]{true, null}, 2, 3)
	};
	Line twoOpeningLine = new Line(new int[] {1,1}, new Boolean[] {null, false, true, null, false});
	Opening[] twoExpectedOpenings = {
		new Opening(null, new Boolean[]{null}, 0, 0),
		new Opening(null, new Boolean[]{true, null}, 2, 3)
	};
	Line threeOpeningLine = new Line(new int[] {1}, new Boolean[] {null, false, true, false, null});
	Opening[] threeExpectedOpenings = {
		new Opening(null, new Boolean[]{null}, 0, 0),
		new Opening(null, new Boolean[]{true}, 2, 2),
		new Opening(null, new Boolean[]{null}, 4, 4)
	};

	@Test
	public void oneOpeningSplit() {
		lineSplitter.split(oneOpeningLine);
		List<Opening> capturedOpenings = openingCaptor.getAllValues();

		verify(openingSolver, times(1)).solve(openingCaptor.capture());
		assertEquals(oneExpectedOpening[0], capturedOpenings.get(0), oneExpectedOpening[0].toString() + capturedOpenings.get(0).toString());
	}

	@Test
	public void twoOpeningSplits() {
		lineSplitter.split(twoOpeningLine);
		List<Opening> capturedOpenings = openingCaptor.getAllValues();

		verify(openingSolver, times(2)).solve(openingCaptor.capture());
		assertEquals(twoExpectedOpenings[0], capturedOpenings.get(0));
		assertEquals(twoExpectedOpenings[1], capturedOpenings.get(1));
	}

	@Test
	public void threeOpeningSplits() {
		lineSplitter.split(threeOpeningLine);
		List<Opening> capturedOpenings = openingCaptor.getAllValues();

		verify(openingSolver, times(3)).solve(openingCaptor.capture());
		assertEquals(threeExpectedOpenings[0], capturedOpenings.get(0));
		assertEquals(threeExpectedOpenings[1], capturedOpenings.get(1));
		assertEquals(threeExpectedOpenings[2], capturedOpenings.get(2));
	}
}
