package DataAccess;
import Models.Orders;

import java.util.List;
import java.util.logging.Logger;

public class OrderDAO extends AbstractDAO<Orders> {
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());


    public List<Orders> findAll() {
        List<Orders> orders = super.findAll();

        return orders;
    }
    public Orders findById(int id) {
        Orders order = super.findById(id);

        return order;
    }

    public Orders insert(Orders order) {
        Orders insertedOrder = super.insert(order);

        return insertedOrder;
    }

    public Orders update(int id, Orders order) {
        Orders updatedOrder = super.update(id, order);

        return updatedOrder;
    }

    public boolean delete(int id) {
        boolean deletedOrder = super.delete(id);

        return deletedOrder;
    }
}


