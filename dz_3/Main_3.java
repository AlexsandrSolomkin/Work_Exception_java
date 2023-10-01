package dz_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {
        startWorking();
    }

    /**
     * Метод, который запускает работу программы
     */
    private static void startWorking() {
        boolean flagWorks = true;
        /**
         * Цикл, который выполняется до тех пор, пока не получит корректные данные для
         * работы
         */
        while (flagWorks) {
            /**
             * Отвечает за проверку корректности данных пользователем
             */
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.println(
                        "Введите данные человека в формате (Фамилия Имя Отчество датарождения номертелефона(без доп. знаков таких как +) пол(f - если женский, m - если мужской)), используйте в качестве разделителя пробел, строго как на примере:\nIvanov Ivan Ivanovich 01.01.1980 9876543210 m");

                System.out.print(">> ");

                String data = scanner.nextLine();
                String[] data_sp = data.split(" ");
                /**
                 * Проверка корректности ввода данных и выброса исключения с указанием на
                 * проблемное место
                 */
                if (data_sp.length < 6) {
                    throw new Exception("Данных не хватает!");
                } else if (data_sp.length > 6) {
                    throw new Exception("Данных больше, чем требуется!");
                } else if (checkString(data_sp[1])) {
                    throw new Exception("Ошибка в имени, обнаружено число!");
                } else if (checkString(data_sp[0])) {
                    throw new Exception("Ошибка в фамилии, обнаружено число!");
                } else if (checkString(data_sp[2])) {
                    throw new Exception("Ошибка в отчестве, обнаружено число!");
                } else if (checkIfDateIsValid(data_sp[3])) {
                    throw new Exception("Ваши данные о дате рождения указаны с ошибкой!");
                } else if (checkStringLong(data_sp[4])) {
                    throw new Exception("Такого номера не существует!");
                } else if (contains(data_sp[5])) {
                    throw new Exception("Такого пола не существует!");
                } else if (data_sp.length == 6) {
                    String path = "dz_3\\AllFilesDataPerson\\" + data_sp[0] + ".txt";
                    createOrAddNewDataFile(path, data_sp);
                    printDataFile(path);

                    flagWorks = false;
                }

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
    }

    /**
     * Метод обрабатывает данные введенные пользователем в формате String и
     * отлавливает данные типа Integer и возврощает результат проверки в
     * формате boolean
     * 
     * @param st
     * @return
     *         false - если проверка пройдена, true - если проверка была провалена
     */
    private static boolean checkString(String st) {
        boolean hasDigits = false;
        for (int i = 0; i < st.length() && !hasDigits; i++) {
            if (Character.isDigit(st.charAt(i))) {
                hasDigits = true;
            }
        }
        return hasDigits;
    }

    /**
     * Метод, которые проверяет можно ли преобразовать данные типа String в
     * long и возврощает результат проверки в формате boolean
     * 
     * @param st_long
     * @return
     *         false - если проверка пройдена, true - если проверка была провалена
     */
    private static boolean checkStringLong(String st_long) {
        boolean res = false;
        try {
            long new_st_long = Long.parseLong(st_long);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
            res = true;
        }
        return res;
    }

    /**
     * Проверка на корректность введенной даты, существует ли она
     * и возврощает результат проверки в формате boolean
     * 
     * @param date
     * @return
     *         false - если проверка пройдена, true - если проверка была провалена
     */
    private static boolean checkIfDateIsValid(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        boolean dateOK = false;
        String[] data_date = date.split("[.]");
        int year = Integer.parseInt(data_date[2]);
        format.setLenient(false);

        if (year < 1850) {
            dateOK = true;
        } else {
            try {
                format.parse(date);
            } catch (ParseException e) {
                System.out.println("ParseException: " + e.getMessage());
                dateOK = true;
            }
        }

        return dateOK;
    }

    /**
     * Проверка на корректность введенных данных, существует ли в enum такие
     * данные и возврощает результат проверки в формате boolean
     * 
     * @param test
     * @return
     *         false - если проверка пройдена, true - если проверка была провалена
     */
    private static boolean contains(String test) {
        boolean dataOK = false;

        for (Gender c : Gender.values()) {
            if (c.name().equals(test)) {
                return dataOK;
            }
        }
        dataOK = true;
        return dataOK;
    }

    /**
     * Метод, который создает файл, используя переданный путь для его
     * расположения в папке и заносит в него данные из массива
     * @param pathFile
     * @param dataArray
     */
    private static void createOrAddNewDataFile(String pathFile, String[] dataArray){
        File file = new File(pathFile);
        try {
            if(!file.exists()){
                //Срабатывает, если файл не существует
                PrintWriter pw = new PrintWriter(file);

                for (String data : dataArray) {
                    pw.print("<" + data + ">");
                }

                pw.print("\n");

                pw.close();
            } else {
                //Срабатывает, если файл существует
                try {
                    FileWriter writer = new FileWriter(pathFile, true);

                    for (String data : dataArray) {
                        writer.write("<" + data + ">");
                    }

                    writer.write("\n");

                    writer.close();
                } catch (IOException e) {
                    System.out.println("IOException: " + e.getMessage());
                }
                
            }

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        }
    }

    /**
     * Метод, которые считывает данные посимвольно из файла
     * @param pathFile
     */
    private static void printDataFile(String pathFile){

        try(FileReader reader = new FileReader(pathFile)){
           // читаем посимвольно
            int c;

            System.out.println("\nДанные из файла: ");
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }

        } catch(IOException ex){
            System.out.println("IOException" + ex.getMessage());
        }
    }
}
