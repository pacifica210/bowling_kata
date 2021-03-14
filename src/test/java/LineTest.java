import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Collection;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class LineTest {


    private Executable createAssertForLine(int[] ballValues, int result){
        Line line = new Line();
        for(int ballValue : ballValues){
            line.addBall(ballValue);
        }
        return () -> assertEquals(result, line.calculateScore());
    }

    @Test
    @DisplayName("test frame combinations")
    void testFrameCombinations() {
        Collection<Executable> listOfAsserts = new LinkedList<>();

        listOfAsserts.add(createAssertForLine(new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, 300)); // all strike (10+2)
        listOfAsserts.add(createAssertForLine(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0)); // all gutter/foul
        listOfAsserts.add(createAssertForLine(new int[] {9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0}, 90)); // all 9 + 0
        listOfAsserts.add(createAssertForLine(new int[] {10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 60)); // 3 strikes, then 0
        listOfAsserts.add(createAssertForLine(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 10, 10}, 60)); // 4 strikes in the end
        // ending tests
        listOfAsserts.add(createAssertForLine(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 9, 1, 3}, 33));
        listOfAsserts.add(createAssertForLine(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 2, 3}, 37));
        listOfAsserts.add(createAssertForLine(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 5, 2}, 42));
        // further "random" tests
        listOfAsserts.add(createAssertForLine(new int[] {10, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 24));
        listOfAsserts.add(createAssertForLine(new int[] {9, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 16));
        listOfAsserts.add(createAssertForLine(new int[] {9, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 15));
        listOfAsserts.add(createAssertForLine(new int[] {9, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 14));
        listOfAsserts.add(createAssertForLine(new int[] {9, 1, 8, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 30));
        listOfAsserts.add(createAssertForLine(new int[] {10, 9, 1, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 42));
        listOfAsserts.add(createAssertForLine(new int[] {10, 10, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 42));

        assertAll(listOfAsserts);
    }

}
