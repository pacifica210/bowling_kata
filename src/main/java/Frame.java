public class Frame {
    private Frame nextFrame;
    private Frame secondNextFrame;

    public Frame(int ball1, int ball2) {
    }

    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    public void setSecondNextFrame(Frame secondNextFrame) {
        this.secondNextFrame = secondNextFrame;
    }

    public Ball getBall1() {
        return ball1;
    }

    public Ball getBall2() {
        return ball2;
    }

    public int calculateScore() {
        return 0;
    }
}
