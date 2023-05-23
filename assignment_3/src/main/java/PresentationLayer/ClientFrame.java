package PresentationLayer;

import DataAccess.ClientDAO;
import Models.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ClientFrame extends JFrame {
    private JPanel addPanel;
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JButton addClientButton;
    private JTextField addressTextField;
    private JPanel mainPanel;
    private JTextField idToUpdateTextField;
    private JTextField updatedNameTextField;
    private JTextField UpdatedEmailTextField;
    private JTextField UpdatedAddressTextField;
    private JButton updateClientButton;
    private JTextField deleteClientTextField;
    private JButton deleteClientButton;
    private JPanel updatePanel;
    private JPanel deletePanel;
    private JTextField findClientTextField;
    private JButton findClientbutton;
    private JTable clientsTable;
    private JPanel tablePanel;
    private JButton refreshButton;
    private JButton backButton;

    public ClientFrame() {
        super("Client Frame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);

        addClientButton.addActionListener(e -> {
            Client client = new Client();
            ClientDAO clientDAO = new ClientDAO();

            client.setId(Integer.parseInt(idTextField.getText()));
            client.setName(nameTextField.getText());
            client.setEmail(emailTextField.getText());
            client.setAddress(addressTextField.getText());


            if (clientDAO.findById(Integer.parseInt(idTextField.getText())) != null) {
                JOptionPane.showConfirmDialog(null, "Client already exists!", "Error", JOptionPane.DEFAULT_OPTION);
                return;
            }

            clientDAO.insert(client);

            JOptionPane.showConfirmDialog(null, "Client added successfully!", "Success", JOptionPane.DEFAULT_OPTION);
        });

        updateClientButton.addActionListener(e -> {
            Client client = new Client();
            ClientDAO clientDAO = new ClientDAO();

            client.setId(Integer.parseInt(idToUpdateTextField.getText()));
            client.setName(updatedNameTextField.getText());
            client.setEmail(UpdatedEmailTextField.getText());
            client.setAddress(UpdatedAddressTextField.getText());

            if (clientDAO.findById(Integer.parseInt(idToUpdateTextField.getText())) == null) {
                JOptionPane.showConfirmDialog(null, "Client does not exist!", "Error", JOptionPane.DEFAULT_OPTION);
                return;
            }

            clientDAO.update(Integer.parseInt(idToUpdateTextField.getText()), client);

            JOptionPane.showConfirmDialog(null, "Client updated successfully!", "Success", JOptionPane.DEFAULT_OPTION);
        });

        deleteClientButton.addActionListener(e -> {
            ClientDAO clientDAO = new ClientDAO();

            if (clientDAO.findById(Integer.parseInt(deleteClientTextField.getText())) == null) {
                JOptionPane.showConfirmDialog(null, "Client does not exist!", "Error", JOptionPane.DEFAULT_OPTION);
                return;
            }

            clientDAO.delete(Integer.parseInt(deleteClientTextField.getText()));

            JOptionPane.showConfirmDialog(null, "Client deleted successfully!", "Success", JOptionPane.DEFAULT_OPTION);
        });

        findClientbutton.addActionListener(e -> {
            ClientDAO clientDAO = new ClientDAO();

            if (clientDAO.findById(Integer.parseInt(findClientTextField.getText())) == null) {
                JOptionPane.showConfirmDialog(null, "Client does not exist!", "Error", JOptionPane.DEFAULT_OPTION);
                return;
            }

            Client client = clientDAO.findById(Integer.parseInt(findClientTextField.getText()));

            JOptionPane.showConfirmDialog(null, "Client found successfully!\n" +
                    "ID: " + client.getId() + "\n" +
                    "Name: " + client.getName() + "\n" +
                    "Email: " + client.getEmail() + "\n" +
                    "Address: " + client.getAddress(), "Success", JOptionPane.DEFAULT_OPTION);
        });

        refreshButton.addActionListener(e -> {
            ClientDAO clientDAO = new ClientDAO();
            List<Client> clients = clientDAO.findAll();

            DefaultTableModel tableModel = clientDAO.retriveProperties(clients);

//            for (Client client : clients) {
//                tableModel.addRow(new Object[]{client.getId(), client.getName(), client.getEmail(), client.getAddress()});
//            }

            clientsTable.setModel(tableModel);
        });

        backButton.addActionListener(e -> {
            new MainFrame();
            this.dispose();
        });

        this.pack();
        this.setVisible(true);
    }
}
