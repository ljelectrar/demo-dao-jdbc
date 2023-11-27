package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
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

        System.out.println("\n\n\n\n=========*========= HERE START DEPARTMENT CONSULT ============*=========");
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: findById =======");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("\n=== TEST 2: findAll =======");
        List<Department> list2 = departmentDao.findAll();
        for (Department d : list2) {
            System.out.println(d);
        }

        System.out.println("\n=== TEST 3: insert =======");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println("\n=== TEST 4: update =======");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("Food");
        departmentDao.update(dep2);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 5: delete =======");
        System.out.print("Enter id for delete test: ");
        int id2 = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}