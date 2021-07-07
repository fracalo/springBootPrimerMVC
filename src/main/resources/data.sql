create table Todo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description VARCHAR(255),
    inserted_at DATE,
    created_at DATE
);

insert into Todo (id, title, description) values (1, 'ciao', 'test destest destest destest destest destest destest destest destest desccccccccctest desc')