package demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static demo.BrutForcing.brutForce;
import static demo.Decryption.decrypt;
import static demo.Encryption.encrypt;
import static demo.Statistics.statistics;

public class Demo {

    public static final Scanner CONSOLE = new Scanner(System.in);
    public static final String ALPHABET = "абвгдежзийклмнопрстуфхцчшщъыьэюяАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ.,-:()«»%1234567890 "; //алфавит
    public static final char[] CHARALPHABET = ALPHABET.toCharArray(); //алфавит, конвертированный в char
    public static char[] charAlphabet = ALPHABET.toCharArray();

    static String src = "/Users/nikola/Documents/IT/Education/Java/JavaRushUniversity/initialText.txt"; //текст для шифрования
    static String encryptedText = "/Users/nikola/Documents/IT/Education/Java/JavaRushUniversity/encryptedText.txt"; //создаем файл для хранения зашифрованного текста
    static String decryptedText = "/Users/nikola/Documents/IT/Education/Java/JavaRushUniversity/decryptedText.txt"; //создаем файл для хранения расшифрованного текста

    static String initialText;

    static {
        try {
            initialText = Files.readString(Paths.get(src));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static char[] charInitialText = initialText.toCharArray();

    static String encrypted;

    static {
        try {
            encrypted = Files.readString(Paths.get(encryptedText));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static char[] charEncrypted = encrypted.toCharArray();

    static char[] resultEncrypted = new char[initialText.length()]; //массив для записи зашифрованного текста в формате char
    static char[] resultDecrypted = new char[encrypted.length()]; //массив для записи расшифрованного текста в формате char

    public static void main(String[] args) throws IOException {

        run();

    }

    private static void run() throws IOException {
        System.out.println("Выберите действие, которое необходимо выполнить, и введите его номер:\n"
            + "1. Зашифровать текст из файла, применяя ключ.\n"
            + "2. Расшифровать текст из файла, применяя ключ.\n"
            + "3. Расшифровать текст из файла, применяя метод подбора ключа.\n"
            + "4. Расшифровать текст из файла, применяя метод статистического анализа.\n");

        System.out.println("Чтобы выйти из программы, введите exit.");

        while (true) {
            //добавить проверку введения пользователем иных символов
            String exit = CONSOLE.nextLine();
            switch (exit) {
                case "1":
                    //System.out.println("1");
                    encrypt(charInitialText, charAlphabet, resultEncrypted);
                    System.out.println(new String(resultEncrypted)); //проверка шифрования
                    break;
                case "2":
                    //System.out.println("2");
                    decrypt(charEncrypted, charAlphabet, resultDecrypted, 10);
                    System.out.println(new String(resultDecrypted)); //проверка дешифрования
                    break;
                case "3":
                    //System.out.println("3");
                    brutForce(charEncrypted, charAlphabet, resultDecrypted);
                    System.out.println(new String(resultDecrypted)); //проверка брутфорса
                    break;
                case "4":
                    //System.out.println("4");
                    statistics();
                    break;
                case "exit":
                    System.out.println("Программа успешно завершена");
                    return;
                //сюда попадает логика для введения ключа из методов шифрования, подумать как игнорировать здесь
                default: {
                    System.out.println("Недопустимое значеие. Выберите число от 1 до 4 или введите exit");
                }
            }
        }
    }


//    private static void encrypt(char[] charInitialText, char[] charAlphabet, char[] resultEncrypted, int key) { //продумать введение кода шифрования пользователем
//        for (int i = 0; i < charInitialText.length; i++) {
//            char charTempOuter = charInitialText[i];
//            for (int j = 0; j < charAlphabet.length; j++) {
//                char charTempInner = charAlphabet[j];
//                if (charTempOuter == charTempInner) {
//                    resultEncrypted[i] = charAlphabet[(j + key) % charAlphabet.length];
//                }
//            }
//        }
//    }

//    private static void decrypt(char[] charEncrypted, char[] charAlphabet, char[] resultDecrypted, int key) { //продумать введение кода дешифрования пользователем
//        for (int i = 0; i < charEncrypted.length; i++) {
//            char charTempOuter = charEncrypted[i];
//            for (int j = 0; j < charAlphabet.length; j++) {
//                char charTempInner = charAlphabet[j];
//                if (charTempOuter == charTempInner) {
//                    resultDecrypted[i] = charAlphabet[(j + (charAlphabet.length - key)) % charAlphabet.length];
//                }
//            }
//        }
//    }

//    private static void brutForce(char[] charEncrypted, char[] charAlphabet, char[] resultDecrypted) throws IOException {
//        int key; String stringKey = "Ключ - ";
//        for (key = 1; key <= charAlphabet.length; key++) {
//            for (int i = 0; i < charEncrypted.length; i++) {
//                char charTempOuter = charEncrypted[i];
//                for (int j = 0; j < charAlphabet.length; j++) {
//                    char charTempInner = charAlphabet[j];
//                    if (charTempOuter == charTempInner) {
//                        resultDecrypted[i] = charAlphabet[(j + (charAlphabet.length - key)) % charAlphabet.length];
//                    }
//                }
//            }
//            int resultComaSpace = isExistComaSpace(resultDecrypted);
//            int resultPointSpace = isExistPointSpace(resultDecrypted);
//            int resultInterestSpace = isExistInterestSpace(resultDecrypted);
//            int resultLongWord = isCountLongWord();
//            if ((resultComaSpace > 5) && (resultPointSpace > 5) && (resultInterestSpace > 1) && (resultLongWord < 5)) {
//                System.out.println(stringKey + key);
//                //записать результат расшифровки в файл
//                break;
//            }
//        }
//    }
//
//    private static int isExistComaSpace(char[] textForAnalysis) {
//        int counterComaSpace = 0;
//        for (int i = 0; i < textForAnalysis.length; i++) {
//            if (textForAnalysis[i] == ',' && textForAnalysis[i + 1] == ' ') {
//                counterComaSpace++;
//            }
//        } return counterComaSpace;
//    }
//
//    private static int isExistPointSpace(char[] textForAnalysis) {
//        int counterPointSpace = 0;
//        for (int i = 0; i < textForAnalysis.length; i++) {
//            if (textForAnalysis[i] == '.' && textForAnalysis[i + 1] == ' ') {
//                counterPointSpace++;
//            }
//        } return counterPointSpace;
//    }
//
//    private static int isExistInterestSpace(char[] textForAnalysis) {
//        int counterInterest = 0;
//        for (int i = 0; i < textForAnalysis.length; i++) {
//            if (textForAnalysis[i] == '%' && textForAnalysis[i + 1] == ' ') {
//                counterInterest++;
//            }
//        } return counterInterest;
//    }
//
//    private static int isCountLongWord() throws IOException {
//        //переписать код, чтобы программа обращалась к переменной resultDecrypted вместо decryptedText.txt
//        String decryptedText = "/Users/nikola/Documents/IT/Education/Java/JavaRushUniversity/decryptedText.txt";
//        String lines = Files.readString(Paths.get(decryptedText), UTF_8);
//        String[] linesWithSpace = lines.split(" ");
//        List<Integer> list = new ArrayList<>();
//
//        for (String value : linesWithSpace) {
//            list.add(value.length());
//        }
//
//        int counterLongWord = 0;
//        for (Integer integer : list) {
//            if (integer >= 20) {
//                counterLongWord++;
//            }
//        }
//        return counterLongWord;
//    }

}





