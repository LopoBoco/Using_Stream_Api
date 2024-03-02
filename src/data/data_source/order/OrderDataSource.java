package data.data_source.order;

import data.models.Order;

public abstract class OrderDataSource {

    public abstract void creatOrder(Order order);
    public abstract Order getOrder();
}
