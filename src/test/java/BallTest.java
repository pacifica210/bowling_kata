import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BallTest {
    @Test
    @DisplayName("basic ball test")
    void basicBallTest() {
        int[] testValues = {0, 1, 10, -1, 11};
        Collection<Executable> listOfAsserts = new LinkedList<>();
        for (int testValue : testValues){
            listOfAsserts.add(()->assertEquals(testValue, (new Ball(testValue)).getPins()));
        }
        assertAll(listOfAsserts);
    }
}
