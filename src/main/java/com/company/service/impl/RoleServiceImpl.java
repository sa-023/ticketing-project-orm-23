package com.company.service.impl;

import com.company.dto.RoleDTO;
import com.company.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
/*
 * 🖍️...
 * · Overridden methods inherited from CrudService interface.
 * · Method implementation is inherited from the AbstractMapService abstract class, which for now we use to fake the database.
 *
 * · We can use the @Service annotation for service.impls classes instead of @Component.
 */
@Service
public class RoleServiceImpl extends AbstractMapService<RoleDTO,Long> implements RoleService{
    @Override
    public RoleDTO save(RoleDTO object) {
        return super.save(object.getId(), object);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void update(RoleDTO object) {
        super.update(object.getId(), object);
    }

    @Override
    public RoleDTO findById(Long id) {
        return super.findById(id);
    }
}
