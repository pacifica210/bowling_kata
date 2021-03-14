import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {
    @Test
    @DisplayName("example test method")
    void exampleTestMethod() {
        int a = 1, b = 42;
        assertAll(
                () -> assertEquals(a, 1),
                () -> assertEquals(b, 42));
    }
}
