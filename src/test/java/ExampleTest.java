import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {
    @Test
    void myTest() {
        int a = 1, b = 42;
        Assertions.assertAll(
                () -> assertEquals(a, 1),
                () -> assertEquals(b, 42));
    }
}
