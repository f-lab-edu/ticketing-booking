package pri.roggu.moduleapi.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pri.roggu.moduleapi.user.service.UserService;
import pri.roggu.modulecore.domain.dto.JwtTokenDto;
import pri.roggu.modulecore.domain.dto.ResponseDto;
import pri.roggu.modulecore.domain.dto.UserDto;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * FUNCTION :: 회원가입
     * @param userDto
     * @return
     */
    @PostMapping(value = "/signup")
    public ResponseDto<String> signup(@RequestBody @Valid final UserDto userDto) {
        return userService.signup(userDto);
    }

    @PostMapping(value = "/signin")
    public ResponseDto<JwtTokenDto> signin(@RequestBody final UserDto userDto) {
        return userService.signin(userDto);
    }
}