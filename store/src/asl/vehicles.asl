// Agent vehicles in project store

/* Initial beliefs and rules */

/* Initial goals */

at(Home).

//+!finds(X) <- .wait(1000);.print("Suup").	

+!find(Wheels, Passengers, Body_frame, Doors, Fuel, Categ, Hp, Trans, Manufacturer, Style, Size, Price, Bus_Type, Trailer, Cargo_size_area, Trailer_weight, Cargo_size, Weight_class, Range, Tspeed, Acc) 
 		<- 	if   (Wheels == 4) {.print("[!] We have 4 wheels"); +fw(Passengers, Body_frame, Doors, Fuel, Categ, Hp, Trans, Manufacturer, Style, Size, Price, Bus_Type, Trailer, Cargo_size_area, Trailer_weight, Cargo_size)}
			elif (Wheels == 2) {.print("[!] We have 2 wheels"); +motorcycle(Weight_class, Manufacturer, Range, Tspeed, Acc, Price)}
			else {.print("nothing found")}.

															
									
+fw(Passengers, Body_frame, Doors, Fuel, Categ, Hp, Trans, Manufacturer, Style, Size, Price, Bus_Type, Trailer, Cargo_size_area, Trailer_weight, Cargo_size) 
 		<- 	if   (Passengers <= 9 & Body_frame == "small"){.print("[!] It's a car"); +car(Doors, Fuel, Categ, Hp, Trans, Manufacturer, Style, Size, Price);}	
			elif (Passengers  > 9 & Body_frame == "big")  {.print("[!] It's a bus"); +bus(Manufacturer, Bus_Type, Size, Price);}	
			elif (Passengers <= 4 & Body_frame == "big")  {.print("[!] It's a truck"); +truck(Trailer, Cargo_size_area, Manufacturer, Trailer_weight, Cargo_size, Price);}.



 //////////////////////////////////////////////////////////////////////////////////
///////		Cars
//////////////////////////////////////////////////////////////////////////////////
+car(Doors, Fuel, Categ, Hp, Trans, Manufacturer, Style, Size, Price)
 		<- 	if ((Fuel == "All" | Fuel == "prem") & (Categ == "All" | Categ == "Perform")   & Hp>350 & (Doors == "All" | Doors == 2)) { .print("[!] It's a super car"); +super_car(Manufacturer, Trans, Style, Size, Price);}
			if ((Fuel == "All" | Fuel == "elec") & (Categ == "All" | Categ == "Hatchback") & (Trans == "All" | Trans == "DIRECT_DRIVE")) { .print("[!] It's an electric car"); +electric(Manufacturer, Style, Size, Price);}
			if ((Fuel == "All" | Fuel == "reg")  & (Categ == "All" | Categ == "Flex_fuel")) { .print("[!] It's an economy car"); +econom(Manufacturer, Trans, Hp, Style, Size, Price);}
			if ((Fuel == "All" | Fuel == "prem") & (Categ == "All" | Categ == "Lux") & (Doors == "All" | Doors == 4)) { .print("[!] It's a luxurious car"); +lux(Manufacturer, Trans, Hp, Style, Size, Price);}.
			
+super_car(Manufacturer, Trans, Style, Size, Price)
		<- 	if ((Manufacturer == "All" | Manufacturer == "Lamborghini") & (Trans == "All" | Trans == "a") & (Style == "All" | Style == "Coupe"	  ) & (Size == "All" | Size == "sm") & Price >=  199800) {.print("[!] It's a Huracan"); .send(ca, achieve, product("Huracan")); }
			if ((Manufacturer == "All" | Manufacturer == "Ferrari" 	) & (Trans == "All" | Trans == "a") & (Style == "All" | Style == "Coupe"	  ) & (Size == "All" | Size == "sm") & Price >=  291744) {.print("[!] It's a 458_Italia"); .send(ca, achieve, product("458_Italia")); }
			if ((Manufacturer == "All" | Manufacturer == "Ferrari"	) & (Trans == "All" | Trans == "a") & (Style == "All" | Style == "Convertible") & (Size == "All" | Size == "sm") & Price >=  180408) {.print("[!] It's a 360"); .send(ca, achieve, product("360")); }
			if ((Manufacturer == "All" | Manufacturer == "Ferrari"	) & (Trans == "All" | Trans == "a") & (Style == "All" | Style == "Coupe"	  ) & (Size == "All" | Size == "md") & Price >=  410000) {.print("[!] It's a 599"); .send(ca, achieve, product("599")); }
			if ((Manufacturer == "All" | Manufacturer == "FIAT"	   	) & (Trans == "All" | Trans == "m") & (Style == "All" | Style == "Convertible") & (Size == "All" | Size == "sm") & Price >=  208195) {.print("[!] It's a 124_Spider"); .send(ca, achieve, product("124_Spider")); }.
   
