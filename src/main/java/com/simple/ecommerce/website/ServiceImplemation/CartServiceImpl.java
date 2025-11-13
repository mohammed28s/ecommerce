package com.simple.ecommerce.website.ServiceImplemation;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.ecommerce.website.DTO.DtoMapper;
import com.simple.ecommerce.website.DTO.Cart.CartAddDTO;
import com.simple.ecommerce.website.DTO.Cart.CartItemDTO;
import com.simple.ecommerce.website.Entity.Cart;
import com.simple.ecommerce.website.Entity.Product;
import com.simple.ecommerce.website.Repository.CartRepository;
import com.simple.ecommerce.website.Repository.ProductRepository;
import com.simple.ecommerce.website.ServiceInterface.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl {


    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;



    @Override
    @Transactional
    public CartItemDTO addItem(Integer userId, CartAddDTO dto){
        User user = userService.getEntity(userId);

        Product product = productRepository.findById(dto.getProductId())
        .orElseThrow(() -> new
        RuntimeException("Product not found"));

        Cart cart = cartRepository.findByUserAndProduct(user, product)
                            .orElseGet(() -> Cart.builder()
                                               .user(user)
                                               .product(product)
                                               .quantity(0)
                                               .build());
        cart.setQuantity(cart.getQuantity() + dto.quantity());
        return DtoMapper.toCartItemDto(cartRepository.save(cart));
}


 @Override
    @Transactional(readOnly = true)
    public List<CartItemDto> getCart(Integer userId) {
        User user = userService.getEntity(userId);
        return cartRepo.findByUser(user)
                       .stream()
                       .map(DtoMapper::toCartItemDto)
                       .toList();
    }


  @Override
    @Transactional
    public void removeItem(Integer userId, Integer productId) {
        User user = userService.getEntity(userId);
        cartRepo.deleteByUserAndProduct(user,
               productRepo.getReferenceById(productId));
    }

    @Override
    @Transactional
    public void clearCart(Integer userId) {
        User user = userService.getEntity(userId);
        cartRepo.deleteByUser(user);
    }

}