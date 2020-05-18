package org.example;


import org.example.Connection.Conection;
import org.example.Model.Product;
import org.example.Service.ProductService;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ProductService service = new ProductService();
        Product pro = new Product.BuilderProduct()
                .name("yerba")
                .price(100.00)
                .brand("amanda")
                .unit(2)
                .quantity(50)
                .discount((float) 10)
                .build();
//        Product pro2 = new Product.BuilderProduct()
//                .name("Azucar")
//                //.price(100.00)
//                .brand("marolio")
//                .unit(2)
//                .quantity(50)
//                .discount((float) 10)
//                .build();
        //System.out.println("prodcuto pro1" + pro1.toString());
        //System.out.println( service.save(pro2));
        List<Product> listAllProducts = new ArrayList<>();

        listAllProducts.addAll(service.getAllProducts());

        for (Product product: listAllProducts ) {
            System.out.println("Producto " +product.toString());
        }
        System.out.println("--------------------------------");
        System.out.println(service.getById(2).toString());
        System.out.println("--------------------------------");
       // System.out.println("eliminar producto " + service.deleteProduct(3));
        System.out.println("--------------------------------");
       // listAllProducts.addAll(service.getAllProducts());
        Product pro2 = new Product.BuilderProduct()
                .name("Azucar")
                .price(100.00)
                .brand("marolio")
                .unit(2)
                .quantity(50)
                .discount((float) 10)
                .build();
        //System.out.println(service.updateProduct(pro2,2));

    }
}
