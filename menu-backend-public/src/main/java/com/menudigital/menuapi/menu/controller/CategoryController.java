package com.menudigital.menuapi.menu.controller;
import com.menudigital.menuapi.common.ApiResponse; import com.menudigital.menuapi.menu.domain.Category; import com.menudigital.menuapi.menu.service.CategoryService;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/categories") @RequiredArgsConstructor
public class CategoryController {
  private final CategoryService service;
  @GetMapping("/company/{companyId}") public ResponseEntity<ApiResponse<java.util.List<Category>>> byCompany(@PathVariable UUID companyId){ return ResponseEntity.ok(ApiResponse.ok(service.byCompany(companyId))); }
  @GetMapping("/{id}") public ResponseEntity<ApiResponse<Category>> get(@PathVariable UUID id){ return ResponseEntity.ok(ApiResponse.ok(service.get(id))); }
  @PostMapping public ResponseEntity<ApiResponse<Category>> create(@RequestBody Category c){ return ResponseEntity.ok(ApiResponse.ok(service.create(c))); }
  @PutMapping("/{id}") public ResponseEntity<ApiResponse<Category>> update(@PathVariable UUID id,@RequestBody Category c){ return ResponseEntity.ok(ApiResponse.ok(service.update(id,c))); }
  @DeleteMapping("/{id}") public ResponseEntity<ApiResponse<String>> delete(@PathVariable UUID id){ service.delete(id); return ResponseEntity.ok(ApiResponse.msg("Deleted")); }
}
