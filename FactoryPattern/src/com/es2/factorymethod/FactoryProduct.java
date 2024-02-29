package com.es2.factorymethod;

public abstract class FactoryProduct {
    public static Product makeProduct(String type) throws UndefinedProductException {
        switch (type) {
            case "Software":
                return new Software();
            case "Computer":
                return new Computer();
            default:
                throw new UndefinedProductException("Invalid product");
        }
    }
}