+electric(Manufacturer, Style, Size, Price)
		<- 	if   ((Manufacturer == "All" | Manufacturer == "FIAT"	   ) & (Style == "All" | Style == "2dr_Hatchback") & (Size == "All" | Size == "sm") & Price >=  31800) {.print("[!] It's a 500e"); .send(ca, achieve, product("500")); }
			if ((Manufacturer == "All" | Manufacturer == "Chevrolet" ) & (Style == "All" | Style == "4dr_Hatchback") & (Size == "All" | Size == "sm") & Price >=  36620) {.print("[!] It's a Bolt_EV"); .send(ca, achieve, product("Bolt_EV")); }
			if ((Manufacturer == "All" | Manufacturer == "Volkswagen") & (Style == "All" | Style == "4dr_Hatchback") & (Size == "All" | Size == "sm") & Price >=  35595) {.print("[!] It's a e-Golf"); .send(ca, achieve, product("e-Golf")); }
			if ((Manufacturer == "All" | Manufacturer == "Tesla"	   ) & (Style == "All" | Style == "Sedan"		 ) & (Size == "All" | Size == "md") & Price >= 112000) {.print("[!] It's a Model_S"); .send(ca, achieve, product("Model S")); }.
   
+econom(Manufacturer, Trans, Hp, Style, Size, Price)
		<- 	if   ((Manufacturer == "All" | Manufacturer == "Volkswagen"	) & (Trans == "All" | Trans == "m") & Hp <= 210 & (Style == "All" | Style == "2dr_Hatchback") & (Size == "All" | Size == "sm") & Price >= 24785) {.print("[!] It's a golf"); .send(ca, achieve, product("Golf")); }
			if ((Manufacturer == "All" | Manufacturer == "Chrysler"	) 	  & (Trans == "All" | Trans == "a") & Hp <= 184 & (Style == "All" | Style == "Sedan") 		  & (Size == "All" | Size == "md") & Price >= 27795) {.print("[!] It's a 200"); .send(ca, achieve, product("200")); }
			if ((Manufacturer == "All" | Manufacturer == "Nissan"		) & (Trans == "All" | Trans == "a") & Hp <= 200 & (Style == "All" | Style == "Convertible")   & (Size == "All" | Size == "sm") & Price >= 39630) {.print("[!] It's a Versa"); .send(ca, achieve, product("Versa")); }.
  
+lux(Manufacturer, Trans, Hp, Style, Size, Price)
		<- 	if ((Manufacturer == "All" | Manufacturer == "Rolls-Royce")   & (Trans == "All" | Trans == "a") & Hp <= 453 & (Style == "All" | Style == "Sedan") & (Size == "All" | Size == "lg") & Price >= 492425) {.print("[!] It's a Phantom"); .send(ca, achieve, product("Phantom")); }
			if ((Manufacturer == "All" | Manufacturer == "BMW"		)     & (Trans == "All" | Trans == "m") & Hp <= 320 & (Style == "All" | Style == "Sedan") & (Size == "All" | Size == "md") & Price >=  49900) {.print("[!] It's a 3_Series"); .send(ca, achieve, product("3_Series")); }
			if ((Manufacturer == "All" | Manufacturer == "Alfa_Romeo" )   & (Trans == "All" | Trans == "a") & Hp <= 337 & (Style == "All" | Style == "Coupe") & (Size == "All" | Size == "sm") & Price >=  65900) {.print("[!] It's a 4c"); .send(ca, achieve, product("4c")); }
			if ((Manufacturer == "All" | Manufacturer == "Audi"		) 	  & (Trans == "All" | Trans == "m") & Hp <= 320 & (Style == "All" | Style == "Sedan") & (Size == "All" | Size == "md") & Price >=  34200) {.print("[!] It's a a3"); .send(ca, achieve, product("a3")); }
			if ((Manufacturer == "All" | Manufacturer == "HUMMER"		) & (Trans == "All" | Trans == "a") & Hp <= 320 & (Style == "All" | Style == "SUV"  ) & (Size == "All" | Size == "lg") & Price >=  35680) {.print("[!] It's a H3T"); .send(ca, achieve, product("H3T")); }
			if ((Manufacturer == "All" | Manufacturer == "Porche"		) & (Trans == "All" | Trans == "a") & Hp <= 400 & (Style == "All" | Style == "SUV"  ) & (Size == "All" | Size == "md") & Price >=  76000) {.print("[!] It's a Macan"); .send(ca, achieve, product("Macan")); }.


