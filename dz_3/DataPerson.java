package dz_3;

import java.time.LocalDate;

/**
 * Класс содержащий данные о пользователе
 */
public class DataPerson {
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthDate;
    private int phone;
    private Gender gender;

    /**
     * Конструктор, в который передаются данные о пользователе:
     * 
     * @param name       - имя;
     * @param surname    - фамилия;
     * @param patronymic - отчество;
     * @param birthDate  - дата рождения;
     * @param phone      - телефон;
     * @param gender     - пол.
     */
    public DataPerson(String name,
            String surname,
            String patronymic,
            LocalDate birthDate,
            int phone,
            Gender gender) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
    }

    /**
     * Метод возврощает данные:
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для занесения данных в поле:
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод возврощает данные:
     * 
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Метод для занесения данных в поле:
     * 
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Метод возврощает данные:
     * 
     * @return patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Метод для занесения данных в поле:
     * 
     * @param patronymic
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Метод возврощает данные:
     * 
     * @return birthDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Метод для занесения данных в поле:
     * 
     * @param birthDate
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Метод возврощает данные:
     * 
     * @return phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * Метод для занесения данных в поле:
     * 
     * @param phone
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * Метод возврощает данные:
     * 
     * @return gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Метод для занесения данных в поле:
     * 
     * @param gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
