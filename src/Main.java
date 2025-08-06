import Quiz.Quiz;
import Questions.Question;
import Questions.QuestionType;
import Questions.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int totalCorrectAnswers = 0;
    static int totalQuestions = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to Math quiz.");
        System.out.println("You can choose from 3 different quizzes. Each containing 3 questions.");
        System.out.println("For each correct answer, you earn 1 point.");
        System.out.println("That means you can get up to 3 points per quiz, and up to 9 points in total.");

        playAgain();
    }

    public static void wholeScore(int correctAnswers, int totalQuestions) {
        double percentage = ((double) correctAnswers / totalQuestions) * 100;

        System.out.println("You answered " + correctAnswers + " out of " + totalQuestions + " questions correctly.");
        System.out.printf("Your score: %.2f%%\n", percentage);

        if (percentage == 100) {
            System.out.println("Excellent! Perfect score!");
        } else if (percentage >= 70) {
            System.out.println("Well done! You passed the quiz.");
        } else if (percentage >= 40) {
            System.out.println("Not bad, but you can do better.");
        } else {
            System.out.println("Better luck next time. Keep practicing!");
        }
    }

    public static void playAgain() {
        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("Let's start! Choose your quiz level.\n 1 - Easy \n 2 - Medium \n 3 - Hard \n What number do you pick?");

            int choiceOfQuiz;
            try {
                choiceOfQuiz = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choiceOfQuiz = 1;
                System.out.println("Invalid input, starting Easy Quiz by default.");
            }

            Quiz selectedQuiz = pickQuiz(choiceOfQuiz);
            int scoreThisQuiz = selectedQuiz.answerAndCheck();
            totalCorrectAnswers += scoreThisQuiz;
            totalQuestions += selectedQuiz.getQuestions().size();

            System.out.println("Your total score so far is: " + totalCorrectAnswers + (totalCorrectAnswers == 1 ? " point" : " points"));

            while (true) {
                System.out.println("\nDo you want to play another quiz? write yes/no");
                String answer = scanner.nextLine().trim().toLowerCase();

                if (answer.equals("yes")) {
                    break;
                } else if (answer.equals("no")) {
                    keepPlaying = false;
                    wholeScore(totalCorrectAnswers, totalQuestions);
                    System.out.println("Thank you for playing! Goodbye");
                    break;
                } else {
                    System.out.println("Invalid input. Please type yes or no.");
                }
            }
        }
    }

    public static Quiz pickQuiz(int number) {
        if (number == 1) {
            return new Quiz("Easy Quiz", questionsQuizEasy(), scanner);
        } else if (number == 2) {
            return new Quiz("Medium Quiz", questionsQuizMedium(), scanner);
        } else if (number == 3) {
            return new Quiz("Hard Quiz", questionsQuizHard(), scanner);
        } else {
            System.out.println("Invalid choice, starting Easy Quiz by default.");
            return new Quiz("Easy Quiz", questionsQuizEasy(), scanner);
        }
    }

    public static List<Question> questionsQuizEasy() {
        List<Question> questions = new ArrayList<>();

        List<Answer> q1Answers = List.of(
                new Answer("40", false),
                new Answer("52", false),
                new Answer("37", true)
        );
        questions.add(new Question("What is 5 + 8 * 4 ? \n(Choose one option number)", QuestionType.SINGLE_CHOICE, q1Answers));

        List<Answer> q2Answers = List.of(
                new Answer("1", false),
                new Answer("0", false),
                new Answer("Can't divide by zero", true)
        );
        questions.add(new Question("What is 5 / 0 ? \n(Choose one option number)", QuestionType.SINGLE_CHOICE, q2Answers));

        List<Answer> q3Answers = List.of(
                new Answer("60", true)
        );
        questions.add(new Question("What is 3 * 20 ? \n(Write the number)", QuestionType.FREE_TEXT, q3Answers));

        return questions;
    }

    public static List<Question> questionsQuizMedium() {
        List<Question> questions = new ArrayList<>();

        List<Answer> q1Answers = List.of(
                new Answer("25", true),
                new Answer("52", false),
                new Answer("10", false)
        );
        questions.add(new Question("What is 5 to the power of 2 (5²) ? \n(Choose one option number)", QuestionType.SINGLE_CHOICE, q1Answers));

        List<Answer> q2Answers = List.of(
                new Answer("58", true),
                new Answer("33", false),
                new Answer("2", true)
        );
        questions.add(new Question("Which of these numbers are even? \n(Choose multiple numbers like 2 3)", QuestionType.MULTIPLE_CHOICE, q2Answers));

        List<Answer> q3Answers = List.of(
                new Answer("-10", true)
        );
        questions.add(new Question("Calculate 560 minus 570 ? \n(Write the number)", QuestionType.FREE_TEXT, q3Answers));

        return questions;
    }

    public static List<Question> questionsQuizHard() {
        List<Question> questions = new ArrayList<>();

        List<Answer> q1Answers = List.of(
                new Answer("15", true)
        );
        questions.add(new Question("What is 10% of 150? \n(Write the number)", QuestionType.FREE_TEXT, q1Answers));

        List<Answer> q2Answers = List.of(
                new Answer("3", false),
                new Answer("4", true),
                new Answer("1", false),
                new Answer("5", false)
        );
        questions.add(new Question("Divide 17 by 4, what is the integer part? \n(Choose one option number)", QuestionType.SINGLE_CHOICE, q2Answers));

        List<Answer> q3Answers = List.of(
                new Answer("3", false),
                new Answer("2", false),
                new Answer("5", true),
                new Answer("15", false)
        );
        questions.add(new Question("Solve for x: x + 5 = 10 \n(Choose one option number)", QuestionType.SINGLE_CHOICE, q3Answers));

        return questions;
    }
}