package com.rachana.EcomProductService.service;

import com.rachana.EcomProductService.demo.Auther;
import com.rachana.EcomProductService.demo.Book;
import com.rachana.EcomProductService.module.Category;
import com.rachana.EcomProductService.module.Price;
import com.rachana.EcomProductService.module.Product;
import com.rachana.EcomProductService.module.ProductOrders;
import com.rachana.EcomProductService.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InisializeImp implements Inisialize {
    private final CategoryRepository categoryRepository;
    private final OrdersRepository ordersRepository;
    private final PriceRepository priceRepository;
   private final ProductRepository productRepository;
    private final AutherRepo autherRepo;

    public InisializeImp(CategoryRepository categoryRepository, OrdersRepository ordersRepository, PriceRepository priceRepository, ProductRepository productRepository, AutherRepo autherRepo) {
        this.categoryRepository = categoryRepository;
        this.ordersRepository = ordersRepository;
        this.priceRepository = priceRepository;
        this.productRepository = productRepository;
        this.autherRepo = autherRepo;
    }

    @Override
    public void initialize() {
        Category electronics=new Category();
        electronics.setCategoryName("Electronics");
        electronics=categoryRepository.save(electronics);

        Price PriceIphone=new Price();
        PriceIphone.setCurrency("INR");
        PriceIphone.setAmt(150000.0);
        PriceIphone.setDiscount(15);
        PriceIphone  =priceRepository.save(PriceIphone);


        Price PriceMacBook=new Price();
        PriceMacBook.setCurrency("INR");
        PriceMacBook.setAmt(250000.0);
        PriceMacBook.setDiscount(15);
        PriceMacBook=priceRepository.save(PriceMacBook);


        Price watch =new Price();
        watch.setCurrency("INR");
        watch.setAmt(85000.0);
        watch.setDiscount(15);
         watch =priceRepository.save(watch);

       Product IPhone=new Product();
       IPhone.setTitle("Iphone");
        IPhone.setDescription("best watch");
       IPhone.setCategory(electronics);
       IPhone.setPrice(PriceIphone);
      IPhone=productRepository.save(IPhone);

        Product MackBook=new Product();
       MackBook.setTitle("Mackbook");
       MackBook.setDescription("best in all OS");
       MackBook.setImage("http:/localhost/mackbook");
       MackBook.setCategory(electronics);
       MackBook.setPrice(PriceMacBook);
       MackBook = productRepository.save(MackBook);

        ProductOrders orders=new ProductOrders();
      orders.setProducts(List.of(MackBook,IPhone));
        orders =ordersRepository.save(orders);


         Auther auther=new Auther();
         auther.setName("rachana");
        Book book =new Book("book1",auther);
        Book book1=new Book("book2",auther);
        Book book2 =new Book("book3",auther);
        auther.setBook(List.of(book,book1,book2));

        Auther saveauther=autherRepo.save(auther);

        Auther savedauther=autherRepo.findById(1).get();
        List<Book> books=savedauther.getBook();
        System.out.println(books);
    }
}
