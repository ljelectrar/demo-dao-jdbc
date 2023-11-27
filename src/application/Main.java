package application;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Department obj = new Department(1, "Books");
        Seller seller = new Seller(23, "Leandro", "leandro@email.com", new Date(), 4000.00, obj);

        System.out.println(obj);
        System.out.println("\n" + seller);
    }
}