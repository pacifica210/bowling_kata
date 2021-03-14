import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Collection;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrameTest {

    @Test
    @DisplayName("test specific frames")
    void testSpecificFrames() {
        int[] ball1 = {0, 0, 1, 4, 9, 10};
        int[] ball2 = {0, 1, 0, 2, 1, 0};
        Collection<Executable> listOfAsserts = new LinkedList<>();
        for (int i = 0; i < ball1.length; i++) {
            int index = i;
            listOfAsserts.add(() -> assertEquals(ball1[index]+ball2[index], (new Frame(ball1[index], ball2[index])).calculateScore()));
        }
        assertAll(listOfAsserts);
    }

    private Executable createAssertForThreeFrames(int frameABall1, int frameABall2, int frameBBall1, int frameBBall2, int frameCBall1, int frameCBall2, int result){
        Frame frameA = new Frame(frameABall1, frameABall2);
        Frame frameB = new Frame(frameBBall1, frameBBall2); // this is necessary to have strictly separated frames
        Frame frameC = new Frame(frameCBall1, frameCBall2);
        frameA.setNext(frameB);
        frameA.setSecondNext(frameC);
        return () -> assertEquals(result, frameA.calculateScore());
    }

    @Test
    @DisplayName("test frame combinations")
    void testFrameCombinations() {
        Collection<Executable> listOfAsserts = new LinkedList<>();

        listOfAsserts.add(createAssertForThreeFrames(0, 0, 0, 0, 0, 0, 0));
        listOfAsserts.add(createAssertForThreeFrames(0, 0, 0, 0, 0, 1, 1));
        listOfAsserts.add(createAssertForThreeFrames(9, 0, 8, 0, 7, 0, 24));
        listOfAsserts.add(createAssertForThreeFrames(9, 1, 8, 2, 7, 3, 50));
        listOfAsserts.add(createAssertForThreeFrames(10, 0, 9, 1, 3, 6, 42));

        assertAll(listOfAsserts);
    }
}
