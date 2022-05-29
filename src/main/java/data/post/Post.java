package data.post;

import java.util.Objects;

/**
 * Класс описывает пост
 */
public class Post {

    private String content;

    public Post(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(content, post.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return "Post{" +
                "content='" + content + '\'' +
                '}';
    }

    /**
     * Получение теста поста
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * Изменяем текст поста
     * @param content новый текст поста
     */
    public void setContent(String content) {
        this.content = content;
    }
}
