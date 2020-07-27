create table person
(
    id             bigint      not null
        constraint person_pkey
            primary key,
    cpf            varchar(255)
        constraint uk_ovihp2p82c97wbe60mv11txrj
            unique,
    name           varchar(255),
    dtype          varchar(31) not null,
    address        varchar(255),
    address_number varchar(255),
    cep            varchar(255),
    city           varchar(255),
    phone          varchar(255),
    state          varchar(255),
    password       varchar(255),
    username       varchar(255)
);

alter table person
    owner to snackxpress;

