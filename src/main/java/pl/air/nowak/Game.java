package pl.air.nowak;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private List<String> cars = List.of("bwm", "audi", "wheel", "fuel", "mercedes");
    private String word;
    private int hp = 3;



    private char[] userWord;

    public void PlayGame(){
        Scanner scanner = new Scanner(System.in);
        Random randomWord = new Random();
        word  = cars.get(randomWord.nextInt(cars.size()));

        userWord = new char[word.length()];
        Arrays.fill(userWord, '_');

        while (!gameEnded())
        {
            System.out.print(userWord);
            System.out.print(word.length());
            System.out.println("twoje hp: " + hp);
            System.out.println();
            System.out.println("Podaj literę");
            System.out.println();
            char letter = scanner.nextLine().charAt(0);


            checkLetter(letter);
            gameEnded();

        }
        if(hp == 0){
            System.out.println("Game Over :(");
        }
        else
        {
            System.out.println("Congratulations you won :)");
        }

        scanner.close();
    }

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
