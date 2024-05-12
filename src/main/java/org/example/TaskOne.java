package org.example;

public class TaskOne {

    public static int solution(int n) {
        int steps = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n == 3 || n % 4 == 1) {
                n -= 1;
            } else {
                n += 1;
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(15));
    }
}


