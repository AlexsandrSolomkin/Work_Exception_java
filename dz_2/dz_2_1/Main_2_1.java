package dz_2.dz_2_1;

import java.util.Scanner;

public class Main_2_1 {
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
                float answer_user = add_data_user();
                System.out.println(answer_user);
                flag_work = false;
            } catch (Exception e) {
                System.out.println("Exception");
            }
        }
    }

    /**
     * Функция запрашивает ввод данных у пользователя, типа float
     * 
     * @return float
     */
    public static float add_data_user() {
        float data_user;
        Scanner scanner = new Scanner(System.in);

        System.out.print(
            "Введите данные в формате типа float, примеры: 0,0; 2,05; 4,0\n>> "
        );

        data_user = scanner.nextFloat();

        return data_user;
    }
}