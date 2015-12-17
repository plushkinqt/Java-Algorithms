package algorithms;

/**
 * Find number in array that does not have a duplicate
 * while all other numbers have
 */
public class Task4 {

    public int solution(int[] array){
        int temp = 0;
        for (int i = 0; i < array.length; i++){
            temp ^= array[i];
        }
        return temp;
    }
}
