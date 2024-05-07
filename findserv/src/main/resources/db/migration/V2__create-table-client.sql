create table client(

                        id uuid primary key not null default uuid_generate_v4(),
                        name varchar(100) not null,
                        email varchar(100) not null unique,
                        cpf varchar(11) not null unique,
                        phone varchar(11) not null,
                        active boolean

);