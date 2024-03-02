package view;

import common.AppView;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderView extends AppView {
    final ShopService shopService;

    public OrderView( ShopService shopService) {
        super("Order", new ArrayList<>());
        this.shopService = shopService;
    }

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        System.out.println("Enter your phone");
        String phone = scanner.nextLine();
        System.out.println("Enter your address");
        String address = scanner.nextLine();
        System.out.println("Enter your paymentType");
        String paymentType = scanner.nextLine();
        System.out.println("Enter your deliveryTime");
        String deliveryTime = scanner.nextLine();

        shopService.creatOrder(name, phone, address, paymentType, deliveryTime);
    }
}
