package com.menudigital.menuapi.menu.controller;
import com.menudigital.menuapi.common.ApiResponse; import com.menudigital.menuapi.menu.domain.*; import com.menudigital.menuapi.menu.service.*; import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/public") @RequiredArgsConstructor
public class PublicMenuController {
  private final CategoryService categoryService; private final MenuService menuService; private final ProductService productService;
  @GetMapping("/companies/{companyId}/categories") public ResponseEntity<ApiResponse<java.util.List<Category>>> categories(@PathVariable java.util.UUID companyId){ return ResponseEntity.ok(ApiResponse.ok(categoryService.byCompany(companyId))); }
  @GetMapping("/companies/{companyId}/menu") public ResponseEntity<ApiResponse<java.util.List<Menu>>> menu(@PathVariable java.util.UUID companyId){ return ResponseEntity.ok(ApiResponse.ok(menuService.byCompany(companyId))); }
  @GetMapping("/categories/{categoryId}/products") public ResponseEntity<ApiResponse<java.util.List<Product>>> productsByCategory(@PathVariable java.util.UUID categoryId){ return ResponseEntity.ok(ApiResponse.ok(productService.byCategory(categoryId))); }
  @GetMapping("/companies/{companyId}/products") public ResponseEntity<ApiResponse<java.util.List<Product>>> productsByCompany(@PathVariable java.util.UUID companyId){ return ResponseEntity.ok(ApiResponse.ok(productService.byCompany(companyId))); }
}
