package com.company.controller;
import com.company.dto.UserDTO;
import com.company.service.RoleService;
import com.company.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
 * 🖍️...
 * · Entity engages with DB and DTO engages with UI.
 * · Entity and DTO separation happens because sometimes in a database we might have extra fields (ex: user id, lastUpdateDateTime etc...)
 *   that we don't want to display on the UI.
 * · We will use the mapper structure to map the entity to dto.
 *
 * · If data is persistent, then it's sustained even if the process, cluster, node, or container is changed or removed.
 * · If data is non-persistent, this means that it can be altered, removed, or lost if the process, cluster, node, or container is changed or removed.
 *
 * · We can use the @Service annotation for service.impls classes instead of @Component.
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;
    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }


    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user", new UserDTO()); // Empty UserDTO object that we bind to the view to get input from the client.
        model.addAttribute("roles", roleService.findAll()); // List of RoleDTOs to bind to the view for Role dropdown. (Comes from DB).
        model.addAttribute("users", userService.findAll()); // List of Users to bind to the view for User List table. (Comes from DB).
        return "/user/create";
    }

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user, Model model){
        /*
         * 🖍️...
         * · @ModelAttribute("user") UserDTO user: Returns values provided by the client in the createUser method.
         * · return "/user/create"; Will return the view.
         * · return "redirect:/user/create"; Will return the @GetMapping("/user/create") endpoint.
         */

//        model.addAttribute("user", new UserDTO());
//        model.addAttribute("roles", roleService.findAll());
//        userService.save(user);
//        model.addAttribute("users", userService.findAll());
//        return "/user/create";

        userService.save(user); // Saving client-provided data.
        return "redirect:/user/create";

    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){
        /*
         * 🖍️...
         * · @GetMapping("/update/{username}"): Passing the path variable to the endpoint to retrieve a specific user when we click on the update button.
         * · @PathVariable("username"): We have to specify an end-point variable name inside the @PathVariable() annotation and pass it into the method parameter.
         */
        model.addAttribute("user", userService.findById(username)); // It populates the fields on the form with user data when we click on the Update button.
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "/user/update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") UserDTO user){
        userService.update(user); // After clicking on the save button, it updates the user information.
        return "redirect:/user/create"; // Redirect to the @GetMapping("/user/create") endpoint.
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username){
        userService.deleteById(username); // After clicking on the delete button, it deletes the user from the table.
        return "redirect:/user/create"; // Redirect to the @GetMapping("/user/create") endpoint.
    }






}
