create table sale_order_item
(
    id       bigint not null
        constraint sale_order_item_pkey
            primary key,
    discount numeric(19, 2),
    subtotal numeric(19, 2),
    total    numeric(19, 2)
);

alter table sale_order_item
    owner to snackxpress;

