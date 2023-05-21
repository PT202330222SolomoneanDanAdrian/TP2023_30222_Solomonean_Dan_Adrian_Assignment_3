package Models;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {

    private int id;
    private int clientId;
    private Date date;
    private BigDecimal total;

    private int productId;

    public Orders() {

    }

    public Orders(int id, int clientId, Date date, BigDecimal total, int productId) {
        this.id = id;
        this.clientId = clientId;
        this.date = date;
        this.total = total;
        this.productId = productId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
