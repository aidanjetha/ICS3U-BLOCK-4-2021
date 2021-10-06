package week5;

public class FormattingStrings {
    public static void main(String[] args) {
        //s:7.345

        //WE WANT THIS s:07.345


        int minutes = 5;
        double seconds = 7.545764;
        

        System.out.println(minutes + ":" + seconds);

        //Placeholder
        // %d -> placeholder for integers
        // %s -> Placeholder for strings 
        // %f -> Placeholder for doubles
        System.out.printf("%d:%06.3f", minutes, seconds);

    }
}
