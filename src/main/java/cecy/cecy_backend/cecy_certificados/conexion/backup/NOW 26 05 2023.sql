PGDMP         ;                {         
   cecy_curso #   14.7 (Ubuntu 14.7-0ubuntu0.22.04.1) #   14.7 (Ubuntu 14.7-0ubuntu0.22.04.1)    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    196864 
   cecy_curso    DATABASE     _   CREATE DATABASE cecy_curso WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'es_EC.UTF-8';
    DROP DATABASE cecy_curso;
                postgres    false            V           1247    196882    enum_catalogues_users_genders    TYPE     ^   CREATE TYPE public.enum_catalogues_users_genders AS ENUM (
    'masculino',
    'femenino'
);
 0   DROP TYPE public.enum_catalogues_users_genders;
       public          postgres    false            �            1259    196865    SequelizeMeta    TABLE     R   CREATE TABLE public."SequelizeMeta" (
    name character varying(255) NOT NULL
);
 #   DROP TABLE public."SequelizeMeta";
       public         heap    postgres    false            �            1259    196927    careers    TABLE     �   CREATE TABLE public.careers (
    id integer NOT NULL,
    name character varying(255),
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone NOT NULL
);
    DROP TABLE public.careers;
       public         heap    postgres    false            �            1259    196926    careers_id_seq    SEQUENCE     �   CREATE SEQUENCE public.careers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.careers_id_seq;
       public          postgres    false    219            �           0    0    careers_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.careers_id_seq OWNED BY public.careers.id;
          public          postgres    false    218            �            1259    196918 
   catalogues    TABLE     U  CREATE TABLE public.catalogues (
    id integer NOT NULL,
    created_at timestamp with time zone,
    updated_at timestamp with time zone,
    deleted_at timestamp with time zone,
    parent_id bigint,
    code character varying(255),
    description text,
    icon character varying(255),
    name text,
    type character varying(255)
);
    DROP TABLE public.catalogues;
       public         heap    postgres    false            �            1259    196917    catalogues_id_seq    SEQUENCE     �   CREATE SEQUENCE public.catalogues_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.catalogues_id_seq;
       public          postgres    false    217            �           0    0    catalogues_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.catalogues_id_seq OWNED BY public.catalogues.id;
          public          postgres    false    216            �            1259    196888    catalogues_users    TABLE     �   CREATE TABLE public.catalogues_users (
    id integer NOT NULL,
    genders public.enum_catalogues_users_genders,
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone NOT NULL
);
 $   DROP TABLE public.catalogues_users;
       public         heap    postgres    false    854            �            1259    196887    catalogues_users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.catalogues_users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.catalogues_users_id_seq;
       public          postgres    false    213            �           0    0    catalogues_users_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.catalogues_users_id_seq OWNED BY public.catalogues_users.id;
          public          postgres    false    212            �            1259    197054 	   classroom    TABLE     �   CREATE TABLE public.classroom (
    id bigint NOT NULL,
    type_id integer,
    capacity integer,
    code character varying(255),
    description text,
    name character varying(255)
);
    DROP TABLE public.classroom;
       public         heap    postgres    false            �            1259    197053    classroom_id_seq    SEQUENCE     y   CREATE SEQUENCE public.classroom_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.classroom_id_seq;
       public          postgres    false    231            �           0    0    classroom_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.classroom_id_seq OWNED BY public.classroom.id;
          public          postgres    false    230            �            1259    196960    courses    TABLE     a  CREATE TABLE public.courses (
    id integer NOT NULL,
    image_id character varying(255),
    planification_id integer NOT NULL,
    modality_id integer,
    category_id integer,
    entity_certification_id integer,
    course_type_id integer,
    certified_type_id integer,
    formation_type_id integer,
    abbreviation character varying(255),
    target_groups character varying(255),
    participant_types character varying(255),
    summary character varying(255),
    project character varying(255),
    objective character varying(255),
    alignment character varying(255),
    area_id integer,
    speciality_id integer,
    practice_hours integer,
    theory_hours integer,
    bibliographies json,
    "evaluationMechanisms" json,
    learning_environments json,
    teaching_strategies json,
    techniques_requisites json,
    prerequisites json
);
    DROP TABLE public.courses;
       public         heap    postgres    false            �            1259    196959    courses_id_seq    SEQUENCE     �   CREATE SEQUENCE public.courses_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.courses_id_seq;
       public          postgres    false    223            �           0    0    courses_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.courses_id_seq OWNED BY public.courses.id;
          public          postgres    false    222            �            1259    197068    detail_planifications    TABLE     3  CREATE TABLE public.detail_planifications (
    id integer NOT NULL,
    "planification_course_Id" integer,
    classroom_id integer,
    day_id integer,
    parallel_id integer,
    workday_id integer,
    ended_time time without time zone,
    observation text,
    started_time time without time zone
);
 )   DROP TABLE public.detail_planifications;
       public         heap    postgres    false            �            1259    197067    detail_planifications_id_seq    SEQUENCE     �   CREATE SEQUENCE public.detail_planifications_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.detail_planifications_id_seq;
       public          postgres    false    233            �           0    0    detail_planifications_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.detail_planifications_id_seq OWNED BY public.detail_planifications.id;
          public          postgres    false    232            �            1259    196936    planifications_courses    TABLE     �  CREATE TABLE public.planifications_courses (
    id integer NOT NULL,
    lective_year character varying(255),
    code_course character varying(255),
    name character varying(255),
    duration_time integer,
    start_date timestamp with time zone,
    finish_date timestamp with time zone,
    state character varying(255),
    career_id integer NOT NULL,
    role_id integer NOT NULL,
    user_id integer NOT NULL,
    create_at timestamp with time zone NOT NULL,
    free boolean
);
 *   DROP TABLE public.planifications_courses;
       public         heap    postgres    false            �            1259    196935    planifications_courses_id_seq    SEQUENCE     �   CREATE SEQUENCE public.planifications_courses_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.planifications_courses_id_seq;
       public          postgres    false    221            �           0    0    planifications_courses_id_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.planifications_courses_id_seq OWNED BY public.planifications_courses.id;
          public          postgres    false    220            �            1259    197023    prerequisites    TABLE     s   CREATE TABLE public.prerequisites (
    id integer NOT NULL,
    course_id integer,
    prerequisite_id integer
);
 !   DROP TABLE public.prerequisites;
       public         heap    postgres    false            �            1259    197022    prerequisites_id_seq    SEQUENCE     �   CREATE SEQUENCE public.prerequisites_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.prerequisites_id_seq;
       public          postgres    false    227            �           0    0    prerequisites_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.prerequisites_id_seq OWNED BY public.prerequisites.id;
          public          postgres    false    226            �            1259    196871    roles    TABLE     �   CREATE TABLE public.roles (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(255),
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone NOT NULL
);
    DROP TABLE public.roles;
       public         heap    postgres    false            �            1259    196870    roles_id_seq    SEQUENCE     �   CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.roles_id_seq;
       public          postgres    false    211            �           0    0    roles_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;
          public          postgres    false    210            �            1259    197102    subtopic    TABLE     e   CREATE TABLE public.subtopic (
    id bigint NOT NULL,
    topic_id integer,
    description text
);
    DROP TABLE public.subtopic;
       public         heap    postgres    false            �            1259    197101    subtopic_id_seq    SEQUENCE     x   CREATE SEQUENCE public.subtopic_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.subtopic_id_seq;
       public          postgres    false    235            �           0    0    subtopic_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.subtopic_id_seq OWNED BY public.subtopic.id;
          public          postgres    false    234            �            1259    197014    teachers    TABLE     �   CREATE TABLE public.teachers (
    id integer NOT NULL,
    name character varying(255),
    create_at timestamp with time zone NOT NULL
);
    DROP TABLE public.teachers;
       public         heap    postgres    false            �            1259    197013    teachers_id_seq    SEQUENCE     �   CREATE SEQUENCE public.teachers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.teachers_id_seq;
       public          postgres    false    225            �           0    0    teachers_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.teachers_id_seq OWNED BY public.teachers.id;
          public          postgres    false    224            �            1259    197040    topics    TABLE     w   CREATE TABLE public.topics (
    id bigint NOT NULL,
    course_id integer,
    description text,
    parent bigint
);
    DROP TABLE public.topics;
       public         heap    postgres    false            �            1259    197039    topics_id_seq    SEQUENCE     v   CREATE SEQUENCE public.topics_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.topics_id_seq;
       public          postgres    false    229            �           0    0    topics_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.topics_id_seq OWNED BY public.topics.id;
          public          postgres    false    228            �            1259    196895    users    TABLE     �  CREATE TABLE public.users (
    id integer NOT NULL,
    names character varying(255),
    lastnames character varying(255),
    phone character varying(255),
    email character varying(255),
    identity_card character varying(255),
    password character varying(255),
    recovery_token character varying(255),
    image character varying(255),
    "gender_Id" integer,
    "role_Id" integer NOT NULL,
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    196894    users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          postgres    false    215            �           0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public          postgres    false    214            �           2604    196930 
   careers id    DEFAULT     h   ALTER TABLE ONLY public.careers ALTER COLUMN id SET DEFAULT nextval('public.careers_id_seq'::regclass);
 9   ALTER TABLE public.careers ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    219    218    219            �           2604    196921    catalogues id    DEFAULT     n   ALTER TABLE ONLY public.catalogues ALTER COLUMN id SET DEFAULT nextval('public.catalogues_id_seq'::regclass);
 <   ALTER TABLE public.catalogues ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    216    217            �           2604    196891    catalogues_users id    DEFAULT     z   ALTER TABLE ONLY public.catalogues_users ALTER COLUMN id SET DEFAULT nextval('public.catalogues_users_id_seq'::regclass);
 B   ALTER TABLE public.catalogues_users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    213    213            �           2604    197057    classroom id    DEFAULT     l   ALTER TABLE ONLY public.classroom ALTER COLUMN id SET DEFAULT nextval('public.classroom_id_seq'::regclass);
 ;   ALTER TABLE public.classroom ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    230    231    231            �           2604    196963 
   courses id    DEFAULT     h   ALTER TABLE ONLY public.courses ALTER COLUMN id SET DEFAULT nextval('public.courses_id_seq'::regclass);
 9   ALTER TABLE public.courses ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    223    223            �           2604    197071    detail_planifications id    DEFAULT     �   ALTER TABLE ONLY public.detail_planifications ALTER COLUMN id SET DEFAULT nextval('public.detail_planifications_id_seq'::regclass);
 G   ALTER TABLE public.detail_planifications ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    232    233    233            �           2604    196939    planifications_courses id    DEFAULT     �   ALTER TABLE ONLY public.planifications_courses ALTER COLUMN id SET DEFAULT nextval('public.planifications_courses_id_seq'::regclass);
 H   ALTER TABLE public.planifications_courses ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    221    220    221            �           2604    197026    prerequisites id    DEFAULT     t   ALTER TABLE ONLY public.prerequisites ALTER COLUMN id SET DEFAULT nextval('public.prerequisites_id_seq'::regclass);
 ?   ALTER TABLE public.prerequisites ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    226    227    227            �           2604    196874    roles id    DEFAULT     d   ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);
 7   ALTER TABLE public.roles ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    211    211            �           2604    197105    subtopic id    DEFAULT     j   ALTER TABLE ONLY public.subtopic ALTER COLUMN id SET DEFAULT nextval('public.subtopic_id_seq'::regclass);
 :   ALTER TABLE public.subtopic ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    234    235    235            �           2604    197017    teachers id    DEFAULT     j   ALTER TABLE ONLY public.teachers ALTER COLUMN id SET DEFAULT nextval('public.teachers_id_seq'::regclass);
 :   ALTER TABLE public.teachers ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    225    225            �           2604    197043 	   topics id    DEFAULT     f   ALTER TABLE ONLY public.topics ALTER COLUMN id SET DEFAULT nextval('public.topics_id_seq'::regclass);
 8   ALTER TABLE public.topics ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    228    229    229            �           2604    196898    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215            �          0    196865    SequelizeMeta 
   TABLE DATA           /   COPY public."SequelizeMeta" (name) FROM stdin;
    public          postgres    false    209   2K      �          0    196927    careers 
   TABLE DATA           C   COPY public.careers (id, name, created_at, updated_at) FROM stdin;
    public          postgres    false    219   dK      �          0    196918 
   catalogues 
   TABLE DATA           |   COPY public.catalogues (id, created_at, updated_at, deleted_at, parent_id, code, description, icon, name, type) FROM stdin;
    public          postgres    false    217   >L      �          0    196888    catalogues_users 
   TABLE DATA           O   COPY public.catalogues_users (id, genders, created_at, updated_at) FROM stdin;
    public          postgres    false    213   4X      �          0    197054 	   classroom 
   TABLE DATA           S   COPY public.classroom (id, type_id, capacity, code, description, name) FROM stdin;
    public          postgres    false    231   �X      �          0    196960    courses 
   TABLE DATA           �  COPY public.courses (id, image_id, planification_id, modality_id, category_id, entity_certification_id, course_type_id, certified_type_id, formation_type_id, abbreviation, target_groups, participant_types, summary, project, objective, alignment, area_id, speciality_id, practice_hours, theory_hours, bibliographies, "evaluationMechanisms", learning_environments, teaching_strategies, techniques_requisites, prerequisites) FROM stdin;
    public          postgres    false    223   �X      �          0    197068    detail_planifications 
   TABLE DATA           �   COPY public.detail_planifications (id, "planification_course_Id", classroom_id, day_id, parallel_id, workday_id, ended_time, observation, started_time) FROM stdin;
    public          postgres    false    233   �Y      �          0    196936    planifications_courses 
   TABLE DATA           �   COPY public.planifications_courses (id, lective_year, code_course, name, duration_time, start_date, finish_date, state, career_id, role_id, user_id, create_at, free) FROM stdin;
    public          postgres    false    221   Z      �          0    197023    prerequisites 
   TABLE DATA           G   COPY public.prerequisites (id, course_id, prerequisite_id) FROM stdin;
    public          postgres    false    227   -[      �          0    196871    roles 
   TABLE DATA           N   COPY public.roles (id, name, description, created_at, updated_at) FROM stdin;
    public          postgres    false    211   J[      �          0    197102    subtopic 
   TABLE DATA           =   COPY public.subtopic (id, topic_id, description) FROM stdin;
    public          postgres    false    235   �\      �          0    197014    teachers 
   TABLE DATA           7   COPY public.teachers (id, name, create_at) FROM stdin;
    public          postgres    false    225   �\      �          0    197040    topics 
   TABLE DATA           D   COPY public.topics (id, course_id, description, parent) FROM stdin;
    public          postgres    false    229   �\      �          0    196895    users 
   TABLE DATA           �   COPY public.users (id, names, lastnames, phone, email, identity_card, password, recovery_token, image, "gender_Id", "role_Id", created_at, updated_at) FROM stdin;
    public          postgres    false    215   �\      �           0    0    careers_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.careers_id_seq', 6, true);
          public          postgres    false    218            �           0    0    catalogues_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.catalogues_id_seq', 111, true);
          public          postgres    false    216            �           0    0    catalogues_users_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.catalogues_users_id_seq', 2, true);
          public          postgres    false    212            �           0    0    classroom_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.classroom_id_seq', 2, true);
          public          postgres    false    230            �           0    0    courses_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.courses_id_seq', 5, true);
          public          postgres    false    222            �           0    0    detail_planifications_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.detail_planifications_id_seq', 4, true);
          public          postgres    false    232            �           0    0    planifications_courses_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.planifications_courses_id_seq', 5, true);
          public          postgres    false    220            �           0    0    prerequisites_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.prerequisites_id_seq', 1, false);
          public          postgres    false    226            �           0    0    roles_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.roles_id_seq', 7, true);
          public          postgres    false    210            �           0    0    subtopic_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.subtopic_id_seq', 1, false);
          public          postgres    false    234            �           0    0    teachers_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.teachers_id_seq', 1, false);
          public          postgres    false    224            �           0    0    topics_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.topics_id_seq', 1, false);
          public          postgres    false    228            �           0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 5, true);
          public          postgres    false    214            �           2606    196869     SequelizeMeta SequelizeMeta_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public."SequelizeMeta"
    ADD CONSTRAINT "SequelizeMeta_pkey" PRIMARY KEY (name);
 N   ALTER TABLE ONLY public."SequelizeMeta" DROP CONSTRAINT "SequelizeMeta_pkey";
       public            postgres    false    209            �           2606    204256    careers careers_name_key 
   CONSTRAINT     S   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key UNIQUE (name);
 B   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key;
       public            postgres    false    219            �           2606    204258    careers careers_name_key1 
   CONSTRAINT     T   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key1 UNIQUE (name);
 C   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key1;
       public            postgres    false    219            �           2606    204254    careers careers_name_key10 
   CONSTRAINT     U   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key10 UNIQUE (name);
 D   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key10;
       public            postgres    false    219            �           2606    204276    careers careers_name_key11 
   CONSTRAINT     U   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key11 UNIQUE (name);
 D   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key11;
       public            postgres    false    219            �           2606    204278    careers careers_name_key12 
   CONSTRAINT     U   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key12 UNIQUE (name);
 D   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key12;
       public            postgres    false    219            �           2606    204280    careers careers_name_key13 
   CONSTRAINT     U   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key13 UNIQUE (name);
 D   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key13;
       public            postgres    false    219            �           2606    204282    careers careers_name_key14 
   CONSTRAINT     U   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key14 UNIQUE (name);
 D   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key14;
       public            postgres    false    219            �           2606    204284    careers careers_name_key15 
   CONSTRAINT     U   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key15 UNIQUE (name);
 D   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key15;
       public            postgres    false    219            �           2606    204252    careers careers_name_key16 
   CONSTRAINT     U   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key16 UNIQUE (name);
 D   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key16;
       public            postgres    false    219            �           2606    204286    careers careers_name_key17 
   CONSTRAINT     U   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key17 UNIQUE (name);
 D   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key17;
       public            postgres    false    219            �           2606    204250    careers careers_name_key18 
   CONSTRAINT     U   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key18 UNIQUE (name);
 D   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key18;
       public            postgres    false    219            �           2606    204288    careers careers_name_key19 
   CONSTRAINT     U   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key19 UNIQUE (name);
 D   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key19;
       public            postgres    false    219            �           2606    204260    careers careers_name_key2 
   CONSTRAINT     T   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key2 UNIQUE (name);
 C   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key2;
       public            postgres    false    219            �           2606    204248    careers careers_name_key20 
   CONSTRAINT     U   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key20 UNIQUE (name);
 D   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key20;
       public            postgres    false    219            �           2606    204290    careers careers_name_key21 
   CONSTRAINT     U   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key21 UNIQUE (name);
 D   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key21;
       public            postgres    false    219            �           2606    204292    careers careers_name_key22 
   CONSTRAINT     U   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key22 UNIQUE (name);
 D   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key22;
       public            postgres    false    219            �           2606    204294    careers careers_name_key23 
   CONSTRAINT     U   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key23 UNIQUE (name);
 D   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key23;
       public            postgres    false    219            �           2606    204246    careers careers_name_key24 
   CONSTRAINT     U   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key24 UNIQUE (name);
 D   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key24;
       public            postgres    false    219            �           2606    204296    careers careers_name_key25 
   CONSTRAINT     U   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key25 UNIQUE (name);
 D   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key25;
       public            postgres    false    219            �           2606    204262    careers careers_name_key3 
   CONSTRAINT     T   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key3 UNIQUE (name);
 C   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key3;
       public            postgres    false    219            �           2606    204264    careers careers_name_key4 
   CONSTRAINT     T   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key4 UNIQUE (name);
 C   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key4;
       public            postgres    false    219            �           2606    204266    careers careers_name_key5 
   CONSTRAINT     T   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key5 UNIQUE (name);
 C   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key5;
       public            postgres    false    219            �           2606    204268    careers careers_name_key6 
   CONSTRAINT     T   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key6 UNIQUE (name);
 C   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key6;
       public            postgres    false    219            �           2606    204270    careers careers_name_key7 
   CONSTRAINT     T   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key7 UNIQUE (name);
 C   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key7;
       public            postgres    false    219            �           2606    204272    careers careers_name_key8 
   CONSTRAINT     T   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key8 UNIQUE (name);
 C   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key8;
       public            postgres    false    219            �           2606    204274    careers careers_name_key9 
   CONSTRAINT     T   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_name_key9 UNIQUE (name);
 C   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_name_key9;
       public            postgres    false    219            �           2606    196932    careers careers_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.careers
    ADD CONSTRAINT careers_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.careers DROP CONSTRAINT careers_pkey;
       public            postgres    false    219            �           2606    196925    catalogues catalogues_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.catalogues
    ADD CONSTRAINT catalogues_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.catalogues DROP CONSTRAINT catalogues_pkey;
       public            postgres    false    217                       2606    196893 &   catalogues_users catalogues_users_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.catalogues_users
    ADD CONSTRAINT catalogues_users_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.catalogues_users DROP CONSTRAINT catalogues_users_pkey;
       public            postgres    false    213                        2606    197061    classroom classroom_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.classroom
    ADD CONSTRAINT classroom_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.classroom DROP CONSTRAINT classroom_pkey;
       public            postgres    false    231            �           2606    196967    courses courses_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.courses DROP CONSTRAINT courses_pkey;
       public            postgres    false    223                       2606    197075 0   detail_planifications detail_planifications_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.detail_planifications
    ADD CONSTRAINT detail_planifications_pkey PRIMARY KEY (id);
 Z   ALTER TABLE ONLY public.detail_planifications DROP CONSTRAINT detail_planifications_pkey;
       public            postgres    false    233            �           2606    196943 2   planifications_courses planifications_courses_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.planifications_courses
    ADD CONSTRAINT planifications_courses_pkey PRIMARY KEY (id);
 \   ALTER TABLE ONLY public.planifications_courses DROP CONSTRAINT planifications_courses_pkey;
       public            postgres    false    221            �           2606    197028     prerequisites prerequisites_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.prerequisites
    ADD CONSTRAINT prerequisites_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.prerequisites DROP CONSTRAINT prerequisites_pkey;
       public            postgres    false    227            �           2606    204068    roles roles_name_key 
   CONSTRAINT     O   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key UNIQUE (name);
 >   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key;
       public            postgres    false    211            �           2606    204070    roles roles_name_key1 
   CONSTRAINT     P   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key1 UNIQUE (name);
 ?   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key1;
       public            postgres    false    211            �           2606    204066    roles roles_name_key10 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key10 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key10;
       public            postgres    false    211            �           2606    204088    roles roles_name_key11 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key11 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key11;
       public            postgres    false    211            �           2606    204090    roles roles_name_key12 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key12 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key12;
       public            postgres    false    211            �           2606    204092    roles roles_name_key13 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key13 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key13;
       public            postgres    false    211            �           2606    204094    roles roles_name_key14 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key14 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key14;
       public            postgres    false    211            �           2606    204096    roles roles_name_key15 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key15 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key15;
       public            postgres    false    211            �           2606    204098    roles roles_name_key16 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key16 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key16;
       public            postgres    false    211            �           2606    204100    roles roles_name_key17 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key17 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key17;
       public            postgres    false    211            �           2606    204102    roles roles_name_key18 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key18 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key18;
       public            postgres    false    211            �           2606    204064    roles roles_name_key19 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key19 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key19;
       public            postgres    false    211            �           2606    204072    roles roles_name_key2 
   CONSTRAINT     P   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key2 UNIQUE (name);
 ?   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key2;
       public            postgres    false    211            �           2606    204104    roles roles_name_key20 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key20 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key20;
       public            postgres    false    211            �           2606    204062    roles roles_name_key21 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key21 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key21;
       public            postgres    false    211            �           2606    204106    roles roles_name_key22 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key22 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key22;
       public            postgres    false    211            �           2606    204108    roles roles_name_key23 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key23 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key23;
       public            postgres    false    211            �           2606    204110    roles roles_name_key24 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key24 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key24;
       public            postgres    false    211            �           2606    204060    roles roles_name_key25 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key25 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key25;
       public            postgres    false    211                        2606    204112    roles roles_name_key26 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key26 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key26;
       public            postgres    false    211                       2606    204114    roles roles_name_key27 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key27 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key27;
       public            postgres    false    211                       2606    204058    roles roles_name_key28 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key28 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key28;
       public            postgres    false    211                       2606    204116    roles roles_name_key29 
   CONSTRAINT     Q   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key29 UNIQUE (name);
 @   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key29;
       public            postgres    false    211                       2606    204074    roles roles_name_key3 
   CONSTRAINT     P   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key3 UNIQUE (name);
 ?   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key3;
       public            postgres    false    211            
           2606    204076    roles roles_name_key4 
   CONSTRAINT     P   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key4 UNIQUE (name);
 ?   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key4;
       public            postgres    false    211                       2606    204078    roles roles_name_key5 
   CONSTRAINT     P   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key5 UNIQUE (name);
 ?   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key5;
       public            postgres    false    211                       2606    204080    roles roles_name_key6 
   CONSTRAINT     P   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key6 UNIQUE (name);
 ?   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key6;
       public            postgres    false    211                       2606    204082    roles roles_name_key7 
   CONSTRAINT     P   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key7 UNIQUE (name);
 ?   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key7;
       public            postgres    false    211                       2606    204084    roles roles_name_key8 
   CONSTRAINT     P   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key8 UNIQUE (name);
 ?   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key8;
       public            postgres    false    211                       2606    204086    roles roles_name_key9 
   CONSTRAINT     P   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_name_key9 UNIQUE (name);
 ?   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_name_key9;
       public            postgres    false    211                       2606    196878    roles roles_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    211                       2606    197109    subtopic subtopic_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.subtopic
    ADD CONSTRAINT subtopic_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.subtopic DROP CONSTRAINT subtopic_pkey;
       public            postgres    false    235            �           2606    204325    teachers teachers_name_key 
   CONSTRAINT     U   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key UNIQUE (name);
 D   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key;
       public            postgres    false    225            �           2606    204327    teachers teachers_name_key1 
   CONSTRAINT     V   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key1 UNIQUE (name);
 E   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key1;
       public            postgres    false    225            �           2606    204323    teachers teachers_name_key10 
   CONSTRAINT     W   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key10 UNIQUE (name);
 F   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key10;
       public            postgres    false    225            �           2606    204345    teachers teachers_name_key11 
   CONSTRAINT     W   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key11 UNIQUE (name);
 F   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key11;
       public            postgres    false    225            �           2606    204347    teachers teachers_name_key12 
   CONSTRAINT     W   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key12 UNIQUE (name);
 F   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key12;
       public            postgres    false    225            �           2606    204349    teachers teachers_name_key13 
   CONSTRAINT     W   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key13 UNIQUE (name);
 F   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key13;
       public            postgres    false    225            �           2606    204351    teachers teachers_name_key14 
   CONSTRAINT     W   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key14 UNIQUE (name);
 F   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key14;
       public            postgres    false    225            �           2606    204321    teachers teachers_name_key15 
   CONSTRAINT     W   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key15 UNIQUE (name);
 F   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key15;
       public            postgres    false    225            �           2606    204353    teachers teachers_name_key16 
   CONSTRAINT     W   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key16 UNIQUE (name);
 F   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key16;
       public            postgres    false    225            �           2606    204319    teachers teachers_name_key17 
   CONSTRAINT     W   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key17 UNIQUE (name);
 F   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key17;
       public            postgres    false    225            �           2606    204355    teachers teachers_name_key18 
   CONSTRAINT     W   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key18 UNIQUE (name);
 F   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key18;
       public            postgres    false    225            �           2606    204317    teachers teachers_name_key19 
   CONSTRAINT     W   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key19 UNIQUE (name);
 F   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key19;
       public            postgres    false    225            �           2606    204329    teachers teachers_name_key2 
   CONSTRAINT     V   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key2 UNIQUE (name);
 E   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key2;
       public            postgres    false    225            �           2606    204357    teachers teachers_name_key20 
   CONSTRAINT     W   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key20 UNIQUE (name);
 F   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key20;
       public            postgres    false    225            �           2606    204359    teachers teachers_name_key21 
   CONSTRAINT     W   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key21 UNIQUE (name);
 F   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key21;
       public            postgres    false    225            �           2606    204361    teachers teachers_name_key22 
   CONSTRAINT     W   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key22 UNIQUE (name);
 F   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key22;
       public            postgres    false    225            �           2606    204315    teachers teachers_name_key23 
   CONSTRAINT     W   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key23 UNIQUE (name);
 F   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key23;
       public            postgres    false    225            �           2606    204363    teachers teachers_name_key24 
   CONSTRAINT     W   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key24 UNIQUE (name);
 F   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key24;
       public            postgres    false    225            �           2606    204331    teachers teachers_name_key3 
   CONSTRAINT     V   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key3 UNIQUE (name);
 E   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key3;
       public            postgres    false    225            �           2606    204333    teachers teachers_name_key4 
   CONSTRAINT     V   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key4 UNIQUE (name);
 E   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key4;
       public            postgres    false    225            �           2606    204335    teachers teachers_name_key5 
   CONSTRAINT     V   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key5 UNIQUE (name);
 E   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key5;
       public            postgres    false    225            �           2606    204337    teachers teachers_name_key6 
   CONSTRAINT     V   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key6 UNIQUE (name);
 E   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key6;
       public            postgres    false    225            �           2606    204339    teachers teachers_name_key7 
   CONSTRAINT     V   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key7 UNIQUE (name);
 E   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key7;
       public            postgres    false    225            �           2606    204341    teachers teachers_name_key8 
   CONSTRAINT     V   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key8 UNIQUE (name);
 E   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key8;
       public            postgres    false    225            �           2606    204343    teachers teachers_name_key9 
   CONSTRAINT     V   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_name_key9 UNIQUE (name);
 E   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_name_key9;
       public            postgres    false    225            �           2606    197019    teachers teachers_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.teachers DROP CONSTRAINT teachers_pkey;
       public            postgres    false    225            �           2606    197047    topics topics_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.topics
    ADD CONSTRAINT topics_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.topics DROP CONSTRAINT topics_pkey;
       public            postgres    false    229                       2606    204130    users users_email_key 
   CONSTRAINT     Q   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);
 ?   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key;
       public            postgres    false    215                       2606    204132    users users_email_key1 
   CONSTRAINT     R   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key1 UNIQUE (email);
 @   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key1;
       public            postgres    false    215                       2606    204128    users users_email_key10 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key10 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key10;
       public            postgres    false    215                        2606    204150    users users_email_key11 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key11 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key11;
       public            postgres    false    215            "           2606    204152    users users_email_key12 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key12 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key12;
       public            postgres    false    215            $           2606    204154    users users_email_key13 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key13 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key13;
       public            postgres    false    215            &           2606    204156    users users_email_key14 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key14 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key14;
       public            postgres    false    215            (           2606    204158    users users_email_key15 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key15 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key15;
       public            postgres    false    215            *           2606    204160    users users_email_key16 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key16 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key16;
       public            postgres    false    215            ,           2606    204162    users users_email_key17 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key17 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key17;
       public            postgres    false    215            .           2606    204126    users users_email_key18 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key18 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key18;
       public            postgres    false    215            0           2606    204164    users users_email_key19 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key19 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key19;
       public            postgres    false    215            2           2606    204134    users users_email_key2 
   CONSTRAINT     R   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key2 UNIQUE (email);
 @   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key2;
       public            postgres    false    215            4           2606    204124    users users_email_key20 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key20 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key20;
       public            postgres    false    215            6           2606    204166    users users_email_key21 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key21 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key21;
       public            postgres    false    215            8           2606    204168    users users_email_key22 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key22 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key22;
       public            postgres    false    215            :           2606    204122    users users_email_key23 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key23 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key23;
       public            postgres    false    215            <           2606    204170    users users_email_key24 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key24 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key24;
       public            postgres    false    215            >           2606    204172    users users_email_key25 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key25 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key25;
       public            postgres    false    215            @           2606    204120    users users_email_key26 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key26 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key26;
       public            postgres    false    215            B           2606    204174    users users_email_key27 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key27 UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key27;
       public            postgres    false    215            D           2606    204136    users users_email_key3 
   CONSTRAINT     R   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key3 UNIQUE (email);
 @   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key3;
       public            postgres    false    215            F           2606    204138    users users_email_key4 
   CONSTRAINT     R   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key4 UNIQUE (email);
 @   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key4;
       public            postgres    false    215            H           2606    204140    users users_email_key5 
   CONSTRAINT     R   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key5 UNIQUE (email);
 @   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key5;
       public            postgres    false    215            J           2606    204142    users users_email_key6 
   CONSTRAINT     R   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key6 UNIQUE (email);
 @   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key6;
       public            postgres    false    215            L           2606    204144    users users_email_key7 
   CONSTRAINT     R   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key7 UNIQUE (email);
 @   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key7;
       public            postgres    false    215            N           2606    204146    users users_email_key8 
   CONSTRAINT     R   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key8 UNIQUE (email);
 @   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key8;
       public            postgres    false    215            P           2606    204148    users users_email_key9 
   CONSTRAINT     R   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key9 UNIQUE (email);
 @   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key9;
       public            postgres    false    215            R           2606    204198    users users_identity_card_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key UNIQUE (identity_card);
 G   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key;
       public            postgres    false    215            T           2606    204200    users users_identity_card_key1 
   CONSTRAINT     b   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key1 UNIQUE (identity_card);
 H   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key1;
       public            postgres    false    215            V           2606    204196    users users_identity_card_key10 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key10 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key10;
       public            postgres    false    215            X           2606    204218    users users_identity_card_key11 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key11 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key11;
       public            postgres    false    215            Z           2606    204220    users users_identity_card_key12 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key12 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key12;
       public            postgres    false    215            \           2606    204222    users users_identity_card_key13 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key13 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key13;
       public            postgres    false    215            ^           2606    204224    users users_identity_card_key14 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key14 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key14;
       public            postgres    false    215            `           2606    204226    users users_identity_card_key15 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key15 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key15;
       public            postgres    false    215            b           2606    204180    users users_identity_card_key16 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key16 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key16;
       public            postgres    false    215            d           2606    204182    users users_identity_card_key17 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key17 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key17;
       public            postgres    false    215            f           2606    204194    users users_identity_card_key18 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key18 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key18;
       public            postgres    false    215            h           2606    204184    users users_identity_card_key19 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key19 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key19;
       public            postgres    false    215            j           2606    204202    users users_identity_card_key2 
   CONSTRAINT     b   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key2 UNIQUE (identity_card);
 H   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key2;
       public            postgres    false    215            l           2606    204192    users users_identity_card_key20 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key20 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key20;
       public            postgres    false    215            n           2606    204186    users users_identity_card_key21 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key21 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key21;
       public            postgres    false    215            p           2606    204188    users users_identity_card_key22 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key22 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key22;
       public            postgres    false    215            r           2606    204190    users users_identity_card_key23 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key23 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key23;
       public            postgres    false    215            t           2606    204228    users users_identity_card_key24 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key24 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key24;
       public            postgres    false    215            v           2606    204230    users users_identity_card_key25 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key25 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key25;
       public            postgres    false    215            x           2606    204178    users users_identity_card_key26 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key26 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key26;
       public            postgres    false    215            z           2606    204232    users users_identity_card_key27 
   CONSTRAINT     c   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key27 UNIQUE (identity_card);
 I   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key27;
       public            postgres    false    215            |           2606    204204    users users_identity_card_key3 
   CONSTRAINT     b   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key3 UNIQUE (identity_card);
 H   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key3;
       public            postgres    false    215            ~           2606    204206    users users_identity_card_key4 
   CONSTRAINT     b   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key4 UNIQUE (identity_card);
 H   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key4;
       public            postgres    false    215            �           2606    204208    users users_identity_card_key5 
   CONSTRAINT     b   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key5 UNIQUE (identity_card);
 H   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key5;
       public            postgres    false    215            �           2606    204210    users users_identity_card_key6 
   CONSTRAINT     b   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key6 UNIQUE (identity_card);
 H   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key6;
       public            postgres    false    215            �           2606    204212    users users_identity_card_key7 
   CONSTRAINT     b   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key7 UNIQUE (identity_card);
 H   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key7;
       public            postgres    false    215            �           2606    204214    users users_identity_card_key8 
   CONSTRAINT     b   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key8 UNIQUE (identity_card);
 H   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key8;
       public            postgres    false    215            �           2606    204216    users users_identity_card_key9 
   CONSTRAINT     b   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_identity_card_key9 UNIQUE (identity_card);
 H   ALTER TABLE ONLY public.users DROP CONSTRAINT users_identity_card_key9;
       public            postgres    false    215            �           2606    196902    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    215                       2606    204429     classroom classroom_type_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.classroom
    ADD CONSTRAINT classroom_type_id_fkey FOREIGN KEY (type_id) REFERENCES public.catalogues(id) ON UPDATE CASCADE ON DELETE SET NULL;
 J   ALTER TABLE ONLY public.classroom DROP CONSTRAINT classroom_type_id_fkey;
       public          postgres    false    217    231    3468                       2606    204399    courses courses_area_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_area_id_fkey FOREIGN KEY (area_id) REFERENCES public.catalogues(id) ON UPDATE CASCADE ON DELETE SET NULL;
 F   ALTER TABLE ONLY public.courses DROP CONSTRAINT courses_area_id_fkey;
       public          postgres    false    217    223    3468                       2606    204374     courses courses_category_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_category_id_fkey FOREIGN KEY (category_id) REFERENCES public.catalogues(id) ON UPDATE CASCADE ON DELETE SET NULL;
 J   ALTER TABLE ONLY public.courses DROP CONSTRAINT courses_category_id_fkey;
       public          postgres    false    223    217    3468                       2606    204389 &   courses courses_certified_type_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_certified_type_id_fkey FOREIGN KEY (certified_type_id) REFERENCES public.catalogues(id) ON UPDATE CASCADE ON DELETE SET NULL;
 P   ALTER TABLE ONLY public.courses DROP CONSTRAINT courses_certified_type_id_fkey;
       public          postgres    false    223    217    3468                       2606    204384 #   courses courses_course_type_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_course_type_id_fkey FOREIGN KEY (course_type_id) REFERENCES public.catalogues(id) ON UPDATE CASCADE ON DELETE SET NULL;
 M   ALTER TABLE ONLY public.courses DROP CONSTRAINT courses_course_type_id_fkey;
       public          postgres    false    217    223    3468                       2606    204379 ,   courses courses_entity_certification_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_entity_certification_id_fkey FOREIGN KEY (entity_certification_id) REFERENCES public.catalogues(id) ON UPDATE CASCADE ON DELETE SET NULL;
 V   ALTER TABLE ONLY public.courses DROP CONSTRAINT courses_entity_certification_id_fkey;
       public          postgres    false    217    223    3468                       2606    204394 &   courses courses_formation_type_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_formation_type_id_fkey FOREIGN KEY (formation_type_id) REFERENCES public.catalogues(id) ON UPDATE CASCADE ON DELETE SET NULL;
 P   ALTER TABLE ONLY public.courses DROP CONSTRAINT courses_formation_type_id_fkey;
       public          postgres    false    223    217    3468                       2606    204369     courses courses_modality_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_modality_id_fkey FOREIGN KEY (modality_id) REFERENCES public.catalogues(id) ON UPDATE CASCADE ON DELETE SET NULL;
 J   ALTER TABLE ONLY public.courses DROP CONSTRAINT courses_modality_id_fkey;
       public          postgres    false    223    217    3468            
           2606    204364 %   courses courses_planification_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_planification_id_fkey FOREIGN KEY (planification_id) REFERENCES public.planifications_courses(id) ON UPDATE CASCADE ON DELETE SET NULL;
 O   ALTER TABLE ONLY public.courses DROP CONSTRAINT courses_planification_id_fkey;
       public          postgres    false    3524    221    223                       2606    204404 "   courses courses_speciality_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_speciality_id_fkey FOREIGN KEY (speciality_id) REFERENCES public.catalogues(id) ON UPDATE CASCADE ON DELETE SET NULL;
 L   ALTER TABLE ONLY public.courses DROP CONSTRAINT courses_speciality_id_fkey;
       public          postgres    false    223    3468    217                       2606    204439 =   detail_planifications detail_planifications_classroom_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.detail_planifications
    ADD CONSTRAINT detail_planifications_classroom_id_fkey FOREIGN KEY (classroom_id) REFERENCES public.classroom(id) ON UPDATE CASCADE ON DELETE SET NULL;
 g   ALTER TABLE ONLY public.detail_planifications DROP CONSTRAINT detail_planifications_classroom_id_fkey;
       public          postgres    false    231    3584    233                       2606    204444 7   detail_planifications detail_planifications_day_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.detail_planifications
    ADD CONSTRAINT detail_planifications_day_id_fkey FOREIGN KEY (day_id) REFERENCES public.catalogues(id) ON UPDATE CASCADE ON DELETE SET NULL;
 a   ALTER TABLE ONLY public.detail_planifications DROP CONSTRAINT detail_planifications_day_id_fkey;
       public          postgres    false    217    233    3468                       2606    204449 <   detail_planifications detail_planifications_parallel_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.detail_planifications
    ADD CONSTRAINT detail_planifications_parallel_id_fkey FOREIGN KEY (parallel_id) REFERENCES public.catalogues(id) ON UPDATE CASCADE ON DELETE SET NULL;
 f   ALTER TABLE ONLY public.detail_planifications DROP CONSTRAINT detail_planifications_parallel_id_fkey;
       public          postgres    false    233    3468    217                       2606    204434 H   detail_planifications detail_planifications_planification_course_Id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.detail_planifications
    ADD CONSTRAINT "detail_planifications_planification_course_Id_fkey" FOREIGN KEY ("planification_course_Id") REFERENCES public.planifications_courses(id) ON UPDATE CASCADE ON DELETE SET NULL;
 t   ALTER TABLE ONLY public.detail_planifications DROP CONSTRAINT "detail_planifications_planification_course_Id_fkey";
       public          postgres    false    233    221    3524                       2606    204454 ;   detail_planifications detail_planifications_workday_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.detail_planifications
    ADD CONSTRAINT detail_planifications_workday_id_fkey FOREIGN KEY (workday_id) REFERENCES public.catalogues(id) ON UPDATE CASCADE ON DELETE SET NULL;
 e   ALTER TABLE ONLY public.detail_planifications DROP CONSTRAINT detail_planifications_workday_id_fkey;
       public          postgres    false    3468    233    217                       2606    204297 <   planifications_courses planifications_courses_career_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.planifications_courses
    ADD CONSTRAINT planifications_courses_career_id_fkey FOREIGN KEY (career_id) REFERENCES public.careers(id) ON UPDATE CASCADE ON DELETE SET NULL;
 f   ALTER TABLE ONLY public.planifications_courses DROP CONSTRAINT planifications_courses_career_id_fkey;
       public          postgres    false    221    3522    219                       2606    204302 :   planifications_courses planifications_courses_role_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.planifications_courses
    ADD CONSTRAINT planifications_courses_role_id_fkey FOREIGN KEY (role_id) REFERENCES public.roles(id) ON UPDATE CASCADE ON DELETE SET NULL;
 d   ALTER TABLE ONLY public.planifications_courses DROP CONSTRAINT planifications_courses_role_id_fkey;
       public          postgres    false    221    211    3350            	           2606    204307 :   planifications_courses planifications_courses_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.planifications_courses
    ADD CONSTRAINT planifications_courses_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) ON UPDATE CASCADE ON DELETE SET NULL;
 d   ALTER TABLE ONLY public.planifications_courses DROP CONSTRAINT planifications_courses_user_id_fkey;
       public          postgres    false    215    3466    221                       2606    204409 *   prerequisites prerequisites_course_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.prerequisites
    ADD CONSTRAINT prerequisites_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.courses(id) ON UPDATE CASCADE ON DELETE SET NULL;
 T   ALTER TABLE ONLY public.prerequisites DROP CONSTRAINT prerequisites_course_id_fkey;
       public          postgres    false    223    227    3526                       2606    204414 0   prerequisites prerequisites_prerequisite_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.prerequisites
    ADD CONSTRAINT prerequisites_prerequisite_id_fkey FOREIGN KEY (prerequisite_id) REFERENCES public.courses(id) ON UPDATE CASCADE ON DELETE SET NULL;
 Z   ALTER TABLE ONLY public.prerequisites DROP CONSTRAINT prerequisites_prerequisite_id_fkey;
       public          postgres    false    227    223    3526                       2606    204459    subtopic subtopic_topic_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.subtopic
    ADD CONSTRAINT subtopic_topic_id_fkey FOREIGN KEY (topic_id) REFERENCES public.topics(id) ON UPDATE CASCADE ON DELETE CASCADE;
 I   ALTER TABLE ONLY public.subtopic DROP CONSTRAINT subtopic_topic_id_fkey;
       public          postgres    false    235    229    3582                       2606    204419    topics topics_course_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.topics
    ADD CONSTRAINT topics_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.courses(id) ON UPDATE CASCADE ON DELETE SET NULL;
 F   ALTER TABLE ONLY public.topics DROP CONSTRAINT topics_course_id_fkey;
       public          postgres    false    229    3526    223                       2606    204424    topics topics_parent_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.topics
    ADD CONSTRAINT topics_parent_fkey FOREIGN KEY (parent) REFERENCES public.topics(id) ON UPDATE CASCADE ON DELETE SET NULL;
 C   ALTER TABLE ONLY public.topics DROP CONSTRAINT topics_parent_fkey;
       public          postgres    false    229    3582    229                       2606    204233    users users_gender_Id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.users
    ADD CONSTRAINT "users_gender_Id_fkey" FOREIGN KEY ("gender_Id") REFERENCES public.catalogues_users(id) ON UPDATE CASCADE ON DELETE SET NULL;
 F   ALTER TABLE ONLY public.users DROP CONSTRAINT "users_gender_Id_fkey";
       public          postgres    false    215    3352    213                       2606    204238    users users_role_Id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.users
    ADD CONSTRAINT "users_role_Id_fkey" FOREIGN KEY ("role_Id") REFERENCES public.roles(id) ON UPDATE CASCADE ON DELETE SET NULL;
 D   ALTER TABLE ONLY public.users DROP CONSTRAINT "users_role_Id_fkey";
       public          postgres    false    215    211    3350            �   "   x�3202605�022R��y�%zY�\1z\\\ \R`      �   �   x�}�M� F��)�@
