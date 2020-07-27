create table stock
(
    id       bigint not null
        constraint stock_pkey
            primary key,
    quantity integer
);

alter table stock
    owner to snackxpress;

INSERT INTO public.stock (id, quantity) VALUES (63, 50);
INSERT INTO public.stock (id, quantity) VALUES (65, 50);
INSERT INTO public.stock (id, quantity) VALUES (67, 50);
INSERT INTO public.stock (id, quantity) VALUES (69, 50);
INSERT INTO public.stock (id, quantity) VALUES (71, 5);
INSERT INTO public.stock (id, quantity) VALUES (73, 20);
INSERT INTO public.stock (id, quantity) VALUES (75, 10);
INSERT INTO public.stock (id, quantity) VALUES (77, 10);
INSERT INTO public.stock (id, quantity) VALUES (79, 10);
INSERT INTO public.stock (id, quantity) VALUES (81, 10);
INSERT INTO public.stock (id, quantity) VALUES (83, 10);
INSERT INTO public.stock (id, quantity) VALUES (85, 10);
INSERT INTO public.stock (id, quantity) VALUES (87, 25);
INSERT INTO public.stock (id, quantity) VALUES (89, 250);
INSERT INTO public.stock (id, quantity) VALUES (91, 5);
INSERT INTO public.stock (id, quantity) VALUES (93, 250);
INSERT INTO public.stock (id, quantity) VALUES (95, 30);
INSERT INTO public.stock (id, quantity) VALUES (97, 30);
INSERT INTO public.stock (id, quantity) VALUES (99, 30);
INSERT INTO public.stock (id, quantity) VALUES (101, 15);
INSERT INTO public.stock (id, quantity) VALUES (103, 100);
INSERT INTO public.stock (id, quantity) VALUES (104, 100);
INSERT INTO public.stock (id, quantity) VALUES (108, 10);
INSERT INTO public.stock (id, quantity) VALUES (136, 18);