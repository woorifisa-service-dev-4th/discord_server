package dev.discord_server.domain.server.dto;

import dev.discord_server.domain.server.entity.Server;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseDto {
    private String name;

    public static ResponseDto toResponseDto(Server server) {
        return ResponseDto.builder()
                .name(server.getName())
                .build();
    }
}
