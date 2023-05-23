package PresentationLayer;

import javax.swing.*;
/***
 * This class is represents the main window which is displayed when starting the app.
 * It offers the options to choose what model will be used for queries.*/
public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JButton clientsOperationsButton;
    private JButton productsOperationsButton;
    private JButton ordersOperationsButton;

    public MainFrame() {
        super("Main Frame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 200, 500, 500);
       // this.setSize(500, 500);

        clientsOperationsButton.addActionListener(e -> {
            new ClientFrame();
            this.dispose();
        });

        productsOperationsButton.addActionListener(e -> {
            new ProductFrame();
            this.dispose();
        });

        ordersOperationsButton.addActionListener(e -> {
            new OrderFrame();
            this.dispose();
        });

       // this.pack();
        this.setVisible(true);
    }

}
