package Questions;

public class Answer {
    private String title;
    private boolean isCorrect;

    public Answer(String title, boolean isCorrect) {
        this.title = title;
        this.isCorrect = isCorrect;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}