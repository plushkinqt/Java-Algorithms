package lambda;

import java.util.List;

/**
 *
 * @author Yevgen Zinchenko
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
    /**
     * This function is O(N) (linear)
     * 
     * Time complexity is good, because when we double number of elements in the list computation time is doubled.
     * 
     * Space complexity: reduce function returns a new value every time when it makes an operation, so this program space
     * complexity might be improved if reduce function added values to the same variable.
     * 
     */
}
