import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class wordle {


    public static void main(String[] args) throws IOException {

        //assigning values to letters to later calculate words values
        ConcurrentHashMap<String, Integer> letterVal = new ConcurrentHashMap<String, Integer>();
        letterVal.put("s", 46);
        letterVal.put("e", 44);
        letterVal.put("a", 41);
        letterVal.put("o", 30);
        letterVal.put("r", 30);
        letterVal.put("i", 28);
        letterVal.put("l", 24);
        letterVal.put("t", 23);
        letterVal.put("n", 22);
        letterVal.put("u", 19);
        letterVal.put("d", 18);
        letterVal.put("y", 16);
        letterVal.put("c", 15);
        letterVal.put("p", 15);
        letterVal.put("m", 14);
        letterVal.put("h", 13);
        letterVal.put("g", 12);
        letterVal.put("b", 12);
        letterVal.put("k", 11);
        letterVal.put("w", 8);
        letterVal.put("f", 8);
        letterVal.put("j", 4);
        letterVal.put("q", 3);
        letterVal.put("v", 3);
        letterVal.put("x", 3);
        letterVal.put("z", 2);

        ///////Reads in text file and places each word into its on index inside an array list.
        BufferedReader bufReader = new BufferedReader(new FileReader("words.txt"));
        ArrayList<String> listOfWords = new ArrayList<>();
        String line = bufReader.readLine();
        while (line != null) {
            listOfWords.add(line);
            line = bufReader.readLine();
        }
        bufReader.close();

        //original hash attaching words to values
        ConcurrentHashMap<String, Integer> wordVal = new ConcurrentHashMap<String, Integer>();//original hash
        for (int i = 0; i < 5755; i++) {
            String[] tempWord = listOfWords.get(i).split("");
            int temp = 0;
            for (int j = 0; j < 5; j++) {
                temp += letterVal.get(tempWord[j]);

            }
            wordVal.put(listOfWords.get(i), temp);
        }

        //generating initial guesses
        System.out.println("Hello User!, I recommend one of the following words: " +
                "salet\n" +
                "arose\n" +
                "soare\n" +
                "later\n" +
                "saine\n" +
                "tares\n" +
                "lares\n" +
                "rales\n" +
                "rates\n" +
                "cares");

        //taking in data from user
        boolean solved = false;
        int guesses = 0;
        String letter1 = "";
        String letter1Val = "";
        String letter2 = "";
        String letter2Val = "";
        String letter3 = "";
        String letter3Val = "";
        String letter4 = "";
        String letter4Val = "";
        String letter5 = "";
        String letter5Val = "";

        while (guesses < 12) {

            Scanner scan = new Scanner(System.in);

            System.out.println("What is the first letter?");
            letter1 = scan.next();
            System.out.println("Was it green, yellow, or grey?");
            letter1Val = scan.next();

            System.out.println("What is the second letter?");
            letter2 = scan.next();
            System.out.println("Was it green, yellow, or grey?");
            letter2Val = scan.next();

            System.out.println("What is the third letter?");
            letter3 = scan.next();
            System.out.println("Was it green, yellow, or grey?");
            letter3Val = scan.next();

            System.out.println("What is the fourth letter?");
            letter4 = scan.next();
            System.out.println("Was it green, yellow, or grey?");
            letter4Val = scan.next();

            System.out.println("What is the fifth letter?");
            letter5 = scan.next();
            System.out.println("Was it green, yellow, or grey?");
            letter5Val = scan.next();

            guesses++;


            //if inputs(1-5) are green
            if (Objects.equals(letter1Val, "green")) {
                for (Entry<String, Integer> entry : wordVal.entrySet()) {
                    String[] tempWord = entry.getKey().split("");
                    if (!letter1.equals(tempWord[0])) {
                        wordVal.remove(entry.getKey());
                    }

                }

            }

            if (Objects.equals(letter2Val, "green")) {
                for (Entry<String, Integer> entry : wordVal.entrySet()) {
                    String[] tempWord = entry.getKey().split("");
                    if (!letter2.equals(tempWord[1])) {
                        wordVal.remove(entry.getKey());
                    }
                }
            }

            if (Objects.equals(letter3Val, "green")) {
                for (Entry<String, Integer> entry : wordVal.entrySet()) {
                    String[] tempWord = entry.getKey().split("");
                    if (!letter3.equals(tempWord[2])) {
                        wordVal.remove(entry.getKey());
                        ;
                    }

                }
            }

            if (Objects.equals(letter4Val, "green")) {
                for (Entry<String, Integer> entry : wordVal.entrySet()) {
                    String[] tempWord = entry.getKey().split("");
                    if (!letter4.equals(tempWord[3])) {
                        wordVal.remove(entry.getKey());
                    }

                }
            }

            if (Objects.equals(letter5Val, "green")) {
                for (Entry<String, Integer> entry : wordVal.entrySet()) {
                    String[] tempWord = entry.getKey().split("");
                    if (!letter5.equals(tempWord[4])) {
                        wordVal.remove(entry.getKey());
                    }
                }
            }
            ////////////////////////////////////////////////////////


            ////////grey////////
            if (Objects.equals(letter1Val, "grey")) {
                for (Entry<String, Integer> entry : wordVal.entrySet()) {
                    String[] tempWord = entry.getKey().split("");
                    int green = -1;
                    int yellow = -1;
                    boolean YellowBol = false;
                    if ((Objects.equals(letter1, letter2)) && ((Objects.equals(letter2Val, "green")))) {
                        green = 1;
                    }
                    if ((Objects.equals(letter1, letter2)) && (Objects.equals(letter2Val, "yellow"))) {
                        yellow = 1;
                        YellowBol = true;

                    }
                    if ((Objects.equals(letter1, letter3)) && ((Objects.equals(letter3Val, "green")))) {
                        green = 2;
                    }
                    if ((Objects.equals(letter1, letter3)) && (Objects.equals(letter3Val, "yellow"))) {
                        yellow = 2;
                        YellowBol = true;

                    }
                    if ((Objects.equals(letter1, letter4)) && ((Objects.equals(letter4Val, "green")))) {
                        green = 3;
                    }
                    if ((Objects.equals(letter1, letter4)) && (Objects.equals(letter4Val, "yellow"))) {
                        yellow = 3;
                        YellowBol = true;

                    }
                    if ((Objects.equals(letter1, letter5)) && ((Objects.equals(letter5Val, "green")))) {
                        green = 4;
                    }
                    if ((Objects.equals(letter1, letter5)) && (Objects.equals(letter5Val, "yellow"))) {
                        yellow = 4;
                        YellowBol = true;

                    }
                    //if yellow occurs before or after letter
                    if (YellowBol) {
                        for (int j = 0; j < 5; j++) {
                            if (letter1.equals(tempWord[yellow])) {
                                wordVal.remove(entry.getKey());
                            }
                            if (letter1.equals(tempWord[0])) {
                                wordVal.remove(entry.getKey());
                            }
                        }
                    }
                    //if green occurs before or after letter
                    if (!YellowBol) {
                        for (int j = 0; j < 5; j++) {
                            if (letter1.equals(tempWord[j]) && j != green) {
                                wordVal.remove(entry.getKey());
                            }
                        }
                    }

                }
            }
            if (Objects.equals(letter2Val, "grey")) {
                for (Entry<String, Integer> entry : wordVal.entrySet()) {
                    String[] tempWord = entry.getKey().split("");

                    int green = -1;
                    int yellow = -1;
                    boolean YellowBol = false;
                    if ((Objects.equals(letter2, letter1)) && ((Objects.equals(letter1Val, "green")))) {
                        green = 0;

                    }
                    if ((Objects.equals(letter2, letter1)) && (Objects.equals(letter1Val, "yellow"))) {
                        yellow = 0;
                        YellowBol = true;

                    }
                    if ((Objects.equals(letter2, letter3)) && ((Objects.equals(letter3Val, "green")))) {
                        green = 2;
                    }
                    if ((Objects.equals(letter2, letter3)) && (Objects.equals(letter3Val, "yellow"))) {
                        yellow = 2;
                        YellowBol = true;

                    }
                    if ((Objects.equals(letter2, letter4)) && ((Objects.equals(letter4Val, "green")))) {

                        green = 3;
                    }
                    if ((Objects.equals(letter2, letter4)) && (Objects.equals(letter4Val, "yellow"))) {
                        yellow = 3;
                        YellowBol = true;

                    }
                    if ((Objects.equals(letter2, letter5)) && ((Objects.equals(letter5Val, "green")))) {

                        green = 4;
                    }
                    if ((Objects.equals(letter2, letter5)) && (Objects.equals(letter5Val, "yellow"))) {
                        yellow = 4;
                        YellowBol = true;

                    }


                    //if yellow occurs before or after letter
                    if (YellowBol) {
                        for (int j = 0; j < 5; j++) {
                            if (letter2.equals(tempWord[yellow])) {
                                wordVal.remove(entry.getKey());
                            }
                            if (letter2.equals(tempWord[1])) {
                                wordVal.remove(entry.getKey());
                            }
                        }
                    }
                    //if green occurs before or after letter
                    if (!YellowBol) {
                        for (int j = 0; j < 5; j++) {
                            if (letter2.equals(tempWord[j]) && j != green) {
                                wordVal.remove(entry.getKey());
                            }
                        }
                    }

                }
            }
            if (Objects.equals(letter3Val, "grey")) {
                for (Entry<String, Integer> entry : wordVal.entrySet()) {
                    String[] tempWord = entry.getKey().split("");
                    int green = -1;
                    int yellow = -1;
                    boolean YellowBol = false;

                    if ((Objects.equals(letter3, letter1)) && ((Objects.equals(letter1Val, "green")))) {
                        green = 0;
                    }
                    if ((Objects.equals(letter3, letter1)) && (Objects.equals(letter1Val, "yellow"))) {
                        yellow = 0;
                        YellowBol = true;

                    }
                    if ((Objects.equals(letter3, letter2)) && ((Objects.equals(letter2Val, "green")))) {
                        green = 1;
                    }
                    if ((Objects.equals(letter3, letter2)) && (Objects.equals(letter2Val, "yellow"))) {
                        yellow = 1;
                        YellowBol = true;

                    }
                    if ((Objects.equals(letter3, letter4)) && ((Objects.equals(letter4Val, "green")))) {
                        green = 3;
                    }
                    if ((Objects.equals(letter3, letter4)) && (Objects.equals(letter4Val, "yellow"))) {
                        yellow = 3;
                        YellowBol = true;

                    }
                    if ((Objects.equals(letter3, letter5)) && ((Objects.equals(letter5Val, "green")))) {
                        green = 4;
                    }
                    if ((Objects.equals(letter3, letter5)) && (Objects.equals(letter5Val, "yellow"))) {
                        yellow = 4;
                        YellowBol = true;

                    }

                    //if yellow occurs before or after letter
                    if (YellowBol) {
                        for (int j = 0; j < 5; j++) {
                            if (letter3.equals(tempWord[yellow])) {
                                wordVal.remove(entry.getKey());
                            }
                            if (letter3.equals(tempWord[2])) {
                                wordVal.remove(entry.getKey());
                            }
                        }
                    }
                    //if green occurs before or after letter
                    if (!YellowBol) {
                        for (int j = 0; j < 5; j++) {
                            if (letter3.equals(tempWord[j]) && j != green) {
                                wordVal.remove(entry.getKey());
                            }
                        }
                    }
                }
            }
            if (Objects.equals(letter4Val, "grey")) {
                for (Entry<String, Integer> entry : wordVal.entrySet()) {
                    String[] tempWord = entry.getKey().split("");
                    int green = -1;
                    int yellow = -1;
                    boolean YellowBol = false;

                    if ((Objects.equals(letter4, letter1)) && ((Objects.equals(letter1Val, "green")))) {
                        green = 0;
                    }
                    if ((Objects.equals(letter4, letter1)) && (Objects.equals(letter1Val, "yellow"))) {
                        yellow = 0;
                        YellowBol = true;

                    }
                    if ((Objects.equals(letter4, letter2)) && ((Objects.equals(letter2Val, "green")))) {
                        green = 1;
                    }
                    if ((Objects.equals(letter4, letter2)) && (Objects.equals(letter2Val, "yellow"))) {
                        yellow = 1;
                        YellowBol = true;

                    }
                    if ((Objects.equals(letter4, letter3)) && ((Objects.equals(letter3Val, "green")))) {
                        green = 2;
                    }
                    if ((Objects.equals(letter4, letter3)) && (Objects.equals(letter3Val, "yellow"))) {
                        yellow = 2;
                        YellowBol = true;

                    }
                    if ((Objects.equals(letter4, letter5)) && ((Objects.equals(letter5Val, "green")))) {
                        green = 4;
                    }
                    if ((Objects.equals(letter4, letter5)) && (Objects.equals(letter5Val, "yellow"))) {
                        yellow = 4;
                        YellowBol = true;

                    }


                    //if yellow occurs before or after letter
                    if (YellowBol) {
                        for (int j = 0; j < 5; j++) {
                            if (letter4.equals(tempWord[yellow])) {
                                wordVal.remove(entry.getKey());
                            }
                            if (letter4.equals(tempWord[3])) {
                                wordVal.remove(entry.getKey());
                            }
                        }
                    }
                    //if green occurs before or after letter
                    if (!YellowBol) {
                        for (int j = 0; j < 5; j++) {
                            if (letter4.equals(tempWord[j]) && j != green) {
                                wordVal.remove(entry.getKey());
                            }
                        }
                    }

                }
            }

            if (Objects.equals(letter5Val, "grey")) {
                for (Entry<String, Integer> entry : wordVal.entrySet()) {
                    String[] tempWord = entry.getKey().split("");
                    int green = -1;
                    int yellow = -1;
                    boolean YellowBol = false;

                    if ((Objects.equals(letter5, letter1)) && ((Objects.equals(letter1Val, "green")))) {
                        green = 0;
                    }
                    if ((Objects.equals(letter5, letter1)) && (Objects.equals(letter1Val, "yellow"))) {
                        yellow = 0;
                        YellowBol = true;
                    }

                    if ((Objects.equals(letter5, letter2)) && ((Objects.equals(letter2Val, "green")))) {
                        green = 1;
                    }
                    if ((Objects.equals(letter5, letter2)) && (Objects.equals(letter2Val, "yellow"))) {
                        yellow = 1;
                        YellowBol = true;
                    }
                    if ((Objects.equals(letter5, letter3)) && ((Objects.equals(letter3Val, "green")))) {
                        green = 2;
                    }
                    if ((Objects.equals(letter5, letter3)) && (Objects.equals(letter3Val, "yellow"))) {
                        yellow = 2;
                        YellowBol = true;
                    }
                    if ((Objects.equals(letter5, letter4)) && ((Objects.equals(letter4Val, "green")))) {
                        green = 3;
                    }
                    if ((Objects.equals(letter5, letter4)) && (Objects.equals(letter4Val, "yellow"))) {
                        yellow = 3;
                        YellowBol = true;
                    }
                    //if yellow occurs before or after letter
                    if (YellowBol) {
                        for (int j = 0; j < 5; j++) {
                            if (letter5.equals(tempWord[yellow])) {
                                wordVal.remove(entry.getKey());
                            }
                            if (letter5.equals(tempWord[4])) {
                                wordVal.remove(entry.getKey());
                            }
                        }
                    }
                    if (!YellowBol) {
                        for (int j = 0; j < 5; j++) {
                            if (letter5.equals(tempWord[j]) && j != green) {
                                wordVal.remove(entry.getKey());
                            }
                        }
                    }


                }
            }
            //////////Yellow////////
            if (Objects.equals(letter1Val, "yellow")) {

                for (Entry<String, Integer> entry : wordVal.entrySet()) {
                    String[] tempWord = entry.getKey().split("");
                    if (letter1.equals(tempWord[0])) wordVal.remove(entry.getKey());
                    int ocur = 0;
                    for (int j = 1; j < 5; j++) {
                        if (letter1.equals(tempWord[j])) {
                            ocur++;
                        }
                    }
                    if (ocur == 0) {
                        wordVal.remove(entry.getKey());
                    }

                }
            }
            if (Objects.equals(letter2Val, "yellow")) {

                for (Entry<String, Integer> entry : wordVal.entrySet()) {
                    String[] tempWord = entry.getKey().split("");
                    if (letter2.equals(tempWord[1])) wordVal.remove(entry.getKey());

                    tempWord[1] = "null";
                    int ocur = 0;
                    for (int j = 0; j < 5; j++) {
                        if (letter2.equals(tempWord[j])) {
                            ocur++;
                        }
                    }
                    if (ocur == 0) {
                        wordVal.remove(entry.getKey());
                    }

                }
            }
            if (Objects.equals(letter3Val, "yellow")) {

                for (Entry<String, Integer> entry : wordVal.entrySet()) {
                    String[] tempWord = entry.getKey().split("");
                    if (letter3.equals(tempWord[2])) wordVal.remove(entry.getKey());
                    ;
                    tempWord[2] = "null";
                    int ocur = 0;
                    for (int j = 0; j < 5; j++) {
                        if (letter3.equals(tempWord[j])) {
                            ocur++;
                        }
                    }
                    if (ocur == 0) {
                        wordVal.remove(entry.getKey());
                        ;
                    }

                }
            }
            if (Objects.equals(letter4Val, "yellow")) {

                for (Entry<String, Integer> entry : wordVal.entrySet()) {
                    String[] tempWord = entry.getKey().split("");
                    if (letter4.equals(tempWord[3])) wordVal.remove(entry.getKey());
                    ;
                    tempWord[3] = "null";
                    int ocur = 0;
                    for (int j = 0; j < 5; j++) {
                        if (letter4.equals(tempWord[j])) {
                            ocur++;
                        }
                    }
                    if (ocur == 0) {
                        wordVal.remove(entry.getKey());
                        ;
                    }

                }
            }
            if (Objects.equals(letter5Val, "yellow")) {

                for (Entry<String, Integer> entry : wordVal.entrySet()) {
                    String[] tempWord = entry.getKey().split("");
                    if (letter3.equals(tempWord[4])) wordVal.remove(entry.getKey());
                    ;
                    tempWord[4] = "null";
                    int ocur = 0;
                    for (int j = 0; j < 5; j++) {
                        if (letter5.equals(tempWord[j])) {
                            ocur++;
                        }
                    }
                    if (ocur == 0) {
                        wordVal.remove(entry.getKey());

                    }

                }
            }

            //System.out.println(wordVal);

            // max word value;
            System.out.println(wordVal);
            String key = Collections.max(wordVal.entrySet(), Map.Entry.comparingByValue()).getKey();
            System.out.println("I would reccomend " + key);
            guesses++;
        }
    }
}
