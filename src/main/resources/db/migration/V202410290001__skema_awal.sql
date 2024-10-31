create table c_security_user
(
    id         varchar(36)  not null,
    created    timestamp(6) not null,
    created_by varchar(100) not null,
    updated    timestamp(6),
    updated_by varchar(100),
    username   varchar(100) not null,
    active     boolean,
    id_role    varchar(36)  not null,
    primary key (id)
);

create table c_security_role
(
    id          varchar(36)  not null,
    created     timestamp(6) not null,
    created_by  varchar(100) not null,
    updated     timestamp(6),
    updated_by  varchar(100),
    description varchar(100),
    name        varchar(15)  not null,
    primary key (id)
);

create table c_security_permission
(
    id               varchar(36)  not null,
    created          timestamp(6) not null,
    created_by       varchar(100) not null,
    updated          timestamp(6),
    updated_by       varchar(100),
    permission_label varchar(100) not null,
    permission_value varchar(100) not null,
    primary key (id)
);

create table c_security_role_permission
(
    id_role       VARCHAR(36) not null,
    id_permission VARCHAR(36) not null,
    primary key (id_role, id_permission)
);

create table c_security_user_password
(
    id_user       varchar(36)  not null,
    created       timestamp(6) not null,
    created_by    varchar(100) not null,
    updated       timestamp(6),
    updated_by    varchar(100),
    user_password varchar(255) not null,
    primary key (id_user)
);

CREATE TABLE post
(
    id         VARCHAR(36)  NOT NULL,
    created    TIMESTAMP(6) NOT NULL,
    created_by VARCHAR(100) NOT NULL,
    updated    TIMESTAMP(6),
    updated_by VARCHAR(100),
    title      VARCHAR(255) NOT NULL,
    slug       VARCHAR(255) NOT NULL,
    content    TEXT         NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (slug)
);