//////////////////////////////////////////////////////////////////////////////////
///////		Bus
//////////////////////////////////////////////////////////////////////////////////
+bus(Manufacturer, Bus_Type, Size, Price)
		<- 	if ((Manufacturer == "All" | Manufacturer == "MCV"		) & (Bus_Type == "All" | Bus_Type == "double_deck") & (Size == "All" | Size == "lg") & Price >= 134142) {.print("[!] It's a 800");.send(ca, achieve, product("800"));}
			if ((Manufacturer == "All" | Manufacturer == "Volvo"		) & (Bus_Type == "All" | Bus_Type == "single_deck") & (Size == "All" | Size == "md") & Price >=  21612) {.print("[!] It's a 7900");.send(ca, achieve, product("7900"));}
			if ((Manufacturer == "All" | Manufacturer == "TransBus"	) & (Bus_Type == "All" | Bus_Type == "double_deck") & (Size == "All" | Size == "md") & Price >=  20000) {.print("[!] It's a ALX400");.send(ca, achieve, product("ALX400"));}
			if ((Manufacturer == "All" | Manufacturer == "VDL_Berkhof") & (Bus_Type == "All" | Bus_Type == "single_deck") & (Size == "All" | Size == "sm") & Price >=  16379) {.print("[!] It's a Ambassador");.send(ca, achieve, product("Ambassador"));}
			if ((Manufacturer == "All" | Manufacturer == "Goppel"		) & (Bus_Type == "All" | Bus_Type == "single_deck") & (Size == "All" | Size == "lg") & Price >= 120000) {.print("[!] It's a AutoTram_Extra_Grand");.send(ca, achieve, product("AutoTram_Extra_Grand"));}.
			
//////////////////////////////////////////////////////////////////////////////////
///////		Truck
//////////////////////////////////////////////////////////////////////////////////
+truck(Trailer, Cargo_size_area, Manufacturer, Trailer_weight, Cargo_size, Price)
		<- 	if (Trailer == "All" | Trailer == "true") {.print("[!] It's a tractor_trailer"); +tractor_trailer(Manufacturer, Trailer_weight, Price); }
			if (Cargo_size_area == "All"  | Cargo_size_area == "true") {.print("[!] It's a pickup"); +pickup(Manufacturer, Cargo_size, Price); }.
			
+tractor_trailer(Manufacturer, Trailer_weight, Price)
		<- 	if ((Manufacturer == "All" | Manufacturer == "Tesla"	  ) & Trailer_weight <= 36287 & Price >= 120000) {.print("[!] It's a Semi-Truck"); .send(ca, achieve, product("Semi-Truck")); }
			if ((Manufacturer == "All" | Manufacturer == "Cascadia" ) & Trailer_weight <= 27487 & Price >= 150000) {.print("[!] It's a Freightliner"); .send(ca, achieve, product("Freightliner")); }
			if ((Manufacturer == "All" | Manufacturer == "Volva"	  ) & Trailer_weight <= 10164 & Price >= 160000) {.print("[!] It's a VNL"); .send(ca, achieve, product("VNL")); }
			if ((Manufacturer == "All" | Manufacturer == "Peterbilt") & Trailer_weight <= 36287 & Price >= 145500) {.print("[!] It's a Model_579"); .send(ca, achieve, product("Model_579")); }.
			
