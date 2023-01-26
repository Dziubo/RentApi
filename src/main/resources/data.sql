insert into application_users( first_name, last_name, pesel) values
                                                       ('Jan', 'Kowalski', '90101222457'),
                                                       ( 'Maciej', 'Zalewski', '87112242456'),
                                                       ( 'Aneta', 'Korczyńska', '76061536749'),
                                                       ( 'Wojciech', 'Sokolik', '82010877245');
INSERT INTO category( name , description ) values ('pojazd','brum'),('komputer','klik'),('ryba','chlup');
INSERT INTO Assets(name,description,serial_number,category_id)
    values
        ('laptop','test','122313',2),
        ('karaś','karasieJedząGówno','2137',3),
        ('dzip','SyndromMałegoChuja','420',1);
