create table api_limiter
(
    id bigserial not null
        constraint api_limiter_pk
            primary key,
    path varchar(255) NOT NULL,
    method varchar(255) NOT NULL,
    threshold integer NOT NULL,
    ttl bigint NOT NULL,
    active boolean NOT NULL,
    CONSTRAINT api_limiter_pkey PRIMARY KEY (id)
)