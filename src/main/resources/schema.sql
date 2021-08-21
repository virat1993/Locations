drop table IF EXISTS location ;
drop schema IF EXISTS positioning ;

create schema positioning;

create table location (locationId int not null, locationName varchar(45), location_coordinates geometry, longitude double precision, latitude double precision);