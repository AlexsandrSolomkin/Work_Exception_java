package dz_2.dz_2_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_2_3 {
    public static void main(String[] args) {
        boolean flag_work = true;
        /**
         * Цикл работает до тех пор пока не получит от пользователя
         * корректные данные
         */
        while (flag_work) {
            /**
             * Отвечает за проверку корректности данных пользователем
             */
            try {
                int a = add_data_u();
                int b = add_data_u();
                System.out.println(a / b);
                printSum(a, b);
                System.out.println("Введите индекс ");
                ArrayList<Integer> abc = new ArrayList<>();
                abc.add(a);
                abc.add(b);
                flag_work = false;
            } catch (ArithmeticException ex) {
                System.out.println("Catching exception: " + ex);
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Индекс массива, выходит за пределы диапазона!");
            } catch (Throwable ex) {
                System.out.println("Что-то пошло не так: " + ex);
            }
        }
    }

    /**
     * Вывод суммы двух чисел в консоль
     * @param a
     * @param b
     */
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    /**
     * Функция запрашивает ввод данных у пользователя, типа Integer
     * 
     * @return Integer
     */
    public static Integer add_data_u() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(
                "Введите данные, примеры: 1, 6, 9, 55\n>> ");

        int data = scanner.nextInt();
        return data;
    }
}
