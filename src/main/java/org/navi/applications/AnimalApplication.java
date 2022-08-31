package org.navi.applications;

import org.navi.dao.DB;
import org.navi.pojo.Animal;

import java.sql.SQLException;
import java.util.Scanner;

public class AnimalApplication {
    public static void main(String[] args) throws SQLException {
        DB db = new DB();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1: Add 2: update: 3: Delete 4: Print Table");
            int response = scanner.nextInt();

            if (response == 1) {
                // Adding or saving the data to database
                System.out.println("Name of the Animal: ");
                String name = scanner.next();
                System.out.println("Breed of the Animal: ");
                String breed = scanner.next();
                System.out.println("Rows affected: " + db.save(name, breed));

            } else if (response == 2) {
                //update the data
                System.out.println("Name to be updated");
                String nameUpdate = scanner.next();
                System.out.println("New Name of the Animal: ");
                String name = scanner.next();
                System.out.println("Breed of the Animal: ");
                String breed = scanner.next();
                System.out.println("Rows affected: " + db.update(nameUpdate, name, breed));
            } else if (response == 3) {
                //delete the data
                System.out.println("Name of the Animal to delete: ");
                String name = scanner.next();
                System.out.println("Rows affected: " + db.delete(name));

            } else if (response == 4) {
                //Print the data
                db.listOFAllAnimals().forEach(Animal -> System.out.print(Animal.getName() + "  " + Animal.getBreed() + "\n"));


            } else {
                System.out.println("try again");
            }
        }
    }
}
