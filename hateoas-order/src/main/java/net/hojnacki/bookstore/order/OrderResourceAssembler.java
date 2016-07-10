package net.hojnacki.bookstore.order;

import net.hojnacki.bookstore.order.web.OrderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class OrderResourceAssembler extends ResourceAssemblerSupport<Order, OrderResource> {

    public OrderResourceAssembler() {
        super(OrderController.class, OrderResource.class);
    }

    public OrderResource toResource(Order order) {
        OrderResource result = instantiateResource(order);
        result.setOrderId(order.getOrderId());
        result.setBookIds(order.getBookIds());
        result.setPaid(order.isPaid());
        result.add(linkTo(methodOn(OrderController.class).getOrder(order.getOrderId())).withSelfRel());
        result.add(linkTo(methodOn(OrderController.class).updateOrder(order.getOrderId(), null)).withRel("addBook"));
        result.add(linkTo(methodOn(OrderController.class).payOrder(order.getOrderId())).withRel("pay"));
        return result;
    }

}
