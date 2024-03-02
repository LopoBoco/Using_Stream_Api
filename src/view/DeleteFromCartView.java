package view;

import common.AppView;
import data.service.ShopService;

import java.util.ArrayList;

public class DeleteFromCartView extends AppView {

    final ShopService shopService;

    public DeleteFromCartView(ShopService shopService) {
        super("Empty cart", new ArrayList<>());
        this.shopService = shopService;
    }

    @Override
    public void action() {
       shopService.deleteItems();
    }
}

