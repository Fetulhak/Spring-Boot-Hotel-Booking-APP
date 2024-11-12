package com.hotelbookingproject.BLITCoding.controller;

import com.hotelbookingproject.BLITCoding.exception.RoleAlreadyExistException;
import com.hotelbookingproject.BLITCoding.model.Role;
import com.hotelbookingproject.BLITCoding.model.User;
import com.hotelbookingproject.BLITCoding.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.FOUND;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/all-roles")
    public ResponseEntity<List<Role>>  getAllRoles(){
        return new ResponseEntity<>(roleService.getRoles(), FOUND);
    }

    @PostMapping("/create-new-role")
    public ResponseEntity<String> createRole(@RequestBody Role theRole){
        try{
            roleService.createRole(theRole);
            return  ResponseEntity.ok("Role created");

        }catch (RoleAlreadyExistException e){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(e.getMessage());

        }

    }

    @DeleteMapping("/delete/{roleId}")
    public void deleteRole( @PathVariable("roleId") Long roleId){
        roleService.deleteRole(roleId);
    }

    @PostMapping("/remove-all-users-from-role/{roleId}")
    public Role removeAllUsersFromRole(@PathVariable Long roleId){
        return roleService.removeAllUsersFromRole(roleId);
    }


    @PostMapping("/remove-user-from-role")
    public User removeUserFromRole(@RequestParam("userId") Long userId,
                                  @RequestParam("roleId") Long roleId){
        return roleService.removeUserFromRole(userId, roleId);

    }

    @PostMapping("assign-user-to-role")
    public User assignUserToRole(@RequestParam("userId") Long userId,
                                   @RequestParam("roleId") Long roleId){
        return roleService.assignRoleToUser(userId, roleId);

    }










}
