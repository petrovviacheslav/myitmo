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

CREATE TYPE injury_type AS ENUM (
    'лёгкая',
    'средней тяжести',
    'тяжёлые',
    'не совместимые с жизнью'
    );

CREATE TABLE IF NOT EXISTS agency
(
    name               TEXT NOT NULL PRIMARY KEY,
    main_base_location TEXT NOT NULL
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
    name_agency      TEXT      NOT NULL REFERENCES agency (name),
    name        TEXT UNIQUE NOT NULL,
    type        ship_type   NOT NULL,
    last_change TIMESTAMP   NOT NULL
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



CREATE TABLE IF NOT EXISTS incident
(
    id               SERIAL PRIMARY KEY,
    description      TEXT      NOT NULL DEFAULT 'кое-где',
    id_distress_ship INT       NOT NULL REFERENCES ship,
    time_incident    TIMESTAMP NOT NULL,
    coordinate_x     INT       NOT NULL,
    coordinate_y     INT       NOT NULL,
    coordinate_z     INT       NOT NULL,
    id_rescue_ship   INT REFERENCES ship,
    start_operation  TIMESTAMP CHECK ( start_operation >= time_incident ),
    end_operation    TIMESTAMP CHECK ( end_operation >= start_operation )
);
CREATE TABLE IF NOT EXISTS injury
(
    passenger_id INT         NOT NULL REFERENCES passenger,
    incident_id  INT         NOT NULL REFERENCES incident,
    description  injury_type NOT NULL,
    time_injury  TIMESTAMP   NOT NULL,
    PRIMARY KEY (passenger_id, incident_id, time_injury)
);


CREATE OR REPLACE FUNCTION check_and_update_type_ship() RETURNS trigger AS
$$
declare
    type_of_rescue_ship ship_type;
BEGIN
    SELECT ship.type INTO type_of_rescue_ship FROM ship WHERE ship.id = NEW.id_rescue_ship;
    IF (type_of_rescue_ship = 'distress') then
        RAISE EXCEPTION 'Терпящий бедствие корабль не может прийти на помощь';
    end if;
    UPDATE ship
    SET type = 'distress',
        last_change = now()
    WHERE id = NEW.id_distress_ship;
    UPDATE ship
    SET type = 'rescue',
        last_change = now()
    WHERE id = NEW.id_rescue_ship;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
CREATE OR REPLACE TRIGGER check_and_update_type
    BEFORE INSERT OR UPDATE
    ON incident
EXECUTE FUNCTION check_and_update_type_ship();


INSERT INTO agency(name, main_base_location)
VALUES ('Агенство по космонавтике', 'Земля');

INSERT INTO human(name, gender)
VALUES ('Роберт', 'male');
INSERT INTO human(name, gender)
VALUES ('Максим', 'male');
INSERT INTO human(name, gender)
VALUES ('Клара', 'female');
INSERT INTO human(name, gender)
VALUES ('Екатерина', 'female');

INSERT INTO ship(name_agency, name, type, last_change)
VALUES ('Агенство по космонавтике', 'Шатл спасения', 'distress', '2021-03-05 17:00:00');
INSERT INTO passenger(ship_id, human_id, got_on, got_off)
VALUES (1, 1, '2021-03-05 17:00:00', '2021-03-05 23:00:00'),
       (1, 2, '2021-03-05 17:00:00', '2021-03-05 23:00:00');

INSERT INTO ship(name_agency, name, type, last_change)
VALUES ('Агенство по космонавтике', 'Летящий вперёд', 'distress', '2021-03-05 17:00:00');
INSERT INTO passenger(ship_id, human_id, got_on, got_off)
VALUES (2, 3, '2021-03-05 17:00:00', '2021-03-05 23:00:00'),
       (2, 4, '2021-03-05 17:00:00', '2021-03-05 23:00:00');


INSERT INTO incident(description, id_distress_ship, time_incident, coordinate_x, coordinate_y,
                     coordinate_z, id_rescue_ship, start_operation, end_operation)
VALUES ('Крушение корабля', 2, '2021-03-05 17:00:00', 123456.00, 123456.00, 123456.001, 1,
        '2021-03-05 17:10:00', '2021-03-05 19:10:00');
INSERT INTO injury(passenger_id, incident_id, description, time_injury)
VALUES (1, 1, 'средней тяжести', '2021-03-05 18:00:00'),
       (2, 1, 'лёгкая', '2021-03-05 18:00:00');
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
