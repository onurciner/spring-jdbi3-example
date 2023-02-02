package com.onurciner.jdbi3.api;

import com.onurciner.jdbi3.model.User;
import com.onurciner.jdbi3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class BookController {

    private final UserService entityService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid User user) {
        return new ResponseEntity<>(entityService.create(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(entityService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(entityService.getOne(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(entityService.deleteById(id), HttpStatus.OK);
    }

}