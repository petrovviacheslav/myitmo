BEGIN;

CREATE TYPE gender AS ENUM (
    'male',
    'female'
    );
CREATE TYPE ship_type AS ENUM (
    'rescue',
    'distress',
    'default'
    );
CREATE TABLE IF NOT EXISTS agency
(
    id            SERIAL PRIMARY KEY,
    name          TEXT NOT NULL,
    base_location TEXT NOT NULL
);
CREATE TABLE IF NOT EXISTS human
(
    id     SERIAL PRIMARY KEY,
    name   TEXT   NOT NULL,
    gender gender NOT NULL
);
CREATE TABLE IF NOT EXISTS ship
(
    id          SERIAL PRIMARY KEY,
    name        TEXT      NOT NULL,
    type        ship_type NOT NULL,
    last_change TIMESTAMP NOT NULL
);
CREATE TABLE IF NOT EXISTS passenger
(
    id       SERIAL PRIMARY KEY,
    ship_id  INT REFERENCES ship,
    human_id INT REFERENCES human,
    got_on   TIMESTAMP NOT NULL,
    got_off  TIMESTAMP CHECK ( got_off > got_on ),
    UNIQUE (ship_id, human_id, got_on)
);

CREATE TABLE IF NOT EXISTS injury
(
    passenger_id INT       NOT NULL REFERENCES passenger,
    description  TEXT      NOT NULL,
    time_injury  TIMESTAMP NOT NULL,
    PRIMARY KEY (passenger_id, time_injury)
);

CREATE TABLE IF NOT EXISTS incident
(
    id               SERIAL PRIMARY KEY,
    description      TEXT      NOT NULL DEFAULT 'кое-где',
    id_agency        INT       NOT NULL REFERENCES agency,
    id_distress_ship INT       NOT NULL REFERENCES ship,
    is_seriously     BOOLEAN   NOT NULL,
    time_incident    TIMESTAMP NOT NULL,
    coordinate_x     INT       NOT NULL,
    coordinate_y     INT       NOT NULL,
    coordinate_z     INT       NOT NULL
);


CREATE TABLE IF NOT EXISTS rescue_operation
(
    id_incident     INT       NOT NULL REFERENCES incident,
    id_rescue_ship  INT       NOT NULL REFERENCES ship,
    is_successfully BOOLEAN   NOT NULL,
    start_operation TIMESTAMP NOT NULL,
    end_operation   TIMESTAMP NOT NULL CHECK ( end_operation > start_operation ),
    PRIMARY KEY (id_incident, start_operation)
);

INSERT INTO agency(name, base_location)
VALUES ('Агенство по космонавтике', 'Земля');

INSERT INTO human(name, gender)
VALUES ('Роберт', 'male');
INSERT INTO human(name, gender)
VALUES ('Максим', 'male');
INSERT INTO human(name, gender)
VALUES ('Клара', 'female');
INSERT INTO human(name, gender)
VALUES ('Екатерина', 'female');

INSERT INTO ship(name, type, last_change)
VALUES ('Шатл спасения', 'rescue', '2021-03-05 17:00:00');
INSERT INTO passenger(ship_id, human_id, got_on, got_off)
VALUES (1, 1, '2021-03-05 17:00:00', '2021-03-05 23:00:00'),
       (1, 2, '2021-03-05 17:00:00', '2021-03-05 23:00:00');
INSERT INTO injury(passenger_id, description, time_injury)
VALUES (1, 'травмы средней тяжести', '2021-03-05 18:00:00'),
       (2, 'нет травм', '2021-03-05 18:00:00');
INSERT INTO ship(name, type, last_change)
VALUES ('Летящий вперёд', 'distress', '2021-03-05 17:00:00');
INSERT INTO passenger(ship_id, human_id, got_on, got_off)
VALUES (2, 3, '2021-03-05 17:00:00', '2021-03-05 23:00:00'),
       (2, 4, '2021-03-05 17:00:00', '2021-03-05 23:00:00');


INSERT INTO incident(description, id_agency, id_distress_ship, is_seriously, time_incident, coordinate_x, coordinate_y,
                     coordinate_z)
VALUES ('Крушение корабля', 1, 2, 'TRUE', '2021-03-05 17:00:00', 123456.00, 123456.00, 123456.00);

INSERT INTO rescue_operation (id_incident, id_rescue_ship, is_successfully, start_operation, end_operation)
VALUES (1, 1, 'TRUE', '2021-03-05 17:10:00', '2021-03-05 19:10:00');

END;

/*

 CREATE OR REPLACE FUNCTION check_type_ship()
    RETURNS TRIGGER AS
$$
BEGIN
    IF NEW.ship_id > CURRENT_TIMESTAMP
    THEN
        RAISE EXCEPTION 'Ship [id:%] expired!',
            NEW.id;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER view_insert
    INSTEAD OF INSERT
    ON rescue_operation
    FOR EACH ROW
EXECUTE FUNCTION check_type_ship();
 */
