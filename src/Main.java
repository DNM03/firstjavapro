import javax.sound.midi.SysexMessage;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static boolean checkequal(int n, int arr[]){
        for(int i = 0; i < arr.length;i++){
            if(n == arr[i])
                return true;
        }
        return false;
    }

    public static int compare(int arr1[], int arr2[]){
        int sum = 0;
        for(int i = 0; i < arr1.length;i++){
            for(int j = 0; j < arr2.length;j++){
                if(arr1[i] == arr2[j]){
                    sum++;
                }
            }
        }
        return sum;
    }

    public static boolean check(int arr[]){
        for(int i = 0; i < 5; i++){
            for(int j = i + 1; j < 6; j++){
                if(arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int winningtickets[] = {-1, -1, -1, -1, -1, -1};
        for(int i = 0; i < 6; i++){
            int randnum = rand.nextInt(1, 10);
            if(checkequal(randnum, winningtickets)) {
                i--;
            }
            else{
                winningtickets[i] = randnum;
            }
        }
        System.out.println("How many games do you want to play?");
        int Numofgames = sc.nextInt();
        if(Numofgames == 1) {
            System.out.println("True/false?");
            sc.nextLine();
            String tf = sc.nextLine();
            String t = "true", f = "false";
            if (tf.equals(t)) {
                System.out.println("Enter 6 nums: ");
                int yourtickets[] = {-1, -1, -1, -1, -1, -1};
                do {
                    for (int i = 0; i < 6; i++) {
                        yourtickets[i] = sc.nextInt();
                    }
                    if(check(yourtickets)){
                        System.out.println("Nhap lai");
                    }
                }
                while(check(yourtickets));
                System.out.println("your: ");
                for (int i = 0; i < 6; i++) {
                    System.out.print(yourtickets[i] + " ");
                }
                System.out.println("winning: ");
                for (int i = 0; i < 6; i++) {
                    System.out.print(winningtickets[i] + " ");
                }
                System.out.println("matched: " + compare(winningtickets, yourtickets));
            }
            else {
                int yourtickets[] = {-1, -1, -1, -1, -1, -1};
                for (int i = 0; i < 6; i++) {
                    int randnum = rand.nextInt(1, 10);
                    if(checkequal(randnum, yourtickets)) {
                        i--;
                    }
                    else{
                        yourtickets[i] = randnum;
                    }
                }
                System.out.println("your: ");
                for (int i = 0; i < 6; i++) {
                    System.out.print(yourtickets[i] + " ");
                }
                System.out.println("winning: ");
                for (int i = 0; i < 6; i++) {
                    System.out.print(winningtickets[i] + " ");
                }
                System.out.println("matched: " + compare(winningtickets, yourtickets));
            }
        }
        else{
            int sumwingames = 0;
            int summoney = 0;
            int sum6match = 0;
            for(int i = 0; i < Numofgames; i++){
                int yourtickets[] = {-1, -1, -1, -1, -1, -1};
                for (int j = 0; j < 6; j++) {
                    int randnum = rand.nextInt(1, 10);
                    if(checkequal(randnum, yourtickets)) {
                        j--;
                    }
                    else{
                        yourtickets[j] = randnum;
                    }
                }
                int temp = compare(winningtickets, yourtickets);
                if(temp != 0){
                    sumwingames++;
                    if(temp == 1 || temp == 2){
                        summoney += 10;
                    }
                    else if(temp == 3){
                         summoney += 100;
                    }
                    else if(temp == 4){
                        summoney += 1000;
                    }
                    else if(temp == 5){
                        summoney += 5000;
                    }
                    else if(temp == 6){
                        summoney += 5000000;
                        sum6match++;
                    }
                }
                System.out.println();
                System.out.println("your: ");
                for (int k = 0; k < 6; k++) {
                    System.out.print(yourtickets[k] + " ");
                }

            }
            System.out.println();
            System.out.println("winning: ");
            for (int k = 0; k < 6; k++) {
                System.out.print(winningtickets[k] + " ");
            }
            System.out.println("win: " + sumwingames);
            System.out.println("win 6: " + sum6match);
            System.out.println("money: " + summoney);
        }
    }
}