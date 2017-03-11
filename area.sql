declare
v_radius NUMBER;
v_area NUMBER(5,2);

begin
for i in 1..7 loop
v_radius:=i;
v_area:=3.14*v_radius*v_radius;
insert into trigonometry values(v_radius, v_area);
end loop;
commit;
end;
.
/
