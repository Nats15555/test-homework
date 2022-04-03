package data.massage;

import java.util.Objects;

public class Massage {
    private String receivingData;
    private String receivingTime;
    private String massageContent;

    public Massage(String receivingData, String receivingTime, String massageContent) {
        this.receivingData = receivingData;
        this.receivingTime = receivingTime;
        this.massageContent = massageContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Massage massage = (Massage) o;
        return Objects.equals(receivingData, massage.receivingData) && Objects.equals(receivingTime, massage.receivingTime) && Objects.equals(massageContent, massage.massageContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receivingData, receivingTime, massageContent);
    }

    public String getReceivingData() {
        return receivingData;
    }

    public void setReceivingData(String receivingData) {
        this.receivingData = receivingData;
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
