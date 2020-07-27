create table order_item
(
    id       bigint not null
        constraint order_item_pkey
            primary key,
    discount numeric(19, 2),
    price    numeric(19, 2),
    subtotal numeric(19, 2),
    total    numeric(19, 2)
);

alter table order_item
    owner to snackxpress;

