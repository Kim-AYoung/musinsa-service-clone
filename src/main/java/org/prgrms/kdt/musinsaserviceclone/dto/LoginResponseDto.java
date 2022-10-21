package org.prgrms.kdt.musinsaserviceclone.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LoginResponseDto {

    private String email;
    private String nickname;
    private String token;

    @Builder
    public LoginResponseDto(String email, String nickname, String token) {
        this.email = email;
        this.nickname = nickname;
        this.token = token;
    }
}
