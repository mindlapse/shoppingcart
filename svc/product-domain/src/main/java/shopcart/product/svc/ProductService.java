package shopcart.product.svc;

import shopcart.product.model.Product;
/**
            ____                 __           __  _____                 _
           / __ \_________  ____/ /_  _______/ /_/ ___/___  ______   __(_)_______
          / /_/ / ___/ __ \/ __  / / / / ___/ __/\__ \/ _ \/ ___/ | / / / ___/ _ \
         / ____/ /  / /_/ / /_/ / /_/ / /__/ /_ ___/ /  __/ /   | |/ / / /__/  __/
        /_/   /_/   \____/\__,_/\__,_/\___/\__//____/\___/_/    |___/_/\___/\___/

 */
public interface ProductService {

    /**
     * Loads the products
     * @return The products
     */
    Iterable<Product> getProducts();
}
