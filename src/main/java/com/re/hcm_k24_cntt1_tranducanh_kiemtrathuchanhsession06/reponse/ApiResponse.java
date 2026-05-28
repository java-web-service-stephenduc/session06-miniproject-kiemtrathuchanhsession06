package com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.reponse;

import lombok.Builder;

@Builder
public record ApiResponse<T>(
        String message,
        T data
) {
    public static <T> ApiResponse<T> response(String msg, T data) {
        return ApiResponse.<T>builder()
                .message(msg)
                .data(data)
                .build();
    }
}
