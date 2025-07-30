import Questions.Question;
import Questions.QuestionType;
import Quiz.Quiz;
import Quiz.QuizResult;

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

// celkový výsledek
    public static void wholeScore(int correctAnswers, int totalQuestions) {

        double percentage = ((double) correctAnswers / totalQuestions) * 100;

        System.out.println("You answered " + correctAnswers + " out of " + totalQuestions + " questions correctly.");

        System.out.printf("Your score: %.2f%%\n", percentage);

            if (percentage == 100) {
                System.out.println("Excellent! Perfect score!");
            } else if (percentage >= 70 && percentage <= 100) {
                System.out.println("Well done! You passed the quiz.");
            } else if (percentage >= 40 && percentage <= 70) {
                System.out.println("Not bad, but you can do better.");
            } else {
                System.out.println("Better luck next time. Keep practicing!");
            }
    }

// zahájení 1. kvízu a opakování hry
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

            QuizResult result = pickQuiz(choiceOfQuiz);
            totalCorrectAnswers += result.correctAnswers;
            totalQuestions += result.totalQuestions;

            System.out.println("Your total score so far is: " + totalCorrectAnswers + (totalCorrectAnswers == 1 ? " point" : " points"));

            while(true) {
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

// výběr kvízu
    public static QuizResult pickQuiz(int number) {

        Quiz selectedQuiz;

        if (number == 1) {
            selectedQuiz = new Quiz("Easy Quiz", questionsQuizEasy(),scanner);
        } else if (number == 2) {
            selectedQuiz = new Quiz("Medium Quiz", questionsQuizMedium(),scanner);
        } else if (number == 3) {
            selectedQuiz = new Quiz("Hard Quiz", questionsQuizHard(),scanner);
        } else {
            System.out.println("Invalid choice, starting Easy Quiz by default.");
            selectedQuiz  = new Quiz("Easy Quiz", questionsQuizEasy(),scanner);
        }

        int scoreThisQuiz = selectedQuiz.answerAndCheck();
        int totalQ = selectedQuiz.getQuestions().size();

        return new QuizResult(scoreThisQuiz, totalQ);
    }

// jednotlivé kvízy s otázkami
    public static List<Question> questionsQuizEasy() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("What is 5 + 8 * 4 ? \n(Choose one letter)", new String[]{"40", "52", "37"}, "c",
                QuestionType.SINGLE_CHOICE));
        questions.add(new Question("What is 5 / 0 ? \n(Choose multiple letters e.g. ab or bc in this format)", new String[]{"1", "0", "Can't divide by zero"}, "bc",
                QuestionType.MULTIPLE_CHOICE));
        questions.add(new Question("What is 3 * 20 ? \n(Free text, answer in number(s))", null, "60",
                QuestionType.FREE_TEXT));
        return questions;
    }

    public static List<Question> questionsQuizMedium() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("What is 5 to the power of 2 (5²) ? \n(Choose one letter)", new String[]{"25", "52", "10"}, "a",
                QuestionType.SINGLE_CHOICE));
        questions.add(new Question("Which of these numbers are even ? \n(Choose multiple letters e.g. ab or bc in this format)", new String[]{"58", "33", "2"}, "ac",
                QuestionType.MULTIPLE_CHOICE));
        questions.add(new Question("Calculate 560 minus 570 ? \n(Free text, answer in number(s))", null, "-10",
                QuestionType.FREE_TEXT));
        return questions;
    }

    public static List<Question> questionsQuizHard() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("What is 10% of 150? \n(Free text, answer in number(s))", null, "15",
                QuestionType.FREE_TEXT));
        questions.add(new Question("Divide 17 by 4, what is the integer part? \n(Choose one letter)", new String[]{"3", "4", "1", "5"}, "c",
                QuestionType.SINGLE_CHOICE));
        questions.add(new Question("Solve for x: x + 5 = 10 \n(Choose one letter)", new String[]{"3", "2", "5", "15"}, "c",
                QuestionType.SINGLE_CHOICE));
        return questions;
    }
}

