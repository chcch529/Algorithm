import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];

            int minDist = Integer.MAX_VALUE;

            // 왼쪽
            if (!(startY == targetY && startX > targetX)) {
                int nx = -targetX;
                int ny = targetY;
                minDist = Math.min(minDist, dist(startX, startY, nx, ny));
            }

            // 오른쪽
            if (!(startY == targetY && startX < targetX)) {
                int nx = 2 * m - targetX;
                int ny = targetY;
                minDist = Math.min(minDist, dist(startX, startY, nx, ny));
            }

            // 아래
            if (!(startX == targetX && startY > targetY)) {
                int nx = targetX;
                int ny = -targetY;
                minDist = Math.min(minDist, dist(startX, startY, nx, ny));
            }

            // 위
            if (!(startX == targetX && startY < targetY)) {
                int nx = targetX;
                int ny = 2 * n - targetY;
                minDist = Math.min(minDist, dist(startX, startY, nx, ny));
            }

            answer[i] = minDist;
        }

        return answer;
    }

    private int dist(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}
