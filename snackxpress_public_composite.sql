create table composite
(
    id            bigint not null
        constraint composite_pkey
            primary key,
    quantity      integer,
    ingredient_id bigint
        constraint fkhyhyeo4aqq7q4qbra9jasl45h
            references product
);

alter table composite
    owner to snackxpress;

INSERT INTO public.composite (id, quantity, ingredient_id) VALUES (116, 1, 72);
INSERT INTO public.composite (id, quantity, ingredient_id) VALUES (117, 1, 74);
INSERT INTO public.composite (id, quantity, ingredient_id) VALUES (118, 1, 78);
INSERT INTO public.composite (id, quantity, ingredient_id) VALUES (119, 1, 94);
INSERT INTO public.composite (id, quantity, ingredient_id) VALUES (120, 1, 62);
INSERT INTO public.composite (id, quantity, ingredient_id) VALUES (123, 1, 72);
INSERT INTO public.composite (id, quantity, ingredient_id) VALUES (124, 1, 74);
INSERT INTO public.composite (id, quantity, ingredient_id) VALUES (125, 1, 78);
INSERT INTO public.composite (id, quantity, ingredient_id) VALUES (126, 1, 98);
INSERT INTO public.composite (id, quantity, ingredient_id) VALUES (127, 1, 62);
INSERT INTO public.composite (id, quantity, ingredient_id) VALUES (130, 1, 72);
INSERT INTO public.composite (id, quantity, ingredient_id) VALUES (131, 1, 74);
INSERT INTO public.composite (id, quantity, ingredient_id) VALUES (132, 1, 78);
INSERT INTO public.composite (id, quantity, ingredient_id) VALUES (133, 1, 96);
INSERT INTO public.composite (id, quantity, ingredient_id) VALUES (134, 1, 62);