package com.fhict.server;

import com.fhict.server.animals.Cat;
import com.fhict.server.animals.Dog;
import com.fhict.server.products.Product;

import java.io.*;
import java.util.ArrayList;

public class Webshop {
    ArrayList<ISellable> sellables = new ArrayList<>();
    private static final String filepath= System.getProperty("user.dir") + "/";

    public void NewProduct(String name, double price){
        ISellable sellable = new Product(name, price);
        this.sellables.add(sellable);
        writeToFile(sellable);
    }
    public void NewCat(String name, double price, Gender gender, String badHabits) {
        ISellable sellable = new Cat(name, price, gender, badHabits);
        this.getSellables().add(sellable);
        writeToFile(sellable);
    }

    public void NewDog(String name, double price, Gender gender) {
        ISellable sellable = new Dog(name, price, gender);
        this.getSellables().add(sellable);
        writeToFile(sellable);
    }
    public void RemoveProduct(ISellable sold) {
        sellables.removeIf(sellable -> sellable.equals(sold));
    }

    public ArrayList<ISellable> getSellables(){
        return sellables;
    }
    void setSellables(ArrayList<ISellable> sellables) {
        this.sellables = sellables;
    }

    public void writeToFile(ISellable iSellable) {
        try(FileWriter fw = new FileWriter("myfile.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(iSellable);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }
    }

    public static ArrayList<ISellable> readObjects()  {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("myfile.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<ISellable> objectsList = new ArrayList<ISellable>();
        boolean cont = true;
        while (cont) {
            try (ObjectInputStream input = new ObjectInputStream(fis)) {
                ISellable obj = (ISellable) input.readObject();
                if (obj != null) {
                    objectsList.add(obj);
                } else {
                    cont = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return objectsList;
    }
}
