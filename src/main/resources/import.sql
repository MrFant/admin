-- 此文件会被hibernate自动执行，用于初始化数据库
-- 以下插入的两条数据的密码明文均为123456
INSERT INTO user (id, username, password, name, email,phone) VALUES (1, 'admin', '$2a$10$GAjSdF0eK7x2YuWaBW2fb.dpGdwh7VULDUfnd/ienj0Fs/BwxuikS', '管理员', 'ygtq@haibusiness.com','12345678');
INSERT INTO user (id, username, password, name, email,phone)  VALUES (2, 'test', '$2a$10$GAjSdF0eK7x2YuWaBW2fb.dpGdwh7VULDUfnd/ienj0Fs/BwxuikS', '张三', 'zhangsan@haibusiness.com','87654321');

INSERT INTO authority (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authority (id, name) VALUES (2, 'ROLE_USER');
INSERT INTO authority (id, name) VALUES (3, 'ROLE_WAITER');


INSERT INTO user_authority (user_id, authority_id) VALUES (1, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 2);


insert into card_list_info(`title`,`date`,`url`,`article`) value ('test','20190102','http://www.google.com',1);
insert into card_list_info(`title`,`date`,`url`,`article`) value ('test2','20190102','http://www.google.com',2);
insert into card_list_info(`title`,`date`,`url`,`article`) value ('test3','20190102','http://www.google.com',3);
insert into card_list_info(`title`,`date`,`url`,`article`) value ('test4','20190102','http://www.google.com',4);

insert article(`content`,`date`,`title`) values("为了解国内外油茶研究动态，弘扬和繁荣海南油茶文化，推动海南油茶产业健康发展，2019年4月18-19日，海南省山柚（油茶）产业技术联盟启动会暨第四届热带油茶产业发展研讨会于海南大学儋州校区森林客栈顺利召开。出席本次会议的有儋州市常务副市长林刚，海南大学副校长胡新文，林业厅领导钟仕进，科技厅领导李美凤等领导和10多名省内外油茶专家，此外参加本次会议的还有侯臣生物公司总经理谭运寿，高晖农业投资公司董事长徐敏高，新美特科技公司总经理冯一格，万安农业开发公司董事长林壮等企业家，以及近100名省内油茶种植大户。会议由吴友根教授主持。","20190209","test");
insert article(`content`,`date`,`title`) values("为了解国内外油茶研究动态，弘扬和繁荣海南油茶文化，推动海南油茶产业健康发展，2019年4月18-19日，海南省山柚（油茶）产业技术联盟启动会暨第四届热带油茶产业发展研讨会于海南大学儋州校区森林客栈顺利召开。出席本次会议的有儋州市常务副市长林刚，海南大学副校长胡新文，林业厅领导钟仕进，科技厅领导李美凤等领导和10多名省内外油茶专家，此外参加本次会议的还有侯臣生物公司总经理谭运寿，高晖农业投资公司董事长徐敏高，新美特科技公司总经理冯一格，万安农业开发公司董事长林壮等企业家，以及近100名省内油茶种植大户。会议由吴友根教授主持。","20190209","test2");
insert article(`content`,`date`,`title`) values("为了解国内外油茶研究动态，弘扬和繁荣海南油茶文化，推动海南油茶产业健康发展，2019年4月18-19日，海南省山柚（油茶）产业技术联盟启动会暨第四届热带油茶产业发展研讨会于海南大学儋州校区森林客栈顺利召开。出席本次会议的有儋州市常务副市长林刚，海南大学副校长胡新文，林业厅领导钟仕进，科技厅领导李美凤等领导和10多名省内外油茶专家，此外参加本次会议的还有侯臣生物公司总经理谭运寿，高晖农业投资公司董事长徐敏高，新美特科技公司总经理冯一格，万安农业开发公司董事长林壮等企业家，以及近100名省内油茶种植大户。会议由吴友根教授主持。","20190209","test3");
insert article(`content`,`date`,`title`) values("为了解国内外油茶研究动态，弘扬和繁荣海南油茶文化，推动海南油茶产业健康发展，2019年4月18-19日，海南省山柚（油茶）产业技术联盟启动会暨第四届热带油茶产业发展研讨会于海南大学儋州校区森林客栈顺利召开。出席本次会议的有儋州市常务副市长林刚，海南大学副校长胡新文，林业厅领导钟仕进，科技厅领导李美凤等领导和10多名省内外油茶专家，此外参加本次会议的还有侯臣生物公司总经理谭运寿，高晖农业投资公司董事长徐敏高，新美特科技公司总经理冯一格，万安农业开发公司董事长林壮等企业家，以及近100名省内油茶种植大户。会议由吴友根教授主持。","20190209","test4");

