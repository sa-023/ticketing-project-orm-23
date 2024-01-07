package com.company.service.impl;

import com.company.dto.UserDTO;
import com.company.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
 * 🖍️...
 * · Overridden methods inherited from CrudService interface.
 * · Method implementations are inherited from the AbstractMapService abstract class, which for now we use to fake the database.
 *
 * · We can use the @Service annotation for service.impls classes instead of @Component.
 */
@Service
public class UserServiceImpl extends AbstractMapService<UserDTO,String> implements UserService {
    @Override
    public UserDTO save(UserDTO object) {
        return super.save(object.getUserName(), object);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public void update(UserDTO object) {
        super.update(object.getUserName(), object);
    }

    @Override
    public UserDTO findById(String  id) {
        return super.findById(id);
    }

    @Override
    public List<UserDTO> findManagers() {
        return super.findAll().stream().filter(user -> user.getRole().getId() == 2).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findEmployees() {
        return super.findAll().stream().filter(userDTO -> userDTO.getRole().getId() == 3).collect(Collectors.toList());
    }


}
