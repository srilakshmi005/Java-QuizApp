import java.util.*;
import java.io.*;

public class QuizApp {
    public static void main(String[] args) throws IOException {
        List<Question> questions = QuestionLoader.loadFromFile("questions.txt");
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question q : questions) {
            System.out.println("\n" + q.question);
            System.out.println("A. " + q.optionA);
            System.out.println("B. " + q.optionB);
            System.out.println("C. " + q.optionC);
            System.out.println("D. " + q.optionD);
            System.out.print("Your answer: ");
            
            char userans = scanner.next().toUpperCase().charAt(0);

            if (userans == q.answer) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.answer);
            }
        }

        System.out.println("\nYour final score: " + score + " out of " + questions.size());
        scanner.close();
    }
}