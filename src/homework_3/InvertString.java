package homework_3;

/**
 * @autor Kunakbaev Artem
 */
public class InvertString {
    private String str;

    public InvertString(String str) {
        this.str = str;
    }

    public String invert() {
        char[] chars = str.toCharArray();
        StringBuilder invertString = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            invertString.append(chars[i]);
        }
        return invertString.toString();
    }
}

