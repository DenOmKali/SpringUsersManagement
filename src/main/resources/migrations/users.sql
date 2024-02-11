-- first query, auto generated uuid
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- create table users
CREATE TABLE public.users
(
    id         varchar DEFAULT uuid_generate_v4() not null
        constraint users_id_pk
        primary key,
    first_name varchar not null,
    last_name  varchar not null,
    role       varchar not null
);