package demo;

/*
Часть 2. Расшифровать текст
 */

public class Decryption {

    public static void decrypt(char[] charEncrypted, char[] charAlphabet, char[] resultDecrypted, int key) { //продумать введение кода дешифрования пользователем
        for (int i = 0; i < charEncrypted.length; i++) {
            char charTempOuter = charEncrypted[i];
            for (int j = 0; j < charAlphabet.length; j++) {
                char charTempInner = charAlphabet[j];
                if (charTempOuter == charTempInner) {
                    resultDecrypted[i] = charAlphabet[(j + (charAlphabet.length - key)) % charAlphabet.length];
                }
            }
        }
    }
}
