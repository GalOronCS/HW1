import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        int[] new_array = new int[array.length] ;

        if (array.length == 0) {return array ;}
        if (direction != 'R' && direction != 'L') {return array ;}
        if (move < 0) {direction = (direction == 'R' ? 'L' : 'R') ; move = -move ;}

        int new_move = move % (array.length) ;
        
        if (direction == 'R') {
            for (int i = array.length - new_move ; i <= array.length - 1 ; i++) {new_array[i - (array.length - new_move)] = array[i] ;}
            for (int i = 0 ; i < array.length - new_move ; i++) {new_array[i + new_move] = array[i] ;}
        } else {
            for (int i = 0 ; i < new_move ; i++) {new_array[i + (array.length - new_move)] = array[i] ;} 
            for (int i = new_move ; i <= array.length - 1 ; i++) {new_array[i - new_move] = array[i] ;}
        }

        for (int i = 0; i < array.length; i++) {array[i] = new_array[i] ;}

        return array ;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}