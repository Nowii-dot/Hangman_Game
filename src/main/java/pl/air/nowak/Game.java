package pl.air.nowak;

import java.util.*;
import java.lang.Character;

public class Game {

    private List<String> Cars = List.of("bwm", "audi", "wheel", "fuel", "mercedes");
    private List<String> Animal = List.of("dog", "cat", "lion", "owl", "duck");
    private List<String> Profession = List.of("miner", "firefighter", "doctor");


    private String word;
    private int hp = 3;
    private char[] userWord;

    //funkcja obsługująca całą grę
    public void ChooseCategory(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose Category");
            System.out.println("1. Cars");
            System.out.println("2. Animal");
            System.out.println("3. Profession");
            System.out.println("4. End Game");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> PlayGame(Cars);
                case 2 -> PlayGame(Animal);
                case 3 -> PlayGame(Profession);
                case 4 -> {
                    scanner.close();
                    System.exit(0);
                }
            }

        }
    }
    public void PlayGame(List NameCategory){
        Scanner scanner = new Scanner(System.in);
        Random randomWord = new Random();


        word  = NameCategory.get(randomWord.nextInt(NameCategory.size())).toString();
        System.out.println(word);

        userWord = new char[word.length()];
        Arrays.fill(userWord, '_');

        while (!gameEnded())
        {
            System.out.println(userWord);
            System.out.println("Word lenght: "+ word.length());
            System.out.println("Your Hp: " + hp);
            System.out.println();
            System.out.print("Enter the letter:");
            char letter = scanner.nextLine().charAt(0);
            char lowLetter = Character.toLowerCase(letter);


            checkLetter(lowLetter);
            gameEnded();

        }
        if(hp == 0){
            System.out.println("Game Over :(");
            System.out.println(word);
        }
        else
        {
            System.out.println("Congratulations you won :)");
        }


    }

    //funkcja sprawdzająca poprawność literki w słowie
    private void checkLetter(char letter) {

        boolean foundLetter = false;
        for (int i=0; i<word.length(); i++)
        {

            if(word.charAt(i)==letter) {
                userWord[i] = letter;
                foundLetter = true;
            }
        }
        if(!foundLetter) {
            hp--;
        }
    }

    private boolean gameEnded() {
        return hp == 0 ||  word.equals(String.valueOf(userWord));
    }
}
