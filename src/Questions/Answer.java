package Questions;

public class Answer {
    private String correctAnswer;
    private QuestionType type;

    public Answer(String correctAnswer, QuestionType type) {
        this.correctAnswer = correctAnswer;
        this.type = type;
    }

// ověření correctAnswer
    public boolean checkAnswer (String userAnswer) {
        if (type == QuestionType.FREE_TEXT || type == QuestionType.SINGLE_CHOICE) {
            return userAnswer.trim().equalsIgnoreCase(correctAnswer.trim());
        }

        if (type == QuestionType.MULTIPLE_CHOICE) {
            String cleanedUserAnswer = userAnswer.toLowerCase().replaceAll("\\s+", "");
            String cleanedCorrect = correctAnswer.toLowerCase().replaceAll("\\s+", "");

            for (int i = 0; i < cleanedCorrect.length(); i++) {
                char c = cleanedCorrect.charAt(i);
                if (!cleanedUserAnswer.contains(String.valueOf(c))) {
                    return false;
                }
            }
            return cleanedUserAnswer.length() == cleanedCorrect.length();
        }
        return false;
    }

// vrátí correct answer
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}


/*
, ale iba v podsatte
questionType, questionText a List<Answer> by malo stacit..
 */