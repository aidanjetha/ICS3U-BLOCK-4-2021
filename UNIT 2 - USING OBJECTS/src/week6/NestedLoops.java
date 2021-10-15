package week6;

public class NestedLoops {
    public static void main(String[] args) {
        // exampleOne();
        // framingSquares(2,3,2,3);
        //wordFrame("CANADA");
        //diamondCanada("CANADA");
        
        int num = 90;
        System.out.println(num % 10);
    }

    private static void diamondCanada(String str) {
        for (int i = 0; i < str.length() - 1; i++){
            System.out.print(" ");

        }
        System.out.println(str.substring(0,1));

        for (int i = 1; i < str.length(); i++){
            for (int j = 0; j < str.length() - 1 - i; j++){
                System.out.print(" ");
            }
            System.out.print(str.substring(i, i + 1));
        }
    }

    private static void wordFrame(String str) {
        System.out.println("*" + str + "*");

        for (int i = 0; i < str.length(); i++){
            String start = str.substring(i, i + 1);
            String end = str.substring(str.length()- i - 1);

            System.out.print(end);
            for (int j = 0; j<str.length(); j++){
                System.out.print("*");
            }
            System.out.println(start);
        }

        System.out.print("*");
        
        for (int i = str.length() -1; i >= 0; i++){
            System.out.println(str.substring(i, i+1));
        }


        System.out.println("*");
    }

    private static void framingSquares(int M, int N, int P, int Q) {
        for (int i = 0; i < Q; i++) {
            for (int j = 0; j < 2 * P + 2 * Q + N; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        for (int i = 0; i < P; i++) {
            for (int j = 0; j < Q; j++) {
                System.out.print("#");
            }
            for (int j = 0; j < 2 * P + N; j++) {

            }
        }
    }

    private static void exampleOne() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%5d", (i * j));
            }
            System.out.println();
        }
    }
}
