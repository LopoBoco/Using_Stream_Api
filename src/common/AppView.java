package common;

import data.comparators.AppComparator;
import data.models.Product;

import java.util.ArrayList;
import java.util.List;

public abstract class AppView {
    public final String title;
    public final ArrayList<AppView> children;
    public int nowPage = 0;
    public final int pageLimit = 5;
    public boolean hasNext = false;
    public final List<AppComparator<Product>> availableComparators;
    public AppComparator<Product> selectedComparator;

    public AppView(String title, ArrayList<AppView> children) {
        this.title = title;
        this.children = children;
        this.availableComparators = new ArrayList<>();
    }

    public void action() {}
}
