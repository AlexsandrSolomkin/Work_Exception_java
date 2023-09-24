package dz_2.dz_2_2;

import java.util.Scanner;

public class Main_2_2 {
    public static void main(String[] args) {
        boolean flag_work = true;
        /**
         * Цикл работает до тех пор пока не получит от пользователя
         * корректные данные
         */
        while(flag_work){
            /**
             * Отвечает за проверку корректности данных пользователем
             */
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(
                    "Введите данные, примеры: 1, 6, 9, 55\n>> "
                );
                int d = scanner.nextInt();
                int[] intArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
                double catchedRes1 = intArray[8] / d;
                System.out.println("catchedRes1 = " + catchedRes1);
                flag_work = false;
            } catch (ArithmeticException e) {
                System.out.println("Catching exception: " + e);
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
    }
}
