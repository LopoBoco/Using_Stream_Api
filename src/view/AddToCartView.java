package view;

import common.AppView;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class AddToCartView extends AppView {

    final ShopService shopService;

    public AddToCartView(ShopService shopService) {
        super("Add product", new ArrayList<>());
        this.shopService = shopService;
    }

    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter id of the product");
        String productId = in.nextLine();
        if (productId == null) {
            return;
        }
        System.out.println("Enter count");
        int count = in.nextInt();
        final boolean res = shopService.addToCart(productId, count);
        if(res) {
            System.out.println("Product is added");
        }else {
            System.out.println("Product is NOT added");
        }
    }
}

