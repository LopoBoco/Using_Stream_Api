import common.AppView;
import common.PageLoop;
import data.comparators.AppComparator;
import data.comparators.PriceComparator;
import data.data_source.cart.CartDataSource;
import data.data_source.cart.MockCartDataSourceImpl;
import data.data_source.catalog.CatalogDataSource;
import data.data_source.catalog.MockCatalogDataSourceImpl;
import data.data_source.order.MockOrderDataSourceImpl;
import data.data_source.order.OrderDataSource;
import data.models.Product;
import data.service.ShopService;
import view.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CatalogDataSource catalogDataSource = new MockCatalogDataSourceImpl();
        CartDataSource cartDataSource = new MockCartDataSourceImpl();
        OrderDataSource orderDataSource = new MockOrderDataSourceImpl();
        ShopService shopService = new ShopService(catalogDataSource,cartDataSource,orderDataSource);

        AppView addToCartView = new AddToCartView(shopService);

        ArrayList<AppView> catalogChildren = new ArrayList<>();
        catalogChildren.add(addToCartView);
        List<AppComparator<Product>> catalogComparators = new ArrayList<>();
        catalogComparators.add(new AppComparator<>(new PriceComparator(true), "Price Asc"));
        catalogComparators.add(new AppComparator<>(new PriceComparator(false), "Price Desc"));
        AppView catalogView = new CatalogView(catalogChildren, shopService, catalogComparators);

        AppView cartView = new CartView(shopService);
        AppView orderView = new OrderView(shopService);
        AppView deleteView = new DeleteFromCartView(shopService);

        ArrayList<AppView> mainChildren = new ArrayList<>();
        mainChildren.add(catalogView);
        mainChildren.add(cartView);
        mainChildren.add(orderView);
        mainChildren.add(deleteView);
        AppView mainView = new MainView(mainChildren);

        new PageLoop(mainView).run();
    }
}
