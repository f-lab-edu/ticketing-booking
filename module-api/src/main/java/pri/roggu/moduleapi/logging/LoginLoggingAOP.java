package pri.roggu.moduleapi.logging;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import pri.roggu.moduleapi.user.repository.LoginLogRepository;
import pri.roggu.modulecore.domain.dto.JwtTokenDto;
import pri.roggu.modulecore.domain.dto.ResponseDto;
import pri.roggu.modulecore.domain.entity.LoginLog;
import pri.roggu.modulecore.enums.LoginResult;
import pri.roggu.modulecore.exception.exceptions.UserLoginException;

import static pri.roggu.modulecore.util.CommonUtil.getClientIP;

@Aspect
@Component
@RequiredArgsConstructor
public class LoginLoggingAOP {

    private final LoginLogRepository loginLogRepository;

    @AfterReturning(value = "execution(* pri.roggu.moduleapi.user.controller.UserController.signin(..))", returning = "returnData")
    private void loginSuccess(ResponseDto<JwtTokenDto> returnData) {
        saveLoginLog(returnData.getData().getUserId(), getClientIP(), LoginResult.SUCCESS);
    }

    @AfterThrowing(value = "execution(* pri.roggu.moduleapi.user.controller.UserController.signin(..))", throwing = "exception")
    private void loginFail(UserLoginException exception) {
        saveLoginLog(exception.getUserId(), getClientIP(), LoginResult.FAIL);
    }

    /**
     * FUNCTION :: 로그인 로그 저장
     * @param userId
     * @param loginIp
     * @param loginResult
     */
    private void saveLoginLog(String userId, String loginIp, LoginResult loginResult) {
        loginLogRepository.save(LoginLog.builder()
                                              .userId(userId)
                                              .loginIp(loginIp)
                                              .loginResult(loginResult)
                                              .build());
    }

}
