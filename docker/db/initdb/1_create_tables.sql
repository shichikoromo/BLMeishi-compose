-- Adminer 4.7.8 PostgreSQL dump

\connect "dev";

DROP TABLE IF EXISTS "doms";
DROP SEQUENCE IF EXISTS doms_id_seq;
CREATE SEQUENCE doms_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1;

CREATE TABLE "public"."doms" (
                                 "id" integer DEFAULT nextval('doms_id_seq') NOT NULL,
                                 "name" character varying(255) NOT NULL,
                                 "description" character varying(400) NOT NULL,
                                 "manager" character varying(250) NOT NULL,
                                 "icon" character varying(1000) NOT NULL,
                                 "createdAt" timestamptz NOT NULL,
                                 "active" boolean NOT NULL
) WITH (oids = false);


DROP TABLE IF EXISTS "memberdoms";
DROP SEQUENCE IF EXISTS memberdoms_id_seq;
CREATE SEQUENCE memberdoms_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1;

CREATE TABLE "public"."memberdoms" (
                                       "id" integer DEFAULT nextval('memberdoms_id_seq') NOT NULL,
                                       "memberId" integer NOT NULL,
                                       "domId" integer NOT NULL
) WITH (oids = false);


DROP TABLE IF EXISTS "members";
DROP SEQUENCE IF EXISTS users_id_seq;
CREATE SEQUENCE users_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1;

CREATE TABLE "public"."members" (
                                    "id" integer DEFAULT nextval('users_id_seq') NOT NULL,
                                    "name" character varying(255) NOT NULL,
                                    "twitterId" character varying(15) NOT NULL,
                                    "accessToken" character varying(100) NOT NULL,
                                    "accessSecret" character varying(100) NOT NULL,
                                    "createdAt" timestamptz NOT NULL,
                                    "active" boolean NOT NULL,
                                    CONSTRAINT "users_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


-- 2022-02-19 09:00:28.986903+00
