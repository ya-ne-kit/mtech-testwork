drop table if exists bodies, wheels, cars;

CREATE TABLE IF NOT EXISTS bodies
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY not null,
    body_type  varchar                                         not null,
    length     int                                             not null,
    max_width  int                                             not null,
    max_heigth int                                             not null,
    quantity   int                                             not null
);

CREATE TABLE IF NOT EXISTS wheels
(
    id           BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY not null,
    rim_diameter varchar                                         not null,
    tire_width   int                                             not null,
    side_heigth  int                                             not null,
    quantity     int                                             not null
);

CREATE TABLE IF NOT EXISTS cars
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY not null,
    name        varchar                                         not null,
    body_id     BIGINT                                          not null,
    wheel_id    BIGINT                                          not null,
    wheel_count int                                             not null,
    CONSTRAINT fk_cars_to_wheels FOREIGN KEY (wheel_id) REFERENCES wheels (id),
    CONSTRAINT fk_cars_to_bodies FOREIGN KEY (body_id) REFERENCES bodies (id)
);