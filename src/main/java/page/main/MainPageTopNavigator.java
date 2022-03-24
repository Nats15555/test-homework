package page.main;

public enum MainPageTopNavigator {
    MESSAGES("//*[contains(@data-l,\"t,messages\")]"),
    DISCUSSIONS("//*[contains(@data-l,\"t,discussions\")]"),
    NOTIFICATIONS("//*[contains(@data-l,\"t,notifications\")]"),
    FRIENDS("//*[contains(@data-l,\"t,friends\")]"),
    GUESTS("//*[contains(@data-l,\"t,guests\")]"),
    MARKS("//*[contains(@data-l,\"t,marks\")]"),
    VIDEO("//*[contains(@data-l,\"t,video\")]"),
    MUSIC("//*[contains(@data-l,\"t,music\")]");

    private final String xpath;

    MainPageTopNavigator(String xpath) {
        this.xpath = xpath;
    }

    public String getXpath() {
        return xpath;
    }
}
