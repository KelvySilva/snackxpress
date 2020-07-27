create table recipe_composities
(
    recipe_id      bigint not null
        constraint fk9reujkguiy8f5xi15fk85b9er
            references recipe,
    composities_id bigint not null
        constraint fkrig0exlmbfqgrh1wuajyech4
            references composite
);

alter table recipe_composities
    owner to snackxpress;

INSERT INTO public.recipe_composities (recipe_id, composities_id) VALUES (114, 116);
INSERT INTO public.recipe_composities (recipe_id, composities_id) VALUES (114, 117);
INSERT INTO public.recipe_composities (recipe_id, composities_id) VALUES (114, 118);
INSERT INTO public.recipe_composities (recipe_id, composities_id) VALUES (114, 119);
INSERT INTO public.recipe_composities (recipe_id, composities_id) VALUES (114, 120);
INSERT INTO public.recipe_composities (recipe_id, composities_id) VALUES (121, 123);
INSERT INTO public.recipe_composities (recipe_id, composities_id) VALUES (121, 124);
INSERT INTO public.recipe_composities (recipe_id, composities_id) VALUES (121, 125);
INSERT INTO public.recipe_composities (recipe_id, composities_id) VALUES (121, 126);
INSERT INTO public.recipe_composities (recipe_id, composities_id) VALUES (121, 127);
INSERT INTO public.recipe_composities (recipe_id, composities_id) VALUES (128, 130);
INSERT INTO public.recipe_composities (recipe_id, composities_id) VALUES (128, 131);
INSERT INTO public.recipe_composities (recipe_id, composities_id) VALUES (128, 132);
INSERT INTO public.recipe_composities (recipe_id, composities_id) VALUES (128, 133);
INSERT INTO public.recipe_composities (recipe_id, composities_id) VALUES (128, 134);