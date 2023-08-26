--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.16
-- Dumped by pg_dump version 9.5.12

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: bonus; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bonus (
    emp_name character varying(15),
    job_name character varying(10),
    salary integer,
    commission integer
);


ALTER TABLE public.bonus OWNER TO postgres;

--
-- Name: department; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.department (
    dep_id integer NOT NULL,
    dep_name character varying(20),
    dep_location character varying(15)
);


ALTER TABLE public.department OWNER TO postgres;

--
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employees (
    emp_id integer NOT NULL,
    emp_name character varying(15),
    job_name character varying(10),
    manager_id integer,
    hire_date date,
    salary numeric(10,2),
    commission numeric(7,2),
    dep_id integer
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- Name: salary_grade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.salary_grade (
    grade integer,
    min_sal integer,
    max_sal integer
);


ALTER TABLE public.salary_grade OWNER TO postgres;

--
-- Data for Name: bonus; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bonus (emp_name, job_name, salary, commission) FROM stdin;
\.


--
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.department (dep_id, dep_name, dep_location) FROM stdin;
1001	FINANCE	SYDNEY
2001	AUDIT	MELBOURNE
3001	MARKETING	PERTH
4001	PRODUCTION	BRISBANE
\.


--
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employees (emp_id, emp_name, job_name, manager_id, hire_date, salary, commission, dep_id) FROM stdin;
68319	KAYLING	PRESIDENT	\N	1991-11-18	6000.00	\N	1001
66928	BLAZE	MANAGER	68319	1991-05-01	2750.00	\N	3001
67832	CLARE	MANAGER	68319	1991-06-09	2550.00	\N	1001
65646	JONAS	MANAGER	68319	1991-04-02	2957.00	\N	2001
64989	ADELYN	SALESMAN	66928	1991-02-20	1700.00	400.00	3001
65271	WADE	SALESMAN	66928	1991-02-22	1350.00	600.00	3001
66564	MADDEN	SALESMAN	66928	1991-09-28	1350.00	1500.00	3001
68454	TUCKER	SALESMAN	66928	1991-09-08	1600.00	0.00	3001
68736	ADNRES	CLERK	67858	1997-05-23	1200.00	\N	2001
69000	JULIUS	CLERK	66928	1991-12-03	1050.00	\N	3001
69324	MARKER	CLERK	67832	1992-01-23	1400.00	\N	1001
67858	SCARLET	ANALYST	65646	1997-04-19	3100.00	\N	2001
69062	FRANK	ANALYST	65646	1991-12-03	3100.00	\N	2001
63679	SANDRINE	CLERK	69062	1990-12-18	900.00	\N	2001
\.


--
-- Data for Name: salary_grade; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.salary_grade (grade, min_sal, max_sal) FROM stdin;
1	800	1300
2	1301	1500
3	1501	2100
4	2101	3100
5	3101	9999
\.


--
-- Name: pk_dep_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT pk_dep_id PRIMARY KEY (dep_id);


--
-- Name: pk_emp_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT pk_emp_id PRIMARY KEY (emp_id);


--
-- Name: fk_dep_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT fk_dep_id FOREIGN KEY (dep_id) REFERENCES public.department(dep_id);


--
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- Name: TABLE bonus; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE public.bonus FROM PUBLIC;
REVOKE ALL ON TABLE public.bonus FROM postgres;
GRANT ALL ON TABLE public.bonus TO postgres;
GRANT SELECT ON TABLE public.bonus TO emp;


--
-- Name: TABLE department; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE public.department FROM PUBLIC;
REVOKE ALL ON TABLE public.department FROM postgres;
GRANT ALL ON TABLE public.department TO postgres;
GRANT SELECT ON TABLE public.department TO emp;


--
-- Name: TABLE employees; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE public.employees FROM PUBLIC;
REVOKE ALL ON TABLE public.employees FROM postgres;
GRANT ALL ON TABLE public.employees TO postgres;
GRANT SELECT ON TABLE public.employees TO emp;


--
-- Name: TABLE salary_grade; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE public.salary_grade FROM PUBLIC;
REVOKE ALL ON TABLE public.salary_grade FROM postgres;
GRANT ALL ON TABLE public.salary_grade TO postgres;
GRANT SELECT ON TABLE public.salary_grade TO emp;


--
-- PostgreSQL database dump complete
--

