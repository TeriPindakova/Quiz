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

    // odpověď a kontrola správnosti
    public int answerAndCheck() {
        System.out.println("Starting quiz: " + nameOfQuiz);
        int score = 0;

        for (int i = 0; i < questions.size();i++) {
            Question currentQuestion = questions.get(i);
            System.out.println("Question " + (i+1));
            currentQuestion.printQuestion();

            System.out.println("What is your answer? ");
            String userAnswer = scanner.nextLine();

            if (currentQuestion.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;

            } else {
                System.out.println("Wrong!");
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
