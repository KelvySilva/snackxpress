create table sale_order_item_products
(
    sale_order_item_id bigint not null
        constraint fky0sofk1jaw8arl4e2g6ehsb5
            references sale_order_item,
    products_id        bigint not null
        constraint fkj46evd3dnyq8dnlgm1a53qec6
            references product
);

alter table sale_order_item_products
    owner to snackxpress;

