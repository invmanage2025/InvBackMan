--
-- PostgreSQL database cluster dump
--

-- Started on 2025-08-04 01:04:28

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'SCRAM-SHA-256$4096:Vfcl75esZdBwV98RaCILAw==$KpQhR1+CnG7LV5giKFIbAKTskGnnkhf90C/lvXh+rhQ=:iOvCcJSShwm2pqVq2RhYp6o74D+TpVZr59ghgftNpAI=';

--
-- User Configurations
--








--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 16.9
-- Dumped by pg_dump version 16.9

-- Started on 2025-08-04 01:04:28

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2025-08-04 01:04:28

--
-- PostgreSQL database dump complete
--

--
-- Database "INV_USER_01" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 16.9
-- Dumped by pg_dump version 16.9

-- Started on 2025-08-04 01:04:28

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4872 (class 1262 OID 24584)
-- Name: INV_USER_01; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "INV_USER_01" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_India.1252';


ALTER DATABASE "INV_USER_01" OWNER TO postgres;

\connect "INV_USER_01"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 219 (class 1259 OID 24634)
-- Name: T_DOMAIN; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."T_DOMAIN" (
    "DOM_ID" integer NOT NULL,
    "DOM_ATTR" text NOT NULL,
    "DOM_TYPE" text NOT NULL,
    "DOM_SUBTYPE" text,
    "DOM_VALUE" text NOT NULL,
    "EFF_START_DATE" timestamp without time zone NOT NULL,
    "EFF_END_DATE" timestamp without time zone NOT NULL,
    "DELETED_FLAG" boolean NOT NULL,
    "CREATED_BY" text NOT NULL,
    "UPDATED_BY" text
);


ALTER TABLE public."T_DOMAIN" OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 24594)
-- Name: T_MODEL; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."T_MODEL" (
    "MDL_ID" integer NOT NULL,
    "MDL_MODEL" text NOT NULL,
    "MDL_NAME" text,
    "MDL_REMARKS" text,
    "EFF_START_DATE" timestamp without time zone NOT NULL,
    "EFF_END_DATE" timestamp without time zone NOT NULL,
    "DELETED_FLAG" boolean NOT NULL,
    "CREATED_BY" text NOT NULL,
    "UPDATED_BY" text
);


ALTER TABLE public."T_MODEL" OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 24622)
-- Name: T_PRIMARY_GODOWN; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."T_PRIMARY_GODOWN" (
    "PGN_ID" integer NOT NULL,
    "PGN_PRC_ID" integer NOT NULL,
    "PGN_MODEL" text NOT NULL,
    "PGN_PRODUCT_NO" text NOT NULL,
    "PGN_REMARKS" text,
    "EFF_START_DATE" timestamp without time zone NOT NULL,
    "EFF_END_DATE" timestamp without time zone NOT NULL,
    "DELETED_FLAG" boolean NOT NULL,
    "CREATED_BY" text NOT NULL,
    "UPDATED_BY" text
);


ALTER TABLE public."T_PRIMARY_GODOWN" OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 24585)
-- Name: T_PURCHASE; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."T_PURCHASE" (
    "PRC_ID" integer NOT NULL,
    "PRC_INVOICE" text NOT NULL,
    "PRC_REMARKS" text,
    "EFF_START_DATE" timestamp without time zone NOT NULL,
    "EFF_END_DATE" timestamp without time zone NOT NULL,
    "DELETED_FLAG" boolean NOT NULL,
    "CREATED_BY" text NOT NULL,
    "UPDATED_BY" text
);


ALTER TABLE public."T_PURCHASE" OWNER TO postgres;

--
-- TOC entry 4873 (class 0 OID 0)
-- Dependencies: 215
-- Name: TABLE "T_PURCHASE"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public."T_PURCHASE" IS 'Table to Store Purchase and Invoice Records';


--
-- TOC entry 217 (class 1259 OID 24603)
-- Name: T_PURCHASE_INS; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."T_PURCHASE_INS" (
    "PIS_ID" integer NOT NULL,
    "PIS_PRC_ID" integer NOT NULL,
    "PIS_MODEL" text NOT NULL,
    "PIS_SERIAL_NO" text NOT NULL,
    "PIS_PRODUCT_NO" text NOT NULL,
    "PIS_REMARKS" text,
    "PIS_STATUS" text NOT NULL,
    "EFF_START_DATE" timestamp without time zone NOT NULL,
    "EFF_END_DATE" timestamp without time zone NOT NULL,
    "DELETED_FLAG" boolean NOT NULL,
    "CREATED_BY" text NOT NULL,
    "UPDATED_BY" text
);


ALTER TABLE public."T_PURCHASE_INS" OWNER TO postgres;

--
-- TOC entry 4866 (class 0 OID 24634)
-- Dependencies: 219
-- Data for Name: T_DOMAIN; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."T_DOMAIN" ("DOM_ID", "DOM_ATTR", "DOM_TYPE", "DOM_SUBTYPE", "DOM_VALUE", "EFF_START_DATE", "EFF_END_DATE", "DELETED_FLAG", "CREATED_BY", "UPDATED_BY") FROM stdin;
\.


