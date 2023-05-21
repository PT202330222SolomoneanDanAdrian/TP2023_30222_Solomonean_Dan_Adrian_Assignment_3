package PresentationLayer;

import DataAccess.ProductDAO;
import Models.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.util.List;

public class ProductFrame extends JFrame {

    private JPanel mainPanel;
    private JTextField nameTextField;
    private JTextField quantityTextField;
    private JTextField priceTextField;
    private JButton addProductButton;
    private JPanel updatePanel;
    private JTextField idToUpdateTextField;
    private JTextField nameToUpdateTextField;
    private JTextField quantityToUpdateTextField;
    private JTextField priceToUpdateTextField;
    private JButton updateProductButton;
    private JPanel deletePanel;
    private JTextField deleteProductTextField;
    private JButton deleteProductButton;
    private JTable productsTable;
    private JPanel tablePanel;
    private JTextField idTextField;
    private JButton refreshButton;
    private JButton backButton;

    public ProductFrame() {
        super("Product Frame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);

        addProductButton.addActionListener(e -> {
            Models.Product product = new Models.Product();
            DataAccess.ProductDAO productDAO = new DataAccess.ProductDAO();

            product.setId(Integer.parseInt(idTextField.getText()));
            product.setName(nameTextField.getText());
            product.setQuantity(Integer.parseInt(quantityTextField.getText()));
            product.setPrice(BigDecimal.valueOf(Double.parseDouble(priceTextField.getText())));

            if (productDAO.findById(Integer.parseInt(idTextField.getText())) != null) {
                JOptionPane.showConfirmDialog(null, "Product already exists!", "Error", JOptionPane.DEFAULT_OPTION);
                return;
            }

            productDAO.insert(product);

            JOptionPane.showConfirmDialog(null, "Product added successfully!", "Success", JOptionPane.DEFAULT_OPTION);
        });

        updateProductButton.addActionListener(e -> {
            Models.Product product = new Models.Product();
            DataAccess.ProductDAO productDAO = new DataAccess.ProductDAO();

            product.setId(Integer.parseInt(idToUpdateTextField.getText()));
            product.setName(nameToUpdateTextField.getText());
            product.setQuantity(Integer.parseInt(quantityToUpdateTextField.getText()));
            product.setPrice(BigDecimal.valueOf(Double.parseDouble(priceToUpdateTextField.getText())));

            if (productDAO.findById(Integer.parseInt(idToUpdateTextField.getText())) == null) {
                JOptionPane.showConfirmDialog(null, "Product doesn't exist!", "Error", JOptionPane.DEFAULT_OPTION);
                return;
            }

            productDAO.update(Integer.parseInt(idToUpdateTextField.getText()) ,product);

            JOptionPane.showConfirmDialog(null, "Product updated successfully!", "Success", JOptionPane.DEFAULT_OPTION);
        });

        deleteProductButton.addActionListener(e -> {
            Models.Product product = new Models.Product();
            DataAccess.ProductDAO productDAO = new DataAccess.ProductDAO();

            product.setId(Integer.parseInt(deleteProductTextField.getText()));

            if (productDAO.findById(Integer.parseInt(deleteProductTextField.getText())) == null) {
                JOptionPane.showConfirmDialog(null, "Product doesn't exist!", "Error", JOptionPane.DEFAULT_OPTION);
                return;
            }

            productDAO.delete(Integer.parseInt(deleteProductTextField.getText()));

            JOptionPane.showConfirmDialog(null, "Product deleted successfully!", "Success", JOptionPane.DEFAULT_OPTION);
        });

        refreshButton.addActionListener(e -> {
            ProductDAO productDAO = new ProductDAO();
            List<Product> products = productDAO.findAll();

            DefaultTableModel model = new DefaultTableModel(new Object[]{"Id", "Name", "Quantity", "Price"}, 0);

            for (Product product : products) {
                model.addRow(new Object[]{product.getId(), product.getName(), product.getQuantity(), product.getPrice()});
            }

            productsTable.setModel(model);
        });

        backButton.addActionListener(e -> {
            this.dispose();
            new MainFrame();
        });

        this.setVisible(true);
    }
}
