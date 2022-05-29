package page.message;

/**
 * Интерфейс показывает, что класс использует паттерн Factory/Page Factory
 */
public interface MessagePageInterface {

    MessagePageInterface openDialog(String identification);

    MessagePageInterface sendMessage(String message);

    boolean chekMessage(String message);

}
