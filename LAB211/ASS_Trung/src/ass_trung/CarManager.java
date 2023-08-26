/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_trung;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CarManager {

    private static Scanner scanner = new Scanner(System.in);
    private static BrandList brandList = new BrandList();
    private static CarList carList = new CarList();

    public static void main(String[] args) {
        brandList.loadBrandsFromFile("brands.txt");
        carList.loadCarsFromFile("cars.txt");

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    listAllBrands();
                    break;
                case 2:
                    addNewBrand();
                    break;
                case 3:
                    searchBrandById();
                    break;
                case 4:
                    updateBrand();
                    break;
                case 5:
                    saveBrandsToFile("brands.txt");
                    break;
                case 6:
                    listAllCarsInAscendingOrder();
                    break;
                case 7:
                    listCarsByBrandName();
                    break;
                case 8:
                    addNewCar();
                    break;
                case 9:
                    removeCarById();
                    break;
                case 10:
                    updateCarById();
                    break;
                case 11:
                    saveCarsToFile("cars.txt");
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("---------- Car Showroom Manager ----------");
        System.out.println("1. List all brands");
        System.out.println("2. Add a new brand");
        System.out.println("3. Search a brand based on its ID");
        System.out.println("4. Update a brand");
        System.out.println("5. Save brands to file");
        System.out.println("6. List all cars in ascending order of brand names");
        System.out.println("7. List cars based on a part of an input brand name");
        System.out.println("8. Add a car");
        System.out.println("9. Remove a car based on its ID");
        System.out.println("10. Update a car based on its ID");
        System.out.println("11. Save cars to file");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

   

    

    private static void listAllBrands() {
        System.out.println("---------- List of Brands ----------");
        brandList.listAllBrands();
        System.out.println("-----------------------------------");
    }

    private static void addNewBrand() {
        System.out.println("---------- Add New Brand ----------");
        System.out.print("Enter Brand ID: ");
        String brandId = scanner.nextLine();
        if (brandList.isBrandIdExists(brandId)) {
            System.out.println("Brand ID already exists.");
            return;
        }
        System.out.print("Enter Brand Name: ");
        String brandName = scanner.nextLine();
        System.out.print("Enter Sound Brand: ");
        String soundBrand = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        Brand brand = new Brand(brandId, brandName, soundBrand, price);
        brandList.addBrand(brand);
        System.out.println("Brand added successfully.");
    }

    private static void searchBrandById() {
        System.out.println("---------- Search Brand by ID ----------");
        System.out.print("Enter Brand ID: ");
        String brandId = scanner.nextLine();
        Brand brand = brandList.getBrandById(brandId);
        if (brand != null) {
            System.out.println("Brand found:");
            System.out.println(brand.toString());
        } else {
            System.out.println("Brand not found.");
        }
    }

    private static void updateBrand() {
        System.out.println("---------- Update Brand ----------");
        System.out.print("Enter Brand ID: ");
        String brandId = scanner.nextLine();
        Brand brand = brandList.getBrandById(brandId);
        if (brand != null) {
            System.out.print("Enter Brand Name: ");
            String brandName = scanner.nextLine();
            System.out.print("Enter Sound Brand: ");
            String soundBrand = scanner.nextLine();
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character

            brandList.updateBrand(brandId, brandName, soundBrand, price);
            System.out.println("Brand updated successfully.");
        } else {
            System.out.println("Brand not found.");
        }
    }

    private static void saveBrandsToFile(String fileName) {
        brandList.saveToFile(fileName);
        System.out.println("Brands saved to file successfully.");
    }

    private static void listAllCarsInAscendingOrder() {
        System.out.println("---------- List of Cars in Ascending Order of Brand Names ----------");
        carList.listAllCars();
        System.out.println("------------------------------------------------------------------");
    }

    private static void listCarsByBrandName() {
        System.out.println("---------- List Cars by Brand Name ----------");
        System.out.print("Enter part of Brand Name: ");
        String brandName = scanner.nextLine();
      //  carList.listCarsByBrand(brandName);
    }

    private static void addNewCar() {
        System.out.println("---------- Add New Car ----------");
        System.out.print("Enter Car ID: ");
        String carId = scanner.nextLine();
        if (carList.isCarIdExists(carId)) {
            System.out.println("Car ID already exists.");
            return;
        }
        System.out.print("Enter Brand ID: ");
        String brandId = scanner.nextLine();
        if (!brandList.isBrandIdExists(brandId)) {
            System.out.println("Brand ID does not exist.");
            return;
        }
        System.out.print("Enter Color: ");
        String color = scanner.nextLine();
        System.out.print("Enter Frame ID: ");
        String frameId = scanner.nextLine();
        System.out.print("Enter Engine ID: ");
        String engineId = scanner.nextLine();

        Car car = new Car(carId, brandId, color, frameId, engineId);
        carList.addCar(car);
        System.out.println("Car added successfully.");
    }

    private static void removeCarById() {
        System.out.println("---------- Remove Car by ID ----------");
        System.out.print("Enter Car ID: ");
        String carId = scanner.nextLine();
        carList.removeCarById(carId);
        System.out.println("Car removed successfully.");
    }

    private static void updateCarById() {
        System.out.println("---------- Update Car by ID ----------");
        System.out.print("Enter Car ID: ");
        String carId = scanner.nextLine();
        Car car = carList.getCarById(carId);
        if (car != null) {
            System.out.print("Enter Brand ID: ");
            String brandId = scanner.nextLine();
            if (!brandList.isBrandIdExists(brandId)) {
                System.out.println("Brand ID does not exist.");
                return;
            }
            System.out.print("Enter Color: ");
            String color = scanner.nextLine();
            System.out.print("Enter Frame ID: ");
            String frameId = scanner.nextLine();
            System.out.print("Enter Engine ID: ");
            String engineId = scanner.nextLine();

            carList.updateCar(carId, brandId, color, frameId, engineId);
            System.out.println("Car updated successfully.");
        } else {
            System.out.println("Car not found.");
        }
    }

    private static void saveCarsToFile(String fileName) {
        carList.saveToFile(fileName);
        System.out.println("Cars saved to file successfully.");
    }
}
