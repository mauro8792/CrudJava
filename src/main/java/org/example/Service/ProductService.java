package org.example.Service;

import org.example.Connection.Conection;
import org.example.Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    Connection conexion = Conection.getConnect();

    public Boolean save(Product product){
        Boolean rtn=false;
        PreparedStatement query;
        try {
            query = this.conexion.prepareStatement("Insert into products (name, price,brand,unit,quantity, discount) values (?,?,?,?,?,?)");
            query.setString(1,product.getName());
            query.setDouble(2,product.getPrice()!= null ? product.getPrice() : 0);
            query.setString(3,product.getBrand());
            query.setInt(4,product.getUnit());
            query.setInt(5, product.getQuantity());
            query.setFloat(6,product.getDiscount());
            query.execute();
            rtn = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rtn;
    }

    public List<Product> getAllProducts(){
        PreparedStatement query;
        List<Product> productos = new ArrayList<>();
        try {
            ResultSet listProducts;
            query = this.conexion.prepareStatement("Select * from products");
            listProducts = query.executeQuery();

            while (listProducts.next()){
                productos.add(
                        new Product.BuilderProduct()
                        .id(listProducts.getInt("id"))
                        .name(listProducts.getString("name"))
                        .brand(listProducts.getString("brand"))
                        .price(listProducts.getDouble("price"))
                        .unit(listProducts.getInt("unit"))
                        .quantity(listProducts.getInt("quantity"))
                        .discount(listProducts.getFloat("discount"))
                        .build()
                );
            }
            return productos;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productos;
    }

    public Product getById(int id){
       Product result1 = new Product();
        PreparedStatement query;
        try {
            ResultSet rProduct;
            query = this.conexion.prepareStatement("select * from products where id = ?");
            query.setInt(1,id);
            rProduct=query.executeQuery();
            while (rProduct.next()) {
                Product result = new Product.BuilderProduct()
                        .id(rProduct.getInt("id"))
                        .name(rProduct.getString("name"))
                        .brand(rProduct.getString("brand"))
                        .price(rProduct.getDouble("price"))
                        .unit(rProduct.getInt("unit"))
                        .quantity(rProduct.getInt("quantity"))
                        .discount(rProduct.getFloat("discount"))
                        .build();

                result1 = result;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  result1;
    }

    public Boolean deleteProduct(int id){
        Boolean rtn=false;
        PreparedStatement query;
        try {
            query = this.conexion.prepareStatement("Delete from products where id = ?");
            query.setInt(1,id);
            query.execute();
            rtn = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rtn;
    }

    public Boolean updateProduct(Product product, int id){
        Boolean rtn=false;
        Product oldPr= new Product();
        oldPr = getById(id);
        PreparedStatement query;
        try {
            query = this.conexion.prepareStatement(
                    "update products set name = ?, price = ?, brand = ?, unit = ?, quantity= ?, discount = ?" +
                            "where id = ?");
            query.setString(1,product.getName()!= null ? product.getName() : oldPr.getName());
            query.setDouble(2,product.getPrice()!= null ? product.getPrice() : oldPr.getPrice());
            query.setString(3,product.getBrand()!= null ? product.getBrand() : oldPr.getBrand());
            query.setInt(4,product.getUnit()!= null ? product.getUnit() : oldPr.getUnit());
            query.setInt(5, product.getQuantity()!= null ? product.getQuantity() : oldPr.getQuantity());
            query.setFloat(6,product.getDiscount()!= null ? product.getDiscount() : oldPr.getDiscount());
            query.setInt(7,oldPr.getId());
            query.executeUpdate();
            rtn = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  rtn;

    }
}
