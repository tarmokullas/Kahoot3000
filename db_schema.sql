CREATE DATABASE qmark

USE qmark

CREATE TABLE IF NOT EXISTS users (
id integer NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    username text COLLATE pg_catalog."default" NOT NULL,
    password text COLLATE pg_catalog."default" NOT NULL,
    salt text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS questions
(
    id integer NOT NULL DEFAULT nextval('questions_id_seq'::regclass),
    title text COLLATE pg_catalog."default" NOT NULL,
    game integer NOT NULL,
    CONSTRAINT questions_pkey PRIMARY KEY (id),
    CONSTRAINT fk_question_2_game FOREIGN KEY (game)
        REFERENCES public.games (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS games
(
    id integer NOT NULL DEFAULT nextval('games_id_seq'::regclass),
    creator integer NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT games_pkey PRIMARY KEY (id),
    CONSTRAINT fk_game_2_creator FOREIGN KEY (creator)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS answers
(
    id integer NOT NULL DEFAULT nextval('answers_id_seq'::regclass),
    content text COLLATE pg_catalog."default" NOT NULL,
    "isCorrect" boolean NOT NULL,
    question integer NOT NULL,
    CONSTRAINT answers_pkey PRIMARY KEY (id),
    CONSTRAINT fk_answer_2_question FOREIGN KEY (question)
        REFERENCES public.questions (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

