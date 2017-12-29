INSERT INTO hobby (hobby_id, description) VALUES (
  1, 'программировать'
);

INSERT INTO hobby (hobby_id, description) VALUES (
  2, 'торговать'
);

INSERT INTO hobby (hobby_id, description) VALUES (
  3, 'прибираться'
);

INSERT INTO hobby (hobby_id, description) VALUES (
  4, 'играть'
);

INSERT INTO contact (id, birth_date, first_name, last_name, version) VALUES (
  1, '1986-02-20', 'Алексей', 'Сугробов', 1
);

INSERT INTO contact_tel_detail (id, tel_number, tel_type, version, contact, contact_by_id) VALUES (
    1, '+79923320010', 'mobile', 1, 1, 1
);

INSERT INTO contact (id, birth_date, first_name, last_name, version) VALUES (
  2, '1960-01-22', 'Лев', 'Сугробов', 1
);

INSERT INTO contact_tel_detail (id, tel_number, tel_type, version, contact, contact_by_id) VALUES (
  2, '+79028733530', 'mobile', 1, 2, 2
);

INSERT INTO contact (id, birth_date, first_name, last_name, version) VALUES (
  3, '1961-08-05', 'Ирина', 'Сугробова', 1
);

INSERT INTO contact_tel_detail (id, tel_number, tel_type, version, contact, contact_by_id) VALUES (
  3, '+79028735530', 'mobile', 1, 3, 3
);

INSERT INTO contact (id, birth_date, first_name, last_name, version) VALUES (
  4, '1990-04-28', 'Максим', 'Сугробов', 1
);

INSERT INTO contact_tel_detail (id, tel_number, tel_type, version, contact, contact_by_id) VALUES (
  4, '+7-*-*-*-*', 'mobile', 1, 4, 4
);

INSERT INTO contact_hobby_detail (contact_id, hobby_id) VALUES (
    1,1
);

INSERT INTO contact_hobby_detail (contact_id, hobby_id) VALUES (
  2,2
);

INSERT INTO contact_hobby_detail (contact_id, hobby_id) VALUES (
  3,3
);

INSERT INTO contact_hobby_detail (contact_id, hobby_id) VALUES (
  4,4
);