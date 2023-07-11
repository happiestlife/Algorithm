class Solution {
    
    private long width;
    private long height;
    
    public long solution(long w, long h) {
        width = w;
        height = h;
        
        long cnt = w * h;
        long x = 1;
        while(x <= w){
            double sy = getY(x-1);
            double ey = getY(x);
            
            long startY = (long) Math.floor(sy);
            long endY = (long) Math.ceil(ey);
            
            cnt -= endY - startY;
            x++;
        }
        
        return cnt;
    }
    
    public double getY(long x){
        return (double)height * x / width;
    }
}