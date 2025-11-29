import java.util.*;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    // Constructor
    Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    // Display the question
    void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    // Check if answer is correct
    boolean checkAnswer(int userChoice) {
        return userChoice == correctAnswerIndex;
    }
}

class Quiz {
    private List<Question> questions = new ArrayList<>();
    private int score = 0;

    // Add a question to the quiz
    void addQuestion(Question q) {
        questions.add(q);
    }

    // Start the quiz
    void startQuiz() {
        Scanner sc = new Scanner(System.in);
        for (Question q : questions) {
            q.displayQuestion();
            System.out.print("Your answer: ");
            int ans = sc.nextInt();
            if (q.checkAnswer(ans)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong!\n");
            }
        }
        showResults();
    }

    // Show final results
    void showResults() {
        System.out.println("🎯 Quiz Over! Your score: " + score + "/" + questions.size());
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        quiz.addQuestion(new Question("What is the capital of India?",
                new String[]{"Delhi", "Mumbai", "Pakistan", "Kirgistan"}, 1));

        quiz.addQuestion(new Question("Which language is used for Android development?",
                new String[]{"Python", "Java", "C++", "Swift"}, 2));

        quiz.addQuestion(new Question("OOP stands for?",
                new String[]{"Object Oriented Programming", "Open Online Platform", "Order Of Priority", "None"}, 1));

        quiz.startQuiz();
    }
}
