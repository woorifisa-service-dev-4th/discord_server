package dev.discord_server.domain.server.repository;

import dev.discord_server.domain.server.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server, Long> {


}
