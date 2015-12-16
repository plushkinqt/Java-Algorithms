package algorithms;

/**
 * Find maximum sum-distance value of an array
 * like array[a] + array[b] + (a - b)
 */
public class Task3 {

    public int solution(int[] array){
        int a = array[0];
        int indA = 0;
        int b = array[0];
        int indB = 0;
        for(int i = 0; i < array.length; i++){
            if(i + array[i] > a + indA){
                a = array[i] + i;
                indA = i;
            }
            if(array[i] - i > b  - indB && i <= indA){
                b = array[i];
                indB = i;
            }
        }
        return a + b + indA - indB;
    }
}
