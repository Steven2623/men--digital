package com.menudigital.menuapi.menu.service.impl;
import com.menudigital.menuapi.menu.domain.Product; import com.menudigital.menuapi.menu.repo.ProductRepository; import com.menudigital.menuapi.menu.service.ProductService; import lombok.RequiredArgsConstructor; import org.springframework.data.domain.*; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.util.*;
@Service @RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepository repo;
  public Page<Product> list(Pageable p){ return repo.findAll(p); }
  public java.util.List<Product> byCategory(UUID categoryId){ return repo.findByCategoryId(categoryId); }
  public java.util.List<Product> byCompany(UUID companyId){ return repo.findByCompanyId(companyId); }
  public Product get(UUID id){ return repo.findById(id).orElseThrow(); }
  @Transactional public Product create(Product p){ return repo.save(p); }
  @Transactional public Product update(UUID id, Product p){ var db=get(id); db.setName(p.getName()); db.setDescription(p.getDescription()); db.setPrice(p.getPrice()); db.setImageUrl(p.getImageUrl()); db.setCategory(p.getCategory()); db.setCompany(p.getCompany()); db.setMenus(p.getMenus()); return repo.save(db); }
  public void delete(UUID id){ repo.deleteById(id); }
}
