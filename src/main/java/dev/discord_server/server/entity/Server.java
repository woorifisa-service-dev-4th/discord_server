package dev.discord_server.server.entity;

import dev.discord_server.channel.entity.Channel;
import dev.discord_server.config.BaseEntity;
import dev.discord_server.serverUser.entity.ServerUser;
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
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "server")
    private Set<Channel> channels = new LinkedHashSet<>();

    @OneToMany(mappedBy = "server")
    private Set<ServerUser> serverUsers = new LinkedHashSet<>();



}