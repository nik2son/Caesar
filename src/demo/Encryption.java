package demo;

/*
Часть 1. Зашифровать текст
 */

import java.io.IOException;

import static demo.Demo.CONSOLE;

public class Encryption {

    public static void encrypt(char[] charInitialText, char[] charAlphabet, char[] resultEncrypted) throws IOException { //продумать введение кода шифрования пользователем
        System.out.println("Выберите файл, который требуется зашифровать");
        //String fileAddress = CONSOLE.nextLine();
        //String fileForEncryption = Files.readString(Paths.get(fileAddress));
        //charInitialText = fileAddress.toCharArray();
        System.out.println("Введите ключ шифрования");
        int key = CONSOLE.nextInt();
        for (int i = 0; i < charInitialText.length; i++) { //работа с одним конкретным файлом, не универсалный доступ к библиотеке для шифрования
            char charTempOuter = charInitialText[i];
            for (int j = 0; j < charAlphabet.length; j++) {
                char charTempInner = charAlphabet[j];
                if (charTempOuter == charTempInner) {
                    resultEncrypted[i] = charAlphabet[(j + key) % charAlphabet.length];
                }
            }
        }
    }

//    public static void encrypt() throws IOException {
//        System.out.println("Выберите файл, который требуется зашифровать");
//        String fileAddress = CONSOLE.nextLine();
//        String fileForEncryption = Files.readString(Paths.get(fileAddress));
//        char[] charInitialText = fileAddress.toCharArray();
//        char[] resultEncrypted = new char[fileForEncryption.length()];
//        System.out.println("Введите ключ шифрования (число от 1 до 10");
//        int key = CONSOLE.nextInt();
//        for (int i = 0; i < charInitialText.length; i++) {
//            char charTempOuter = charInitialText[i];
//            for (int j = 0; j < CHARALPHABET.length; j++) {
//                char charTempInner = CHARALPHABET[j];
//                if (charTempOuter == charTempInner) {
//                    resultEncrypted[i] = CHARALPHABET[(j + key) % CHARALPHABET.length];
//                }
//            }
//        }
//    }

    public static void writeToFile() {

    }

}
