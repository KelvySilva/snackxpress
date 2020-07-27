create table order_item_products
(
    order_item_id bigint not null
        constraint fkpi5b8n0h3a51a24gw1eqpitcv
            references order_item,
    products_id   bigint not null
        constraint fkd4xg48lqapvagv12samuxggex
            references product
);

alter table order_item_products
    owner to snackxpress;

