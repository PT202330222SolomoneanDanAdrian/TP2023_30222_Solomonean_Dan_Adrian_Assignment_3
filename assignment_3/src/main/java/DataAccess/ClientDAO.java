package DataAccess;

import Models.Client;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.logging.Logger;

public class ClientDAO extends AbstractDAO<Client> {
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());

    public Client findById(int id) {
        Client client = super.findById(id);

        return client;
    }

    public List<Client> findAll() {
        List<Client> clients = super.findAll();

        return clients;
    }

    public Client insert(Client client) {
        Client insertedClient = super.insert(client);

        return insertedClient;
    }

    public Client update(int id, Client client) {
        Client updatedClient = super.update(id, client);

        return updatedClient;
    }

    public boolean delete(int id) {
        boolean deletedClient = super.delete(id);

        return deletedClient;
    }

    public DefaultTableModel retriveProperties(List<Client> clients) {
        return super.retriveProperties(clients);
    }
}
