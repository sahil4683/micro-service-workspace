//package com.mic;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//public class ProductServiceTest {
//
//    @Mock
//    private ProductRepository productRepository;
//
//    @InjectMocks
//    private ProductServiceTest productService;
//
//    private Product testProduct;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//        testProduct = new Product();
//        testProduct.setId(1L);
//        testProduct.setName("Test Product");
//        testProduct.setPrice(10.99);
//    }
//
//    @Test
//    public void testGetProductById() {
//        when(productRepository.findById(1L)).thenReturn(Optional.of(testProduct));
//
//        Product result = productService.getProductById(1L);
//
//        assertEquals("Test Product", result.getName());
//        assertEquals(10.99, result.getPrice());
//    }
//
//    @Test
//    public void testGetProductById_NotFound() {
//        when(productRepository.findById(2L)).thenReturn(Optional.empty());
//
//        assertThrows(ResourceNotFoundException.class, () -> productService.getProductById(2L));
//    }
//
//    // Add more test methods for other service methods...
//}
