package week6;

public class practice {
    public static void main(String[] args) {
        // printBack("AIDAN");
        // removeVowels("CANADA");
        // rowsAndColums();
        // printBackWards("JETHA");
        minutesToSeconds("06:34.356");
        takeOutA("I AM SUSSY BAKA");

    }

    private static void takeOutA(String str) {
        for(int i = str.length() - 1; i >= 0)
    }

    private static void minutesToSeconds(String str) {
     int index = str.indexOf(":");

     String front = str.substring(0, index);
     String back = str.substring(index + 1);
     int frontSeconds = Integer.parseInt(front);
     frontSeconds *= frontSeconds * 60;
     Double backSeconds = Double.parseDouble(back);
     System.out.println(frontSeconds + backSeconds);
      
    
    }

    private static void rowsAndColums() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printBackWards(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            String word = str.substring(i, i + 1);
            System.out.print(word);
        }
        System.out.println();
    }

    private static void removeVowels(String str) {

        String newString = "";

        for (int i = str.length() - 1; i >= 0; i--) {

            String letter = str.substring(i, i + 1);
            if (!letter.equals("A"))
                newString += letter;
        }

        System.out.print(newString);

    }

    
}
