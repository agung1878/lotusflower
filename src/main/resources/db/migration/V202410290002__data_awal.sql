insert into c_security_permission (id, created_by, created, permission_label, permission_value)
values ('PERMISSION_001', 'SYSTEM', '2024-01-16 00:00:00', 'Base Permission', 'ROLE_BASIC');

insert into c_security_role (id, created_by, created, name, description)
values ('ROLE_001', 'SYSTEM', '2024-01-16 00:00:00', 'Administrator', 'Role for Administrator');

insert into c_security_role_permission (id_role, id_permission)
values ('ROLE_001', 'PERMISSION_001');

insert into c_security_user (id, created_by, created, username, active, id_role)
values ('default_user', 'SYSTEM', '2024-01-16 00:00:00', 'lf@yopmail.com', true, 'ROLE_001');

insert into c_security_user_password (created_by, created, id_user, user_password)
values ('SYSTEM', '2024-01-16 00:00:00', 'default_user',
        '$2y$10$6xVr5ZxD4E01D8Ib.Bie.edKCH2WWa.pGsTBGm/tW19/ElHBLSTaS');
