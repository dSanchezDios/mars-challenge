import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainClassTest {

	@Test
	void shouldFailWhenThereIsNoArguments() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> MarsRover.main(null));
	}

	@Test
	void shouldFailWhenMoreThanOneArgument() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> MarsRover.main(new String[]{"-a", "-i"}));
	}

	@Test
	void shouldFailWhenNotValid() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> MarsRover.main(new String[]{"--a"}));
	}
}
