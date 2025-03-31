package dev.discord_server.channel.entity;

import dev.discord_server.channelUser.entity.ChannelUser;
import dev.discord_server.config.BaseEntity;
import dev.discord_server.message.entity.Message;
import dev.discord_server.server.entity.Server;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "channel")
public class Channel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "server_id")
    private Server server;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Lob
    @Column(name = "type", nullable = false)
    private String type;

    @OneToMany(mappedBy = "channel")
    private Set<ChannelUser> channelUsers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "channel")
    private Set<Message> messages = new LinkedHashSet<>();

}