--
-- TOC entry 4863 (class 0 OID 24594)
-- Dependencies: 216
-- Data for Name: T_MODEL; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."T_MODEL" ("MDL_ID", "MDL_MODEL", "MDL_NAME", "MDL_REMARKS", "EFF_START_DATE", "EFF_END_DATE", "DELETED_FLAG", "CREATED_BY", "UPDATED_BY") FROM stdin;
\.


--
-- TOC entry 4865 (class 0 OID 24622)
-- Dependencies: 218
-- Data for Name: T_PRIMARY_GODOWN; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."T_PRIMARY_GODOWN" ("PGN_ID", "PGN_PRC_ID", "PGN_MODEL", "PGN_PRODUCT_NO", "PGN_REMARKS", "EFF_START_DATE", "EFF_END_DATE", "DELETED_FLAG", "CREATED_BY", "UPDATED_BY") FROM stdin;
\.


--
-- TOC entry 4862 (class 0 OID 24585)
-- Dependencies: 215
-- Data for Name: T_PURCHASE; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."T_PURCHASE" ("PRC_ID", "PRC_INVOICE", "PRC_REMARKS", "EFF_START_DATE", "EFF_END_DATE", "DELETED_FLAG", "CREATED_BY", "UPDATED_BY") FROM stdin;
100	SDEF345	Test	2000-01-01 00:00:00	9999-01-01 00:00:00	t	Tanmoy	\N
101	ACD	\N	2000-01-01 00:00:00	9999-01-01 00:00:00	f	Sumit	\N
\.


--
-- TOC entry 4864 (class 0 OID 24603)
-- Dependencies: 217
-- Data for Name: T_PURCHASE_INS; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."T_PURCHASE_INS" ("PIS_ID", "PIS_PRC_ID", "PIS_MODEL", "PIS_SERIAL_NO", "PIS_PRODUCT_NO", "PIS_REMARKS", "PIS_STATUS", "EFF_START_DATE", "EFF_END_DATE", "DELETED_FLAG", "CREATED_BY", "UPDATED_BY") FROM stdin;
\.


--
-- TOC entry 4716 (class 2606 OID 24640)
-- Name: T_DOMAIN T_DOMAIN_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."T_DOMAIN"
    ADD CONSTRAINT "T_DOMAIN_pkey" PRIMARY KEY ("DOM_ID");


--
-- TOC entry 4708 (class 2606 OID 24600)
-- Name: T_MODEL T_MODEL_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."T_MODEL"
    ADD CONSTRAINT "T_MODEL_pkey" PRIMARY KEY ("MDL_ID");


--
-- TOC entry 4714 (class 2606 OID 24628)
-- Name: T_PRIMARY_GODOWN T_PRIMARY_GODOWN_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."T_PRIMARY_GODOWN"
    ADD CONSTRAINT "T_PRIMARY_GODOWN_pkey" PRIMARY KEY ("PGN_ID");


--
-- TOC entry 4712 (class 2606 OID 24609)
-- Name: T_PURCHASE_INS T_PURCHASE_INS_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."T_PURCHASE_INS"
    ADD CONSTRAINT "T_PURCHASE_INS_pkey" PRIMARY KEY ("PIS_ID");


--
-- TOC entry 4704 (class 2606 OID 24591)
-- Name: T_PURCHASE T_PURCHASE_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."T_PURCHASE"
    ADD CONSTRAINT "T_PURCHASE_pkey" PRIMARY KEY ("PRC_ID");


--
-- TOC entry 4706 (class 2606 OID 24593)
-- Name: T_PURCHASE Unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."T_PURCHASE"
    ADD CONSTRAINT "Unique" UNIQUE ("PRC_INVOICE");


--
-- TOC entry 4710 (class 2606 OID 24602)
-- Name: T_MODEL Unique Model; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."T_MODEL"
    ADD CONSTRAINT "Unique Model" UNIQUE ("MDL_MODEL");


--
-- TOC entry 4717 (class 2606 OID 24610)
-- Name: T_PURCHASE_INS PURCHASE_Fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."T_PURCHASE_INS"
    ADD CONSTRAINT "PURCHASE_Fkey" FOREIGN KEY ("PIS_PRC_ID") REFERENCES public."T_PURCHASE"("PRC_ID");


--
-- TOC entry 4718 (class 2606 OID 24629)
-- Name: T_PRIMARY_GODOWN T_PRIMARY_GODOWN_PGN_PRC_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."T_PRIMARY_GODOWN"
    ADD CONSTRAINT "T_PRIMARY_GODOWN_PGN_PRC_ID_fkey" FOREIGN KEY ("PGN_PRC_ID") REFERENCES public."T_PURCHASE"("PRC_ID");


-- Completed on 2025-08-04 01:04:28

--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

\connect postgres

--
-- PostgreSQL database dump
--

-- Dumped from database version 16.9
-- Dumped by pg_dump version 16.9

-- Started on 2025-08-04 01:04:28

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 4832 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


-- Completed on 2025-08-04 01:04:28

--
-- PostgreSQL database dump complete
--

-- Completed on 2025-08-04 01:04:28

--
-- PostgreSQL database cluster dump complete
--

