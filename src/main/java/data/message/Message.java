package data.message;

import java.util.Objects;

/**
 * Класс описывает сообщение
 */
public class Message {
    private String massageContent;
    private String receivingTime;

    /**
     * Конструктор для создания сообщения
     *
     * @param massageContent Само сообщения
     * @param receivingTime  Время когда оно было получено
     */
    public Message(String massageContent, String receivingTime) {
        this.massageContent = massageContent;
        this.receivingTime = receivingTime;
    }

    /**
     * Сетод что бы сравнивать объекты этого класса
     *
     * @param o объект с которым мы хотим сравнить
     * @return возвращает true если равны и false если не равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message massage = (Message) o;
        return Objects.equals(receivingTime, massage.receivingTime) && Objects.equals(massageContent, massage.massageContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receivingTime, massageContent);
    }

    /**
     * Позволяет представить объект класса в текстовом виде
     *
     * @return возвращает текстовое представление класса
     */
    @Override
    public String toString() {
        return "Massage{" +
                "receivingTime='" + receivingTime + '\'' +
                ", massageContent='" + massageContent + '\'' +
                '}';
    }

    /**
     * Получаем время сообщения
     *
     * @return возвращает время в тестовом формате
     */
    public String getReceivingTime() {
        return receivingTime;
    }

    /**
     * Метод меняет время у сообщения
     *
     * @param receivingTime
     */
    public void setReceivingTime(String receivingTime) {
        this.receivingTime = receivingTime;
    }

    /**
     * Метод возвращает текстовое сообщение
     *
     * @return возвращает сообщение
     */
    public String getMassageContent() {
        return massageContent;
    }

    /**
     * Меняет текстовое сообщение
     *
     * @param massageContent новое текстовое сообщение
     */
    public void setMassageContent(String massageContent) {
        this.massageContent = massageContent;
    }
}
