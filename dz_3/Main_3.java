package dz_3;

import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {
        startWorking();
    }

    private static void startWorking(){
        boolean flagWorks = true;

        while (flagWorks) {
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Введите данные человека в формате (Фамилия Имя Отчество датарождения номертелефона(без доп. знаков таких как +) пол(f - если женский, m - если мужской)), используйте в качестве разделителя пробел, строго как на примере:\nIvanov Ivan Ivanovich 01.01.1980 9876543210 m");

                System.out.print(">> ");

                String data = scanner.nextLine();
                String[] data_sp = data.split(" ");

                if (data_sp.length < 6){
                    throw new Exception("Данных не хватает!");
                } else if (data_sp.length > 6){
                    throw new Exception("Данных больше, чем требуется!");
                }

            } catch (Exception e) {

            }
        }
    }
}
