package com.example.shoppingcart.models;

import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class CartItem {

    private Product product;
    private int quantity;

    //Objetos del carrito

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    //Obtener Producto

    public Product getProduct() {
        return product;
    }

    //Establecer producto

    public void setProduct(Product product) {
        this.product = product;
    }

    //Obtener cantidad

    public int getQuantity() {
        return quantity;
    }

    //Establecer cantidad

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    //To String
    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    //Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return getQuantity() == cartItem.getQuantity() &&
                getProduct().equals(cartItem.getProduct());
    }

    //Obtener el valor de la ruleta seleccionada
    @BindingAdapter("android:setVal")
    public static void getSelectedSpinnerValue(Spinner spinner, int quantity) {
        spinner.setSelection(quantity - 1, true);
    }

    public static DiffUtil.ItemCallback<CartItem> itemCallback = new DiffUtil.ItemCallback<CartItem>() {

        //Elementos iguales

        @Override
        public boolean areItemsTheSame(@NonNull CartItem oldItem, @NonNull CartItem newItem) {
            return oldItem.getQuantity() == newItem.getQuantity();
        }

        //Contenidos iguales

        @Override
        public boolean areContentsTheSame(@NonNull CartItem oldItem, @NonNull CartItem newItem) {
            return oldItem.equals(newItem);
        }
    };

}
