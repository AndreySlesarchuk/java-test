package by.atmm.__tests.app.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalMatchers.or;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.endsWith;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import by.atmm.java.__tests.app.rest.FlowerController;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.exceptions.misusing.InvalidUseOfMatchersException;
import org.mockito.junit.MockitoJUnitRunner;

import by.atmm.java.__tests.app.api.Flower;
import by.atmm.java.__tests.domain.service.FlowerService;

@RunWith(MockitoJUnitRunner.class)
public class FlowerControllerUnitTest {

	@InjectMocks
	private FlowerController flowerController;

	@Mock
	private FlowerService flowerService;

	@Test
	public void givenPoppyFlower_whenUsingDoReturn_thenCorrect() {
		Mockito.doReturn("Flower").when(flowerService).analyze("poppy");

		String response = flowerController.isAFlower("poppy");
		Assertions.assertThat(response).isEqualTo("Flower");
	}

	@Test
	public void givenAnyString_whenUsingArgumentMatcher_thenCorrect() {
		Mockito.when(flowerService.analyze(ArgumentMatchers.anyString())).thenReturn("Flower");

		String response = flowerController.isAFlower("violetta");
		Assertions.assertThat(response).isEqualTo("Flower");
	}

	@Test(expected = InvalidUseOfMatchersException.class)
	public void whenIncorrectMatchers_thenThrowsError() {
		Mockito.when(flowerService.isABigFlower("poppy", ArgumentMatchers.anyInt())).thenReturn(true);

		Flower flower = new Flower("poppy", 15);

		Boolean response = flowerController.isABigFlower(flower);
		Assertions.assertThat(response).isTrue();
	}

	@Test
	public void whenCorrectMatchers_thenCorrect() {
		Mockito.when(flowerService.isABigFlower(ArgumentMatchers.eq("poppy"), ArgumentMatchers.anyInt())).thenReturn(true);

		Flower flower = new Flower("poppy", 15);

		Boolean response = flowerController.isABigFlower(flower);
		Assertions.assertThat(response).isTrue();
	}

	@Test(expected = InvalidUseOfMatchersException.class)
	public void whenUsingMatchersAsReturnValue_thenThrowsError() {
		flowerController.isAFlower("poppy");

		String orMatcher = AdditionalMatchers.or(ArgumentMatchers.eq("poppy"), ArgumentMatchers.endsWith("y"));
		Mockito.verify(flowerService).analyze(orMatcher);
	}

	@Test
	public void whenUsingMatchersAsOngoingStubbing_thenCorrect1() {
		flowerController.isAFlower("poppy");

		Mockito.verify(flowerService).analyze(AdditionalMatchers.or(ArgumentMatchers.eq("poppy"), ArgumentMatchers.endsWith("y")));
	}

	@Test
	public void whenUsingMatchersAsOngoingStubbing_thenCorrect2() {
		flowerController.isAFlower("lily");

		Mockito.verify(flowerService).analyze(AdditionalMatchers.or(ArgumentMatchers.eq("poppy"), ArgumentMatchers.endsWith("y")));
	}
}
