package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("--- Test Nº1: Seller FindById ---");
        Seller seller = sellerDao.findById(3);

        System.out.println("\n" + seller);

        System.out.println("\n\n--- Test Nº2: Seller FindByDepartment ---");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n\n--- Test Nº3: Seller FindAll ---");
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n\n--- Test Nº4: Seller Insert Data ---");
        Seller seller1 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 1500.55, department);
        sellerDao.insert(seller1);

        System.out.println("Inserted! New id: " + seller1.getId());

        System.out.println("\n\n--- Test Nº5: Seller Update ---");
        seller = sellerDao.findById(1);

        seller.setName("Marta Way");
        sellerDao.update(seller);

        System.out.println("Update completed!");

        System.out.println("\n\n--- Test Nº6: Seller Delete ---");

        System.out.println("Insert id for delete test: ");
        int id = sc.nextInt();

        sellerDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();

    }
}