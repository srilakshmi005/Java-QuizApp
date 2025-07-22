import java.io.*;
import java.util.*;

public class QuestionLoader {
    public static List<Question> loadFromFile(String filename) throws IOException {
        List<Question> questions = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            String question = line;
            String optionA = br.readLine();
            String optionB = br.readLine();
            String optionC = br.readLine();
            String optionD = br.readLine();
            String ansLine = br.readLine();
            br.readLine(); // skip empty line

            if (optionA == null || optionB == null || optionC == null || optionD == null || ansLine == null) {
                System.out.println("❌ Incomplete question found. Skipping...");
                break;
            }

            char answer = ansLine.toUpperCase().charAt(0);
            questions.add(new Question(question, optionA, optionB, optionC, optionD, answer));
        }

        br.close();
        return questions;
    }
}