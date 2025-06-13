// ... all imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.security.MessageDigest;

public class Dashboard extends JFrame {

    private final String accountNumber;
    private final JLabel balanceLabel;
    private final JButton showBalanceBtn;
    private boolean isBalanceVisible = false;

    private final JLabel accountNumberLabel;
    private final JButton toggleAccountBtn;
    private boolean isAccountVisible = false;

    public Dashboard(String username, String accountNumber) {
        this.accountNumber = accountNumber;

        setTitle("FINTECHBank - Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel background = getJPanel();
        JPanel dashboardPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.setOpaque(false);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 3, 15, 15));
        buttonPanel.setOpaque(false);

        dashboardPanel.add(topPanel, BorderLayout.NORTH);
        dashboardPanel.add(buttonPanel, BorderLayout.CENTER);

        // Header panel
        JLabel welcomeLabel = new JLabel("Welcome, " + username);
        welcomeLabel.setFont(new Font("Segue UI", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(0, 70, 140));

        balanceLabel = new JLabel("Balance: ₹ *****");
        balanceLabel.setFont(new Font("Segue UI", Font.PLAIN, 18));
        balanceLabel.setForeground(new Color(0, 128, 0));

        showBalanceBtn = new JButton("Show Balance");
        showBalanceBtn.setFocusPainted(false);
        showBalanceBtn.setBackground(new Color(70, 130, 180));
        showBalanceBtn.setForeground(Color.WHITE);
        showBalanceBtn.addActionListener(e -> toggleBalanceVisibility());

        JPanel balancePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        balancePanel.setOpaque(false);
        balancePanel.add(balanceLabel);
        balancePanel.add(showBalanceBtn);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.add(welcomeLabel, BorderLayout.WEST);
        headerPanel.add(balancePanel, BorderLayout.CENTER);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setFocusPainted(false);
        logoutBtn.setFont(new Font("Segue UI", Font.PLAIN, 14));
        logoutBtn.setBackground(new Color(200, 50, 50));
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutBtn.addActionListener(e -> logout());

        headerPanel.add(logoutBtn, BorderLayout.EAST);
        topPanel.add(headerPanel);

        // Account Number + Eye Toggle
        String maskedAcc = "" + accountNumber.substring(accountNumber.length() - 4);
        accountNumberLabel = new JLabel("Account Number: " + maskedAcc);
        accountNumberLabel.setFont(new Font("Segue UI", Font.BOLD, 14));
        accountNumberLabel.setForeground(Color.BLUE);

        toggleAccountBtn = new JButton("👁");
        toggleAccountBtn.setFocusPainted(false);
        toggleAccountBtn.setPreferredSize(new Dimension(40, 25));
        toggleAccountBtn.setFont(new Font("Segue UI", Font.PLAIN, 14));
        toggleAccountBtn.addActionListener(e -> toggleAccountVisibility());

        JPanel accountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        accountPanel.setOpaque(false);
        accountPanel.add(accountNumberLabel);
        accountPanel.add(toggleAccountBtn);

        topPanel.add(accountPanel);

        // ✅ Define button font and color
        Font btnFont = new Font("Segue UI", Font.BOLD, 14);
        Color btnColor = new Color(0, 120, 215);

        // Buttons
        JButton depositBtn = createButton("Deposit", btnFont, btnColor);
        JButton withdrawBtn = createButton("Withdraw", btnFont, btnColor);
        JButton transferBtn = createButton("Transfer", btnFont, btnColor);
        JButton statementBtn = createButton("Mini Statement", btnFont, btnColor);
        JButton chatbotBtn = createButton("FIN AI", btnFont, btnColor);
        JButton loanBtn = createButton("Loan Services", btnFont, btnColor);
        JButton loanStatusBtn = createButton("View Loan Status", btnFont, btnColor);
        JButton fdBtn = createButton("Fixed Deposit", btnFont, btnColor);
        JButton billPayBtn = createButton("Bill Payments", btnFont, btnColor);
        JButton cardViewerBtn = createButton("Virtual Debit Card", btnFont, btnColor);
        JButton serviceRequestBtn = createButton("Service Requests", btnFont, btnColor);
        JButton settingsBtn = createButton("Account Settings", btnFont, btnColor);
        JButton fdViewerBtn = createButton("My FDs", btnFont, btnColor);
        JButton rtgsBtn = createButton("RTGS Transfer", btnFont, btnColor);
        JButton impsBtn = createButton("IMPS Transfer", btnFont, btnColor);
        JButton neftBtn = createButton("NEFT Transfer", btnFont, btnColor);
        JButton nomineeBtn = createButton("Nominee Details", btnFont, btnColor);
        JButton setPinBtn = createButton("Set UPI PIN", btnFont, btnColor);
        JButton forgotPinBtn = createButton("Forgot UPI PIN", btnFont, Color.RED);

        // Add buttons to panel
        buttonPanel.add(depositBtn);
        buttonPanel.add(withdrawBtn);
        buttonPanel.add(transferBtn);
        buttonPanel.add(statementBtn);
        buttonPanel.add(chatbotBtn);
        buttonPanel.add(loanBtn);
        buttonPanel.add(fdBtn);
        buttonPanel.add(billPayBtn);
        buttonPanel.add(cardViewerBtn);
        buttonPanel.add(serviceRequestBtn);
        buttonPanel.add(settingsBtn);
        buttonPanel.add(fdViewerBtn);
        buttonPanel.add(loanStatusBtn);
        buttonPanel.add(rtgsBtn);
        buttonPanel.add(impsBtn);
        buttonPanel.add(neftBtn);
        buttonPanel.add(nomineeBtn);
        buttonPanel.add(setPinBtn);
        buttonPanel.add(forgotPinBtn); // ✅ Added to UI

        // Button Actions
        depositBtn.addActionListener(e -> new Deposit(accountNumber, this));
        withdrawBtn.addActionListener(e -> new Withdraw(accountNumber, this));
        transferBtn.addActionListener(e -> new Transfer(accountNumber, this));
        statementBtn.addActionListener(e -> new MiniStatement(accountNumber));
        chatbotBtn.addActionListener(e -> new ChatBot(accountNumber, username));
        loanBtn.addActionListener(e -> new LoanApplication(accountNumber));
        loanStatusBtn.addActionListener(e -> new LoanStatus(accountNumber));
        fdBtn.addActionListener(e -> new FDApplication(accountNumber, this::updateBalance));
        billPayBtn.addActionListener(e -> new BillPayment(accountNumber, this::updateBalance));
        cardViewerBtn.addActionListener(e -> new DebitCardViewer(accountNumber, username));
        serviceRequestBtn.addActionListener(e -> new ServiceRequestCenter(accountNumber));
        settingsBtn.addActionListener(e -> new AccountSettings(accountNumber));
        fdViewerBtn.addActionListener(e -> new FDViewer(accountNumber));
        rtgsBtn.addActionListener(e -> new RTGSTransfer(accountNumber, this::updateBalance));
        impsBtn.addActionListener(e -> new IMPS(accountNumber));
        neftBtn.addActionListener(e -> new NEFT(accountNumber));
        nomineeBtn.addActionListener(e -> new NomineeForm(accountNumber));
        setPinBtn.addActionListener(e -> new SetUpiPin(accountNumber));
        forgotPinBtn.addActionListener(e -> new ForgotUpiPin(accountNumber)); // ✅ Action added

        JPanel card = new JPanel(new BorderLayout(20, 20));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 200, 220), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        card.add(topPanel, BorderLayout.NORTH);
        card.add(buttonPanel, BorderLayout.CENTER);

