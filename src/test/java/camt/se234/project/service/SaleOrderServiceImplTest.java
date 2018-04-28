package camt.se234.project.service;

import camt.se234.project.dao.OrderDao;
import camt.se234.project.entity.Product;
import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaleOrderServiceImplTest {
    OrderDao orderDao;
    SaleOrderServiceImpl saleOrderService;

    @Before
    public void setup() {
        orderDao = mock(OrderDao.class);
        saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
    }

    @Test
    public void testGetSaleOrders() {
        List<SaleTransaction> mockTransactions1 = new ArrayList<>();
        List<SaleTransaction> mockTransactions2 = new ArrayList<>();
        mockTransactions1.add(new SaleTransaction("transaction1", new SaleOrder("saleOrder1", mockTransactions1),
                new Product("1", "apple", "Kind of fruit", "location",35.0), 5));
        mockTransactions2.add(new SaleTransaction("transaction2", new SaleOrder("saleOrder2", mockTransactions2),
                new Product("2", "yogurt", "milk product", "location", 12.0), 2));
        List<SaleOrder> mockOrders = new ArrayList<>();
        mockOrders.add(new SaleOrder("saleOrder1", mockTransactions1));
        mockOrders.add(new SaleOrder("saleOrder2", mockTransactions2));
        when(orderDao.getOrders()).thenReturn(mockOrders);
        assertThat(saleOrderService.getSaleOrders(), hasItems(new SaleOrder("saleOrder1", mockTransactions1),
                new SaleOrder("saleOrder2", mockTransactions2)));
    }

    @Test
    public void testAverageSaleOrderPrice() {
        List<SaleTransaction> mockTransactions1 = new ArrayList<>();
        List<SaleTransaction> mockTransactions2 = new ArrayList<>();
        mockTransactions1.add(new SaleTransaction("transaction1", new SaleOrder("saleOrder1", mockTransactions1),
                new Product("1", "apple", "Kind of fruit", "location",35.0), 5));
        mockTransactions2.add(new SaleTransaction("transaction2", new SaleOrder("saleOrder2", mockTransactions2),
                new Product("2", "yogurt", "milk product", "location", 12.0), 2));
        List<SaleOrder> mockOrders = new ArrayList<>();
        mockOrders.add(new SaleOrder("saleOrder1", mockTransactions1));
        mockOrders.add(new SaleOrder("saleOrder2", mockTransactions2));
        when(orderDao.getOrders()).thenReturn(mockOrders);
        assertThat(saleOrderService.getAverageSaleOrderPrice(), is(99.5));
    }
}
