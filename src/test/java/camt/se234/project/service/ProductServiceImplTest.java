package camt.se234.project.service;

import camt.se234.project.dao.ProductDao;
import camt.se234.project.entity.Product;

import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {
    ProductDao productDao;
    ProductServiceImpl productService;

    @Before
    public void setup() {
        productDao = mock(ProductDao.class);
        productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product("1", "apple", "Kind of fruit", "location", 35.0));
        mockProducts.add(new Product("2", "yogurt", "milk product", "location", 12.0));
        mockProducts.add(new Product("3", "khao soi", "spicy soup with noodle", "location", 0.0));
        when(productDao.getProducts()).thenReturn(mockProducts);
        assertThat(productService.getAllProducts(), hasItems(
                new Product("1", "apple", "Kind of fruit", "location",35.0),
                new Product("2", "yogurt", "milk product", "location", 12.0),
                new Product("3", "khao soi", "spicy soup with noodle", "location", 0.0)));

    }

    @Test
    public void testGetAvailableProducts() {
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product("1", "apple", "Kind of fruit", "location", 35.0));
        mockProducts.add(new Product("2", "yogurt", "milk product", "location", 12.0));
        mockProducts.add(new Product("3", "khao soi", "spicy soup with noodle", "location", 0.0));
        when(productDao.getProducts()).thenReturn(mockProducts);
        assertThat(productService.getAvailableProducts(), hasItems(
                new Product("1", "apple", "Kind of fruit", "location",35.0),
                new Product("2", "yogurt", "milk product", "location", 12.0)));

    }

    @Test
    public void testGetUnavailableProductSize() {
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product("1", "apple", "Kind of fruit", "location", 35.0));
        mockProducts.add(new Product("2", "yogurt", "milk product", "location", 12.0));
        mockProducts.add(new Product("3", "khao soi", "spicy soup with noodle", "location", 0.0));
        when(productDao.getProducts()).thenReturn(mockProducts);
        assertThat(productService.getUnavailableProductSize(), is(1));
    }
}
