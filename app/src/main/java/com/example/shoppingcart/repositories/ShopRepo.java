package com.example.shoppingcart.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shoppingcart.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData<List<Product>> mutableProductList;

    //Carga de lista de productos de la tienda
    public LiveData<List<Product>> getProducts() {
        if (mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

//Lista de productos de la tienda
    private void loadProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(), "Audi e-tron", 95240, true, "https://www.autobild.es/sites/autobild.es/public/dc/fotos/Audi-e-tron-2020-C01.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Audi S8 TFSI", 180560, true, "https://static.motor.es/fotos-noticias/2019/11/precio-audi-a8-60-tfsi-e-quattro-201962855-1574849826_1.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "Audi TT", 58870, true, "https://static.motor.es/fotos-noticias/2021/12/audi-tt-tourist-trophy-202183643-1640078352_1.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "Audi R8 Coupé V10", 245100, false, "https://periodismodelmotor.com/wp-content/uploads/2020/01/prueba-audi-r8-v10-performance-quattro-1280x720.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "Mirai Luxury ", 75344, true, "https://d1eip2zddc2vdv.cloudfront.net/dphotos/750x400/15662892-1614274448.jpeg"));
        productList.add(new Product(UUID.randomUUID().toString(), "Highlander LUXURY", 66950, true, "https://www.diariomotor.com/imagenes/picscache/1920x1600c/toyota-highlander-2021-0121-021_1920x1600c.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "GR Supra Pure", 54990, true, "https://cdn.motor1.com/images/mgl/o0RAl/s1/prueba-toyota-gr-supra-pure-258-cv.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "Ford Fiesta", 20484, true, "https://cdn.drivek.it/configurator-imgs/cars/es/800/FORD/FIESTA/40810_BERLINA-5-PUERTAS/ford-fiesta-5-doors-2021.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "Ford EcoSport", 22566, true, "https://www.autobild.es/sites/autobild.es/public/styles/480/public/dc/fotos/Ford-EcoSport_ST-Line-2018-C01.jpg?itok=jQ_ncoZf"));
        productList.add(new Product(UUID.randomUUID().toString(), "Ford Mustang", 59366, true, "https://static.motor.es/fotos-noticias/2020/10/ford-mustang-herrod-sm17-edition-oficial-202071704-1602417606_11.jpg"));
        mutableProductList.setValue(productList);
    }
}
