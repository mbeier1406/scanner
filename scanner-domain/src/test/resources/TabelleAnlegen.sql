
-- Einfaches Beispiel zum Anlegen einer Tabelle mit automatischer Generierung des PK
create table xxx ( id number, yyy varchar2(4), constraint xxx_pk primary key(id) enable );
create sequence xxx_seq start with 1;
create or replace trigger xxx_trg before insert on xxx for each row
begin
    select xxx_seq.nextval into :new.id from dual;
end;
/
insert into xxx ( yyy ) values ( 'YYY' );
insert into xxx ( yyy ) values ( 'ZZZ' );
commit;
select * from xxx;
