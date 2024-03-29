PGDMP          6                {            cecy_modulos    15.3    15.3 b    p           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            q           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            r           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            s           1262    23651    cecy_modulos    DATABASE     x   CREATE DATABASE cecy_modulos WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'es_EC.UTF-8';
    DROP DATABASE cecy_modulos;
                postgres    false            �            1259    23653 
   asistencia    TABLE     �   CREATE TABLE public.asistencia (
    id bigint NOT NULL,
    curso_id integer,
    duracion_clase character varying(255),
    evidencia_fotografica character varying(255),
    fecha date,
    periodo character varying(255),
    matriculas_id bigint
);
    DROP TABLE public.asistencia;
       public         heap    postgres    false            �            1259    23652    asistencia_id_seq    SEQUENCE     z   CREATE SEQUENCE public.asistencia_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.asistencia_id_seq;
       public          postgres    false    215            t           0    0    asistencia_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.asistencia_id_seq OWNED BY public.asistencia.id;
          public          postgres    false    214            �            1259    23662 	   catalogos    TABLE     �   CREATE TABLE public.catalogos (
    id bigint NOT NULL,
    descripcion character varying(255),
    nombre character varying(255)
);
    DROP TABLE public.catalogos;
       public         heap    postgres    false            �            1259    23661    catalogos_id_seq    SEQUENCE     y   CREATE SEQUENCE public.catalogos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.catalogos_id_seq;
       public          postgres    false    217            u           0    0    catalogos_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.catalogos_id_seq OWNED BY public.catalogos.id;
          public          postgres    false    216            �            1259    23671    certificados    TABLE     �   CREATE TABLE public.certificados (
    id bigint NOT NULL,
    course_id bigint,
    estado character varying(255),
    fecha date,
    tuition_id bigint,
    user_id bigint
);
     DROP TABLE public.certificados;
       public         heap    postgres    false            �            1259    23678    certificados_generados    TABLE     �   CREATE TABLE public.certificados_generados (
    id bigint NOT NULL,
    name character varying(255),
    certificado_id bigint,
    code_id bigint
);
 *   DROP TABLE public.certificados_generados;
       public         heap    postgres    false            �            1259    23677    certificados_generados_id_seq    SEQUENCE     �   CREATE SEQUENCE public.certificados_generados_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.certificados_generados_id_seq;
       public          postgres    false    221            v           0    0    certificados_generados_id_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.certificados_generados_id_seq OWNED BY public.certificados_generados.id;
          public          postgres    false    220            �            1259    23670    certificados_id_seq    SEQUENCE     |   CREATE SEQUENCE public.certificados_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.certificados_id_seq;
       public          postgres    false    219            w           0    0    certificados_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.certificados_id_seq OWNED BY public.certificados.id;
          public          postgres    false    218            �            1259    23685    codigos    TABLE     x   CREATE TABLE public.codigos (
    id bigint NOT NULL,
    codigo character varying(255),
    estado boolean NOT NULL
);
    DROP TABLE public.codigos;
       public         heap    postgres    false            �            1259    23684    codigos_id_seq    SEQUENCE     w   CREATE SEQUENCE public.codigos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.codigos_id_seq;
       public          postgres    false    223            x           0    0    codigos_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.codigos_id_seq OWNED BY public.codigos.id;
          public          postgres    false    222            �            1259    23692    detalle_asistencia    TABLE     s   CREATE TABLE public.detalle_asistencia (
    id bigint NOT NULL,
    estado_id bigint,
    asistencia_id bigint
);
 &   DROP TABLE public.detalle_asistencia;
       public         heap    postgres    false            �            1259    23691    detalle_asistencia_id_seq    SEQUENCE     �   CREATE SEQUENCE public.detalle_asistencia_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.detalle_asistencia_id_seq;
       public          postgres    false    225            y           0    0    detalle_asistencia_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.detalle_asistencia_id_seq OWNED BY public.detalle_asistencia.id;
          public          postgres    false    224            �            1259    23699    empresas    TABLE     @  CREATE TABLE public.empresas (
    id bigint NOT NULL,
    actividad character varying(255),
    direccion character varying(255),
    email character varying(255),
    nombre character varying(255),
    numero_celular character varying(255),
    numero_convencional character varying(255),
    estudiantes_id bigint
);
    DROP TABLE public.empresas;
       public         heap    postgres    false            �            1259    23698    empresas_id_seq    SEQUENCE     x   CREATE SEQUENCE public.empresas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.empresas_id_seq;
       public          postgres    false    227            z           0    0    empresas_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.empresas_id_seq OWNED BY public.empresas.id;
          public          postgres    false    226            �            1259    23708    estudiantes    TABLE     >  CREATE TABLE public.estudiantes (
    id bigint NOT NULL,
    apellidos character varying(255),
    detalles_discapacidad character varying(255),
    direccion character varying(255),
    discapacidad boolean,
    dni character varying(255),
    email character varying(255),
    fecha_nacimiento date,
    nombres character varying(255),
    numero_celular character varying(255),
    numero_convencional character varying(255),
    etnia_id bigint,
    genero_id bigint,
    nivel_instruccion_id bigint,
    situacion_economica_id bigint,
    tipo_estudiante_id bigint
);
    DROP TABLE public.estudiantes;
       public         heap    postgres    false            �            1259    23707    estudiantes_id_seq    SEQUENCE     {   CREATE SEQUENCE public.estudiantes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.estudiantes_id_seq;
       public          postgres    false    229            {           0    0    estudiantes_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.estudiantes_id_seq OWNED BY public.estudiantes.id;
          public          postgres    false    228            �            1259    23717 
   matriculas    TABLE       CREATE TABLE public.matriculas (
    id bigint NOT NULL,
    curso_id bigint,
    nota1 real,
    nota2 real,
    porcentaje_asistencia real,
    promedio real,
    estado_curso_id bigint,
    estado_matricula_id bigint,
    estudiantes_id bigint,
    detalle_asistencia_id bigint
);
    DROP TABLE public.matriculas;
       public         heap    postgres    false            �            1259    23716    matriculas_id_seq    SEQUENCE     z   CREATE SEQUENCE public.matriculas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.matriculas_id_seq;
       public          postgres    false    231            |           0    0    matriculas_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.matriculas_id_seq OWNED BY public.matriculas.id;
          public          postgres    false    230            �            1259    23724    observaciones    TABLE     �   CREATE TABLE public.observaciones (
    id bigint NOT NULL,
    completado boolean NOT NULL,
    created_at date,
    descripcion character varying(255),
    updated_at date,
    matriculas_id bigint
);
 !   DROP TABLE public.observaciones;
       public         heap    postgres    false            �            1259    23723    observaciones_id_seq    SEQUENCE     }   CREATE SEQUENCE public.observaciones_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.observaciones_id_seq;
       public          postgres    false    233            }           0    0    observaciones_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.observaciones_id_seq OWNED BY public.observaciones.id;
          public          postgres    false    232            �            1259    23731    prerequisitos    TABLE     �   CREATE TABLE public.prerequisitos (
    id bigint NOT NULL,
    nombre character varying(255),
    url_archivo character varying(255),
    estudiantes_id bigint
);
 !   DROP TABLE public.prerequisitos;
       public         heap    postgres    false            �            1259    23730    prerequisitos_id_seq    SEQUENCE     }   CREATE SEQUENCE public.prerequisitos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.prerequisitos_id_seq;
       public          postgres    false    235            ~           0    0    prerequisitos_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.prerequisitos_id_seq OWNED BY public.prerequisitos.id;
          public          postgres    false    234            �           2604    23656    asistencia id    DEFAULT     n   ALTER TABLE ONLY public.asistencia ALTER COLUMN id SET DEFAULT nextval('public.asistencia_id_seq'::regclass);
 <   ALTER TABLE public.asistencia ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    214    215            �           2604    23665    catalogos id    DEFAULT     l   ALTER TABLE ONLY public.catalogos ALTER COLUMN id SET DEFAULT nextval('public.catalogos_id_seq'::regclass);
 ;   ALTER TABLE public.catalogos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    216    217            �           2604    23674    certificados id    DEFAULT     r   ALTER TABLE ONLY public.certificados ALTER COLUMN id SET DEFAULT nextval('public.certificados_id_seq'::regclass);
 >   ALTER TABLE public.certificados ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    219    218    219            �           2604    23681    certificados_generados id    DEFAULT     �   ALTER TABLE ONLY public.certificados_generados ALTER COLUMN id SET DEFAULT nextval('public.certificados_generados_id_seq'::regclass);
 H   ALTER TABLE public.certificados_generados ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    221    221            �           2604    23688 
   codigos id    DEFAULT     h   ALTER TABLE ONLY public.codigos ALTER COLUMN id SET DEFAULT nextval('public.codigos_id_seq'::regclass);
 9   ALTER TABLE public.codigos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    223    222    223            �           2604    23695    detalle_asistencia id    DEFAULT     ~   ALTER TABLE ONLY public.detalle_asistencia ALTER COLUMN id SET DEFAULT nextval('public.detalle_asistencia_id_seq'::regclass);
 D   ALTER TABLE public.detalle_asistencia ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    225    225            �           2604    23702    empresas id    DEFAULT     j   ALTER TABLE ONLY public.empresas ALTER COLUMN id SET DEFAULT nextval('public.empresas_id_seq'::regclass);
 :   ALTER TABLE public.empresas ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    226    227    227            �           2604    23711    estudiantes id    DEFAULT     p   ALTER TABLE ONLY public.estudiantes ALTER COLUMN id SET DEFAULT nextval('public.estudiantes_id_seq'::regclass);
 =   ALTER TABLE public.estudiantes ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    229    228    229            �           2604    23720    matriculas id    DEFAULT     n   ALTER TABLE ONLY public.matriculas ALTER COLUMN id SET DEFAULT nextval('public.matriculas_id_seq'::regclass);
 <   ALTER TABLE public.matriculas ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    230    231    231            �           2604    23727    observaciones id    DEFAULT     t   ALTER TABLE ONLY public.observaciones ALTER COLUMN id SET DEFAULT nextval('public.observaciones_id_seq'::regclass);
 ?   ALTER TABLE public.observaciones ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    233    232    233            �           2604    23734    prerequisitos id    DEFAULT     t   ALTER TABLE ONLY public.prerequisitos ALTER COLUMN id SET DEFAULT nextval('public.prerequisitos_id_seq'::regclass);
 ?   ALTER TABLE public.prerequisitos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    235    234    235            Y          0    23653 
   asistencia 
   TABLE DATA           x   COPY public.asistencia (id, curso_id, duracion_clase, evidencia_fotografica, fecha, periodo, matriculas_id) FROM stdin;
    public          postgres    false    215   4y       [          0    23662 	   catalogos 
   TABLE DATA           <   COPY public.catalogos (id, descripcion, nombre) FROM stdin;
    public          postgres    false    217   Qy       ]          0    23671    certificados 
   TABLE DATA           Y   COPY public.certificados (id, course_id, estado, fecha, tuition_id, user_id) FROM stdin;
    public          postgres    false    219   �z       _          0    23678    certificados_generados 
   TABLE DATA           S   COPY public.certificados_generados (id, name, certificado_id, code_id) FROM stdin;
    public          postgres    false    221   �z       a          0    23685    codigos 
   TABLE DATA           5   COPY public.codigos (id, codigo, estado) FROM stdin;
    public          postgres    false    223   �z       c          0    23692    detalle_asistencia 
   TABLE DATA           J   COPY public.detalle_asistencia (id, estado_id, asistencia_id) FROM stdin;
    public          postgres    false    225   �z       e          0    23699    empresas 
   TABLE DATA           �   COPY public.empresas (id, actividad, direccion, email, nombre, numero_celular, numero_convencional, estudiantes_id) FROM stdin;
    public          postgres    false    227   {       g          0    23708    estudiantes 
   TABLE DATA             COPY public.estudiantes (id, apellidos, detalles_discapacidad, direccion, discapacidad, dni, email, fecha_nacimiento, nombres, numero_celular, numero_convencional, etnia_id, genero_id, nivel_instruccion_id, situacion_economica_id, tipo_estudiante_id) FROM stdin;
    public          postgres    false    229   !{       i          0    23717 
   matriculas 
   TABLE DATA           �   COPY public.matriculas (id, curso_id, nota1, nota2, porcentaje_asistencia, promedio, estado_curso_id, estado_matricula_id, estudiantes_id, detalle_asistencia_id) FROM stdin;
    public          postgres    false    231   �|       k          0    23724    observaciones 
   TABLE DATA           k   COPY public.observaciones (id, completado, created_at, descripcion, updated_at, matriculas_id) FROM stdin;
    public          postgres    false    233   �|       m          0    23731    prerequisitos 
   TABLE DATA           P   COPY public.prerequisitos (id, nombre, url_archivo, estudiantes_id) FROM stdin;
    public          postgres    false    235   �|                  0    0    asistencia_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.asistencia_id_seq', 1, false);
          public          postgres    false    214            �           0    0    catalogos_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.catalogos_id_seq', 33, true);
          public          postgres    false    216            �           0    0    certificados_generados_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.certificados_generados_id_seq', 1, false);
          public          postgres    false    220            �           0    0    certificados_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.certificados_id_seq', 1, false);
          public          postgres    false    218            �           0    0    codigos_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.codigos_id_seq', 1, false);
          public          postgres    false    222            �           0    0    detalle_asistencia_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.detalle_asistencia_id_seq', 1, false);
          public          postgres    false    224            �           0    0    empresas_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.empresas_id_seq', 1, false);
          public          postgres    false    226            �           0    0    estudiantes_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.estudiantes_id_seq', 9, true);
          public          postgres    false    228            �           0    0    matriculas_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.matriculas_id_seq', 17, true);
          public          postgres    false    230            �           0    0    observaciones_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.observaciones_id_seq', 1, false);
          public          postgres    false    232            �           0    0    prerequisitos_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.prerequisitos_id_seq', 1, false);
          public          postgres    false    234            �           2606    23660    asistencia asistencia_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.asistencia
    ADD CONSTRAINT asistencia_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.asistencia DROP CONSTRAINT asistencia_pkey;
       public            postgres    false    215            �           2606    23669    catalogos catalogos_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.catalogos
    ADD CONSTRAINT catalogos_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.catalogos DROP CONSTRAINT catalogos_pkey;
       public            postgres    false    217            �           2606    23683 2   certificados_generados certificados_generados_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.certificados_generados
    ADD CONSTRAINT certificados_generados_pkey PRIMARY KEY (id);
 \   ALTER TABLE ONLY public.certificados_generados DROP CONSTRAINT certificados_generados_pkey;
       public            postgres    false    221            �           2606    23676    certificados certificados_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.certificados
    ADD CONSTRAINT certificados_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.certificados DROP CONSTRAINT certificados_pkey;
       public            postgres    false    219            �           2606    23690    codigos codigos_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.codigos
    ADD CONSTRAINT codigos_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.codigos DROP CONSTRAINT codigos_pkey;
       public            postgres    false    223            �           2606    23697 *   detalle_asistencia detalle_asistencia_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.detalle_asistencia
    ADD CONSTRAINT detalle_asistencia_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.detalle_asistencia DROP CONSTRAINT detalle_asistencia_pkey;
       public            postgres    false    225            �           2606    23706    empresas empresas_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.empresas
    ADD CONSTRAINT empresas_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.empresas DROP CONSTRAINT empresas_pkey;
       public            postgres    false    227            �           2606    23715    estudiantes estudiantes_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.estudiantes
    ADD CONSTRAINT estudiantes_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.estudiantes DROP CONSTRAINT estudiantes_pkey;
       public            postgres    false    229            �           2606    23722    matriculas matriculas_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.matriculas
    ADD CONSTRAINT matriculas_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.matriculas DROP CONSTRAINT matriculas_pkey;
       public            postgres    false    231            �           2606    23729     observaciones observaciones_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.observaciones
    ADD CONSTRAINT observaciones_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.observaciones DROP CONSTRAINT observaciones_pkey;
       public            postgres    false    233            �           2606    23738     prerequisitos prerequisitos_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.prerequisitos
    ADD CONSTRAINT prerequisitos_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.prerequisitos DROP CONSTRAINT prerequisitos_pkey;
       public            postgres    false    235            �           2606    23784 '   estudiantes fk6538qkq7bcr86vprvdxbqjg1m    FK CONSTRAINT     �   ALTER TABLE ONLY public.estudiantes
    ADD CONSTRAINT fk6538qkq7bcr86vprvdxbqjg1m FOREIGN KEY (situacion_economica_id) REFERENCES public.catalogos(id);
 Q   ALTER TABLE ONLY public.estudiantes DROP CONSTRAINT fk6538qkq7bcr86vprvdxbqjg1m;
       public          postgres    false    229    4262    217            �           2606    23804 &   matriculas fk662xv1oxgif0n4tk39jmexr11    FK CONSTRAINT     �   ALTER TABLE ONLY public.matriculas
    ADD CONSTRAINT fk662xv1oxgif0n4tk39jmexr11 FOREIGN KEY (estudiantes_id) REFERENCES public.estudiantes(id);
 P   ALTER TABLE ONLY public.matriculas DROP CONSTRAINT fk662xv1oxgif0n4tk39jmexr11;
       public          postgres    false    4274    231    229            �           2606    23759 .   detalle_asistencia fk6htbuwyclwgduwxcpeq6giuht    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_asistencia
    ADD CONSTRAINT fk6htbuwyclwgduwxcpeq6giuht FOREIGN KEY (asistencia_id) REFERENCES public.asistencia(id);
 X   ALTER TABLE ONLY public.detalle_asistencia DROP CONSTRAINT fk6htbuwyclwgduwxcpeq6giuht;
       public          postgres    false    225    4260    215            �           2606    23769 '   estudiantes fk6k387vuxm1xm4q2uoyevnjxvn    FK CONSTRAINT     �   ALTER TABLE ONLY public.estudiantes
    ADD CONSTRAINT fk6k387vuxm1xm4q2uoyevnjxvn FOREIGN KEY (etnia_id) REFERENCES public.catalogos(id);
 Q   ALTER TABLE ONLY public.estudiantes DROP CONSTRAINT fk6k387vuxm1xm4q2uoyevnjxvn;
       public          postgres    false    217    4262    229            �           2606    23819 )   prerequisitos fkago1xwlikpgrrqjpr1b60phvf    FK CONSTRAINT     �   ALTER TABLE ONLY public.prerequisitos
    ADD CONSTRAINT fkago1xwlikpgrrqjpr1b60phvf FOREIGN KEY (estudiantes_id) REFERENCES public.estudiantes(id);
 S   ALTER TABLE ONLY public.prerequisitos DROP CONSTRAINT fkago1xwlikpgrrqjpr1b60phvf;
       public          postgres    false    4274    229    235            �           2606    23794 &   matriculas fkaq27p6b496by78awa53g1p0u1    FK CONSTRAINT     �   ALTER TABLE ONLY public.matriculas
    ADD CONSTRAINT fkaq27p6b496by78awa53g1p0u1 FOREIGN KEY (estado_curso_id) REFERENCES public.catalogos(id);
 P   ALTER TABLE ONLY public.matriculas DROP CONSTRAINT fkaq27p6b496by78awa53g1p0u1;
       public          postgres    false    217    231    4262            �           2606    23774 '   estudiantes fkbhi1rw1qwqpb806op2elaimmr    FK CONSTRAINT     �   ALTER TABLE ONLY public.estudiantes
    ADD CONSTRAINT fkbhi1rw1qwqpb806op2elaimmr FOREIGN KEY (genero_id) REFERENCES public.catalogos(id);
 Q   ALTER TABLE ONLY public.estudiantes DROP CONSTRAINT fkbhi1rw1qwqpb806op2elaimmr;
       public          postgres    false    229    4262    217            �           2606    23764 $   empresas fkbl53la6tnm41nr5t1ss149a8x    FK CONSTRAINT     �   ALTER TABLE ONLY public.empresas
    ADD CONSTRAINT fkbl53la6tnm41nr5t1ss149a8x FOREIGN KEY (estudiantes_id) REFERENCES public.estudiantes(id);
 N   ALTER TABLE ONLY public.empresas DROP CONSTRAINT fkbl53la6tnm41nr5t1ss149a8x;
       public          postgres    false    227    229    4274            �           2606    23749 2   certificados_generados fkfq3y2e3c1b6ti3e7qifn5hoet    FK CONSTRAINT     �   ALTER TABLE ONLY public.certificados_generados
    ADD CONSTRAINT fkfq3y2e3c1b6ti3e7qifn5hoet FOREIGN KEY (code_id) REFERENCES public.codigos(id);
 \   ALTER TABLE ONLY public.certificados_generados DROP CONSTRAINT fkfq3y2e3c1b6ti3e7qifn5hoet;
       public          postgres    false    4268    223    221            �           2606    23754 .   detalle_asistencia fkgq36e88o5xb4bf34fynh3lqoi    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_asistencia
    ADD CONSTRAINT fkgq36e88o5xb4bf34fynh3lqoi FOREIGN KEY (estado_id) REFERENCES public.catalogos(id);
 X   ALTER TABLE ONLY public.detalle_asistencia DROP CONSTRAINT fkgq36e88o5xb4bf34fynh3lqoi;
       public          postgres    false    225    4262    217            �           2606    23744 2   certificados_generados fkk3fhf2io9w9ple08i98cktmcy    FK CONSTRAINT     �   ALTER TABLE ONLY public.certificados_generados
    ADD CONSTRAINT fkk3fhf2io9w9ple08i98cktmcy FOREIGN KEY (certificado_id) REFERENCES public.certificados(id);
 \   ALTER TABLE ONLY public.certificados_generados DROP CONSTRAINT fkk3fhf2io9w9ple08i98cktmcy;
       public          postgres    false    221    4264    219            �           2606    23809 &   matriculas fklepplo7cnefdkn549oy096k0t    FK CONSTRAINT     �   ALTER TABLE ONLY public.matriculas
    ADD CONSTRAINT fklepplo7cnefdkn549oy096k0t FOREIGN KEY (detalle_asistencia_id) REFERENCES public.detalle_asistencia(id);
 P   ALTER TABLE ONLY public.matriculas DROP CONSTRAINT fklepplo7cnefdkn549oy096k0t;
       public          postgres    false    231    225    4270            �           2606    23779 '   estudiantes fkn2kri8nsr58avxt4atufan4n6    FK CONSTRAINT     �   ALTER TABLE ONLY public.estudiantes
    ADD CONSTRAINT fkn2kri8nsr58avxt4atufan4n6 FOREIGN KEY (nivel_instruccion_id) REFERENCES public.catalogos(id);
 Q   ALTER TABLE ONLY public.estudiantes DROP CONSTRAINT fkn2kri8nsr58avxt4atufan4n6;
       public          postgres    false    229    4262    217            �           2606    23739 &   asistencia fkpb6gos896bnrjmci9kd3s6x94    FK CONSTRAINT     �   ALTER TABLE ONLY public.asistencia
    ADD CONSTRAINT fkpb6gos896bnrjmci9kd3s6x94 FOREIGN KEY (matriculas_id) REFERENCES public.matriculas(id);
 P   ALTER TABLE ONLY public.asistencia DROP CONSTRAINT fkpb6gos896bnrjmci9kd3s6x94;
       public          postgres    false    4276    231    215            �           2606    23814 )   observaciones fkqhgre9sr9rbgcvk7cm7rm0sea    FK CONSTRAINT     �   ALTER TABLE ONLY public.observaciones
    ADD CONSTRAINT fkqhgre9sr9rbgcvk7cm7rm0sea FOREIGN KEY (matriculas_id) REFERENCES public.matriculas(id);
 S   ALTER TABLE ONLY public.observaciones DROP CONSTRAINT fkqhgre9sr9rbgcvk7cm7rm0sea;
       public          postgres    false    231    233    4276            �           2606    23799 &   matriculas fkr3j72sbq3p56rgdusgmy8q370    FK CONSTRAINT     �   ALTER TABLE ONLY public.matriculas
    ADD CONSTRAINT fkr3j72sbq3p56rgdusgmy8q370 FOREIGN KEY (estado_matricula_id) REFERENCES public.catalogos(id);
 P   ALTER TABLE ONLY public.matriculas DROP CONSTRAINT fkr3j72sbq3p56rgdusgmy8q370;
       public          postgres    false    231    217    4262            �           2606    23789 '   estudiantes fkrrcp2dl35lt21xspn65psby5y    FK CONSTRAINT     �   ALTER TABLE ONLY public.estudiantes
    ADD CONSTRAINT fkrrcp2dl35lt21xspn65psby5y FOREIGN KEY (tipo_estudiante_id) REFERENCES public.catalogos(id);
 Q   ALTER TABLE ONLY public.estudiantes DROP CONSTRAINT fkrrcp2dl35lt21xspn65psby5y;
       public          postgres    false    229    217    4262            Y      x������ � �      [   /  x�uQYJA��>EN �鬟	$��eO)%3ݡ��)��5`��3��~]���(�KV���1�����U�l�N8��1�+[���5�u��z��Na'�:�ܺ�����1sظ��S\�)��5��s���K��L�<H$���Ԑ��4<�p���(�!�����+F��6���&�7���%��B���Sz
�d������!r��2%Y�|#-*=���~q+)�_[���߫b�A�x�ɜj��ﬃ�s���w���:6��U��'�U���D���4E�`����/�h�      ]      x������ � �      _      x������ � �      a      x������ � �      c      x������ � �      e      x������ � �      g   R  x���KN�0����@*g��cǣ�,$V�IH-%q�,z+��Ű[@�����͌��/;�'��P�`�S^��dx�-��r�5I�a�}~�j:v����@�D��=� ��ƚ\���<̀\�i�)�	�^o���[�*PPA�&I�YXhΒ( ��^Ą����Ucs���7���=O��=G.zH2pF� ��W�0w��{n7�Vu������k��]��\`ڍ�hHKX���OP�!�c,�*C�Ɣ�����������ߍr�1��is��=<'Ť+�Z��D��F�����gI�a*�]��	��ǝ���X5Q�E��,I�/��@      i   L   x�34���CGF���!Y��'�����!L�]҈��&i�&id4�,e�M�,e�[���H*F��� !�-5      k      x������ � �      m      x������ � �     