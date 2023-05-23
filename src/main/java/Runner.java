import java.io.IOException;

import static java.lang.Integer.valueOf;

public class Runner {
    public void run(String[] args) {

        FileApplication fileApplication = new FileApplication();
        Cipher cipher = new Cipher();
        String text;

        if (args.length < 4 && args.length >0) {
            String command = args[0];
            String path = args[1];
            try {
                text = fileApplication.readFile(path);

                if (command.equalsIgnoreCase("E")) {
                    String key = args[2];
                    String pathForEncryptCipher = fileApplication.giveNewFileName(path, Command.ENCRYPTED);

                    try {
                        fileApplication.writeFile(pathForEncryptCipher, cipher.encryptText(text, valueOf(key)));

                        System.out.println("Successfully written Message to the file");
                    } catch (IOException e) {
                        System.out.println("There is no file to write");
                    }

                } else if (command.equalsIgnoreCase("D")) {
                    String key = args[2];

                    String pathForDecryptCipher = fileApplication.giveNewFileName(path, Command.DECRYPTED);

                    try {

                        fileApplication.writeFile(pathForDecryptCipher, cipher.decryptText(text, valueOf(key)));
                        System.out.println("Successfully written Message to the file");
                    } catch (IOException e) {
                        System.out.println("There is no file to write");
                    }
                } else if (command.equalsIgnoreCase("B")) {

                    String pathForBruteForceCipher = fileApplication.giveNewFileName(path, Command.BRUTE_FORCE);
                    try {
                        fileApplication.writeFile(pathForBruteForceCipher, cipher.bruteForceText(text));

                        System.out.println("Successfully written Message to the file");
                    } catch (IOException e) {
                        System.out.println("There is no file to write");
                    }

                } else {
                    System.out.println(" your сhoice is wrong");
                }
            } catch (
                    IOException e) {
                System.out.println("There is no file on this path");
            }
        } else {
            CLI cli = new CLI();
            cli.runCLI();
        }
    }
}
