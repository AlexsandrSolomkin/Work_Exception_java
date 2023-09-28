package dz_3;

import java.time.LocalDate;
import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {
        startWorking();
    }
    /**
     * Метод, который запускает работу программы
     */
    private static void startWorking(){
        boolean flagWorks = true;
        /**
         * Цикл, который выполняется до тех пор, пока не получит корректные данные для работы
         */
        while (flagWorks) {
            /**
             * Отвечает за проверку корректности данных пользователем
             */
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Введите данные человека в формате (Фамилия Имя Отчество датарождения номертелефона(без доп. знаков таких как +) пол(f - если женский, m - если мужской)), используйте в качестве разделителя пробел, строго как на примере:\nIvanov Ivan Ivanovich 01.01.1980 9876543210 m");

                System.out.print(">> ");

                String data = scanner.nextLine();
                String[] data_sp = data.split(" ");
                /**
                 * Проверка корректности ввода данных и выброса исключения с указанием на проблемное место
                 */
                if (data_sp.length < 6){
                    throw new Exception("Данных не хватает!");
                } else if (data_sp.length > 6){
                    throw new Exception("Данных больше, чем требуется!");
                } else if (checkString(data_sp[1])){
                    throw new Exception("Ошибка в имени, обнаружено число!");
                } else if (checkString(data_sp[0])){
                    throw new Exception("Ошибка в фамилии, обнаружено число!");
                } else if (checkString(data_sp[2])){
                    throw new Exception("Ошибка в отчестве, обнаружено число!");
                } else if (data_sp.length == 6){
                    flagWorks = false;
                }

                //DataPerson dataPerson = new DataPerson((String) data_sp[1], (String) data_sp[0], (String) data_sp[2], (LocalDate) data_sp[3], (int) data_sp[4], (Gender) data_sp[5]);

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
    }

    /**
     * Метод обрабатывает данные введенные пользователем в формате String и 
     * отлавливает данные типа Integer и возврощает результат проверки в 
     * формате boolean
     * @param st
     * @return 
     * false - если проверка пройдена, true - если проверка была провалена
     */
    private static boolean checkString(String st){
        boolean hasDigits = false;
        for(int i = 0; i < st.length() && !hasDigits; i++) {
            if(Character.isDigit(st.charAt(i))) {
                hasDigits = true;
            }
        }
        return hasDigits;
    }
}
