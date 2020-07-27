create table sale_order_item_list
(
    sale_order_id bigint not null
        constraint fkicayc6cfv4u2yr7mg50yqtilp
            references sale_order,
    item_list_id  bigint not null
        constraint uk_9gsgdjexccqygnkkfr6eaeklb
            unique
        constraint fks6cil86bykcuvjwwxo4u4yq4w
            references sale_order_item
);

alter table sale_order_item_list
    owner to snackxpress;

