import java.util.Scanner;

/**
 * Created by BraslavetsIryna on 26.02.2017.
 *
 * Find Distance
 * Твоя задача создать консольное приложение, которое принимало бы на вход ряд чисел и выводило расстояние между двумя
 * наименьшими. Например, дано ряд чисел: "23 45 34 12 45 4 38 56 2 49 100". Наименьшие числа в нем 2 и 4.
 * Расстояние между ними - 3.
 */
public class Task1 {
    private static int[] getArrayOfNumbers() {
        int[] array;
        int lenght;
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Enter the lenght of array ");
            lenght = in.nextInt();
            array = new int[lenght];
            System.out.println("Enter array:");
            for (int i = 0; i < lenght; i++) {
                array[i] = in.nextInt();
            }
        } catch (Exception ex) {
            return null;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = getArrayOfNumbers();
        if (array != null) {
            int distance = 0;
            int index1 = 0;
            int index2 = 1;
            if (array.length >= 2) {

                for (int i = 2; i < array.length; i++) {
                    if (array[index1] > array[index2]) {
                        if (array[i] < array[index1]) {
                            index1 = i;
                        }
                    } else if (array[index1] < array[index2]) {
                        if (array[i] < array[index2]) {
                            index2 = i;
                        }
                    }
                }
                distance = index1 - index2;
                if (distance < 0) {
                    distance = -distance;
                }
            }
            System.out.println("Distance = " + distance);
        } else {
            System.out.println("Wrong array");
        }
    }
}
