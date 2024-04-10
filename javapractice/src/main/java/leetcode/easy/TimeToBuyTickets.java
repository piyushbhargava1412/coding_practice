package main.java.leetcode.easy;

public class TimeToBuyTickets {
    public static void main(String[] args) {
        int[] tickets = {84,49,5,24,70,77,87,8};
        System.out.println(timeRequiredToBuy(tickets, 3));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int counter = 0;
        while (tickets[k] != 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    tickets[i]--;
                    counter++;
                }
                if(tickets[k] == 0) return counter;
            }
        }
        return counter;
    }
}
