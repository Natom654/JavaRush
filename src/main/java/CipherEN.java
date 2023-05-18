import java.util.Arrays;
import java.util.List;

public class CipherEN {
    String alphabetUpEN = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String alphabetLitEN = "abcdefghijklmnopqrstuvwxyz";

    public String encryptTextEn(String text, int key) {
        String encryptText = "";
        for (int i = 0; i < text.length(); i++)
            if (Character.isLetter(text.charAt(i))) {
                if (Character.isUpperCase(text.charAt(i))) {
                    int charPosition = alphabetUpEN.indexOf(text.charAt(i));
                    int keyValue = (key + charPosition) % alphabetUpEN.length();
                    char replace = alphabetUpEN.charAt(keyValue);
                    encryptText += replace;
                } else if (Character.isLowerCase(text.charAt(i))) {
                    int charPosition = alphabetLitEN.indexOf(text.charAt(i));
                    int keyValue = (key + charPosition) % alphabetLitEN.length();
                    char replace = alphabetLitEN.charAt(keyValue);
                    encryptText += replace;
                }
            } else {
                encryptText += text.charAt(i);
            }
        System.out.println(encryptText);
        return encryptText;
    }

    public String decryptTextEn(String text, int key) {
        return encryptTextEn(text, 26 - (key % 26));
    }

    public String bruteForceTextEn(String text) {
        int key;
        String textUp = text.toUpperCase();
        char newChar;
        StringBuilder sbdecrypt = new StringBuilder(textUp);

        for (key = 1; key < 27; key++) {

            sbdecrypt = new StringBuilder(textUp);
            for (int i = 0; i < sbdecrypt.length(); i++) {

                char currentchar = sbdecrypt.charAt(i);

                int index = alphabetUpEN.indexOf(currentchar);

                if (index != -1) {
                    index = index - key;

                    if (index < 0) {
                        index = index + 26;

                        newChar = alphabetUpEN.charAt(index);
                        sbdecrypt.setCharAt(i, newChar);
                    } else {
                        newChar = alphabetUpEN.charAt(index);
                        sbdecrypt.setCharAt(i, newChar);
                    }
                }
            }
            System.out.println("Key: " + key + " Decrypted String: " + sbdecrypt);
        }
        return sbdecrypt.toString();
    }
}






