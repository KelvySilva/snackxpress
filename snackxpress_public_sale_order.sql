create table sale_order
(
    id              bigint not null
        constraint sale_order_pkey
            primary key,
    discount_amount numeric(19, 2),
    subtotal        numeric(19, 2),
    total           numeric(19, 2),
    status          integer,
    client_id       bigint
        constraint fk4s9turntrsyjc2w5purd54tgg
            references person
);

alter table sale_order
    owner to snackxpress;

