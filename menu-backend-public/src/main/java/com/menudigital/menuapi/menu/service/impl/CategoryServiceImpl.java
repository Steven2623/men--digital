package com.menudigital.menuapi.menu.service.impl;
import com.menudigital.menuapi.menu.domain.Category; import com.menudigital.menuapi.menu.repo.CategoryRepository; import com.menudigital.menuapi.menu.service.CategoryService; import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.util.*;
@Service @RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
  private final CategoryRepository repo;
  public java.util.List<Category> byCompany(UUID companyId){ return repo.findByCompanyIdOrderByNameAsc(companyId); }
  public Category get(UUID id){ return repo.findById(id).orElseThrow(); }
  @Transactional public Category create(Category c){ return repo.save(c); }
  @Transactional public Category update(UUID id, Category c){ var db=get(id); db.setName(c.getName()); db.setActive(c.isActive()); db.setCompany(c.getCompany()); return repo.save(db); }
  public void delete(UUID id){ repo.deleteById(id); }
}
