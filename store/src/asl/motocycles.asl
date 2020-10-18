// Agent motocycles in project store

/* Initial beliefs and rules */

/* Initial goals */

!start.

+!start <- .print("loaded!").

/* Plans */

+!find(Manufacturer, Weight_class, Range, Tspeed, Acc, Price) 
<- 	if ((Manufacturer == "All" | Manufacturer == "Piaggio") 		& (Weight_class == "All" | Weight_class == "light") & Range <= 110 & Tspeed <= 120 & Price >= 7499) 
	{.print("[!] It's a BEVERLY_350"); .send(central, achieve, product("Piaggio BEVERLY_350")); }
	if ((Manufacturer == "All" | Manufacturer == "YAMAHA"	) 		& (Weight_class == "All" | Weight_class == "light") & Range <= 90  & Tspeed <= 120 & Price >= 12502) 
	{ .print("[!] It's a TMax"); .send(central, achieve, product("YAMAHA TMax")); }
	if ((Manufacturer == "All" | Manufacturer == "BMW"	) 			& (Weight_class == "All" | Weight_class == "mid") 	& Tspeed <= 320 & Price >= 22693) 
	{.print("[!] It's a s1000rr"); .send(central, achieve, product("BMW s1000rr")); }
	if ((Manufacturer == "All" | Manufacturer == "Ducati"	) 		& (Weight_class == "All" | Weight_class == "mid") 	& Tspeed <= 305 & Price >= 54118) 
	{ .print("[!] It's a v5s"); .send(central, achieve, product("Ducati v5s")); }		
	if ((Manufacturer == "All" | Manufacturer == "triumph") 		& (Weight_class == "All" | Weight_class == "heavy") & Acc <= 2.79 & Price >= 22600) 
	{ .print("[!] It's a rocket_3"); .send(central, achieve, product("Triumph rocket_3")); }
	if ((Manufacturer == "All" | Manufacturer == "arch_motorcycle") & (Weight_class == "All" | Weight_class == "heavy") & Acc <= 2.31 & Price >= 85000) 
	{ .print("[!] It's a krgt-1"); .send(central, achieve, product("Arch_motorcyclekrgt-1")); }.				
									