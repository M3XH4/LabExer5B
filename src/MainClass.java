import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        //Declaring Objects and Variables
        Scanner input = new Scanner(System.in);
        int score = 0;

        //Setting Questions And Answers
        String[][] QnA = {
                {"What is the chemical symbol for Gold?\nA. Gd\nB. Ag\nC. Au", "C. Au"},
                {"What is the tallest mountain in the world?\nA. Mount Everest\nB. Mount Fuji\nC. Mount Kilimanjaro", "A. Mount Everest"},
                {"Who painted the \"Mona Lisa\"?\nA. Michelangelo\nB. Van Gogh\nC. Leonardo da Vinci", "C. Leonardo da Vinci"},
                {"What is the fastest land animal?\nA. Ostrich\nB. Cheetah\nC. Lion", "B. Cheetah"},
                {"What is the smallest country in the world?\nA. Vatican City\nB. Monaco\nC. Malta", "A. Vatican City"},
                {"What is the world's largest desert?\nA. Sahara\nB. Siberian Desert\nC. Antarctica", "C. Antarctica"},
                {"What does WWW stand for?\nA. Web Wide World\nB. World Wide Web\nC. Wide World Web", "B. World Wide Web"},
                {"What is the longest river in the world?\nA. Amazon River\nB. Nile River\nC. Mississippi River", "B. Nile River"},
                {"\"E = mc²\" is known as?\nA. Einstein's Theory of Relativity\nB. Newton's Law of Motion\nC. Boyle's Law", "A. Einstein's Theory of Relativity"},
                {"In which country is the Sphinx located?\nA. Greece\nB. Egypt\nC. Italy", "B. Egypt"}
        };

        String[] userAnswers = new String[QnA.length];

        //Randomizing Questions
        List<String[]> qnaList = Arrays.asList(QnA);
        Collections.shuffle(qnaList);
        qnaList.toArray(QnA);


        //Main Window
        System.out.println("---------------------------------------------");
        System.out.println("|\t\t\t\t  Quiz Bee     \t\t\t\t|");
        System.out.println("---------------------------------------------");
        System.out.println();

        //Main Function
        for (int i = 0; i < QnA.length; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print((i + 1) + ".");
                System.out.println(QnA[i][0]);
                System.out.print("Your Answer (A/B/C): ");
                String userAnswer = input.nextLine().trim().toUpperCase();
                try {
                    if (userAnswer.isEmpty()) {
                        throw new Exception("You Didn't Give Any Answer. Please Input A, B, or C");
                    } else if (userAnswer.length() != 1 || "ABC".indexOf(userAnswer.charAt(0)) == -1) {
                        throw new Exception("Input Invalid. Please Only Input Either A, B, or C");
                    } else {
                        validInput = true;

                        if (userAnswer.charAt(0) == QnA[i][1].charAt(0)) {
                            System.out.println("Correct Answer!\n");
                            score++;
                        } else {
                            System.out.println("Incorrect. The Correct Answer Is " + QnA[i][1] + ".\n");
                        }

                        String chosenAnswer = "";
                        String[] options = QnA[i][0].split("\n");
                        for (String option : options) {
                            if (option.trim().startsWith(userAnswer + ".")) {
                                chosenAnswer = option;
                                break;
                            }
                        }

                        userAnswers[i] = chosenAnswer;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid Answer!!! " + e.getMessage() + ". Please Try Again.\n");
                }
            }
        }

        //Ending And Summary
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Thank You For Partaking In This Quiz User.");
        System.out.println("Your Final Score: " + score + " out of " +  QnA.length);
        System.out.println("---------------------------- Summary ----------------------------");
        for (int i = 0; i < QnA.length; i++) {
            System.out.println((i + 1) + ". Correct Answer is " + QnA[i][1] + "\nYour Answer is " + userAnswers[i]);
        }
    }
}
