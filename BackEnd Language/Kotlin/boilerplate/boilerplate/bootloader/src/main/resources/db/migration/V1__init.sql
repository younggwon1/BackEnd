create table tb_order (
   id bigint not null auto_increment,
    order_desc varchar(255),
    price decimal(19,2),
    status varchar(255),
    primary key (id)
);

INSERT INTO tb_order(order_desc, price, status)VALUES('감자', 10000.00, 'START');
INSERT INTO tb_order(order_desc, price, status)VALUES('고구마', 15000.00, 'START');
INSERT INTO tb_order(order_desc, price, status)VALUES('소고기(한우)', 300000.00, 'COMPLETE');
