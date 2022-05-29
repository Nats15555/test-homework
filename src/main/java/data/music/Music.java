package data.music;

import java.util.Objects;

/**
 * Класс описывающий песню
 */
public class Music {
    private String name;
    private String author;

    /**
     * Конструктор для создания песни
     *
     * @param name   Название песни
     * @param author Автор песни
     */
    public Music(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Music{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music music = (Music) o;
        return Objects.equals(name, music.name) && Objects.equals(author, music.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author);
    }

    /**
     * Получение названия песни
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Изменения названия песни
     *
     * @param name новое название песни
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получение автора песни
     *
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Изменение автора песни
     *
     * @param author новый автор
     */
    public void setAuthor(String author) {
        this.author = author;
    }
}
