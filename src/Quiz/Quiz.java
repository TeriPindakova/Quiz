package Quiz;

import Questions.Question;
import java.util.List;
import java.util.Scanner;


public class Quiz {


    private String nameOfQuiz;
    private List<Question> questions;
    private Scanner scanner;

    public Quiz(String nameOfQuiz, List<Question> questions, Scanner scanner) {
        this.nameOfQuiz = nameOfQuiz;
        this.questions = questions;
        this.scanner = scanner;
    }

    // vypíše otázky
    public void printQuestion() {
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question " + (i + 1) + ". ");
            questions.get(i).printQuestionInfo();
            System.out.println();
        }
    }
    // odpověď a kontrola správnosti
    public int answerAndCheck() {

        int score = 0;

        for (int i = 0; i < questions.size();i++) {
            Question currentQuestion = questions.get(i);
            System.out.println("Question " + (i+1));
            currentQuestion.printQuestionInfo();

            System.out.println("What is your answer? ");
            String userAnswer = scanner.nextLine();

            if (currentQuestion.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;

            } else {
                System.out.println("Wrong! The correct answer is: " + currentQuestion.getCorrectAnswer());
            }
            System.out.println("Your actual score is: " + score + (score == 1 ? " point" : " points"));
            System.out.println();
        }
        return score;
    }

// getter na získání počtu otázek
    public List<Question> getQuestions() {
        return questions;
    }

}
