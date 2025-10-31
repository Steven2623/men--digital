package com.menudigital.menuapi.menu.controller;
import com.menudigital.menuapi.common.ApiResponse; import com.menudigital.menuapi.menu.domain.Product; import com.menudigital.menuapi.menu.service.ProductService;
import lombok.RequiredArgsConstructor; import org.springframework.data.domain.*; import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/products") @RequiredArgsConstructor
public class ProductController {
  private final ProductService service;
  @GetMapping public ResponseEntity<ApiResponse<Page<Product>>> list(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="20") int size){ return ResponseEntity.ok(ApiResponse.ok(service.list(PageRequest.of(page,size)))); }
  @GetMapping("/{id}") public ResponseEntity<ApiResponse<Product>> get(@PathVariable UUID id){ return ResponseEntity.ok(ApiResponse.ok(service.get(id))); }
  @PostMapping public ResponseEntity<ApiResponse<Product>> create(@RequestBody Product p){ return ResponseEntity.ok(ApiResponse.ok(service.create(p))); }
  @PutMapping("/{id}") public ResponseEntity<ApiResponse<Product>> update(@PathVariable UUID id,@RequestBody Product p){ return ResponseEntity.ok(ApiResponse.ok(service.update(id,p))); }
  @DeleteMapping("/{id}") public ResponseEntity<ApiResponse<String>> delete(@PathVariable UUID id){ service.delete(id); return ResponseEntity.ok(ApiResponse.msg("Deleted")); }
}
