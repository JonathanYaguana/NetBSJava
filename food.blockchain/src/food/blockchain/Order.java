/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.blockchain;

/**
 *
 * @author Mauricio
 */
public class Order {
    public String customer;
    public String details;
    public long total;
    
    public Order(String customer, String details, long total) {
        this.customer = customer;
        this.details = details;
        this.total = total;
    }
    
    public String getString() {
        return String.format(
                "Customer [%s] has ordered [%s], total [%d] VND",
                this.customer,
                this.details,
                this.total);
    }
}
