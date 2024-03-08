package com.es2.composite;

import java.util.List;
import java.util.ArrayList;

public class SubMenu extends Menu {
    private final List<Menu> children;

    public SubMenu() {
        this.children = new ArrayList<>();
    }

    public void addChild(Menu child) {
        children.add(child);
    }

    public void showOptions() {
        System.out.println(getLabel());
        for (Menu child : children) {
            child.showOptions();
        }
    }

    public void removeChild(Menu child) {
        children.remove(child);
    }
}
