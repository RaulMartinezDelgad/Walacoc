package com.example.shoppingcart.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shoppingcart.models.CartItem;
import com.example.shoppingcart.models.Product;
import com.example.shoppingcart.repositories.CartRepo;
import com.example.shoppingcart.repositories.ShopRepo;

import java.util.List;

public class ShopViewModel extends ViewModel {

    ShopRepo shopRepo = new ShopRepo();
    CartRepo cartRepo = new CartRepo();

    MutableLiveData<Product> mutableProduct = new MutableLiveData<>();

    //Obtener productos

    public LiveData<List<Product>> getProducts() {
        return shopRepo.getProducts();
    }

    //Establecer producto

    public void setProduct(Product product) {
        mutableProduct.setValue(product);
    }

    //Obtener productos

    public LiveData<Product> getProduct() {
        return mutableProduct;
    }

    //Obtener carrito

    public LiveData<List<CartItem>> getCart() {
        return cartRepo.getCart();
    }

    //Añadir objeto al carrito

    public boolean addItemToCart(Product product) {
        return cartRepo.addItemToCart(product);
    }

    //Eliminar objeto del carrito

    public void removeItemFromCart(CartItem cartItem) {
        cartRepo.removeItemFromCart(cartItem);
    }

    //Cambiar la cantidad del objeto

    public void changeQuantity(CartItem cartItem, int quantity) {
        cartRepo.changeQuantity(cartItem, quantity);
    }

    //Obtener el precio total

    public LiveData<Double> getTotalPrice() {
        return cartRepo.getTotalPrice();
    }

    //Resetear el carrito

    public void resetCart() {
        cartRepo.initCart();
    }

}
