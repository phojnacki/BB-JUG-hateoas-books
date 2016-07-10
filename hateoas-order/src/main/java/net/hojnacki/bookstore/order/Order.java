package net.hojnacki.bookstore.order;


import java.util.Collection;

public class Order {

    private  String orderId;
    private  Collection<String> bookIds;
    private boolean isPaid;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Collection<String> getBookIds() {
        return bookIds;
    }

    public void setBookIds(Collection<String> bookIds) {
        this.bookIds = bookIds;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
