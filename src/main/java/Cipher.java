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
        String decryptText = " ";
        for (int i = 0; i < text.length(); i++)
            if (Character.isLetter(text.charAt(i))) {
                if (Character.isUpperCase(text.charAt(i))) {
                    int charPosition = alphabetUp.indexOf(text.charAt(i));
                    int keyValue = (charPosition - key) % alphabetUp.length();
                    if (keyValue < 0) {
                        keyValue = alphabetUp.length() + keyValue;
                    }
                    char replace = alphabetUp.charAt(keyValue);
                    decryptText += replace;
                } else if (Character.isLowerCase(text.charAt(i))) {
                    int charPosition = alphabetLit.indexOf(text.charAt(i));
                    int keyValue = (charPosition - key) % alphabetLit.length();
                    if (keyValue < 0) {
                        keyValue = alphabetLit.length() + keyValue;
                    }
                    char replace = alphabetLit.charAt(keyValue);
                    decryptText += replace;
                }
            } else {
                decryptText += text.charAt(i);
            }
        System.out.println(decryptText);
        return decryptText;
    }


    public String bruteForceText(String text) {
        String bruteForceText = "";
        for (int k = 0; k < 33; k++) {
            bruteForceText = decryptText(text, k);
            int indexSymbol = bruteForceText.indexOf(",");
            if (indexSymbol > 0) {
                String nextSymbol = bruteForceText.substring(indexSymbol + 1, indexSymbol + 2);
                System.out.println(nextSymbol);
                if (nextSymbol.equals(" ")) {
                    System.out.println("Decrypted Text Using key " + k + ":" + bruteForceText);
                    break;
                }
            }
        }
        return bruteForceText;
    }
}





