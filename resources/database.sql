CREATE TABLE babyfoot
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    id_match BIGINT                NULL,
    is_used  TINYINT(1) DEFAULT 0  NULL,
    etat     VARCHAR(255)          NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE goal
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    id_equipe BIGINT                NOT NULL,
    id_match  BIGINT                NOT NULL,
    vitesse   INT                   NOT NULL,
    match_id  BIGINT                NULL,
    team_id   BIGINT                NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE matches
(
    id          BIGINT AUTO_INCREMENT  NOT NULL,
    score_1     INT                    NULL,
    score_2     INT                    NULL,
    id_equipe_1 BIGINT                 NOT NULL,
    id_equipe_2 BIGINT                 NOT NULL,
    vitesse_max INT                    NULL,
    babyfoot_id BIGINT                 NULL,
    created_at  datetime DEFAULT NOW() NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE team
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE users
(
    id         BIGINT AUTO_INCREMENT  NOT NULL,
    name       VARCHAR(255)           NOT NULL,
    email      VARCHAR(255)           NOT NULL,
    password   VARCHAR(255)           NOT NULL,
    id_team    BIGINT                 NULL,
    is_admin   TINYINT(1)             NOT NULL,
    created_at datetime DEFAULT NOW() NULL,
    team_id    BIGINT                 NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT email UNIQUE (email);

ALTER TABLE babyfoot
    ADD CONSTRAINT id_match UNIQUE (id_match);

ALTER TABLE goal
    ADD CONSTRAINT FK5h3n8a7x2jfhrcqom6c3xtduf FOREIGN KEY (team_id) REFERENCES team (id) ON DELETE NO ACTION;

CREATE INDEX FK5h3n8a7x2jfhrcqom6c3xtduf ON goal (team_id);

ALTER TABLE goal
    ADD CONSTRAINT FKb2w6sm66s1l5lw1qjwk9cn0ko FOREIGN KEY (match_id) REFERENCES matches (id) ON DELETE NO ACTION;

CREATE INDEX FKb2w6sm66s1l5lw1qjwk9cn0ko ON goal (match_id);

ALTER TABLE users
    ADD CONSTRAINT FKhn2tnbh9fqjqeuv8ehw5ple7a FOREIGN KEY (team_id) REFERENCES team (id) ON DELETE NO ACTION;

CREATE INDEX FKhn2tnbh9fqjqeuv8ehw5ple7a ON users (team_id);

ALTER TABLE matches
    ADD CONSTRAINT FKssxmqju542kfda1690w0dm2ab FOREIGN KEY (babyfoot_id) REFERENCES babyfoot (id) ON DELETE NO ACTION;

CREATE INDEX FKssxmqju542kfda1690w0dm2ab ON matches (babyfoot_id);

ALTER TABLE babyfoot
    ADD CONSTRAINT fk_babyfoot_match FOREIGN KEY (id_match) REFERENCES matches (id) ON DELETE NO ACTION;

ALTER TABLE goal
    ADD CONSTRAINT fk_goal_match FOREIGN KEY (id_match) REFERENCES matches (id) ON DELETE NO ACTION;

CREATE INDEX fk_goal_match ON goal (id_match);

ALTER TABLE goal
    ADD CONSTRAINT fk_goal_team FOREIGN KEY (id_equipe) REFERENCES team (id) ON DELETE NO ACTION;

CREATE INDEX fk_goal_team ON goal (id_equipe);

ALTER TABLE matches
    ADD CONSTRAINT fk_match_team1 FOREIGN KEY (id_equipe_1) REFERENCES team (id) ON DELETE NO ACTION;

CREATE INDEX fk_match_team1 ON matches (id_equipe_1);

ALTER TABLE matches
    ADD CONSTRAINT fk_match_team2 FOREIGN KEY (id_equipe_2) REFERENCES team (id) ON DELETE NO ACTION;

CREATE INDEX fk_match_team2 ON matches (id_equipe_2);

ALTER TABLE users
    ADD CONSTRAINT fk_user_team FOREIGN KEY (id_team) REFERENCES team (id) ON DELETE SET NULL;

CREATE INDEX fk_user_team ON users (id_team);
CREATE TABLE babyfoot
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    id_match BIGINT                NULL,
    is_used  TINYINT(1) DEFAULT 0  NULL,
    etat     VARCHAR(255)          NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE goal
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    id_equipe BIGINT                NOT NULL,
    id_match  BIGINT                NOT NULL,
    vitesse   INT                   NOT NULL,
    match_id  BIGINT                NULL,
    team_id   BIGINT                NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE matches
(
    id          BIGINT AUTO_INCREMENT  NOT NULL,
    score_1     INT                    NULL,
    score_2     INT                    NULL,
    id_equipe_1 BIGINT                 NOT NULL,
    id_equipe_2 BIGINT                 NOT NULL,
    vitesse_max INT                    NULL,
    babyfoot_id BIGINT                 NULL,
    created_at  datetime DEFAULT NOW() NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE team
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE users
(
    id         BIGINT AUTO_INCREMENT  NOT NULL,
    name       VARCHAR(255)           NOT NULL,
    email      VARCHAR(255)           NOT NULL,
    password   VARCHAR(255)           NOT NULL,
    id_team    BIGINT                 NULL,
    is_admin   TINYINT(1)             NOT NULL,
    created_at datetime DEFAULT NOW() NULL,
    team_id    BIGINT                 NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT email UNIQUE (email);

ALTER TABLE babyfoot
    ADD CONSTRAINT id_match UNIQUE (id_match);

ALTER TABLE goal
    ADD CONSTRAINT FK5h3n8a7x2jfhrcqom6c3xtduf FOREIGN KEY (team_id) REFERENCES team (id) ON DELETE NO ACTION;

CREATE INDEX FK5h3n8a7x2jfhrcqom6c3xtduf ON goal (team_id);

ALTER TABLE goal
    ADD CONSTRAINT FKb2w6sm66s1l5lw1qjwk9cn0ko FOREIGN KEY (match_id) REFERENCES matches (id) ON DELETE NO ACTION;

CREATE INDEX FKb2w6sm66s1l5lw1qjwk9cn0ko ON goal (match_id);

ALTER TABLE users
    ADD CONSTRAINT FKhn2tnbh9fqjqeuv8ehw5ple7a FOREIGN KEY (team_id) REFERENCES team (id) ON DELETE NO ACTION;

CREATE INDEX FKhn2tnbh9fqjqeuv8ehw5ple7a ON users (team_id);

ALTER TABLE matches
    ADD CONSTRAINT FKssxmqju542kfda1690w0dm2ab FOREIGN KEY (babyfoot_id) REFERENCES babyfoot (id) ON DELETE NO ACTION;

CREATE INDEX FKssxmqju542kfda1690w0dm2ab ON matches (babyfoot_id);

ALTER TABLE babyfoot
    ADD CONSTRAINT fk_babyfoot_match FOREIGN KEY (id_match) REFERENCES matches (id) ON DELETE NO ACTION;

ALTER TABLE goal
    ADD CONSTRAINT fk_goal_match FOREIGN KEY (id_match) REFERENCES matches (id) ON DELETE NO ACTION;

CREATE INDEX fk_goal_match ON goal (id_match);

ALTER TABLE goal
    ADD CONSTRAINT fk_goal_team FOREIGN KEY (id_equipe) REFERENCES team (id) ON DELETE NO ACTION;

CREATE INDEX fk_goal_team ON goal (id_equipe);

ALTER TABLE matches
    ADD CONSTRAINT fk_match_team1 FOREIGN KEY (id_equipe_1) REFERENCES team (id) ON DELETE NO ACTION;

CREATE INDEX fk_match_team1 ON matches (id_equipe_1);

ALTER TABLE matches
    ADD CONSTRAINT fk_match_team2 FOREIGN KEY (id_equipe_2) REFERENCES team (id) ON DELETE NO ACTION;

CREATE INDEX fk_match_team2 ON matches (id_equipe_2);

ALTER TABLE users
    ADD CONSTRAINT fk_user_team FOREIGN KEY (id_team) REFERENCES team (id) ON DELETE SET NULL;

CREATE INDEX fk_user_team ON users (id_team);