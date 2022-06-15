package com.example.shoppingcart.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingcart.R;
import com.example.shoppingcart.adapters.CartListAdapter;
import com.example.shoppingcart.databinding.FragmentCartBinding;
import com.example.shoppingcart.models.CartItem;
import com.example.shoppingcart.viewmodels.ShopViewModel;

import java.util.List;

public class CartFragment extends Fragment implements CartListAdapter.CartInterface {


    private static final String TAG = "CartFragment";
    ShopViewModel shopViewModel;
    FragmentCartBinding fragmentCartBinding;
    NavController navController;

    public CartFragment() {
        // Constructor público vacío
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el diseño
        fragmentCartBinding = FragmentCartBinding.inflate(inflater, container, false);
        return fragmentCartBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Navegación a un destino
        navController = Navigation.findNavController(view);

        //CartListAdapter Contiene metodos de eliminar, cambiar cantidad, etc.
        final CartListAdapter cartListAdapter = new CartListAdapter(this);
        fragmentCartBinding.cartRecyclerView.setAdapter(cartListAdapter);
        fragmentCartBinding.cartRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        //Modelo del vehículo
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        //Obtener los items seleccionados
        shopViewModel.getCart().observe(getViewLifecycleOwner(), new Observer<List<CartItem>>() {
            @Override
            public void onChanged(List<CartItem> cartItems) {
                cartListAdapter.submitList(cartItems);
                fragmentCartBinding.placeOrderButton.setEnabled(cartItems.size() > 0);
            }
        });

        //Obtener el precio total
        shopViewModel.getTotalPrice().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                fragmentCartBinding.orderTotalTextView.setText("Total: $ " + aDouble.toString());
            }
        });


        //OnClick para navegar a action_cartFragment_to_orderFragment
        fragmentCartBinding.placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_cartFragment_to_orderFragment);
            }
        });

    }

    //Eliminar objeto
    @Override
    public void deleteItem(CartItem cartItem) {
        shopViewModel.removeItemFromCart(cartItem);
    }

    //Cambiar cantidad

    @Override
    public void changeQuantity(CartItem cartItem, int quantity) {
        shopViewModel.changeQuantity(cartItem, quantity);
    }


}