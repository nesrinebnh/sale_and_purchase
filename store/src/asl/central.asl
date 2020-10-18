// Agent central in project store

/* Initial beliefs and rules */

/* Initial goals */

!start.

//+!start : true <- burn(garb, test, nada).
+!start <- .print("loaded!").
/* Plans */
+find_phone(Manufacturer, CPU, RAM, ROM, Battery, Screen, Fingerprint, Size, Price) <- .send(phones, achieve, find(Manufacturer, CPU, RAM, ROM, Battery, Screen, Fingerprint, Size, Price)).
-find_phone(Manufacturer, CPU, RAM, ROM, Battery, Screen, Fingerprint, Size, Price) <- .print("droping find phone").

+find_car(Manufacturer, Trans, Fuel, Style, Size, Hp, Price) <- .send(cars, achieve, find(Manufacturer, Trans, Fuel, Style, Size, Hp, Price)).
-find_car(Manufacturer, Trans, Fuel, Style, Size, Hp, Price) <- .print("droping find car").

+find_bus(Manufacturer, Bus_Type, Size, Price) <- .send(buses, achieve, find(Manufacturer, Bus_Type, Size, Price)).
-find_bus(Manufacturer, Bus_Type, Size, Price) <- .print("droping find bus").

+find_mc(Manufacturer, Weight_class, Range, Tspeed, Acc, Price)  <- .send(motocycles, achieve, find(Manufacturer, Weight_class, Range, Tspeed, Acc, Price) ).
-find_mc(Manufacturer, Weight_class, Range, Tspeed, Acc, Price)  <- .print("droping find bus").

+find_truck(Manufacturer, Trailer, Trailer_weight, Cargo_area, Cargo_size, Price)  <- .send(trucks, achieve, find(Manufacturer, Trailer, Trailer_weight, Cargo_area, Cargo_size, Price) ).
-find_truck(Manufacturer, Trailer, Trailer_weight, Cargo_area, Cargo_size, Price)  <- .print("droping find bus").

+find_travel(From, To, Class, Price)  <- .send(travel, achieve, find(From, To, Class, Price) ).
-find_travel(From, To, Class, Price)  <- .print("droping find bus").



+!product(Name) <- .print("found this product: ", Name); printR("found this product: ", Name).








/* 
+!start : true <-.send(phn, achieve, find(
	"All", // Manufacturer,
	"All",// CPU
	6,// RAM
	100,// ROM
	1000,// Baterry
	"All",// Screen
	"All",// Fingerprint
	1.9,// Size,
	1400// Price
)).
//+!start : true <- burn.
//+!start : true <- .send(ag1,askOne,finds(5)); .print("hii").
/*+!start : true <- .send(vcl,tell,engine);
				  .send(vcl,achieve,find(
						4,//Wheels, 
						2,//Passengers, 
						"small",//Body_frame, 
						2,//Doors, 
						"All",//Fuel, 
						"All",//Categ, 
						400,//Hp, 
						"All",//Trans, 
						"Ferrari",//Manufacturer, 
						"All",//Style, 
						"All",//Size, 
						1000000,//Price, 
						"All",//Bus_Type, 
						"All",//Trailer, 
						"All",//Cargo_size_area, 
						0,//Trailer_weight, 
						0,//Cargo_size, 
						"All",//Weight_class, 
						0,//Range, 
						0,//Tspeed, 
						0//Acc 
				  )).
+!product(Text) <- .print("").
 /*
+!start : true <- .send(ag1,tell,hello).
+hello[source(A)] <- .print("I received a 'hello' from ",A).*/
