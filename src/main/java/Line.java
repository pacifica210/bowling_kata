import java.util.ArrayList;

public class Line {
    public void addBall(int ballValue) {

    private ArrayList<Frame> frames = new ArrayList();

    public Line(){
        frames.add(new Frame());
    }

    private Frame getLastFrame(){
        return frames.get(frames.size()-1);
    }
    }

    public int calculateScore() {
        return 0;
    }
}
