package com.hhwaaaaa1.blog.api.controller.mem;

import com.hhwaaaaa1.blog.api.exception.NoSuchUserException;
import com.hhwaaaaa1.blog.api.exception.mapper.ApiExceptionMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "/api/mem",
        produces = "application/json"
)
@ApiExceptionMapper
public class UserController {
    @GetMapping(value = "/{userNo}")
    public String findByUserNo(
            @PathVariable(value = "userNo") /*@RequestParam(value="userNo", required=false, defaultValue="")*/ Long userNo
    ) throws NoSuchUserException {
        throw new NoSuchUserException();
    }
}
