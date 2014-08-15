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
#insert into a_club values (null,'Cardiff City','1899-00-00','Cardiff City Stadium','Malky Mackay',null,'images/cardif.png','Cardiff,Wales');
insert into a_club values (null,'Crystal Palace','1905-00-00','Selhurst Park','Ian Scott Holloway',null,'images/crystalpalace.png','South London,England');
#insert into a_club values (null,'Fulham','1879-00-00','Craven Cottage','Martin Jol',null,'images/ffc.png','London,England');
insert into a_club values (null,'Sunderland Association','1879-00-00','Stadium of Light','Paolo Di Canio','','images/sunderland.png','Sunderland,England');
insert into a_club values (null,'Southampton','1885-11-00','St. Mary''s Stadiu','Pochettino',null,'images/southampton.png','Southampton,England');
insert into a_club values (null,'Newcastle United','1881-00-00','St James'' Park','Alan Pardew',null,'images/newcastleunited.png','Newcastle,England');
insert into a_club values (null,'West Ham United','1895-00-00','Upton Park','Sam Allardyce','Dave Taylo,Arnold Hills','images/westhamunited.png','Outer London,England');
insert into a_club values (null,'Stoke City','1868-00-00','The Britannia Stadium','Mark Hughes',null,'images/stokecity.png','Stoke-on-Trent,England');
insert into a_club values (null,'West Bromwich Albion','1878-00-00','The Hawthorns','Steve Clarke','','images/westbromwich.png','West Bromwich,England');
insert into a_club values (null,'Swansea City','1912-00-00','Liberty Stadium','Michael Laudrup',null,'images/swansea.png','Swansea,Wales');
#insert into a_club values (null,'Norwich City','1902-00-00','Carrow Road','Christopher "Chris" Hughton',null,'images/norwich.png','Norwich City,England');
insert into a_club values (null,'Hull City Association','1904-00-00','Kingston Communications Stadium','Bruce',null,'images/hullcity.png','Hull City,England');
insert into a_club values (null,'Queens Park Rangers','1882-00-00','Loftus Road','Henry Redknapp',null,'images/queensparkrangers.png','Hammersmith,England');
insert into a_club values (null,'Leicester City','1884-00-00','King Power Stadium','Nigel Graham Pearson',null,'images/leicestercity.png','Leicester City,England');
insert into a_club values (null,'Burnley','1882-00-00','Turf Moor','Sean Dyche',null,'images/burnley.png','Burnley,England');
#更新字符集
#ALTER DATABASE `aodci` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
#show variables like "%char%";
#测试数据
#insert into a_club values (null,'Manchester United00','18780101','老特拉福德','David Moyes',null,'images/manchesterunited.png','Manchester City,England');
#select * from a_sporter where cname = 'Manchester United'  and name = 'qian' and band = 'A'
#update a_scoreboard set win = win+1 where id = 2;
#insert into a_shotboard values (null,'qian','hui',1,'qian_hui') ON DUPLICATE KEY UPDATE goals=goals+1;


