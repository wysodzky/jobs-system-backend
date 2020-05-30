INSERT INTO user (id,username,password,email) VALUES (1,'admin','$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6','');

INSERT INTO authority (id,role,user_account_id) VALUES  (2,'ROLE_ADMIN',1);