package dev.discord_server.domain.server.service;

import dev.discord_server.domain.server.dto.ResponseDto;
import dev.discord_server.domain.server.entity.Server;
import dev.discord_server.domain.server.repository.ServerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServerService {

    private final ServerRepository serverRepository;

    public List<ResponseDto> findServers() {
        List<Server> all = serverRepository.findAll();
        List<ResponseDto> responseDtoStream = all.stream()
                .map((ResponseDto::toResponseDto))
                .toList();
        return responseDtoStream;
    }




}
