package page.message;

public interface MessagePageInterface {

    MessagePageInterface openDialog(String identification);

    MessagePageInterface sendMessage(String message);

    boolean chekMessage(String message);

}
