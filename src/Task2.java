import java.util.Scanner;

/**
 * Created by BraslavetsIryna on 26.02.2017.
 *
 * Anagrams
 * На вход консольного приложения передается строка слов, разделенных пробелами. Твоя задача сделать из слов
 * анаграммы ("задом наперед") при этом оставив порядок слов неизменными. Результат вывести в консоль.
 * Пример "мама мыла раму" => "амам алым умар"
 */
public class Task2 {
    private static int findNextGap(char[] str, int start) {
        for (int i = start + 1; i < str.length; i++) {
            if (str[i] == ' ') {
                return i - 1;
            }
        }
        return str.length - 1;
    }

    public static void main(String[] args) {
        System.out.println("Enter the text:");
        Scanner in = new Scanner(System.in);
        char[] str = in.nextLine().toCharArray();
        int gap;
        char h_char;
        int middle_word;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ') {
                gap = findNextGap(str, i);
                middle_word = (gap - i) / 2 + i;
                for (int l = gap; i <= middle_word; l--, i++) {
                    h_char = str[i];
                    str[i] = str[l];
                    str[l] = h_char;
                }
                i = gap + 1;
            }
        }
        System.out.println(str);
    }
}
