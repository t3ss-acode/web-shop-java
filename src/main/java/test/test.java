package test;

import BL.ProductBL;
import Entities.Product;

import java.util.ArrayList;
import java.util.Collection;

public class test {
    public static void main(String args[]){
        System.out.println("Starting test...");


        ArrayList<Product> list = (ArrayList<Product>) ProductBL.getProductsFromDB();
        printProductTable(list);

        Product newProduct = new Product("paper",32,"paper to be written on.");
        System.out.println(ProductBL.addProduct(newProduct));

        list = (ArrayList<Product>) ProductBL.getProductsFromDB();
        printProductTable(list);
        list.get(list.size()-1).setCost(25);
        System.out.println(ProductBL.updateProduct(list.get(list.size()-1)));

        list = (ArrayList<Product>) ProductBL.getProductsFromDB();
        printProductTable(list);
        System.out.println(ProductBL.removeProduct(list.get(list.size()-1)));

        list = (ArrayList<Product>) ProductBL.getProductsFromDB();
        printProductTable(list);

        System.out.println("Test over.");
    }

    private static void printProductTable(Collection<Product> list){
        for (Product p: list) {
            System.out.println("id:"+p.getId()+", name:"+p.getName()+", cost:"+p.getCost()+", desc:"+p.getDescription());
        }
        System.out.println();
    }
}
