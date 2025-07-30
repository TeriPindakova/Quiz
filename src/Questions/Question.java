package Questions;



public class Question {
    private String questionText;
    private String[] options;
    private String correctAnswer;
    private QuestionType type;


    public Question(String questionText, String[] options, String correctAnswer, QuestionType type) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.type = type;
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

// ověření correctAnswer
    public boolean checkAnswer (String answer) {
        if (type == QuestionType.FREE_TEXT) {
          return answer.trim().equalsIgnoreCase(correctAnswer.trim());
        }
        if (type == QuestionType.SINGLE_CHOICE) {
            return answer.trim().equalsIgnoreCase(correctAnswer.trim());
        }
        if (type == QuestionType.MULTIPLE_CHOICE) {
            String userAnswer = answer.toLowerCase().replaceAll("\\s+", "");
            String correct = correctAnswer.toLowerCase().replaceAll("\\s+", "");

            for (int i = 0; i < correct.length(); i++) {
                char c = correct.charAt(i);
                if (!userAnswer.contains(String.valueOf(c))) {
                    return false;
                }
            }
            if (userAnswer.length() != correct.length()) {
                return false;
            }
            return true;
        }
        return false;
    }

// vrátí correct answer
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

