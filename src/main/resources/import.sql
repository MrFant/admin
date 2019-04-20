# # 此文件会被hibernate自动执行，用于初始化数据库
# # 以下插入的两条数据的密码明文均为123456
# INSERT INTO user (id, username, password, name, email,phone) VALUES (1, 'admin', '$2a$10$GAjSdF0eK7x2YuWaBW2fb.dpGdwh7VULDUfnd/ienj0Fs/BwxuikS', '管理员', 'ygtq@haibusiness.com','12345678');
# INSERT INTO user (id, username, password, name, email,phone)  VALUES (2, 'test', '$2a$10$GAjSdF0eK7x2YuWaBW2fb.dpGdwh7VULDUfnd/ienj0Fs/BwxuikS', '张三', 'zhangsan@haibusiness.com','87654321');
#
# INSERT INTO authority (id, name) VALUES (1, 'ROLE_ADMIN');
# INSERT INTO authority (id, name) VALUES (2, 'ROLE_USER');
# INSERT INTO authority (id, name) VALUES (3, 'ROLE_WAITER');
#
#
# INSERT INTO user_authority (user_id, authority_id) VALUES (1, 1);
# INSERT INTO user_authority (user_id, authority_id) VALUES (2, 2);
#
#