J����nH��X!�\x�^̟����y��7�L�!�q�t04�S��`g\�����Jl*d�{��'.&Yw^�T[��,نd���h�֯ZQ���-j��.��~�Z�7XWC�Սjs�$��f~~w����*lT����$�i~h�to���C�l��7�\*��ޅ±�d�qa      �   �  x���˒�H���S��p;\U��.)U���	�]��v3!AB퇘�<E-���jz��s�@�.ew��%�L�#/��dr68v~��?��0���x��ų�//^�9���w���X�|���1K�h5��o<��	~�?�q�EUQa
�L������ l�6՟��t�n�d�dq��,��aq�s�S��)���  ��H*Hu��q��ET�E�w��"yN@��@\񁹊�Yn�2#͖e���i8�gVIV��ez��|N�L�
v����Th��X���(Na��ҡ�Yn$��Y27�$���ExPfn�� y�U�h���|$��e�/[��$��)�}�:h��E����� ?ɒe���T�b_� ����N�ě:m�� �C����kJ�͒�$��8�tݟeR�@FȆE�r����n�A�!���H	.�E�	��)�p%a�3�;z֧5<{F2F�t���|Zaϴ���$t��v��.��AR�;O}k�>-�p�e��K�E�}X3d*�i�B��b��[��N��B��5J!��� ��0�wG�C_����+��Fo�t�۬��a
�c�_���U�L���k\6�߮.Lq6<�P�Q��DIW:����j���;d�k�	�t�/ ^����+�H��z
k)��@HwxF!Tlm�E�|����sM><�ѥ��8�:����)�˄�}�	���OE�l�̗.��nY�xU,��R���,�����M(������]zm��i��D��=����?�Nl�_����!�O���&���o�N!�g�%�zj���{�(��!ְ��C��4z��i��^�;�Cr���E�L��F�g�x���@��[r
����_�'��z�b9�7�1�E��O�/Ѧ���;�)�����E��m�e��"jHp.�S�h
�}/կ������|�z�1���pA����bu�}r�v�.݂�\CA$д4x�7%8�	���A�:܂_n�����2�uŰr��6�ˇ��<Oɫ�=�u[�7�Ià��k�MF!��A3tA�Y��xA�5
�q�PcQ�s;ݲ��	�4.u�deI�$nZui1����B���
�ӈ�Ң\U8M�-�k������Us��x,7��@�(a
�����B��pdC�`J�y}�H'�t�(No#d�^[e��-p���_7s(�=������SH8D�W�����.�u�	����B�a����L���XeÚ�I鴩?�����pkaI�CNa/�l��B#���Z�Ҫ��䏞��! �Mڧ�KaE��}�i��[�v��¶4�)�.��&u?d�\O���X��Hax&�z4֩�vx(,������8(���s�vf�����{u��9��	�tħ��r�h�hϓʨ��CFavNd�x�n�`���qepj/ez>m�\i��0*Wږ�0S�zNs�u�����z��b�_�CT�&<�N�=���.\���Cm�c� �� 	��� @��O��Z}�j���������L1���[��݉'Fm��'�#L%����׎-^.ú�i��_LiW�f�E}%\+����|b� �~C�J���M���/��	�T����u	�:r$lQ}�q�]���G�y`>������v'�:��⻭��K��F�Rw��m a�H�2t�����V��(��/]|\n��0��Tb��.b����&��J�<1`DFn�]���?���U��@C��W1!t�g3�1�zK�)�;��CU��0W�W,�1���(�0��ӾێA���N7�>�����y>ڌ�næt6���v)�w��{��H`��w�����M:O�Z�/N� �W�P܁I��S�*K��:K�]V�܇qIrZ!�i�,yÈ�O���������4�|�RJ�ޣi@(��t�W��{o�ȈVxa�v;�=��4Ϫ0V�^���0��
g_��Na�na�b�oy��<þ\��	,����#���K�Y�[�Uy@Kb	w�T셌b�,��>_m�����4��f[��a��A��q�����a87T��ZE=���|I�\	�e�J�(6 �:[��D�*��<�T���"�2b�&���ۻ:��﶐���0Cb?��<	�,�:���c-
����My��n�U��M�-�����
4K*��)�y1�e6���8��Uef��xH[7��J�w�T|k-��}>���@!6�{'�k� ����N��O׶	�T�N�����^R��3� ~oO�B���v��H�3B=�����3�����La9~�8S���g�Iv[~�8Sؘ3�e����FL/�":�o�Ez�=���+��7�pj���6N��K��飡�������pר����0��y��J�%"9�t*�a
�7C�AS�GsB{G�yN<3�6/�c���Ǎ�y2�7)|O.�L�V����5�v;Rl�aA�m�B�]i�>&��ݦĶ]mxu��)�����4�<����D!��>��e4����0�AxC���B0w(��z���@!��Q|�B����y��X�/�m:��C���Jo�� ��a�.�f\	�0E�+��*�H~�~+�%A+'�B"9�Y�G��uǐ��B���34b5Ə�`�޶+fq<�:��doh��z"�ּb��z#���P����'<���1@i�����9<���B��$��>�#u���X�u�":Σ؉T�ϲ��6Z��C>
������4l��0u2�U�Od�˕�aT�o*�]=�Ξ�d���\u6��A:QY��j^���t)��ڦ��PzLo�"{'f��s��[�{9)����ȶ�(N3�����{)��}��-~�F�T$w��=|}J������wԦI0�܈���Q'C�5V��Б�>���`�c":Y�t�0K��-�y��z!��`��5�C���i��խ@m��i�V�H�WL뽥�U獱3�WJG���=S����z�`��8��~:�����      �   K   x�3��M,N.�����4202�50�52U04�26�26�352723���2�LK�M��i�����Nc`�\1z\\\ �y      �   4   x�3�4�44�,JIO�L�E�E��@�Z��e�i�E�r����O����� �s�      �   �   x��P��@<�~_`��U�c�\V�!d1~�t���I�6��M��p{p*?'�RC� RAr���9d��CU֖@-�<��q6"Yn�,>'ou:&� ڃ��
ù��n6��F�"V������R@�gG�ͮ���<Ӷ�v}���{��f�G3
_�p��Ō1��|i�      �   v   x�U�1�0�W���k��7hi��1R,��� +��j5;Z�J�������1-1��ʤ��:�=Y��}����mOk������_�A���W���
�6�~���}��J�^"r �+W      �     x���MN�0FדS��<�'��U@ �Ԋ
ԍK�
)(.���.���`�,yl�=&Єl����[����Sw��[W5�@��LɌ$UʾW\~�5��� h��w����23����:APE���0w�������C��Д�Gm6~{pృ�H���9@u�ח.ݶ��óo�7&���[b[1���g@B:L>��&#W��x����1N"�4�Wc�^<�vm�����c$�eɘx@��$I� w���      �      x������ � �      �   6  x��RAN1<g_�Ъ���!n q�T�^SYJ�b'���d�Z��(����L��-Gw�>[e�+��\=��ɬ�ԭ��˦]6�i��-�ZU�PD;��DWJ��9@�7F�<f5�ޜ���N3�/F^8%�I4^Z�(r��"x�o�[@��iZ�ђf��Ӟ0'r����N
����C�OP���ɡ_�=�G	R����Ed(� 棤r�Ln(��EiSf��
��;�=���u��*%�Ð�˷�3�'J�4�B7��kd)w1�yة�O��H}7�F���W�"�=AR�����|$�봪�/����      �      x������ � �      �      x������ � �      �      x������ � �      �   2  x�u��Z�@���S�pkALY��NA����T�"S��o0�mG�n��Y�N]����"KϮ3��9;{�ܐ�4]�*���r��˖�"g.�^�tl�B�9ޞ#�\���	J�Y�*���5b�І�r�P������osdG��9I�/� ,�}1�e�R$t�D��L��xv���!����Ϫ���} P7X��BQ/�z�����@U��;�>�{$��i��.^	q�<@z�t�#۸�����W���,pfM0D�<i��jc�ǱA}d��-�nU���ٺ�q��Pc�t��w�/�DA�1E��
�`��;ԣ���?0��>��]�.'�õ����~����G�HCC1��8ĦsK�̢��d�~0c@O��֡��?@�$�x��R��`E��ᣜ]���W�#�w޿�vw�������t3��gv�̦�\WT^����V��?����}؎�ϖO�Ue�ص����%`�R�������GⲓO[�㟖5�|��/-}
	7���7�.]'�˶����ζ�u}X:aM��%Gq��2���*�D7~\�OKz��$�a_<     