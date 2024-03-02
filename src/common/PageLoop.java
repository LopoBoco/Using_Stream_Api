package common;

import java.util.Scanner;

public class PageLoop {
    public AppView view;

    int getChildrenSize() {
        return view.children.size();
    }

    int getOptionalSize() {
        int optionalSize = 0;
        if (view.hasNext) optionalSize++;
        optionalSize += view.availableComparators.size();
        return optionalSize;
    }

    public PageLoop(AppView view) {
        this.view = view;
    }

    public void run() {
        while (true) {
            view.action();
            displayChildren();
            final int fullSize = getChildrenSize() + getOptionalSize() + 1;
            try (Scanner in = new Scanner(System.in)) {
                int value = in.nextInt();
                if (value <= 0 || value > fullSize) {
                    System.out.println("Wrong value page");
                } else if (value == fullSize) {
                    break;
                } else if (value <= getChildrenSize()) {
                    AppView selectedView = view.children.get(value - 1);
                    new PageLoop(selectedView).run();
                } else {
                    view.nowPage = 0;
                    int comparatorIndex = value - getChildrenSize() - (view.hasNext ? 1 : 0);
                    view.selectedComparator = view.availableComparators.get(comparatorIndex);
                    new PageLoop(view).run();
                }
            }
        }
    }


    public void displayChildren() {
        int currentIndex = 1;
        System.out.println(view.title);
        System.out.println("Choose variant (from 1 to " + (view.children.size() + 1) + ")");
        for (int i = 0; i < view.children.size(); i++) {
            AppView _view = view.children.get(i);
            System.out.println(currentIndex + " - " + _view.title);
            currentIndex++;
        }
        if (view.hasNext) {
            System.out.println(currentIndex + " - " + "Next Page");
            currentIndex++;
        }
        for (int i = 0; i < view.availableComparators.size(); i++) {
            System.out.println(currentIndex + " - " + view.availableComparators.get(i).name);
            currentIndex++;
        }
        System.out.println((getChildrenSize() + getOptionalSize() + 1) + " - back");
    }
}
