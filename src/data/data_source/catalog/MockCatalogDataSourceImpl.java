package data.data_source.catalog;

import data.models.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MockCatalogDataSourceImpl extends CatalogDataSource {
    @Override
    public void addToCart(Product product, int count, Comparator<Product> comparator) {

    }

    @Override
    public ArrayList<Product> getCatalog(int page, int limit, Comparator<Product> comparator) {
        ArrayList<Product> products = generateProducts();
        Stream<Product> productStream = products.stream().filter(e -> e.available)
                .sorted(comparator).skip((long) page * limit).limit(limit);
        return productStream.collect(Collectors.toCollection(ArrayList::new));

    }


    @Override
    public ArrayList<Product> getCatalog(int page, int limit) {
        ArrayList<Product> products = generateProducts();
        Stream<Product> productStream = products.stream().filter(e -> e.available).skip((long) page * limit)
                .limit(limit);
        return productStream.collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Product productById(String id) {
        ArrayList<Product> products = getCatalog(0, 9999999);
        for (Product p : products) {
            if (p.id.equals(id)) {
                return p;
            }
        }
        return null;
    }

    ArrayList<Product> generateProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("id1", "SmartPhone", "Best phone", 1000, true));
        products.add(new Product("id2", "Laptop", "Best laptop", 2000, true));
        products.add(new Product("id3", "Watch", "Best watch", 500, true));
        products.add(new Product("id4", "Phone", "Simple phone", 100, true));

        for (int i = 0; i < 20; i++) {
            products.add(new Product("id" + (i + 5), "Phone-" + i, "Simple phone", 100 + i * 1000, i % 4 != 0));
        }
        return products;
    }

}
