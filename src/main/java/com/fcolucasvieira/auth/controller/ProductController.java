package com.fcolucasvieira.auth.controller;

import com.fcolucasvieira.auth.dto.product.ProductRequestDTO;
import com.fcolucasvieira.auth.dto.product.ProductResponseDTO;
import com.fcolucasvieira.auth.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @SecurityRequirement(name = "bearerAuth")
    @Operation(
            summary = "Create product",
            description = "Creates a new product. Requires JWT authentication."
    )
    @ApiResponse(responseCode = "201", description = "Product created successfully")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @PostMapping
    public ResponseEntity<ProductResponseDTO> postProduct(@RequestBody @Valid ProductRequestDTO request){

        ProductResponseDTO response = this.productService.create(request);

        return ResponseEntity.status(201).body(response);
    }

    @SecurityRequirement(name = "bearerAuth")
    @Operation(
            summary = "List all products",
            description = "Returns a paginated list of products. Requires JWT authentication."
    )
    @Parameters({
            @Parameter(name = "page", description = "Page number", example = "0"),
            @Parameter(name = "size", description = "Quantity per page", example = "6"),
            @Parameter(name = "sort", description = "Sorting in field format,asc|desc", example = "name,asc")
    })
    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> getAllProducts(
            @Parameter(description = "Pagination parameters (page, size, sort)")
            Pageable pageable){
        return ResponseEntity.ok(productService.getAll(pageable));
        }
}
