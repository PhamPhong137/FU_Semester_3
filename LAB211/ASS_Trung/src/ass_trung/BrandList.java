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

public class BrandList {

    private List<Brand> brands;

    public BrandList() {
        brands = new ArrayList<>();
    }

    public void addBrand(Brand brand) {
        brands.add(brand);
    }

    public boolean isBrandIdExists(String brandId) {
        for (Brand brand : brands) {
            if (brand.getBrandId().equals(brandId)) {
                return true;
            }
        }
        return false;
    }

    public Brand getBrandById(String brandId) {
        for (Brand brand : brands) {
            if (brand.getBrandId().equals(brandId)) {
                return brand;
            }
        }
        return null;
    }

    public void updateBrand(String brandId, String brandName, String soundBrand, double price) {
        Brand brand = getBrandById(brandId);
        if (brand != null) {
            brand.setBrandName(brandName);
            brand.setSoundBrand(soundBrand);
            brand.setPrice(price);
        }
    }

    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Brand brand : brands) {
                writer.println(brand.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listAllBrands() {
        for (Brand brand : brands) {
            System.out.println(brand.toString());
        }
    }

    public void loadBrandsFromFile(String fileName) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 4) {
                    String brandId = parts[0];
                    String brandName = parts[1];
                    String soundBrand = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    
                    addBrand(new Brand(brandId, brandName, soundBrand, price));                   
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
