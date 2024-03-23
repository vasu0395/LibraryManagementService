package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.request.CreateUserRequest;
import com.example.librarymanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    @GetMapping("/{userName}")
    public ResponseEntity<Object> getUserById(@PathVariable String userName) throws Exception{
        return ResponseEntity.ok(userService.getUserByName(userName));
    }

    @PostMapping("/create/user")
    public ResponseEntity<Object> createUser(@RequestBody CreateUserRequest request) throws Exception{
        return ResponseEntity.ok(userService.createUser(request,false));
    }

    @PostMapping("/create/librarian")
    public ResponseEntity<Object> createLibrarian(@RequestBody CreateUserRequest request) throws Exception{
        return ResponseEntity.ok(userService.createUser(request,true));
    }

    @GetMapping("/{userId}/reservedBooks")
    public ResponseEntity<Object> getReservedBooks(@PathVariable Integer userId) throws Exception{
        return ResponseEntity.ok(userService.getReservedBooks(userId));
    }
}
