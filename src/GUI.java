import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class GUI extends JFrame {

    private Cookies cookies;
    private JLabel cookieLabel;

    public GUI(Cookies cookies) {
        this.cookies = cookies;

        setTitle("中国共产党");
        setIconImage(new ImageIcon("src/ccp.png").getImage());
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon backgroundIcon = new ImageIcon("src/xj.png");

        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new GridLayout(2, 1));
        setContentPane(backgroundLabel);

        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false); // transparent

        cookieLabel = new JLabel();
        cookieLabel.setFont(new Font("Serif", Font.BOLD, 50));
        cookieLabel.setOpaque(true);
        cookieLabel.setBackground(Color.RED);
        cookieLabel.setForeground(Color.BLACK);
        topPanel.add(cookieLabel);



        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new FlowLayout());


        JButton cookieButton = new JButton("社會信用體系");
        JButton upgradeButton = new JButton("升級費用");
        JButton autoButton = new JButton("自動答題器成本");


        Font buttonFont = new Font("Serif", Font.BOLD, 30);

        cookieButton.setForeground(Color.GREEN);
        upgradeButton.setForeground(Color.YELLOW);
        autoButton.setForeground(Color.ORANGE);

        cookieButton.setFont(buttonFont);
        upgradeButton.setFont(buttonFont);
        autoButton.setFont(buttonFont);


        cookieButton.setIcon(new ImageIcon("src/sc.png"));
        upgradeButton.setIcon(new ImageIcon("src/jc.png"));
        autoButton.setIcon(new ImageIcon("src/mi.png"));


        setupButton(cookieButton);
        setupButton(upgradeButton);
        setupButton(autoButton);


        cookieButton.addActionListener(e -> {
            cookies.addCookies();
            updateLabel();
        });
        upgradeButton.addActionListener(e -> {
            cookies.upgradeClick();
            updateLabel();
        });
        autoButton.addActionListener(e -> {
            cookies.upgradeSecond();
            updateLabel();
        });

        bottomPanel.add(cookieButton);
        bottomPanel.add(upgradeButton);
        bottomPanel.add(autoButton);

        add(topPanel);
        add(bottomPanel);

        Timer guiTimer = new Timer(100, e -> updateLabel());
        guiTimer.start();

        updateLabel();
        setVisible(true);
    }

    private void setupButton(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);


        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
    }


    private void updateLabel() {
        cookieLabel.setText(
                "社會信用體系: " + cookies.getCookieCount()
                        + " | 每次點擊的社會信用: " + cookies.getCookiesPerClick()
                        + " | 每秒社會信用: " + cookies.getCookiesPerSecond()
                        + " | 升級費用: " + cookies.getClickUpgradeCost()
                        + " | 自動答題器成本: " + cookies.getAutoClickerCost()
        );
    }
}