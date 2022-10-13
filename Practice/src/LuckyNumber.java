//Import necessary class
import java.util.ArrayList;
import java.util.Scanner;
public class LuckyNumber {
    //Definite necesssary variables
    public static int totalGames = 0;
    public static int guessThisRound = 0;
    public static final int MAXIMUM = 101;
    //constant for random [0-100]
    //Need for best game, average and total guess
    public static ArrayList<Integer> listGuess = new ArrayList<>();
    public static int luckyNumber = (int) Math.floor(Math.random() * MAXIMUM);
    public static void main(String[] args) {
        play();
    }

    public static void play() {
        //System.out.println(luckyNumber);
        //Dòng trên để hiển thị kết quả cho em kiểm tra code và mentor chấm bài, chạy game cho nhanh đó ạ
        //Generate input for game
        Scanner input = new Scanner(System.in);
        System.out.println("Toi dang doan mot so tu 0 den " + (MAXIMUM-1));
        System.out.print("Ban doan? ");
        //input an integer or the game will crash
        int guess = input.nextInt();
        //Count the guess
        guessThisRound++;
        //Follow the rule of game
        if (guess < luckyNumber) {
            System.out.println("So may man lon hon du doan cua ban");
            //Guess again
            play();
        }
        if (guess > luckyNumber) {
            System.out.println("So may man nho hon du doan cua ban");
            play();
        }
        if (guess == luckyNumber) {
            System.out.println("Chuc mung ban da du doan dung con so may man sau " + guessThisRound + " lan doan");
            //Save how many guess the user made this round to the list
            listGuess.add(guessThisRound);
            //Count the game
            totalGames++;
            //Ask for a new game?
            System.out.print("Ban co muon tiep tuc choi khong? ");
            String answer = input.next();
            if (answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("yes")){
                //when user types other answer, method report() will run.
                //Reset the game
                guessThisRound = 0;
                luckyNumber = (int) Math.floor(Math.random() * MAXIMUM);
                //New game
                play();
            } else {
                report();
            }
        }
    }

    public static void report(){
        int totalGuess = 0;
        int guessAvg = 0;
        int bestGame = 99999999;
        //Everyone can beat this challenge
        for (int i = 0;i<=listGuess.size()-1;i++){
            //if the number in list less than the record, it will be the new record.
            if (listGuess.get(i)<bestGame){
                bestGame= listGuess.get(i);
            }
            //Calculate the total and average
            totalGuess+=listGuess.get(i);
        }
        guessAvg = totalGuess/(listGuess.size());
        System.out.println("Tong so lan choi: " + totalGames);
        System.out.println("Tong so lan du doan: " + totalGuess);
        System.out.println("So du doan trung binh moi luot: " + guessAvg);
        System.out.println("Ban du doan nhanh nhat trong " + bestGame + " lan");
    }
    }