+pickup(Manufacturer, Cargo_size, Price)
		<- 	if   ((Manufacturer == "All" | Manufacturer == "Ford"	  ) & Cargo_size <=64 & Price >= 28495) {.print("[!] It's a F-150"); .send(ca, achieve, product("F-150")); }
			if ((Manufacturer == "All" | Manufacturer == "Ram"	  ) & Cargo_size <=53 & Price >= 33356) {.print("[!] It's a 1500"); .send(ca, achieve, product("1500")); }
			if ((Manufacturer == "All" | Manufacturer == "Chevrolet") & Cargo_size <=51 & Price >= 28300) {.print("[!] It's a Silverado_1500"); .send(ca, achieve, product("Silverado_1500")); }
			if ((Manufacturer == "All" | Manufacturer == "Nissan"	  ) & Cargo_size <=50 & Price >= 36190) {.print("[!] It's a Titan"); .send(ca, achieve, product("Titan")); }
			if ((Manufacturer == "All" | Manufacturer == "Toyota"	  ) & Cargo_size <=63 & Price >= 42120) {.print("[!] It's a Tundra"); .send(ca, achieve, product("Tundra")); }
			if ((Manufacturer == "All" | Manufacturer == "Tesla"	  ) & Cargo_size <=60 & Price >= 39900) {.print("[!] It's a Cybertruck"); .send(ca, achieve, product("Cybertruck")); }.				
	
	
//////////////////////////////////////////////////////////////////////////////////
///////		Motorcycle
//////////////////////////////////////////////////////////////////////////////////
+motorcycle(Weight_class, Manufacturer, Range, Tspeed, Acc, Price)
		<- 	if (Weight_class == "All" | Weight_class == "light") {.print("[!] It's a scooter"); +scooter(Manufacturer, Range, Price); }
			if (Weight_class == "All" | Weight_class == "mid"	 ) {.print("[!] It's a sport"); +sport(Manufacturer, Tspeed, Price); }
			if (Weight_class == "All" | Weight_class == "heavy") {.print("[!] It's a cruiser"); +cruiser(Manufacturer, Acc, Price); }.
			
+scooter(Manufacturer, Range, Price)
		<- 	if ((Manufacturer == "All" | Manufacturer == "Piaggio") & Range <= 110 & Price >= 7499) {.print("[!] It's a BEVERLY_350"); .send(ca, achieve, product("BEVERLY_350")); }
			if ((Manufacturer == "All" | Manufacturer == "YAMAHA"	) & Range <= 90  & Price >= 12502) { .print("[!] It's a TMax"); .send(ca, achieve, product("TMax")); }.					
	
+sport(Manufacturer, Tspeed, Price)
		<- 	if ((Manufacturer == "All" | Manufacturer == "BMW"	) & Tspeed <= 320 & Price >= 22693) {.print("[!] It's a s1000rr"); .send(ca, achieve, product("s1000rr")); }
			if ((Manufacturer == "All" | Manufacturer == "Ducati"	) & Tspeed <= 305 & Price >= 54118) { .print("[!] It's a v5s"); .send(ca, achieve, product("v5s")); }.				
						
+cruiser(Manufacturer, Acc, Price) 
		<-	if ((Manufacturer == "All" | Manufacturer == "triumph"		) & Acc <= 2.79 & Price >= 22600) { .print("[!] It's a rocket_3"); .send(ca, achieve, product("rocket_3")); }
			if ((Manufacturer == "All" | Manufacturer == "arch_motorcycle") & Acc <= 2.31 & Price >= 85000) { .print("[!] It's a krgt-1"); .send(ca, achieve, product("krgt-1")); }.				


/*
+sport(Manufacturer, Tspeed, Price) 
			: Manufacturer == 'Ducati' & Tspeed ==305 & Price >= 54118
			<-	.print("[!] It's a v5s"); .send(ca, achieve, product('v5s')).	
				
+sport(Manufacturer, Tspeed, Price) 
			: Manufacturer == 'BMW' & Tspeed ==320 & Price >= 22693
			<-	.print("[!] It's a s1000rr"); .send(ca, achieve, product('s1000rr')).
			
/*			
+cruiser(Manufacturer, Acc, Price) 
			: Manufacturer == 'triumph' & Acc ==2.79 & Price >= 22600
			<-	.print("[!] It's a rocket_3"); .send(ca, achieve, product('rocket_3')).	

+cruiser(Manufacturer, Acc, Price) 
			: Manufacturer == 'arch_motorcycle' & Acc == 2.31 & Price >= 85000
			<-	.print("[!] It's a krgt-1"); .send(ca, achieve, product('krgt-1')).*/
			
			
			
			
			
			
			
			
			