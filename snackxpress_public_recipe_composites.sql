create table recipe_composites
(
    recipe_id     bigint not null
        constraint fkckaqq8v6ig0bo08odgyci45fq
            references recipe,
    composites_id bigint not null
        constraint fk40bbhyrnd3h0i1sgy496p0mfm
            references composite
);

alter table recipe_composites
    owner to snackxpress;

