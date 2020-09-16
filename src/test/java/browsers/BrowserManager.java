package browsers;

public class BrowserManager {

    private static String browser;

    public static String getBrowser() {
        return browser;
    }

    public static void setBrowser(String browser) {
        BrowserManager.browser = browser;
    }
}
