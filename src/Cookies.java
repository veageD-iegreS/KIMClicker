public class Cookies {
    private int cookieCount;
    private int cookiesPerClick;

    public Cookies() {
        cookieCount = 0;
        cookiesPerClick = 1;
    }

    public int getCookieCount() {
        return cookieCount;
    }

    public int getCookiesPerClick() {
        return cookiesPerClick;
    }

    // Increase the total number of cookies
    public void addCookies() {
        cookieCount = cookieCount + cookiesPerClick;
    }

    // Upgrade so each click gives ^2+1
    public void upgradeClick() {
        cookiesPerClick = cookiesPerClick * cookiesPerClick + 1;
    }
}