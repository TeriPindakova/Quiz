package Questions;

import java.util.List;

public class Question {
    private String description;
    private QuestionType type;
    private List<Answer> answers;

    public Question(String description, QuestionType type, List<Answer> answers) {
        this.description = description;
        this.type = type;
        this.answers = answers;
    }

    public void printQuestion() {
        System.out.println(description);
        if (type != QuestionType.FREE_TEXT) {
            for (int i = 0; i < answers.size(); i++) {
                System.out.println((i + 1) + ". " + answers.get(i).getTitle());
            }
        }
    }

    public boolean checkAnswer(String userInput) {
        if (type == QuestionType.FREE_TEXT) {
            for (Answer answer : answers) {
                if (answer.isCorrect() && answer.getTitle().equalsIgnoreCase(userInput.trim())) {
                    return true;
                }
            }
            return false;
        } else if (type == QuestionType.SINGLE_CHOICE) {
            try {
                int selected = Integer.parseInt(userInput.trim()) - 1;
                return selected >= 0 && selected < answers.size() && answers.get(selected).isCorrect();
            } catch (NumberFormatException e) {
                return false;
            }
        } else if (type == QuestionType.MULTIPLE_CHOICE) {
            String[] parts = userInput.trim().split("\\s+");
            boolean[] selected = new boolean[answers.size()];
            for (String part : parts) {
                try {
                    int index = Integer.parseInt(part) - 1;
                    if (index >= 0 && index < answers.size()) {
                        selected[index] = true;
                    } else {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }

            for (int i = 0; i < answers.size(); i++) {
                if (answers.get(i).isCorrect() != selected[i]) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

}