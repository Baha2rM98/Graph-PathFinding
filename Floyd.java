import java.util.Scanner;


/**Created by Baha2r **/


public class Floyd {
    private static int[][] p;
    private static int[][] dis;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();

        /**Default graph you can change it**/

        final int INF = Integer.MAX_VALUE / 2;
        int[][] graph = {{0, 5, INF, 2, INF},
                {INF, 0, 2, INF, INF},
                {3, INF, 0, INF, 7},
                {INF, INF, 4, 0, 1},
                {1, 3, INF, INF, 0},

        };

        floydWarshalll(graph);
        System.out.print(a + " "); //print the source
        path(a, b); //print path
        System.out.print(b + " " + " \n"); //print destination
        System.out.println(dis[a][b]); //print length of path
    }

    private static void floydWarshalll(int graph[][]) {
        int n = graph.length;
        dis = graph.clone();
        p = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = -1;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dis[i][j] > dis[i][k] + dis[k][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                        p[i][j] = k;
                    }
                }
            }
        }
    }

    private static void path(int i, int j) {
        if (p[i][j] != -1) {
            path(i, p[i][j]);
            System.out.print(p[i][j] + " ");
            path(p[i][j], j);
        }
    }
}