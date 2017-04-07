package shopcart.cart.svc;

import shopcart.cart.model.ShoppingCart;
/**
        _____ __                      _             ______           __  _____                 _
       / ___// /_  ____  ____  ____  (_)___  ____ _/ ____/___ ______/ /_/ ___/___  ______   __(_)_______
      \__ \/ __ \/ __ \/ __ \/ __ \/ / __ \/ __ `/ /   / __ `/ ___/ __/\__ \/ _ \/ ___/ | / / / ___/ _ \
     ___/ / / / / /_/ / /_/ / /_/ / / / / / /_/ / /___/ /_/ / /  / /_ ___/ /  __/ /   | |/ / / /__/  __/
    /____/_/ /_/\____/ .___/ .___/_/_/ /_/\__, /\____/\__,_/_/   \__//____/\___/_/    |___/_/\___/\___/
                    /_/   /_/            /____/
*/
public interface ShoppingCartService {

    /**
     * Saves a shopping cart
     * @param cart A ShoppingCart
     */
    void saveCart(ShoppingCart cart);

    /**
     * Loads a user's shopping cart
     * @param userId The user
     * @return A ShoppingCart
     */
    ShoppingCart fetchCart(String userId);

}
