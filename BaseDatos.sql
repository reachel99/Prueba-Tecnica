PGDMP      '                |            tecnica    14.13    16.4 )               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16508    tecnica    DATABASE     z   CREATE DATABASE tecnica WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE tecnica;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    4                       0    0    SCHEMA public    ACL     Q   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   postgres    false    4            �            1259    16802    cliente    TABLE     �   CREATE TABLE public.cliente (
    id bigint NOT NULL,
    clienteid character varying(255) NOT NULL,
    contrasena character varying(255) NOT NULL,
    estado boolean NOT NULL
);
    DROP TABLE public.cliente;
       public         heap    postgres    false    4            �            1259    16801    cliente_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cliente_id_seq;
       public          postgres    false    4    212                       0    0    cliente_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;
          public          postgres    false    211            �            1259    16816    cuenta    TABLE       CREATE TABLE public.cuenta (
    id bigint NOT NULL,
    numero_cuenta character varying(255) NOT NULL,
    tipo_cuenta character varying(255) NOT NULL,
    saldo_inicial numeric(38,2) NOT NULL,
    estado boolean NOT NULL,
    cliente_id bigint NOT NULL
);
    DROP TABLE public.cuenta;
       public         heap    postgres    false    4            �            1259    16815    cuenta_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cuenta_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.cuenta_id_seq;
       public          postgres    false    4    214                       0    0    cuenta_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.cuenta_id_seq OWNED BY public.cuenta.id;
          public          postgres    false    213            �            1259    16830 
   movimiento    TABLE       CREATE TABLE public.movimiento (
    id bigint NOT NULL,
    fecha timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    tipo character varying(255) NOT NULL,
    valor numeric(38,2) NOT NULL,
    saldo numeric(38,2) NOT NULL,
    cuenta_id bigint NOT NULL
);
    DROP TABLE public.movimiento;
       public         heap    postgres    false    4            �            1259    16829    movimiento_id_seq    SEQUENCE     �   CREATE SEQUENCE public.movimiento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.movimiento_id_seq;
       public          postgres    false    216    4                       0    0    movimiento_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.movimiento_id_seq OWNED BY public.movimiento.id;
          public          postgres    false    215            �            1259    16793    persona    TABLE     <  CREATE TABLE public.persona (
    id bigint NOT NULL,
    nombre character varying(255) NOT NULL,
    genero character varying(255) NOT NULL,
    edad integer NOT NULL,
    identificacion character varying(255) NOT NULL,
    direccion character varying(255) NOT NULL,
    telefono character varying(255) NOT NULL
);
    DROP TABLE public.persona;
       public         heap    postgres    false    4            �            1259    16792    persona_id_seq    SEQUENCE     �   CREATE SEQUENCE public.persona_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.persona_id_seq;
       public          postgres    false    210    4                       0    0    persona_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.persona_id_seq OWNED BY public.persona.id;
          public          postgres    false    209            l           2604    16846 
   cliente id    DEFAULT     h   ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);
 9   ALTER TABLE public.cliente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    211    212            m           2604    16866 	   cuenta id    DEFAULT     f   ALTER TABLE ONLY public.cuenta ALTER COLUMN id SET DEFAULT nextval('public.cuenta_id_seq'::regclass);
 8   ALTER TABLE public.cuenta ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    213    214            n           2604    16900    movimiento id    DEFAULT     n   ALTER TABLE ONLY public.movimiento ALTER COLUMN id SET DEFAULT nextval('public.movimiento_id_seq'::regclass);
 <   ALTER TABLE public.movimiento ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215    216            k           2604    16924 
   persona id    DEFAULT     h   ALTER TABLE ONLY public.persona ALTER COLUMN id SET DEFAULT nextval('public.persona_id_seq'::regclass);
 9   ALTER TABLE public.persona ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    210    210                      0    16802    cliente 
   TABLE DATA           D   COPY public.cliente (id, clienteid, contrasena, estado) FROM stdin;
    public          postgres    false    212   --                 0    16816    cuenta 
   TABLE DATA           c   COPY public.cuenta (id, numero_cuenta, tipo_cuenta, saldo_inicial, estado, cliente_id) FROM stdin;
    public          postgres    false    214   g-                 0    16830 
   movimiento 
   TABLE DATA           N   COPY public.movimiento (id, fecha, tipo, valor, saldo, cuenta_id) FROM stdin;
    public          postgres    false    216   �-                 0    16793    persona 
   TABLE DATA           `   COPY public.persona (id, nombre, genero, edad, identificacion, direccion, telefono) FROM stdin;
    public          postgres    false    210   ..                   0    0    cliente_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.cliente_id_seq', 1, false);
          public          postgres    false    211            !           0    0    cuenta_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.cuenta_id_seq', 3, true);
          public          postgres    false    213            "           0    0    movimiento_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.movimiento_id_seq', 9, true);
          public          postgres    false    215            #           0    0    persona_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.persona_id_seq', 4, true);
          public          postgres    false    209            u           2606    16843    cliente cliente_clienteid_key 
   CONSTRAINT     ]   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_clienteid_key UNIQUE (clienteid);
 G   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_clienteid_key;
       public            postgres    false    212            w           2606    16848    cliente cliente_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    212            y           2606    16880    cuenta cuenta_numero_cuenta_key 
   CONSTRAINT     c   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_numero_cuenta_key UNIQUE (numero_cuenta);
 I   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT cuenta_numero_cuenta_key;
       public            postgres    false    214            {           2606    16868    cuenta cuenta_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT cuenta_pkey;
       public            postgres    false    214            }           2606    16902    movimiento movimiento_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.movimiento
    ADD CONSTRAINT movimiento_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.movimiento DROP CONSTRAINT movimiento_pkey;
       public            postgres    false    216            q           2606    16940 "   persona persona_identificacion_key 
   CONSTRAINT     g   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_identificacion_key UNIQUE (identificacion);
 L   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_identificacion_key;
       public            postgres    false    210            s           2606    16926    persona persona_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_pkey;
       public            postgres    false    210                       2606    16888    cuenta fk_cliente    FK CONSTRAINT     �   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES public.cliente(id) ON DELETE CASCADE;
 ;   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT fk_cliente;
       public          postgres    false    3191    212    214            �           2606    16915    movimiento fk_cuenta    FK CONSTRAINT     �   ALTER TABLE ONLY public.movimiento
    ADD CONSTRAINT fk_cuenta FOREIGN KEY (cuenta_id) REFERENCES public.cuenta(id) ON DELETE CASCADE;
 >   ALTER TABLE ONLY public.movimiento DROP CONSTRAINT fk_cuenta;
       public          postgres    false    214    3195    216            ~           2606    16927    cliente fk_persona    FK CONSTRAINT     �   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk_persona FOREIGN KEY (id) REFERENCES public.persona(id) ON DELETE CASCADE;
 <   ALTER TABLE ONLY public.cliente DROP CONSTRAINT fk_persona;
       public          postgres    false    210    3187    212               *   x�3�4���/N�,�2�B# ӘӘ����Ȍ���� ��         7   x�3�442�Nǌ���|NC=�N#.C��������L�.o����� �0         p   x�3�4202�5��5�T04�2 !N�Ԃ��̒|NS= �FscU�Z�YRVd��LP�*���k3��[���`4�>���T��SU�WmA�jK�<���� �K�         �   x�M�;
�0�zu
]�A�'�k�����iE�`���}�&�L�n;��Fذ�]Vg`����e�"u��Z!�[eE�
��5����
��1��~k���O+U�k)W��ᤒ�2��8w�n���(�>2�     