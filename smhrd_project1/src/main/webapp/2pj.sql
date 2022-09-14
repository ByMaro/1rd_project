create table user_info(
    user_id varchar(10) not null,
    user_pw varchar(30) not null,
    nick_name varchar(30) ,
    height_val number(5,2) not null,
    weight_val number(5,2) not null,
    

    constraint user_info_user_id_pk PRIMARY key(user_id)
);

create table training_info (
    training_index NUMBER(7,0) NOT NULL,
    training_name varchar(30) not null,
    act_info long,
    training_part varchar(30) not null,
    training_equip varchar(30) not null,
    training_dif varchar(30) not null,
    CONSTRAINT training_info_tindex_pk PRIMARY key(training_index)
);
--training_index에 사용할 시퀀스
create SEQUENCE training_info_tindex_seq START WITH 1 INCREMENT BY 1 MAXVALUE 9999999 NOCYCLE NOCACHE;

create table training_info_img (
    img_index NUMBER(5) NOT NULL,
    training_index NUMBER(5) not null,
    img_name VARCHAR(30),
    CONSTRAINT training_info_img_index_pk PRIMARY key(img_index),
    constraint training_info_img_index_fk FOREIGN key(training_index) references training_info(training_index) on delete cascade
);

--training_index에 사용할 시퀀스
create SEQUENCE training_info_img_index_seq START WITH 1 INCREMENT BY 1 MAXVALUE 9999999 NOCYCLE NOCACHE;

create table user_training_info(
    index_no number(7,0) not null,
    training_index number(7,0) not null,
    set_val number(2,0) not null,
    secncnt_val varchar(10) not null,
    training_date date DEFAULT sysdate not null, 
    constraint user_training_info_index_pk PRIMARY key(index_no),
    constraint user_training_info_index_fk FOREIGN key(training_index) REFERENCES training_info(training_index) on delete cascade

);
--rutin_index에 사용할 시퀀스
create SEQUENCE user_training_info_no_seq START WITH 1 INCREMENT BY 1 MAXVALUE 9999999 NOCYCLE NOCACHE;