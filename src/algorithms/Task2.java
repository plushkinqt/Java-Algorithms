package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Find number of identical pairs of indices
 * if number of pairs is more then 1,000,000,000 return 1,000,000,000
 */
public class Task2 {
    
    public int calculate(int[] array){
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < array.length; i++){
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i]) + 1);
                count += map.get(array[i]);
                if(count >= 1000000000){
                    return 1000000000;
                }
            } else {
                map.put(array[i], 0);
            }
        }
        return count;
    }
}
