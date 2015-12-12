package algorithms;

import static java.lang.Math.floor;
/**
 * Split array into two parts and return index where number of same numbers as 
 * received parameter from right is equal to number of non equal to parameter
 * from left
 */
public class Task {
    
    public int solution(int num, int[] array){
        int l = 0;
        int r = 0;
        double half = (double)array.length/2;
        if(half != floor(half)){
            half += 1;
        }
        int h = (int)half;
        for (int i = 0; i< h; i++){
            if(array[i] == num){
                l++;
            }
            if(array[array.length - i -1] != num){
                r++;
            }
        }
        if(l > r){
            while(true){
                h--;
                if(array[h] == num){
                    l--;
                } else {
                    r++;
                }
                if (l == r){
                    return h-1;
                }
            }
        } else if(l < r){
            while(true){
                h++;
                if(array[h] == num){
                    l++;
                } else {
                    r--;
                }
                if(l == r){
                    return h - 1;
                }
            }
        } else return h - 1;
    }
}
