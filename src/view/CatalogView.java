package view;

import common.AppView;
import data.comparators.AppComparator;
import data.comparators.PriceComparator;
import data.models.Product;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.List;

public class CatalogView extends AppView {
    public final ShopService shopService;

    public CatalogView(ArrayList<AppView> children, ShopService shopService, List<AppComparator<Product>> comparators) {
        super("Catalog", children);
        this.shopService = shopService;
        availableComparators.addAll(comparators);
        if (!availableComparators.isEmpty()) {
            selectedComparator = availableComparators.get(0);
        }
    }

    @Override
    public void action() {
        PriceComparator comparator = new PriceComparator();
        comparator.isAsc = false;
        ArrayList<Product> catalog = shopService.getCatalog(nowPage, pageLimit, selectedComparator.comparator);
        hasNext = catalog.size() == pageLimit;
        for (Product product : catalog) {
            System.out.println(product.id + " " + product.title + " " + product.price);
        }
        System.out.println();
    }
}
