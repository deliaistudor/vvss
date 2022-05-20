package pizzashop.model;

import java.util.List;

public class Order {
    private List<OrderItem> order;

    public Order(List<OrderItem> order) {
        this.order = order;
    }

    public List<OrderItem> getOrder() {
        return order;
    }

    public void addToOrder(OrderItem orderItem) {
        order.add(orderItem);
    }
}
