import java.util.ArrayList;

public class Line {

    private final ArrayList<Frame> frames = new ArrayList<>();

    public Line(){
        frames.add(new Frame());
    }

    private Frame getLastFrame(){
        return frames.get(frames.size()-1);
    }

    public void addBall(int ballPins) {
        // add ball to last frame
        getLastFrame().addBall(ballPins);

        // if the last frame is now finished (2 balls or strike)
        if(getLastFrame().isFinished()) {
            // add a new empty frame
            Frame newFrame = new Frame();
            frames.add(newFrame);
            // link previous frames to the new one
            int indexOfLastFrame = frames.size()-1;
            if (indexOfLastFrame >= 1)
                frames.get(indexOfLastFrame - 1).setNextFrame(newFrame);
            if (indexOfLastFrame >= 2)
                frames.get(indexOfLastFrame - 2).setSecondNextFrame(newFrame);
        }
    }

    public int calculateScore() {
        // calculate score
        int score = 0;
        int i = 0;
        while(i < frames.size() && i < 10){
            score += frames.get(i).calculateScore();
            i++;
        }
        return score;
    }
}
