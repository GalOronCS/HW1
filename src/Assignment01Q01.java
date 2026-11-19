public class Assignment01Q01 {
    public static void main(String[] args) {
        for (String s : args) {
            char first_char = s.charAt(0) ;
            int ascii = (int) first_char ;
            if (ascii % 5 == 0) {
                System.out.println(first_char) ;
            }
        }
    }
}
