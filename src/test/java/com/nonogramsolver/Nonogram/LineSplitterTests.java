package com.nonogramsolver.Nonogram;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.argThat;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.nonogramsolver.Models.Line;
import com.nonogramsolver.Models.Opening;
import com.nonogramsolver.Services.LineSplitter;
import com.nonogramsolver.Services.OpeningSolver;

@SpringBootTest
class LineSplitterTests {

	@Mock
	OpeningSolver openingSolver;

	@InjectMocks
	LineSplitter lineSplitter;
	
	@Captor
	ArgumentCaptor<Opening> openingCaptor = ArgumentCaptor.forClass(Opening.class);

	Line oneOpeningLine = new Line(List.of(2), new Boolean[] {false, false, true, null, false});
	Opening oneExpectedOpening = new Opening(List.of(2), new Boolean[]{true, null}, 2, 3);

	Line twoOpeningLine = new Line(List.of(1, 1), new Boolean[] {null, false, true, null, false});
	Opening[] twoExpectedOpenings = {
		new Opening(List.of(1), new Boolean[]{null}, 0, 0),
		new Opening(List.of(1), new Boolean[]{true, null}, 2, 3)
	};

	Line threeOpeningLine = new Line(List.of(1), new Boolean[] {null, false, true, false, null});
	Opening[] threeExpectedOpenings = {
		new Opening(List.of(0), new Boolean[]{null}, 0, 0),
		new Opening(List.of(1), new Boolean[]{true}, 2, 2),
		new Opening(List.of(0), new Boolean[]{null}, 4, 4)
	};

	@Test
	public void oneOpeningSplit() {
		lineSplitter.split(oneOpeningLine);
		verify(openingSolver, times(1)).solve(openingCaptor.capture());
		assertEquals(oneExpectedOpening.hints, openingCaptor.getValue().hints);
		assertEquals(oneExpectedOpening.state, openingCaptor.getValue().state);
	}

	@Test
	public void twoOpeningSplits() {
		lineSplitter.split(twoOpeningLine);
		verify(openingSolver, times(2)).solve(openingCaptor.capture());
	
		List<Opening> capturedOpenings = openingCaptor.getAllValues();
		assertNull(capturedOpenings.get(0).hints);
		assertNull(capturedOpenings.get(1).hints);
		assertEquals(twoExpectedOpenings[0].state, capturedOpenings.get(0).state);
		assertEquals(twoExpectedOpenings[1].state, capturedOpenings.get(1).state);
	}

	@Test
	public void threeOpeningSplits() {
		lineSplitter.split(threeOpeningLine);
		verify(openingSolver, times(3)).solve(openingCaptor.capture());
		
		List<Opening> capturedOpenings = openingCaptor.getAllValues();
		assertNull(capturedOpenings.get(0).hints);
		assertEquals(threeExpectedOpenings[0].state, capturedOpenings.get(0).state);
		assertEquals(threeExpectedOpenings[1].state, capturedOpenings.get(1).state);
		assertEquals(threeExpectedOpenings[2].state, capturedOpenings.get(2).state);
	}
}
