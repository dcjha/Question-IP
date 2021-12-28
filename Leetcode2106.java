class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        
        
        int[] f = new int[fruits[fruits.length-1][0] + 1];
        if(startPos > f.length - 1){
            int minMoveRequired =  startPos -(f.length - 1); 
            k = k - minMoveRequired ;
            startPos = f.length-1;
            if(k<0){
                return 0;
            }
        }
        
        for(int[] ele : fruits){
            f[ele[0]] = ele[1];
        }
        
        int[] psa = new int[f.length];
        psa[0] = f[0];
        for(int i = 1 ; i < f.length ; i++){
            psa[i] = psa[i-1] + f[i];
        }
        int maxFruits = 0; 
        
        for(int step = 0 ; step <= k ; step++){
             //first right then left
            int ri = startPos + step;
            int li = ri - (k-step);
            if(li > startPos){
                li = startPos;
            }
            if(li < 0){
                li = 0;
            }
            if(ri >= f.length){
                ri = f.length -1;
            }
            int fruitInRange = psa[ri] - (li-1 >= 0 ? psa[li-1] : 0);
            if(fruitInRange > maxFruits){
                maxFruits = fruitInRange;
            }
            //first left then right       
            li = startPos - step; 
            ri = li + (k-step);     
            if(li < 0){
                li = 0;
            }
            if(ri < startPos){
                ri = startPos;
            }
            if(ri >= f.length){
                ri = f.length -1;
            }
            fruitInRange = psa[ri] - (li-1 >= 0 ? psa[li-1] : 0);
            if(fruitInRange > maxFruits){
                maxFruits = fruitInRange;
            }
        }
        
        return maxFruits;
        
    }
}
