create schema history;

create table history.history
(
    id uuid not null
        constraint history_pk
            primary key,
    name varchar not null,
    user_id uuid not null
        constraint history_users_id_fk
            references auth.users
            on update cascade on delete cascade
);

insert into history.history values ('26d97fa0-459a-48ea-ba08-5a3833a9d524', 'mandarines', '26d97fa0-459a-48ea-ba08-5a3833a9d524');
insert into history.history values ('26d97fa0-459a-48ea-ba08-5a3833a8d524', 'mandarin', '26d97fa0-459a-48ea-ba08-5a3833a9d524');
insert into history.history values ('26d97fa0-459a-48ea-ba08-5a3833a7d524', 'mandalores', '26d97fa0-459a-48ea-ba08-5a3833a9d524');
insert into history.history values ('26d97fa0-459a-48ea-ba08-5a3833a6d524', 'spider-man', '26d97fa0-459a-48ea-ba08-5a3833a9d524');
insert into history.history values ('26d97fa0-459a-48ea-ba08-5a3833a5d524', 'cucumber', '26d97fa0-459a-48ea-ba08-5a3833a9d524');
insert into history.history values ('26d97fa0-459a-48ea-ba08-5a3833a4d524', 'majesty', '26d97fa0-459a-48ea-ba08-5a3833a9d524');
insert into history.history values ('26d97fa0-459a-48ea-ba08-5a3833a3d524', 'hasky', '26d97fa0-459a-48ea-ba08-5a3833a9d524');
insert into history.history values ('26d97fa0-459a-48ea-ba08-5a3833a2d524', 'justchillin', '26d97fa0-459a-48ea-ba08-5a3833a9d524');
insert into history.history values ('26d97fa0-459a-48ea-ba08-5a3834a2d524', 'makarena', '36d97fa0-459a-48ea-ba08-5a3833a9d524');
insert into history.history values ('26d97fa0-459a-48ea-ba08-5a3835a2d524', 'allakebab', '36d97fa0-459a-48ea-ba08-5a3833a9d524');
insert into history.history values ('26d97fa0-459a-48ea-ba08-5a3836a2d524', 'martinez an dot', '36d97fa0-459a-48ea-ba08-5a3833a9d524');