package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class BfsSearchMap {

    private int x;
    private int y;
    private int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int search(int[][] arr) {
        Queue<Pair> queue = new LinkedList<>();
        this.x = arr.length;
        this.y = arr[0].length;
        int check[][] = new int[this.x][this.y];

        int cur_x = 0;
        int cur_y = 0;

        queue.add(new Pair(cur_x, cur_y));
        check[cur_x][cur_y] = 1;

        while(!queue.isEmpty()) {

            cur_x = queue.peek().getX();
            cur_y = queue.peek().getY();
            queue.poll();

            for(int i = 0; i < 4; i++) {
                int next_x = cur_x + dir[i][0];
                int next_y = cur_y + dir[i][1];

                if(isArrayInside(next_x, next_y) && (check[next_x][next_y] == 0) && (arr[next_x][next_y] == 1)) {
                    check[next_x][next_y] = check[cur_x][cur_y] + 1;
                    queue.add(new Pair(next_x, next_y));
                }
            }
        }

        for(int i = 0; i < this.x; i++) {
            for(int j = 0; j < this.y; j++) {
                System.out.print(check[i][j] + " ");
            }
            System.out.println();
        }

        return check[this.x - 1][this.y - 1];
    }

    private boolean isArrayInside(int x, int y) {
        return (x >= 0 && x < this.x) && (y >= 0 && y < this.y);
    }

    class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return x; }
        public int getY() { return y; }
    }

    public static void main(String[] args) {
        BfsSearchMap b = new BfsSearchMap();
        int arr[][] = {{1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 0, 1},
                        {1, 1, 1, 0, 1}
        };

        System.out.println(b.search(arr));
    }
}