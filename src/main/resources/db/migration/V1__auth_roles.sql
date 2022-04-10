create schema auth;

create table auth.roles
(
    id uuid not null
        constraint roles_pk
            primary key,
    name varchar not null
);

create unique index roles_name_uindex
    on auth.roles (name);

insert into auth.roles values ('16d97fa0-459a-48ea-ba08-5a3833a9d524', 'USER');
insert into auth.roles values ('16d97fa0-459a-48ea-ba08-5a3833a9d525', 'ADMIN');