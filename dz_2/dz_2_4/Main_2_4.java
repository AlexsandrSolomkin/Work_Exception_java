package dz_2.dz_2_4;

import java.io.IOException;
import java.util.Scanner;

public class Main_2_4 {
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
                String text = null;
                text = add_data_u_st();
                System.out.println(text);
                flag_work = false;
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
    }

    /**
     * Функция запрашивает ввод данных у пользователя, типа String
     * 
     * @return String
     */
    public static String add_data_u_st() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(
            "Введите данные, пример: Hello Mario, it's me Luidjio!!!\n>> "
        );

        String data = scanner.nextLine();
        return data;
    }
}
