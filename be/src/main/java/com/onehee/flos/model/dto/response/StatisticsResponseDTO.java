package com.onehee.flos.model.dto.response;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatisticsResponseDTO {
    private LoginInfo loginInfo;
    private PostInfo postInfo;
    private List<FlowerResponseDTO> flowers;

    public void setLoginInfo(int month, int lengthOfMonth, int loginCount) {
        this.loginInfo = LoginInfo.builder()
                .month(month)
                .lengthOfMonth(lengthOfMonth)
                .loginCount(loginCount)
                .build();
    }

    public void setPostInfo(int postCount, int sunny, int cloudy, int rainy) {
        this.postInfo = PostInfo.builder()
                .postCount(postCount)
                .sunny(sunny)
                .cloudy(cloudy)
                .rainy(rainy)
                .ratio(
                        PostInfo.Ratio.builder()
                                .sunny((double) sunny / postCount)
                                .cloudy((double) cloudy / postCount)
                                .rainy((double) rainy / postCount)
                                .build()
                )
                .build();
    }

    public void setFlowers(List<FlowerResponseDTO> flowers) {
        this.flowers = flowers;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    private static class LoginInfo {
        int month;
        int lengthOfMonth;
        int loginCount;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    private static class PostInfo {
        int postCount;
        int sunny;
        int cloudy;
        int rainy;
        Ratio ratio;

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        private static class Ratio {
            double sunny;
            double cloudy;
            double rainy;
        }
    }
}
