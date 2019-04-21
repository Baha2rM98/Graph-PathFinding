import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//Created by Baha2r//

public class Dijkstra {
    private static int[] p;
    private static int[] dis;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Default graph you can change it//

        int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        int start = scan.nextInt();
        int des = scan.nextInt();
        dijkstra(graph, start);
        System.out.println(dis[des]);
        System.out.println(path(p, des));
    }

    private static void dijkstra(int[][] graph, int src) {
        final int INF = Integer.MAX_VALUE;
        int n = graph.length, minWay, minNode, currentNode;
        p = new int[n];
        dis = new int[n];
        boolean[] isChecked = new boolean[n];
        Arrays.fill(dis, INF);
        Arrays.fill(isChecked, false);
        Arrays.fill(p, -1);
        currentNode = src;
        dis[currentNode] = 0;
        isChecked[currentNode] = true;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (!isChecked[i] && graph[currentNode][i] != 0 && graph[currentNode][i] + dis[currentNode] < dis[i]) {
                    dis[i] = graph[currentNode][i] + dis[currentNode];
                    p[i] = currentNode;
                }
            }
            minNode = -1;
            minWay = INF;
            for (int i = 0; i < n; i++) {
                if (!isChecked[i] && dis[i] < minWay) {
                    minNode = i;
                    minWay = dis[i];
                }
            }
            if (minNode == -1)
                break;
            currentNode = minNode;
            isChecked[currentNode] = true;
        }
    }

    private static ArrayList<Integer> path(int[] parent, int d) {
        ArrayList<Integer> way = new ArrayList<>();
        int i = d;
        way.add(i);
        while (parent[i] != -1) {
            way.add(parent[i]);
            i = parent[i];
        }
        Collections.reverse(way);
        return way;

    }
}
