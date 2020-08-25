DROP TABLE IF EXISTS Address;
DROP TABLE IF EXISTS OrderData;
DROP TABLE IF EXISTS OrderIdOrderItems;


CREATE TABLE Address (
  AddressId INT AUTO_INCREMENT  PRIMARY KEY,
  PinCode int NOT NULL,
  State VARCHAR(250) NOT NULL
);

CREATE TABLE OrderData (
id INT AUTO_INCREMENT  PRIMARY KEY,
  CustomerName int NOT NULL,
  OrderDate Date NOT NULL,
  AddressId INT,
  foreign key (AddressId) references Address(AddressId)
);
CREATE TABLE OrderIdOrderItems (
OrderId INT  not null,
OrderItemId int NOT NULL
 );