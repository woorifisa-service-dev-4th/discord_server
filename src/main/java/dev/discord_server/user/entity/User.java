package dev.discord_server.user.entity;

import dev.discord_server.channelUser.entity.ChannelUser;
import dev.discord_server.config.BaseEntity;
import dev.discord_server.friend.entity.Friend;
import dev.discord_server.message.entity.Message;
import dev.discord_server.serverUser.entity.ServerUser;
import dev.discord_server.user.Enum.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "nickname", nullable = false, length = 10)
    private String nickname;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "email", nullable = false, length = 20)
    private String email;

    @Column(name = "social_id")
    private Integer socialId;

    @Column(name = "role", nullable = false)
    private Role role;


    @OneToMany(mappedBy = "user")
    private Set<ChannelUser> channelUsers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "fromUser")
    private Set<Friend> to_friends = new LinkedHashSet<>();

    @OneToMany(mappedBy = "toUser")
    private Set<Friend> from_friends = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Message> messages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<ServerUser> serverUsers = new LinkedHashSet<>();

}