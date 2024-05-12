package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class TaskThree {
    static class Point {
        int x, y, dist;
        boolean wallRemoved;

        Point(int x, int y, int dist, boolean wallRemoved) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wallRemoved = wallRemoved;
        }
    }

    public static int solution(int[][] map) {
        int rows = map.length;
        int cols = map[0].length;
        boolean[][][] visited = new boolean[rows][cols][2];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            if (curr.x == rows - 1 && curr.y == cols - 1) return curr.dist;

            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for (int[] dir : directions) {
                int newX = curr.x + dir[0];
                int newY = curr.y + dir[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                    if (map[newX][newY] == 0 && !visited[newX][newY][curr.wallRemoved ? 1 : 0]) {
                        queue.add(new Point(newX, newY, curr.dist + 1, curr.wallRemoved));
                        visited[newX][newY][curr.wallRemoved ? 1 : 0] = true;
                    } else if (!curr.wallRemoved && map[newX][newY] == 1) {
                        queue.add(new Point(newX, newY, curr.dist + 1, true));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] map1 = {
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        System.out.println(solution(map1));

        int[][] map2 = {
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 1, 0}
        };
        System.out.println(solution(map2));
    }
}
