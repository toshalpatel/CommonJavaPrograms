declare
l NUMBER(3) := &limit;
t NUMBER(3);

begin
dbms_output.put_line('Table of 2');
for i in 1..l loop
t := 2*i;
dbms_output.put_line('2 x ' || i || ' = ' || t);
end loop;
end;
.
/
