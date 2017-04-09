--
-- Table structure for table `user_management`
--

drop table if exists `user_management`;

create table `user_management` (
    `username` varchar(25) default null,
    `password` varchar(25) default null
) engine=InnoDB default charset=latin1;

--
-- Dumping data for table `seeds`
--

lock tables `user_management` write;
insert into `user_management` values ('admin', 'password');
unlock tables;

--
-- Table structure for table `log`
--

drop table if exists `log`;

CREATE TABLE log (
    username VARCHAR(25) DEFAULT NULL,
    title VARCHAR(255) DEFAULT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

lock tables `log` write;
insert into log(username)
    values('administrator');