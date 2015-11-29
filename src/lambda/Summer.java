package lambda;

import java.util.List;

/**
 *Write a function, that takes as an input a list of integers and returns a sum of all even integers in the list.
 *You are not allowed to use any kind of loops and you have to do all additions by using + operator.
 *Function's Big-O time complexity must be O(N).
 * 
 */
public class Summer {
    
    public long sumOfEven(List<Integer> list){
        if(list == null){
            return 0;
        }
        long even = list
                .stream()
                .filter(b -> b%2 == 0)
                .mapToInt(Integer::intValue)
                .reduce( 0, (a, b) -> a + b);
        return even;
    }
    
}
