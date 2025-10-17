USE lagitech;

-- =========================================================
--  Table : babyfoot
-- =========================================================
CREATE TABLE IF NOT EXISTS babyfoot (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        is_used BOOLEAN NOT NULL,
                                        etat VARCHAR(255)
);

-- =========================================================
--  Table : team
-- =========================================================
CREATE TABLE IF NOT EXISTS team (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR(255) NOT NULL
);

-- =========================================================
--  Table : users
-- =========================================================
CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
                                     email VARCHAR(255) UNIQUE,
                                     password VARCHAR(255) NOT NULL,
                                     team_id BIGINT,
                                     is_admin BOOLEAN DEFAULT FALSE,
                                     created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                                     CONSTRAINT fk_users_team FOREIGN KEY (team_id) REFERENCES team(id)
);

-- =========================================================
--  Table : matches
-- =========================================================
CREATE TABLE IF NOT EXISTS matches (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       score_1 INT,
                                       score_2 INT,
                                       id_equipe_1 BIGINT,
                                       id_equipe_2 BIGINT,
                                       vitesse_max INT,
                                       babyfoot_id BIGINT,
                                       created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                                       CONSTRAINT fk_match_team1 FOREIGN KEY (id_equipe_1) REFERENCES team(id),
                                       CONSTRAINT fk_match_team2 FOREIGN KEY (id_equipe_2) REFERENCES team(id),
                                       CONSTRAINT fk_match_babyfoot FOREIGN KEY (babyfoot_id) REFERENCES babyfoot(id)
);

-- =========================================================
--  Table : goal
-- =========================================================
CREATE TABLE IF NOT EXISTS goal (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    match_id BIGINT,
                                    team_id BIGINT,
                                    vitesse FLOAT,
                                    CONSTRAINT fk_goal_match FOREIGN KEY (match_id) REFERENCES matches(id),
                                    CONSTRAINT fk_goal_team FOREIGN KEY (team_id) REFERENCES team(id)
);

-- =========================================================
--  Données d’exemple (vérifie avant d'insérer pour éviter doublons)
-- =========================================================
INSERT IGNORE INTO babyfoot (id, is_used, etat) VALUES
                                                    (1, false, 'Neuf'),
                                                    (2, true, 'En jeu'),
                                                    (3, false, 'En maintenance');

INSERT IGNORE INTO team (id, name) VALUES
                                       (1, 'Les Aigles'),
                                       (2, 'Les Titans'),
                                       (3, 'Les Lynx');

INSERT IGNORE INTO users (id, name, email, password, team_id, is_admin) VALUES
                                                                            (1, 'Thomas', 'thomas@example.com', 'hashed_pass_123', 1, true),
                                                                            (2, 'Lucas', 'lucas@example.com', 'hashed_pass_456', 1, false),
                                                                            (3, 'Emma', 'emma@example.com', 'hashed_pass_789', 2, false),
                                                                            (4, 'Sarah', 'sarah@example.com', 'hashed_pass_999', 3, false);

INSERT IGNORE INTO matches (id, score_1, score_2, id_equipe_1, id_equipe_2, vitesse_max, babyfoot_id, created_at) VALUES
                                                                                                                      (1, 10, 8, 1, 2, 98, 2, NOW()),
                                                                                                                      (2, 7, 10, 3, 1, 101, 1, NOW());

INSERT IGNORE INTO goal (id, match_id, team_id, vitesse) VALUES
                                                             (1, 1, 1, 87.5),
                                                             (2, 1, 1, 90.2),
                                                             (3, 1, 2, 85.0),
                                                             (4, 2, 3, 101.1),
                                                             (5, 2, 1, 95.6);
