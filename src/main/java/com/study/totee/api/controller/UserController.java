package com.study.totee.api.controller;

import com.study.totee.api.model.UserEntity;
import com.study.totee.common.ApiResponse;
import com.study.totee.api.dto.UserInfoDTO;
import com.study.totee.api.model.UserInfoEntity;
import com.study.totee.api.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "로그인한 유저 정보" , notes = "유저 이름과 함께 정보를 확인 가능")
    @GetMapping("/api/v1/info")
    public ApiResponse getUserInfo(@AuthenticationPrincipal User principal) {
        UserEntity user = userService.getUser(principal.getUsername());
        UserInfoEntity userInfoEntity = user.getUserInfo();
        UserInfoDTO userInfoDTO = UserInfoDTO.builder()
                .grade(userInfoEntity.getGrade())
                .major(userInfoEntity.getMajor())
                .nickname(userInfoEntity.getNickname())
                .roleType(user.getRoleType())
                .profileImageUrl(user.getProfileImageUrl())
                .build();
        return ApiResponse.success("data" , userInfoDTO);
    }
}