package com.menudigital.menuapi.menu.service.impl;
import com.menudigital.menuapi.menu.domain.Menu; import com.menudigital.menuapi.menu.repo.MenuRepository; import com.menudigital.menuapi.menu.service.MenuService; import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.util.*;
@Service @RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
  private final MenuRepository repo;
  public java.util.List<Menu> byCompany(UUID companyId){ return repo.findByCompanyIdOrderByNameAsc(companyId); }
  public Menu get(UUID id){ return repo.findById(id).orElseThrow(); }
  @Transactional public Menu create(Menu m){ return repo.save(m); }
  @Transactional public Menu update(UUID id, Menu m){ var db=get(id); db.setName(m.getName()); db.setActive(m.isActive()); db.setCompany(m.getCompany()); return repo.save(db); }
  public void delete(UUID id){ repo.deleteById(id); }
}
