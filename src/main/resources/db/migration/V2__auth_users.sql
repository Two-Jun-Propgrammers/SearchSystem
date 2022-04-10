create table auth.users
(
    id uuid not null
        constraint users_pk
            primary key,
    login varchar not null,
    password varchar not null,
    role_id uuid not null
        constraint users_roles_id_fk
            references auth.roles
            on update cascade on delete cascade
);

create unique index users_login_uindex
    on auth.users (login);

insert into auth.users values ('26d97fa0-459a-48ea-ba08-5a3833a9d524', 'User1', '12345', '16d97fa0-459a-48ea-ba08-5a3833a9d524');
insert into auth.users values ('36d97fa0-459a-48ea-ba08-5a3833a9d524', 'User2', '12345', '16d97fa0-459a-48ea-ba08-5a3833a9d524');
insert into auth.users values ('46d97fa0-459a-48ea-ba08-5a3833a9d524', 'User3', '12345', '16d97fa0-459a-48ea-ba08-5a3833a9d524');
insert into auth.users values ('56d97fa0-459a-48ea-ba08-5a3833a9d524', 'User4', '12345', '16d97fa0-459a-48ea-ba08-5a3833a9d524');