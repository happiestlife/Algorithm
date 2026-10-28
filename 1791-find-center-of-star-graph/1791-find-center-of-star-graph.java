class Solution {
    public int findCenter(int[][] edges) {
        int[] cnt = new int[edges.length + 2];
        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int nodeX = edge[0], nodeY = edge[1];  
            cnt[nodeX]++;
            cnt[nodeY]++;

            if(cnt[nodeX] == edges.length) return nodeX;
            if(cnt[nodeY] == edges.length) return nodeY; 
        }

        return -1;
    }
}