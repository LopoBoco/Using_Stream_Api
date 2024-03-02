package view;

import common.AppView;
import data.models.CartItem;
import data.service.ShopService;

import java.util.ArrayList;

public class CartView extends AppView {
    final ShopService shopService;

    public CartView(ShopService shopService) {
        super("Cart", new ArrayList<>());
        this.shopService = shopService;
    }

    @Override
    public void action() {
        ArrayList<CartItem> cartList = shopService.getCart();
        for (CartItem cart : cartList) {
            System.out.println(cart.product.id + " " + cart.product.title + " " + cart.count);
        }
        System.out.println();
    }
}
