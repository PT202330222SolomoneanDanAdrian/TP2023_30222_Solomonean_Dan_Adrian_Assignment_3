package Models;
/*** This is a record which represents the Bill class.
 * It is a record because the bills should be immutable data.*/
public record Bill(int id, Orders order, double total) {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bill ID: ").append(id).append("\n");
        sb.append("Order ID: ").append(order.getId()).append("\n");
        sb.append("Client ID: ").append(order.getClientId()).append("\n");
        sb.append("Product ID: ").append(order.getProductId()).append("\n");
        sb.append("Total: ").append(order.getTotal()).append("\n");

        return sb.toString();
    }
}
