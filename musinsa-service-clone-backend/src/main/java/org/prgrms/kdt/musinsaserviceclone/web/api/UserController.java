package org.prgrms.kdt.musinsaserviceclone.web.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prgrms.kdt.musinsaserviceclone.dto.LoginResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@Slf4j
public class UserController {

    private final KakaoAPI kakaoAPI;

    @GetMapping("/api/v1/login")
    public LoginResponseDto login(@RequestParam("code") String code){
        String accessToken = kakaoAPI.getAccessToken(code);
        log.info("user information : {}", accessToken);
        HashMap<String, Object> userInfo = kakaoAPI.getUserInfo(accessToken);
        log.info("user information : {}", userInfo.toString());
        String email = (String) userInfo.get("email");
        String nickname = (String) userInfo.get("nickname");

        return LoginResponseDto.builder()
                .email(email)
                .nickname(nickname)
                .token(accessToken)
                .build();
    }
}
