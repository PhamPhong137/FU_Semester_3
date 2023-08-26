/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_trung;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CarList {

    private List<Car> cars;

    public CarList() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public boolean isCarIdExists(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId)) {
                return true;
            }
        }
        return false;
    }

    public Car getCarById(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId)) {
                return car;
            }
        }
        return null;
    }

    public void removeCarById(String carId) {
        Car car = getCarById(carId);
        if (car != null) {
            cars.remove(car);
        }
    }

    public void updateCar(String carId, String brandId, String color, String frameId, String engineId) {
        Car car = getCarById(carId);
        if (car != null) {
            car.setBrandId(brandId);
            car.setColor(color);
            car.setFrameId(frameId);
            car.setEngineId(engineId);
        }
    }

    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Car car : cars) {
                writer.println(car.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listAllCars() {
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }

//    public void listCarsByBrand(String brandName) {
//        for (Car car : cars) {
//            Brand brand = BrandList.getBrandById(car.getBrandId());
//            if (brand != null && brand.getBrandName().contains(brandName)) {
//                System.out.println(car.toString());
//            }
//        }
//    }
    
    public void loadCarsFromFile(String fileName) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 5) {
                    String carId = parts[0];
                    String brandId = parts[1];
                    String color = parts[2];
                    String frameId = parts[3];
                    String engineId = parts[4];
                    addCar(new Car(carId, brandId, color, frameId, engineId));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
}
