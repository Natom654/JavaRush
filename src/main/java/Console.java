import java.io.IOException;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) throws IOException {

        FileApplication fileApplication = new FileApplication();
        Cipher cipher = new Cipher();
        CipherEN cipherEN = new CipherEN();
        String text;

        Scanner console = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Choose what do you want to do with the text?");
        System.out.println("Write  e - for ENCRYPT, d - for DECRYPT, b - for BRUTE_FORCE");
        String command = console.nextLine();

        System.out.println("Write path to the file");
        String path = console.nextLine();

        System.out.println("What is text language?");
        System.out.println("Write  ua - for UKRAINIAN,en - for ENGLISH");

        String language = console.nextLine();


        try {
            text = fileApplication.readFile(path);

            if (command.equalsIgnoreCase("E")) {
                System.out.println("Write key for cipher");
                int key = console.nextInt();
                String pathForEncryptCipher = fileApplication.giveNewFileName(path, Command.ENCRYPTED);

                try {
                    if (language.equalsIgnoreCase("UA")) {
                        fileApplication.writeFile(pathForEncryptCipher, cipher.encryptText(text, key));

                    } else if (language.equalsIgnoreCase("EN")) {
                        fileApplication.writeFile(pathForEncryptCipher, cipherEN.encryptTextEn(text, key));
                    }
                    System.out.println("Successfully written Message to the file");
                } catch (IOException e) {
                    System.out.println("There is no file to write");
                }

            } else if (command.equalsIgnoreCase("D")) {
                System.out.println("Write key for cipher");
                int key = console.nextInt();

                String pathForDecryptCipher = fileApplication.giveNewFileName(path, Command.DECRYPTED);

                try {
                    if (language.equalsIgnoreCase("UA")) {
                        fileApplication.writeFile(pathForDecryptCipher, cipher.decryptText(text, key));

                    } else if (language.equalsIgnoreCase("EN")) {
                        fileApplication.writeFile(pathForDecryptCipher, cipherEN.decryptTextEn(text, key));
                    }
                    System.out.println("Successfully written Message to the file");
                } catch (IOException e) {
                    System.out.println("There is no file to write");
                }
            } else if (command.equalsIgnoreCase("B")) {

                String pathForBruteForceCipher = fileApplication.giveNewFileName(path, Command.BRUTE_FORCE);
                try {
                    if (language.equalsIgnoreCase("UA")) {
                        fileApplication.writeFile(pathForBruteForceCipher, cipher.bruteForceText(text));
                    } else if (language.equalsIgnoreCase("EN")) {
                        fileApplication.writeFile(pathForBruteForceCipher, cipherEN.bruteForceTextEn(text));
                    }
                    System.out.println("Successfully written Message to the file");
                } catch (IOException e) {
                    System.out.println("There is no file to write");
                }

            } else {
                System.out.println(" your сhoice is wrong");
            }
        } catch (IOException e) {
            System.out.println("There is no file on this path");
        }
        console.close();
    }
}


