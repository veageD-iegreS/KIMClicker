import java.util.Timer;
import java.util.TimerTask;

public class Cookies {
    private int cookieCount;
    private int cookiesPerClick;
    private int cookiesPerSecond;

    private int clickUpgradeCost;
    private int autoClickerCost;

    public Cookies() {
        cookieCount = 0;
        cookiesPerClick = 1;
        cookiesPerSecond = 0;

        clickUpgradeCost = 1;
        autoClickerCost = 228;


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                cookieCount = cookieCount + cookiesPerSecond;
            }
        }, 0, 1000);
            }

    public int getCookieCount() {
        return cookieCount;
    }

    public int getCookiesPerClick() {
        return cookiesPerClick;
    }

    public int getCookiesPerSecond() {
        return cookiesPerSecond;
    }

    public int getClickUpgradeCost() {
        return clickUpgradeCost;
    }

    public int getAutoClickerCost() {
        return autoClickerCost;
    }


    public void addCookies() {
        cookieCount = cookieCount + cookiesPerClick;
    }


    public void upgradeClick() {
        if (cookieCount >= clickUpgradeCost) {
            cookieCount = cookieCount - clickUpgradeCost;
            cookiesPerClick = cookiesPerClick + 1;
            clickUpgradeCost = cookiesPerClick * cookiesPerClick;
        }
    }


    public void upgradeSecond() {
        if (cookieCount >= autoClickerCost) {
            cookieCount = cookieCount - autoClickerCost;
            cookiesPerSecond = 1 + cookiesPerSecond;
            autoClickerCost = autoClickerCost * cookiesPerSecond;
        }
    }
}