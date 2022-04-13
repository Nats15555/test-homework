package data.message;

import java.util.Objects;

public class Message {
    private String massageContent;
    private String receivingTime;

    public Message(String massageContent, String receivingTime) {
        this.massageContent = massageContent;
        this.receivingTime = receivingTime;
    }

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

    @Override
    public String toString() {
        return "Massage{" +
                "receivingTime='" + receivingTime + '\'' +
                ", massageContent='" + massageContent + '\'' +
                '}';
    }

    public String getReceivingTime() {
        return receivingTime;
    }

    public void setReceivingTime(String receivingTime) {
        this.receivingTime = receivingTime;
    }

    public String getMassageContent() {
        return massageContent;
    }

    public void setMassageContent(String massageContent) {
        this.massageContent = massageContent;
    }
}
