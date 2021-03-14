public class Frame {
    private Frame nextFrame;
    private Frame secondNextFrame;
    private Ball ball1, ball2;

    public Frame(){
    }

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

    public boolean isFinished(){
        // is true if ball1 and ball2 exist or if ball1 exists and is 10.
        return ball1 != null && (ball2 != null || ball1.getPins() == 10);
    }

    public int calculateScore() {
        int score = 0;
        if (ball1 != null)
            score += ball1.getPins();
        if (ball2 != null)
            score += ball2.getPins();

        // if next frame has at least ball 1
        if (nextFrame != null && nextFrame.getBall1() != null) {
            // if strike or spare, add bonus
            if (score == 10) {
                score += nextFrame.getBall1().getPins();
                System.out.println("check1 = "+score);
            }
            // if strike, add second bonus (2nd ball or 1st of second next frame)
            if (ball1.getPins() == 10) {
                if (nextFrame.getBall1().getPins() < 10){
                    score += nextFrame.getBall2().getPins();
                    System.out.println("check2");
                }
                else {
                    System.out.println("check3");
                    if (secondNextFrame != null && secondNextFrame.getBall1() != null) {
                        score += secondNextFrame.getBall1().getPins();
                        System.out.println("check4");
                    }
                }
            }
        }
        return score;
    }
}
