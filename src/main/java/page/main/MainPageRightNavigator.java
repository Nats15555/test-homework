package page.main;

public enum MainPageRightNavigator {
    PAGE("//*[contains(@data-l,\"t,userPage\")]"),
    HOME("//*[contains(@data-l,\"t,userMain\")]"),
    FRIENDS("//*[contains(@data-l,\"t,userFriend\")]"),
    PHOTO("//*[contains(@data-l,\"t,userPhotos\")]"),
    GROUPS("//*[contains(@data-l,\"t,userAltGroup\")]"),
    GAMES("//*[contains(@data-l,\"t,appsShowcaseHD\")]"),
    APPS("//*[contains(@data-l,\"t,bizApps\")]"),
    GIFTS("//*[contains(@data-l,\"t,giftsFront\")]"),
    PRODUCTS("//*[contains(@data-l,\"t,mall\")]"),
    RECOMMENDED("//*[contains(@data-l,\"t,discovery\")]"),
    POSTS("//*[contains(@data-l,\"t,userStatuses\")]"),
    PAYMENT("//*[contains(@data-l,\"t,payments\")]");

    //добавить еще поля, которые ниже (пока не надо)

    private final String xpath;

    MainPageRightNavigator(String xpath) {
        this.xpath = xpath;
    }

    public String getXpath() {
        return xpath;
    }
}
