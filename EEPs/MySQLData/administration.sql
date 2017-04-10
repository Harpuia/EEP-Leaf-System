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
    activity VARCHAR(25) DEFAULT NULL,
    username VARCHAR(25) DEFAULT NULL,
    password VARCHAR(25) DEFAULT NULL,
    is_success BOOL NOT NULL DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);