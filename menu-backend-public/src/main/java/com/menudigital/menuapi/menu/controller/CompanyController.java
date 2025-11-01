package com.menudigital.menuapi.menu.controller;
import com.menudigital.menuapi.common.ApiResponse; import com.menudigital.menuapi.menu.domain.Company; import com.menudigital.menuapi.menu.service.CompanyService;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/companies") @RequiredArgsConstructor
public class CompanyController {
  private final CompanyService service;
  @GetMapping public ResponseEntity<ApiResponse<java.util.List<Company>>> list(){ return ResponseEntity.ok(ApiResponse.ok(service.list())); }
  @GetMapping("/{id}") public ResponseEntity<ApiResponse<Company>> get(@PathVariable UUID id){ return ResponseEntity.ok(ApiResponse.ok(service.get(id))); }
  @PostMapping public ResponseEntity<ApiResponse<Company>> create(@RequestBody Company c){ return ResponseEntity.ok(ApiResponse.ok(service.create(c))); }
  @PutMapping("/{id}") public ResponseEntity<ApiResponse<Company>> update(@PathVariable UUID id,@RequestBody Company c){ return ResponseEntity.ok(ApiResponse.ok(service.update(id,c))); }
  @DeleteMapping("/{id}") public ResponseEntity<ApiResponse<String>> delete(@PathVariable UUID id){ service.delete(id); return ResponseEntity.ok(ApiResponse.msg("Deleted")); }
}
