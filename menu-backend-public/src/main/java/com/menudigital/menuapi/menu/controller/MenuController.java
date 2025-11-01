package com.menudigital.menuapi.menu.controller;
import com.menudigital.menuapi.common.ApiResponse; import com.menudigital.menuapi.menu.domain.Menu; import com.menudigital.menuapi.menu.service.MenuService;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/menus") @RequiredArgsConstructor
public class MenuController {
  private final MenuService service;
  @GetMapping("/company/{companyId}") public ResponseEntity<ApiResponse<java.util.List<Menu>>> byCompany(@PathVariable UUID companyId){ return ResponseEntity.ok(ApiResponse.ok(service.byCompany(companyId))); }
  @GetMapping("/{id}") public ResponseEntity<ApiResponse<Menu>> get(@PathVariable UUID id){ return ResponseEntity.ok(ApiResponse.ok(service.get(id))); }
  @PostMapping public ResponseEntity<ApiResponse<Menu>> create(@RequestBody Menu m){ return ResponseEntity.ok(ApiResponse.ok(service.create(m))); }
  @PutMapping("/{id}") public ResponseEntity<ApiResponse<Menu>> update(@PathVariable UUID id,@RequestBody Menu m){ return ResponseEntity.ok(ApiResponse.ok(service.update(id,m))); }
  @DeleteMapping("/{id}") public ResponseEntity<ApiResponse<String>> delete(@PathVariable UUID id){ service.delete(id); return ResponseEntity.ok(ApiResponse.msg("Deleted")); }
}
