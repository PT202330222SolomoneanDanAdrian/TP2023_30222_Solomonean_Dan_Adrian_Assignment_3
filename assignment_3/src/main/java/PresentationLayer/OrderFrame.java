package PresentationLayer;

import BusinessLogic.BillGenerator;
import DataAccess.ClientDAO;
import DataAccess.OrderDAO;
import DataAccess.ProductDAO;
import Models.*;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class OrderFrame extends JFrame {
    private JComboBox clientComboBox;
    private JComboBox productComboBox;
    private JTextField quantityTextField;
    private JButton addOrderButton;
    private JPanel mainPanel;
    private JButton backButton;

    public OrderFrame() {
        super("Order Frame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);

        ClientDAO clientDAO = new ClientDAO();
        ProductDAO productDAO = new ProductDAO();

        List<Client> clients = clientDAO.findAll();
        List<Product> products = productDAO.findAll();

        for (Client client : clients) {
            ClientDropdown clientDropdown = new ClientDropdown(client.getId(), client.getName());
            clientComboBox.addItem(clientDropdown);
        }

        for (Product product : products) {
            ProductDropdown productDropdown = new ProductDropdown(product.getId(), product.getName());
            productComboBox.addItem(productDropdown);
        }

        addOrderButton.addActionListener(e -> {
            ClientDropdown clientDropdown = (ClientDropdown) clientComboBox.getSelectedItem();
            ProductDropdown productDropdown = (ProductDropdown) productComboBox.getSelectedItem();
            int quantity = Integer.parseInt(quantityTextField.getText());

            Client client = clientDAO.findById(clientDropdown.getId());
            Product product = productDAO.findById(productDropdown.getId());

            if (product.getQuantity() < quantity) {
                JOptionPane.showConfirmDialog(null, "Not enough products in stock!", "Error", JOptionPane.DEFAULT_OPTION);
                return;
            }

            product.setQuantity(product.getQuantity() - quantity);
            productDAO.update(productDropdown.getId(), product);

            OrderDAO orderDAO = new OrderDAO();
            List<Orders> orders = orderDAO.findAll();
            int orderCount = orders.size();

            Orders order = new Orders(orderCount + 1, client.getId(), new Timestamp(new Date().getTime()), BigDecimal.valueOf(quantity), product.getId());
            orderDAO.insert(order);

            BillGenerator billGenerator = new BillGenerator();
            billGenerator.generateBill(order, quantity);

            JOptionPane.showConfirmDialog(null, "Order added successfully!", "Success", JOptionPane.DEFAULT_OPTION);
        });

        backButton.addActionListener(e -> {
            new MainFrame();
            this.dispose();
        });

        this.pack();
        this.setVisible(true);
    }
}
