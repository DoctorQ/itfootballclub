drop database if exists aodci;
create database aodci CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';
use aodci;
#创建积分表a_scoreboard
drop table if exists a_scoreboard;
create table a_scoreboard
(
  id int primary key not null  auto_increment,
  name varchar(40) not null unique,
  win int not null,
  faith int not null,
  tie int not null,
  score int not null,
  gain int not null,
  lose int not null,
  imageurl varchar(126)
)engine=innodb default charset=utf8 auto_increment=1;

#创建a_gameresult
drop table if exists a_gameresult;
create table a_gameresult
(
  id int primary key not null  auto_increment,
  pname varchar(40) not null,
  cname varchar(40) not null,
  pgoal int not null,
  cgoal int not null,
  gametime varchar(10),
  field varchar(40),
  leg int,
  msg varchar(400)
)engine=innodb default charset=utf8 auto_increment=1;
#a_club
drop table if exists a_club;
create table a_club
(
  id int primary key not null  auto_increment,
  cname varchar(40) unique not null,
  ctime varchar(10) not null,
  homefield varchar(100) not null,
  coach varchar(40) not null,
  builder varchar(40),
  imgurl varchar(100),
  location varchar(40)
)engine=innodb default charset=utf8 auto_increment=1;
#a_sporter
drop table if exists a_sporter;
create table a_sporter
(
  id int primary key not null  auto_increment,
  name varchar(40) not null,
  cname varchar(40) not null,
  born varchar(40) not null,
  country varchar(40) not null,
  sendclub varchar(40),
  band varchar(44),
  imgname varchar(50) unique,
  number int unique,
  role varchar(20)
)engine=innodb default charset=utf8 auto_increment=1;
#a_shotboard
drop table if exists a_shotboard;
create table a_shotboard
(
  id int primary key not null  auto_increment,
  name varchar(40) not null,
  cname varchar(40) not null,
  goals int,
  cc varchar(80) unique
)engine=innodb default charset=utf8 auto_increment=1;
#tigger
delimiter $
CREATE TRIGGER trigger_scoreboard_club
AFTER DELETE
ON a_club
FOR EACH ROW
begin
delete from a_scoreboard where  name=OLD.cname;
end;
$
delimiter $
CREATE TRIGGER trigger_add_scoreboard_club
BEFORE INSERT
ON a_club
FOR EACH ROW
begin
 insert into a_scoreboard values(0,NEW.cname,0,0,0,0,0,0,NEW.imgurl);
end;
$
delimiter ;
/*添加两个字段->club
alter table a_club add column imgurl  varchar(100) after builder;
alter table a_club add column location varchar(40);

//club的cname添加unque約束
alter table a_club add constraint uc_cname unique cname;
*/
 
