import java.util.Arrays;
import java.util.List;

public class Cipher {
    String alphabetUp = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
    String alphabetLit = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";

    public String encryptText(String text, int key) {
        String encryptText = "";
        for (int i = 0; i < text.length(); i++)
            if (Character.isLetter(text.charAt(i))) {
                if (Character.isUpperCase(text.charAt(i))) {
                    int charPosition = alphabetUp.indexOf(text.charAt(i));
                    int keyValue = (key + charPosition) % alphabetUp.length();
                    char replace = alphabetUp.charAt(keyValue);
                    encryptText += replace;
                } else if (Character.isLowerCase(text.charAt(i))) {
                    int charPosition = alphabetLit.indexOf(text.charAt(i));
                    int keyValue = (key + charPosition) % alphabetLit.length();
                    char replace = alphabetLit.charAt(keyValue);
                    encryptText += replace;
                }
            } else {
                encryptText += text.charAt(i);
            }
        System.out.println(encryptText);
        return encryptText;
    }

    public String decryptText(String text, int key) {
        return encryptText(text, 33 - (key % 33));
    }

    public String bruteForceText(String text) {
        int key;
        String textUp = text.toUpperCase();
        char newChar;
        StringBuilder sbdecrypt = new StringBuilder(textUp);

        for (key = 1; key < 33; key++) {

            sbdecrypt = new StringBuilder(textUp);
            for (int i = 0; i < sbdecrypt.length(); i++) {

                char currentchar = sbdecrypt.charAt(i);

                int index = alphabetUp.indexOf(currentchar);

                if (index != -1) {
                    index = index - key;

                    if (index < 0) {
                        index = index + 33;

                        newChar = alphabetUp.charAt(index);
                        sbdecrypt.setCharAt(i, newChar);
                    } else {
                        newChar = alphabetUp.charAt(index);
                        sbdecrypt.setCharAt(i, newChar);
                    }
                }
            }
            System.out.println("Key: " + key + " Decrypted String: " + sbdecrypt);
        }
        return sbdecrypt.toString();
    }
}






