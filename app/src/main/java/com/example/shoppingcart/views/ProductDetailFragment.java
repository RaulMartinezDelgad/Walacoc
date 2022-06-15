package com.example.shoppingcart.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingcart.R;
import com.example.shoppingcart.adapters.ShopListAdapter;
import com.example.shoppingcart.databinding.FragmentProductDetailBinding;
import com.example.shoppingcart.viewmodels.ShopViewModel;

public class ProductDetailFragment extends Fragment {

    FragmentProductDetailBinding fragmentProductDetailBinding;
    ShopViewModel shopViewModel;

    public ProductDetailFragment() {
        // Constructor público vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el diseño
        fragmentProductDetailBinding = FragmentProductDetailBinding.inflate(inflater, container, false);
        return fragmentProductDetailBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Modelo del vehiculo
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        fragmentProductDetailBinding.setShopViewModel(shopViewModel);
    }
}