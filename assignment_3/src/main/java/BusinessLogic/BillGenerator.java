package BusinessLogic;

import Models.Bill;
import Models.Orders;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class BillGenerator {
    private static final String LOG_PATH_FILE = "D:\\TP Repository\\TP2023_30222_Solomonean_Dan_Adrian_Assignment_3\\assignment_3\\src\\Logs\\bill_log.log";

    public void generateBill(Orders order, double total) {
        Bill bill = new Bill(order.getId(), order, total);
        String logMessage = bill.toString();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_PATH_FILE, true));
            writer.write(LocalDateTime.now().toString() + " - " + logMessage + "\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
