create table test_table (
  key serial,
  test1 char(4),
  test2 varchar(32),
  test3 varchar(64) not null
);

select column_name from INFORMATION_SCHEMA.COLUMNS where table_name = 'test_table';
