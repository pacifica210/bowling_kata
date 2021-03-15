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

    private Executable createAssertForThreeFramesOnlyFirstFrame(int frameABall1, int frameABall2, int frameBBall1, int frameBBall2, int frameCBall1, int frameCBall2, int result){
        Frame frameA = new Frame(frameABall1, frameABall2);
        Frame frameB = new Frame(frameBBall1, frameBBall2);
        Frame frameC = new Frame(frameCBall1, frameCBall2);
        frameA.setNextFrame(frameB);
        frameA.setSecondNextFrame(frameC);
        return () -> assertEquals(result, frameA.calculateScore());
    }

    @Test
    @DisplayName("test frame combinations, only first frame")
    void testFrameCombinationsOnlyFirstFrame() {
        Collection<Executable> listOfAsserts = new LinkedList<>();

        listOfAsserts.add(createAssertForThreeFramesOnlyFirstFrame(0, 0, 0, 0, 0, 0, 0));
        listOfAsserts.add(createAssertForThreeFramesOnlyFirstFrame(0, 0, 0, 0, 0, 1, 0));
        listOfAsserts.add(createAssertForThreeFramesOnlyFirstFrame(9, 0, 8, 0, 7, 0, 9));
        listOfAsserts.add(createAssertForThreeFramesOnlyFirstFrame(9, 1, 8, 2, 7, 3, 18));
        listOfAsserts.add(createAssertForThreeFramesOnlyFirstFrame(10, 0, 9, 1, 3, 6, 20));

        assertAll(listOfAsserts);
    }

    private Executable createAssertForThreeFramesSumOfThreeFrames(int frameABall1, int frameABall2, int frameBBall1, int frameBBall2, int frameCBall1, int frameCBall2, int result){
        Frame frameA = new Frame(frameABall1, frameABall2);
        Frame frameB = new Frame(frameBBall1, frameBBall2);
        Frame frameC = new Frame(frameCBall1, frameCBall2);
        frameA.setNextFrame(frameB);
        frameA.setSecondNextFrame(frameC);
        frameB.setNextFrame(frameC);
        return () -> assertEquals(result, frameA.calculateScore() + frameB.calculateScore() + frameC.calculateScore());
    }

    @Test
    @DisplayName("test frame combinations, sum of three frame")
    void testFrameCombinationsSumOfThreeFrames() {
        Collection<Executable> listOfAsserts = new LinkedList<>();

        listOfAsserts.add(createAssertForThreeFramesSumOfThreeFrames(0, 0, 0, 0, 0, 0, 0));
        listOfAsserts.add(createAssertForThreeFramesSumOfThreeFrames(0, 0, 0, 0, 0, 1, 1));
        listOfAsserts.add(createAssertForThreeFramesSumOfThreeFrames(9, 0, 8, 0, 7, 0, 24));
        listOfAsserts.add(createAssertForThreeFramesSumOfThreeFrames(9, 1, 8, 2, 0, 0, 28));
        listOfAsserts.add(createAssertForThreeFramesSumOfThreeFrames(9, 1, 8, 2, 7, 1, 43));
        listOfAsserts.add(createAssertForThreeFramesSumOfThreeFrames(10, 0, 9, 1, 3, 6, 42));

        assertAll(listOfAsserts);
    }
}
