import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final Point[][] BLOCKS = {
                {new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0)},
                {new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(1, 1)},
                {new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(1, 2)},
                {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)},
                {new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 0)}
        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < map.length; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < BLOCKS.length; i++) {
            // 1. 원본에 대한 최대값 구하기
            max = Math.max(max, getOriginMaxSum(map, BLOCKS[i]));

            // 2. x축 대칭에 대한 최대값 구하기
            max = Math.max(max, getXSymmetryMaxSum(map, BLOCKS[i]));

            // 3. y축 대칭에 대한 최대값 구하기
            max = Math.max(max, getYSymmetryMaxSum(map, BLOCKS[i]));

            // 4. (0, 0) 점 대칭에 대한 최대값 구하기
            max = Math.max(max, getDotSymmetryMaxSum(map, BLOCKS[i]));
        }

        System.out.println(max);


        br.close();
    }

    private static int getOriginMaxSum(int[][] map, Point[] block) {
        Point[] originBlock = block;
        Point[] convertedBlock = getCrossSymmetryBlock(block);

        int originMax = getMaxSum(map, originBlock);

        int convertedMax = getMaxSum(map, convertedBlock);

        return Math.max(originMax, convertedMax);
    }

    // 각 함수들에서는 자신의 블록 및 y=x 대칭 블록에 대해서도 구한다.
    private static int getXSymmetryMaxSum(int[][] map, Point[] block){
        // 1. x축 대칭 블럭 및 그 블럭을 y=x 축으로 대칭시킨 블럭 생성
        Point[] symmetryBlock = getXSymmetryBlock(block);
        Point[] convertedSymmetryBlock = getCrossSymmetryBlock(symmetryBlock);

        // 2. x축 대칭 블럭 max sum 구하기
        int symmetryMax = getMaxSum(map, symmetryBlock);

        // 3. y=x 축으로 대칭 블럭 max sum 구하기
        int convertedSymmetryMax = getMaxSum(map, convertedSymmetryBlock);

        return Math.max(symmetryMax, convertedSymmetryMax);
    }

    private static int getYSymmetryMaxSum(int[][] map, Point[] block){
        Point[] symmetryBlock = getYSymmetryBlock(block);
        Point[] convertedSymmetryBlock = getCrossSymmetryBlock(symmetryBlock);

        int symmetryMax = getMaxSum(map, symmetryBlock);

        int convertedSymmetryMax = getMaxSum(map, convertedSymmetryBlock);

        return Math.max(symmetryMax, convertedSymmetryMax);
    }

    private static int getDotSymmetryMaxSum(int[][] map, Point[] block){
        Point[] symmetryBlock = getYSymmetryBlock(getXSymmetryBlock(block));
        Point[] convertedSymmetryBlock = getCrossSymmetryBlock(symmetryBlock);

        int symmetryMax = getMaxSum(map, symmetryBlock);

        int convertedSymmetryMax = getMaxSum(map, convertedSymmetryBlock);

        return Math.max(symmetryMax, convertedSymmetryMax);
    }

    private static Point[] getXSymmetryBlock(Point[] block){
        Point[] newBlock = new Point[block.length];

        // 1. x 축 대칭시키기 ( y -> -y )
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < block.length; i++) {
            newBlock[i] = new Point(block[i].x, block[i].y * -1);
            min = Math.min(min, newBlock[i].y);
        }

        // 2. 가장 작은 y 음수를 0으로 만드는 수를 모든 좌표에 더하기
        min *= -1;
        for (int i = 0; i < newBlock.length; i++) {
            newBlock[i].y += min;
        }

        return newBlock;
    }

    private static Point[] getYSymmetryBlock(Point[] block) {
        Point[] newBlock = new Point[block.length];

        // 1. y 축 대칭시키기 ( x -> -x )
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < block.length; i++) {
            newBlock[i] = new Point(block[i].x * -1, block[i].y);
            min = Math.min(min, newBlock[i].x);
        }

        // 2. 가장 작은 x 음수를 0으로 만드는 수를 모든 좌표에 더하기
        min *= -1;
        for (int i = 0; i < newBlock.length; i++) {
            newBlock[i].x += min;
        }

        return newBlock;
    }

    private static Point[] getCrossSymmetryBlock(Point[] block) {
        Point[] newBlock = new Point[block.length];

        // 1. x와 y 반전
        for (int i = 0; i < block.length; i++) {
            newBlock[i] = new Point(block[i].y, block[i].x);
        }

        return newBlock;
    }

    private static int getMaxSum(int[][] map, Point[] block) {
        int max = 0;
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                int curSum = 0;
                boolean canUseBlockHere = true;
                for (int k = 0; k < block.length; k++) {
                    int fx = x + block[k].x;
                    int fy = y + block[k].y;

                    if (fx < 0 || fx >= map.length ||
                            fy < 0 || fy >= map[fx].length) {
                        canUseBlockHere = false;
                        break;
                    }
                    curSum += map[fx][fy];
                }

                if (canUseBlockHere) {
                    max = Math.max(max, curSum);
                }
            }
        }

        return max;
    }

}