package com.simple.ecommerce.website.ServiceImplementation;






import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.simple.ecommerce.website.DTO.DtoMapper;
import com.simple.ecommerce.website.DTO.Order.OrderCreateDTO;
import com.simple.ecommerce.website.DTO.Order.OrderResponseDTO;
import com.simple.ecommerce.website.DTO.Cart.CartItemDTO;
import com.simple.ecommerce.website.Entity.Cart;
import com.simple.ecommerce.website.Entity.Order;
import com.simple.ecommerce.website.Entity.Product;
import com.simple.ecommerce.website.Entity.User;
import com.simple.ecommerce.website.Enum.OrderStatus;
import com.simple.ecommerce.website.Repository.CartRepository;
import com.simple.ecommerce.website.Repository.OrderRepository;
import com.simple.ecommerce.website.Repository.OrderRepostiory;
import com.simple.ecommerce.website.Repository.ProductRepository;
import com.simple.ecommerce.website.ServiceInterface.OrderService;
import com.simple.ecommerce.website.ServiceInterface.UserService;

public class OrderServiceImpl  implements OrderService {


    @Autowired
     private OrderRepository orderRepo;

     @Autowired
     private CartRepository cartRepo;

     @Autowired
     private UserService userService;

     @Autowired
     private ProductRepository productRepo;



    @Override
    @Transactional
    public OrderResponseDTO createOrder(Integer userId, OrderCreateDTO dto) {
        User user = userService.getEntity(userId);

        /* 1. convert DTO lines -> Cart entities */
        List<Cart> carts = dto.getItems()
                .stream()
                .map(i -> buildCart(user, i.getProductId(), i.getQuantity()))
                .toList();

        /* 2. total */
        BigDecimal total = carts.stream()
                .map(c -> c.getProduct()
                           .getPrice()
                           .multiply(BigDecimal.valueOf(c.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        /* 3. save order */
        Order order = new Order();
        order.setUser(user);
        order.setTotal(total);
        order.setStatus(OrderStatus.PENDING);
        order = orderRepo.save(order);

        /* 4. move cart -> order_items (here we simply clear cart) */
        cartRepo.saveAll(carts);
        cartRepo.deleteByUser(user);   // or keep them as order_lines table

        /* 5. return */
        List<CartItemDTO> lines = carts.stream()
                                       .map(DtoMapper::toCartItemDTO)
                                       .toList();
        return DtoMapper.toResponse(order, lines);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderResponseDTO> getMyOrders(Integer userId) {
        User user = userService.getEntity(userId);
        return orderRepo.findByUser(user)
                        .stream()
                        .map(o -> {
                            List<Cart> carts = cartRepo.findByUser(user); // simple demo
                            List<CartItemDTO> lines = carts.stream()
                                    .map(DtoMapper::toCartItemDTO)
                                    .toList();
                            return DtoMapper.toResponse(o, lines);
                        })
                        .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public OrderResponseDTO getOrder(Integer userId, Integer orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        if (!order.getUser().getId().equals(userId))
            throw new RuntimeException("Not your order");

        List<Cart> carts = cartRepo.findByUser(order.getUser());
        List<CartItemDTO> lines = carts.stream()
                                       .map(DtoMapper::toCartItemDTO)
                                       .toList();
        return DtoMapper.toResponse(order, lines);
    }

    /* helper */
    private Cart buildCart(User user, Integer productId, Integer qty) {
        Product p = productRepo.findById(productId)
                 .orElseThrow(() -> new RuntimeException("Product not found"));
        return Cart.builder()
                   .user(user)
                   .product(p)
                   .quantity(qty)
                   .build();
    }


}
