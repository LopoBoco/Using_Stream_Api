package data.data_source.order;

import data.models.Order;

public class MockOrderDataSourceImpl extends OrderDataSource{
    private Order order;

    @Override
    public void creatOrder(Order order) {
        this.order = order;
    }

    @Override
    public Order getOrder() {
        return order;
    }
}
