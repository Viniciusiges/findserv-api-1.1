create table address
(


    id          uuid primary key not null default uuid_generate_v4(),
    postal_code varchar(8)       not null,
    state       char(2)          not null,
    city        varchar(100)     not null,
    district    varchar(100)     not null,
    street      varchar(100)     not null,
    number      varchar(20),
    complement  varchar(100),
    professional_id uuid,
    client_id uuid,

    CONSTRAINT fk_address_professional FOREIGN KEY (professional_id) REFERENCES professional (id) ON DELETE CASCADE,
    CONSTRAINT fk_address_client FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE


);
