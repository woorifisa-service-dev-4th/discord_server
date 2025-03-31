package dev.discord_server.domain.server.entity;

import dev.discord_server.domain.channel.entity.Channel;
import dev.discord_server.config.BaseEntity;
import dev.discord_server.domain.serverUser.entity.ServerUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "server")
public class Server extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "image_url", nullable = false, length = 50)
    private String imageUrl;

    @OneToMany(mappedBy = "server")
    private Set<Channel> channels = new LinkedHashSet<>();

    @OneToMany(mappedBy = "server")
    private Set<ServerUser> serverUsers = new LinkedHashSet<>();



}