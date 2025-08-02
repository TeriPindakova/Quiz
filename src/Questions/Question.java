package Questions;



public class Question {
    private String questionText;
    private String[] options;
    private QuestionType type;
    private Answer answer;
    private String correctAnswer;

    public Question(String questionText, String[] options, String correctAnswer, QuestionType type) {
        this.questionText = questionText;
        this.options = options;
        this.type = type;
        this.answer = new Answer(correctAnswer, type);
    }


    public void printQuestionInfo(){
        System.out.println(questionText);
        if(options != null) {
            char letter = 'a';
            for (String option : options) {
            System.out.println(letter + ". " + option);
            letter++;
            }
        }
    }
    public boolean checkAnswer(String userAnswer) {
        return answer.checkAnswer(userAnswer);
    }
    public String getCorrectAnswer() {
        return answer.getCorrectAnswer();
    }
}

