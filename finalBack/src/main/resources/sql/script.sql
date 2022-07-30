create database final22II;
use final22II;

create table pais (
    id_pais numeric(4),
    codigo char(3),
    nombre varchar(30),
    primary key (id_pais)
);

create table atleta(
    id_atleta numeric(4),
    nombres varchar(50),
    talla numeric(4),
    peso numeric(5,  2),
    flg_condicion_medica numeric(1),
    flg_sustancia_prohibida numeric(1),
    id_pais numeric(4),
    primary key (id_atleta),
    foreign key (id_pais)
            references pais(id_pais)
);

create table puntuacion(
    id_puntacion numeric(4),
    puntaje_juez_1 numeric(2),
    puntaje_juez_2 numeric(2),
    puntaje_juez_3 numeric(2),
    puntaje_juez_4 numeric(2),
    puntaje_juez_5 numeric(2),
    id_atleta numeric(4),
    primary key (id_puntacion),
    foreign key (id_atleta)
        references atleta(id_atleta)
);

insert into puntuacion values (1, 15, 16, 16, 19, 17, 1);
insert into puntuacion values (2, 17, 20, 16, 19, 17, 2);
insert into puntuacion values (3, 16, 18, 17, 19, 17, 3);
insert into puntuacion values (4, 11, 12, 17, 19, 17, 4);
insert into puntuacion values (5, 13, 14, 17, 19, 17, 5);
insert into puntuacion values (6, 17, 12, 16, 19, 17, 6);
insert into puntuacion values (7, 12, 12, 15, 19, 17, 7);
insert into puntuacion values (8, 16, 8, 15, 20, 17, 8);
insert into puntuacion values (9, 13, 13, 18, 19, 17, 9);

insert into pais values(1, 'PER', 'Peru');
insert into pais values(2, 'ARG',  'Argentina');
insert into pais values(3, 'BRA', 'Brasil');

insert into atleta values(1, 'Juan', 174, 75, 0, 1, 1);
insert into atleta values(2, 'Julio', 142, 75, 1, 0, 1);
insert into atleta values(3, 'Armas', 184, 75, 0, 0,  1);
insert into atleta values(4, 'Pepe', 160, 75, 0, 0,  2);
insert into atleta values(5, 'MIguel', 180, 75, 0, 0,  2);
insert into atleta values(6, 'Jaime', 111, 75, 0, 0,  2);
insert into atleta values(7, 'Renato', 123, 75, 0, 0,  3);
insert into atleta values(8, 'Luis', 180, 75, 0, 0,  3);
insert into atleta values(9, 'Jose', 180, 75, 0, 0,  3);

select a.nombres, a.talla, a.peso,
    a.flg_condicion_medica, a.flg_sustancia_prohibida ,
    p.codigo, p.nombre,
    (p2.puntaje_juez_5 + p2.puntaje_juez_4 + p2.puntaje_juez_3 + p2.puntaje_juez_2 + p2.puntaje_juez_1) puntaje_promedio
from atleta a
         inner join pais p on a.id_pais = p.id_pais
         inner join puntuacion p2 on a.id_atleta = p2.id_atleta
where a.flg_condicion_medica = 0 and a.flg_sustancia_prohibida = 0
order by puntaje_promedio;
