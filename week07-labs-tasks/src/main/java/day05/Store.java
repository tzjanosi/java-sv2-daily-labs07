package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {
    List<Product> productList=new ArrayList<>();
    public void addProduct(Product p){
        if(isDateValid(p.getDateOfSelling())) {
            productList.add(p);
        }
    }
    private boolean isDateValid(LocalDate date){
        if(date.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("The date is not correct!");
        }
        return true;
    }
    public void writeOut(int year, int month){
        List<String> outputStringList = new ArrayList<>();
        String outputString;
        for(Product product:productList){
            if(product.getDateOfSelling().getYear()==year && product.getDateOfSelling().getMonthValue()==month){
                outputString=product.getName()+";"+product.getDateOfSelling()+";"+product.getPrice();
                outputStringList.add(outputString);
            }
        }
        try {
            Files.write(Paths.get("src/main/resources/products_"+year+"-"+month+".txt"), outputStringList);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Store store=new Store();
        Product product=new Product("Trabant", LocalDate.of(2021, 11, 13), 150000);
        store.addProduct(product);
        product=new Product("Wartburg", LocalDate.of(2021, 11, 14), 160000);
        store.addProduct(product);
        product=new Product("Dacia", LocalDate.of(2021, 4, 1), 165000);
        store.addProduct(product);

        store.writeOut(2021,4);
        store.writeOut(2021,10);
        store.writeOut(2021,11);
    }
}
