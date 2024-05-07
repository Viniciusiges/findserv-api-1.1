create table users(


                      id uuid primary key not null default uuid_generate_v4(),
                      login varchar(100) not null,
                      password varchar(255) not null


);


insert into users (login, password) values ('joao.alberto@findserv.com.br', '$2a$12$ATrJ.bRmppyLmlvDijVqPu7wQ2dMcXGmHbBjMUyWg/i6XMiBUxnN.')