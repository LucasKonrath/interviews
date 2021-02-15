package exercise8;

public class ReverseString {

    public String reverse_words(String sentence){
        String[] string = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < string.length; i++){
            sb.append(" ").append(string[string.length - i - 1]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverse_words("Hello World"));
    }
}