#给a_club表添加数据
insert into a_club values (null,'Manchester United','1878-01-01','Old Trafford','David Moyes',null,'images/manchesterunited.png','Manchester City,England');
insert into a_club values (null,'Chelsea','1905-03-10','Stamford Bridge Stadium','Jose Mario dos Santos Mourinho Felix','Henry Augustus Mears','images/chelsea.png','London,England');
insert into a_club values (null,'Arsenal','1886-00-00','Emirates Stadium','Arsene Wenger',null,'images/arsenal.png','North London,England');
insert into a_club values (null,'Liverpool','1892-03-15','Anfield Stadium','Brendan Rodgers','John Houlding','images/liverpool.png','Liverpool,England');
insert into a_club values (null,'Manchester City','1894-00-00','Etihad Stadium','Manuel Luis Pellegrini Ripamonti','','images/mcfc.png','Manchester City,England');
insert into a_club values (null,'Tottenham Hotspur','1882-00-00','White Hart Lane','Villas Boas',null,'images/tottenhamhotspur.png','North London,England');
insert into a_club values (null,'Aston Villa','1874-00-00','Villa Park','Paul Lambert',null,'images/avfc.png','Birmingham,England');
insert into a_club values (null,'Everton','1878-01-01','Goodison Park','Roberto Martinez','','images/everton.png','Liverpool,England');
insert into a_club values (null,'Cardiff City','1899-00-00','Cardiff City Stadium','Malky Mackay',null,'images/cardif.png','Cardiff,Wales');
insert into a_club values (null,'Crystal Palace','1905-00-00','Selhurst Park','Ian Scott Holloway',null,'images/crystalpalace.png','South London,England');
insert into a_club values (null,'Fulham','1879-00-00','Craven Cottage','Martin Jol',null,'images/ffc.png','London,England');
insert into a_club values (null,'Sunderland Association','1879-00-00','Stadium of Light','Paolo Di Canio','','images/sunderland.png','Sunderland,England');
insert into a_club values (null,'Southampton','1885-11-00','St. Mary''s Stadiu','Pochettino',null,'images/southampton.png','Southampton,England');
insert into a_club values (null,'Newcastle United','1881-00-00','St James'' Park','Alan Pardew',null,'images/newcastleunited.png','Newcastle,England');
insert into a_club values (null,'West Ham United','1895-00-00','Upton Park','Sam Allardyce','Dave Taylo,Arnold Hills','images/westhamunited.png','Outer London,England');
insert into a_club values (null,'Stoke City','1868-00-00','The Britannia Stadium','Mark Hughes',null,'images/stokecity.png','Stoke-on-Trent,England');
insert into a_club values (null,'West Bromwich Albion','1878-00-00','The Hawthorns','Steve Clarke','','images/westbromwich.png','West Bromwich,England');
insert into a_club values (null,'Swansea City','1912-00-00','Liberty Stadium','Michael Laudrup',null,'images/swansea.png','Swansea,Wales');
insert into a_club values (null,'Norwich City','1902-00-00','Carrow Road','Christopher "Chris" Hughton',null,'images/norwich.png','Norwich City,England');
insert into a_club values (null,'Hull City Association','1904-00-00','Kingston Communications Stadium','Bruce',null,'images/hullcity.png','Hull City,England');
#向积分表中擦人数据
insert into a_scoreboard values (null,'Manchester United',2,1,2,7,7,6,'images/manchesterunited.png');
insert into a_scoreboard values (null,'Chelsea',3,1,1,10,6,2,'images/chelsea.png');
insert into a_scoreboard values (null,'Arsenal',4,1,0,12,11,6,'images/arsenal.png');
insert into a_scoreboard values (null,'Liverpool',3,1,1,10,5,3,'images/liverpool.png');
insert into a_scoreboard values (null,'Manchester City',3,1,1,10,12,4,'images/mcfc.png');
insert into a_scoreboard values (null,'Tottenham Hotspur',4,0,1,12,5,1,'images/tottenhamhotspur.png');
insert into a_scoreboard values (null,'Aston Villa',2,3,0,6,6,6,'images/avfc.png');
insert into a_scoreboard values (null,'Everton',2,3,0,9,6,4,'images/everton.png');
insert into a_scoreboard values (null,'Cardiff City',1,2,2,5,4,4,'images/cardif.png');
insert into a_scoreboard values (null,'Crystal Palace',1,3,1,4,3,6,'images/crystalpalace.png');
insert into a_scoreboard values (null,'Fulham',1,3,1,4,3,7,'images/ffc.png');
insert into a_scoreboard values (null,'Sunderland Association',0,4,1,1,3,11,'images/sunderland.png');
insert into a_scoreboard values (null,'Southampton',2,1,2,8,3,2,'images/southampton.png');
insert into a_scoreboard values (null,'Newcastle United',2,2,1,7,5,8,'images/newcastleunited.png');
insert into a_scoreboard values (null,'West Ham United',1,2,2,5,4,4,'images/westhamunited.png');
insert into a_scoreboard values (null,'Stoke City',2,2,1,7,4,5,'images/stokecity.png');
insert into a_scoreboard values (null,'West Bromwich Albion',1,2,2,5,4,4,'images/westbromwich.png');
insert into a_scoreboard values (null,'Swansea City',2,2,1,7,7,7,'images/swansea.png');
insert into a_scoreboard values (null,'Norwich City',1,3,1,4,3,6,'images/norwich.png');
insert into a_scoreboard values (null,'Hull City Association',2,2,1,7,5,7,'images/hullcity.png');

#更新字符集
#ALTER DATABASE `aodci` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
#show variables like "%char%";
#测试数据
#insert into a_club values (null,'Manchester United00','18780101','老特拉福德','David Moyes',null,'images/manchesterunited.png','Manchester City,England');
#select * from a_sporter where cname = 'Manchester United'  and name = 'qian' and band = 'A'
#update a_scoreboard set win = win+1 where id = 2;
#insert into a_shotboard values (null,'qian','hui',1,'qian_hui') ON DUPLICATE KEY UPDATE goals=goals+1;


