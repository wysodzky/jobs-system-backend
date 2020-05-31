INSERT INTO user (id,username,password,email) VALUES (9999,'admin','$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6','');
INSERT INTO authority (id,role,user_account_id) VALUES  (9998,'ROLE_ADMIN',9999);

INSERT INTO user (id,username,password,email) VALUES (9997,'user','$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6','');
INSERT INTO authority (id,role,user_account_id) VALUES  (9996,'ROLE_USER',9997);

