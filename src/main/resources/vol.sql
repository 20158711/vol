CREATE TABLE article
(
  id             BIGINT                             NOT NULL
    PRIMARY KEY,
  content        VARCHAR(255)                       NOT NULL,
  insert_time    DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
  is_allow_entry BIT                                NOT NULL,
  title          VARCHAR(255)                       NOT NULL,
  type           INT                                NULL,
  team_id        BIGINT                             NULL
)
  ENGINE = InnoDB;

CREATE INDEX FK1epxxo4vpskp6r3234x4h4uht
  ON article (team_id);

CREATE TABLE entry_form
(
  id         BIGINT          NOT NULL
    PRIMARY KEY,
  state      INT DEFAULT '0' NULL,
  article_id BIGINT          NULL,
  user_id    BIGINT          NULL
)
  ENGINE = InnoDB;

CREATE INDEX FK6ao790k2bl4cp3yu1mu09m6wu
  ON entry_form (article_id);

CREATE INDEX FKkcdqf3sygpv1b1g0m3fiya5sy
  ON entry_form (user_id);

CREATE TABLE hibernate_sequence
(
  next_val BIGINT NULL
)
  ENGINE = InnoDB;

CREATE TABLE team
(
  id         BIGINT       NOT NULL
    PRIMARY KEY,
  introduce  VARCHAR(255) NOT NULL,
  login_name VARCHAR(255) NOT NULL,
  password   VARCHAR(255) NOT NULL,
  team_name  VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

CREATE TABLE team_user
(
  id      BIGINT          NOT NULL
    PRIMARY KEY,
  state   INT DEFAULT '0' NULL,
  team_id BIGINT          NULL,
  user_id BIGINT          NULL
)
  ENGINE = InnoDB;

CREATE INDEX FKiuwi96twuthgvhnarqj34mnjv
  ON team_user (team_id);

CREATE INDEX FK6w6lkqjk13n0nmf4jbnb3d376
  ON team_user (user_id);

CREATE TABLE user
(
  id                     BIGINT                              NOT NULL
    PRIMARY KEY,
  age                    INT                                 NOT NULL,
  login_name             VARCHAR(255)                        NOT NULL,
  password               VARCHAR(255)                        NOT NULL,
  personalized_signature VARCHAR(255) DEFAULT '这个人很懒什么也没有留下' NOT NULL,
  user_name              VARCHAR(255)                        NOT NULL
)
  ENGINE = InnoDB;