        background.add(card, BorderLayout.CENTER);
        add(background);
        setVisible(true);
    }

    private static JPanel getJPanel() {
        JPanel background = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(220, 235, 250);
                Color color2 = new Color(170, 210, 240);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        background.setLayout(new BorderLayout(20, 20));
        background.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return background;
    }

    private JButton createButton(String text, Font font, Color bgColor) {
        JButton btn = new JButton(text);
        btn.setFont(font);
        btn.setBackground(bgColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    public void updateBalance() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT balance FROM Users WHERE account_number = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");
                if (isBalanceVisible) {
                    balanceLabel.setText("Balance: ₹" + String.format("%,.2f", balance));
                } else {
                    balanceLabel.setText("Balance: ₹ *****");
                }
            }
        } catch (Exception e) {
            balanceLabel.setText("Unable to load balance.");
            System.err.println("Balance error: " + e.getMessage());
        }
    }

    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
            SwingUtilities.invokeLater(Welcome::new); // Ensure Welcome class exists
        }
    }

    private void toggleBalanceVisibility() {
        if (isBalanceVisible) {
            balanceLabel.setText("Balance: ₹ *****");
            showBalanceBtn.setText("Show Balance");
            isBalanceVisible = false;
        } else {
            JPasswordField pinField = new JPasswordField();
            int result = JOptionPane.showConfirmDialog(this, pinField, "Enter UPI PIN to view balance", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String enteredPin = new String(pinField.getPassword()).trim();
                String hashedEnteredPin = hashUPIPin(enteredPin);

                try (Connection con = DBConnection.getConnection()) {
                    assert con != null;
                    PreparedStatement ps = con.prepareStatement("SELECT upi_pin_hash, balance FROM Users WHERE account_number = ?");
                    ps.setString(1, accountNumber);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        String storedHash = rs.getString("upi_pin_hash");
                        if (hashedEnteredPin.equals(storedHash)) {
                            double balance = rs.getDouble("balance");
                            balanceLabel.setText("Balance: ₹" + String.format("%,.2f", balance));
                            showBalanceBtn.setText("Hide Balance");
                            isBalanceVisible = true;
                        } else {
                            int choice = JOptionPane.showConfirmDialog(this, "❌ Incorrect UPI PIN. Forgot UPI PIN?", "PIN Error", JOptionPane.YES_NO_OPTION);
                            if (choice == JOptionPane.YES_OPTION) {
                                new ForgotUpiPin(accountNumber);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Account not found");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "DB Error: " + e.getMessage());
                }
            }
        }
    }

    private String hashUPIPin(String pin) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(pin.getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) hex.append(String.format("%02x", b));
            return hex.toString();
        } catch (Exception e) {
            return null;
        }
    }

    private void toggleAccountVisibility() {
        if (isAccountVisible) {
            String masked = "" + accountNumber.substring(accountNumber.length() - 4);
            accountNumberLabel.setText("Account Number: " + masked);
            toggleAccountBtn.setText("👁");
            isAccountVisible = false;
        } else {
            accountNumberLabel.setText("Account Number: " + accountNumber);
            toggleAccountBtn.setText("🚫");
            isAccountVisible = true;
        }
    }
}