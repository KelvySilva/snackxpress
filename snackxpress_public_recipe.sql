create table recipe
(
    id               bigint       not null
        constraint recipe_pkey
            primary key,
    product_final_id bigint
        constraint fkq7xqxknwt4rl1nq5jy93btov3
            references product,
    name             varchar(255) not null
);

alter table recipe
    owner to snackxpress;

INSERT INTO public.recipe (id, product_final_id, name) VALUES (114, 115, 'Chicken Premium 200g');
INSERT INTO public.recipe (id, product_final_id, name) VALUES (121, 122, 'Lamb Premium 200g');
INSERT INTO public.recipe (id, product_final_id, name) VALUES (128, 129, 'Burguer Premium 200g');