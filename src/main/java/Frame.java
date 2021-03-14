public class Frame {
    private Frame next;
    private Frame secondNext;

    public Frame(int ball1, int ball2) {
    }

    public void setNext(Frame next) {
        this.next = next;
    }

    public Frame getNext() {
        return next;
    }

    public void setSecondNext(Frame secondNext) {
        this.secondNext = secondNext;
    }

    public Frame getSecondNext() {
        return secondNext;
    }

    public int calculateScore() {
        return 0;
    }
}
