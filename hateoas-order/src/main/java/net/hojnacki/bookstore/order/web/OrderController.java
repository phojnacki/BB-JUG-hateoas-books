package net.hojnacki.bookstore.order.web;

import net.hojnacki.bookstore.book.BookIdResource;
import net.hojnacki.bookstore.order.Order;
import net.hojnacki.bookstore.order.OrderRepository;
import net.hojnacki.bookstore.order.OrderResource;
import net.hojnacki.bookstore.order.OrderResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderResourceAssembler orderResourceAssembeler;

    @RequestMapping(path = "/orders/{id}", method = RequestMethod.GET)
    public HttpEntity<OrderResource> getOrder(@PathVariable String id) {
        OrderResource orderResource = orderResourceAssembeler.toResource(orderRepository.getOrder(id));
        return new ResponseEntity(orderResource, HttpStatus.OK);
    }

    @RequestMapping(path = "/books/{bookId}/order", method = RequestMethod.POST)
    public HttpEntity<OrderResource> makeOrder(@PathVariable String bookId) {
        Order order = new Order();
        List<String> bookIds = new ArrayList<>();
        bookIds.add(bookId);
        order.setBookIds(bookIds);

        Order addedOrder = orderRepository.addOrder(order);
        return new ResponseEntity(orderResourceAssembeler.toResource(addedOrder), HttpStatus.OK);
    }

    @RequestMapping(path = "/orders/{orderId}", method = RequestMethod.PATCH )
    public HttpEntity<OrderResource> updateOrder(@PathVariable String orderId, @RequestBody BookIdResource book) {
        Order order = orderRepository.getOrder(orderId);
        order.getBookIds().add(book.getBookId());

        Order updatedOrder = orderRepository.updateOrder(order);
        return new ResponseEntity(orderResourceAssembeler.toResource(updatedOrder), HttpStatus.OK);
    }

    @RequestMapping(path = "/orders/{id}/payment", method = RequestMethod.POST)
    public HttpEntity<OrderResource> payOrder(@PathVariable String id) {
        Order order = orderRepository.getOrder(id);
        order.setPaid(true);

        Order paidOrder = orderRepository.updateOrder(order);
        return new ResponseEntity(orderResourceAssembeler.toResource(paidOrder), HttpStatus.OK);
    }

}
