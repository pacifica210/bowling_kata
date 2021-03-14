public class Frame {
    private Frame nextFrame;
    private Frame secondNextFrame;
    private Ball ball1, ball2;

    public Frame(int ball1Pins, int ball2Pins) {
        this.ball1 = new Ball(ball1Pins);
        if (ball1Pins != 10)
            this.ball2 = new Ball(ball2Pins);
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
