package MovieTime;

import java.util.*;

public class MovieTime{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("movie time");
        int[] showtime = new int[0];
        int newShowtime = sc.nextInt();
        int[] updatedShowtimes = new int[showtime.length + 1];
        for (int i = 0; i < showtime.length; i++){
            updatedShowtimes[i] = showtime[i];
        }
        updatedShowtimes[updatedShowtimes.length - 1] = newShowtime;

        for (int i = 1; i < updatedShowtimes.length; i++){
            int key = updatedShowtimes[i];
            int j = i - 1;
            while (j >= 0 && updatedShowtimes[j] > key){
                updatedShowtimes[j + 1] = updatedShowtimes[j];
                j--;
            }
            updatedShowtimes[j + 1] = key;
        }
        System.out.println("Updated Movie Showtimes:");
        for (int time : updatedShowtimes) {
            System.out.printf("%04d hrs\n", time);
        }
    }
}