public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) { return 0 ;}
        
        int min_length = m.length + 1 ;

        for (int index = 0 ; index < m.length ; index ++) {
            int curr = 0 ;
            if (m[i][index] != 0) {
                m[i][index] = 0 ;
                int res = findShortestPath(m, index, j) ;
                m[i][index] = 1 ;
                if (res == -1) {continue ;} 
                curr += (1 + res) ;
                if (curr < min_length) {min_length = curr ;}
            }
        }

        if (min_length != m.length + 1) return min_length ; 

        return -1 ;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}