#DO NOT FORGET TO ADD THE DERBYCLIENT TO THE CLASSPATH
connect 'jdbc:derby://localhost:1527/cat_store;create=true';
create table cat(id int primary key GENERATED ALWAYS AS IDENTITY, name varchar(20));
exit;