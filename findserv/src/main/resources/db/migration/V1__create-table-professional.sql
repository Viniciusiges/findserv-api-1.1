create table professional
(

    id           uuid primary key not null default uuid_generate_v4(),
    name         varchar(100)     not null,
    cpf          varchar(11)      not null unique,
    phone        varchar(11)      not null,
    email        varchar(100)     not null unique,
    been_working varchar(100)     not null,
    value_hour   varchar(100)     not null,
    activity     varchar(100)     not null,
    active       boolean

);