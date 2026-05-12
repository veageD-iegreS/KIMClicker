import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private Cookies cookies;
    private JLabel cookieLabel;

    public GUI(Cookies cookies) {
        this.cookies = cookies;

        setTitle("Cookie Clicker");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon backgroundIcon = new ImageIcon("kju.png");

        JLabel backgroundLabel = new JLabel(backgroundIcon);

        backgroundLabel.setLayout(new GridLayout(2, 1));

        setContentPane(backgroundLabel);

        JPanel topPanel = new JPanel();
        cookieLabel = new JLabel("Cookies: " + cookies.getCookieCount());
        topPanel.add(cookieLabel);

        JPanel bottomPanel = new JPanel();

        JButton cookieButton = new JButton("Cookie");

        ImageIcon cookieIcon = new ImageIcon("bmb.png");
        cookieButton.setIcon(cookieIcon);

        JButton upgradeButton = new JButton("Upgrade");

        ImageIcon upgradeIcon = new ImageIcon("urnm.png");
        upgradeButton.setIcon(upgradeIcon);

        cookieButton.addActionListener(e -> {
            cookies.addCookies();
            cookieLabel.setText("Cookies: " + cookies.getCookieCount());
        });

        upgradeButton.addActionListener(e -> {
            cookies.upgradeClick();
            cookieLabel.setText("Cookies: " + cookies.getCookieCount());
        });

        bottomPanel.add(cookieButton);
        bottomPanel.add(upgradeButton);

        add(topPanel);
        add(bottomPanel);

        setVisible(true);
    }
}