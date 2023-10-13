-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	user_id serial4 NOT NULL,
	username varchar NOT NULL,
	"password" varchar NOT NULL,
	expired bool NOT NULL,
	"locked" bool NOT NULL,
	enabled bool NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (user_id)
);
CREATE UNIQUE INDEX users_username_idx ON public.users USING btree (username);


-- public.authorities definition

-- Drop table

-- DROP TABLE public.authorities;

CREATE TABLE public.authorities (
	authority_id serial4 NOT NULL,
	"role" varchar NOT NULL,
	active bool NOT NULL,
	CONSTRAINT authorities_pk PRIMARY KEY (authority_id)
);
CREATE UNIQUE INDEX authorities_role_idx ON public.authorities USING btree (role);


-- public.users_authorities definition

-- Drop table

-- DROP TABLE public.users_authorities;

CREATE TABLE public.users_authorities (
	id serial4 NOT NULL,
	user_id int4 NOT NULL,
	authority_id int4 NOT NULL,
	CONSTRAINT users_authorities_fk FOREIGN KEY (user_id) REFERENCES public.users(user_id),
	CONSTRAINT users_authorities_fk_1 FOREIGN KEY (authority_id) REFERENCES public.authorities(authority_id)
);