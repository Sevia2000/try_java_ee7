insert into ROOM(select 1 as ID, 'プログラム' as name from SYSIBM.SYSDUMMY1 where NOT EXISTS(select * from ROOM where ID = 1))
insert into ROOM(select 2 as ID, '登山' as name from SYSIBM.SYSDUMMY1 where NOT EXISTS(select * from ROOM where ID = 2))
update SEQUENCE set seq_count = 3 where seq_count <= 3
