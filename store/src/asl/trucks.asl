// Agent trucks in project store

/* Initial beliefs and rules */

/* Initial goals */


!start.

+!start <- .print("loaded!").

/* Plans */

+!find(Manufacturer, Trailer, Trailer_weight, Cargo_area, Cargo_size, Price)
<-  if ((Manufacturer == "All" | Manufacturer == "Tesla")		& (Trailer == "All" | Trailer == "true") & (Cargo_area == "All"  | Cargo_area == "false") &  Trailer_weight <= 36287 & Price >= 120000) 
	{.print("[!] It's a Semi-Truck"); .send(central, achieve, product("Tesla Semi-Truck")); }
	if ((Manufacturer == "All" | Manufacturer == "Cascadia") 	& (Trailer == "All" | Trailer == "true") & (Cargo_area == "All"  | Cargo_area == "false") & Trailer_weight <= 27487 & Price >= 150000) 
	{.print("[!] It's a Freightliner"); .send(central, achieve, product("Cascadia Freightliner")); }
	if ((Manufacturer == "All" | Manufacturer == "Volva")		& (Trailer == "All" | Trailer == "true") & (Cargo_area == "All"  | Cargo_area == "false") & Trailer_weight <= 10164 & Price >= 160000) 
	{.print("[!] It's a VNL"); .send(central, achieve, product("Volva VNL")); }
	if ((Manufacturer == "All" | Manufacturer == "Peterbilt") 	& (Trailer == "All" | Trailer == "true") & (Cargo_area == "All"  | Cargo_area == "false") & Trailer_weight <= 36287 & Price >= 145500) 
	{.print("[!] It's a Model_579"); .send(central, achieve, product("Peterbilt Model_579")); }

	if ((Manufacturer == "All" | Manufacturer == "Ford"	  ) 	& (Trailer == "All" | Trailer == "false") & (Cargo_area == "All"  | Cargo_area == "true") & Cargo_size <=64 & Price >= 28495) 
	{.print("[!] It's a F-150"); .send(central, achieve, product("Ford F-150")); }
	if ((Manufacturer == "All" | Manufacturer == "Ram"	  )	 	& (Trailer == "All" | Trailer == "false") & (Cargo_area == "All"  | Cargo_area == "true") & Cargo_size <=53 & Price >= 33356) 
	{.print("[!] It's a 1500"); .send(central, achieve, product("Ram 1500")); }
	if ((Manufacturer == "All" | Manufacturer == "Chevrolet") 	& (Trailer == "All" | Trailer == "false") & (Cargo_area == "All"  | Cargo_area == "true") & Cargo_size <=51 & Price >= 28300) 
	{.print("[!] It's a Silverado_1500"); .send(central, achieve, product("Chevrolet Silverado_1500")); }
	if ((Manufacturer == "All" | Manufacturer == "Nissan"	  ) & (Trailer == "All" | Trailer == "false") & (Cargo_area == "All"  | Cargo_area == "true") & Cargo_size <=50 & Price >= 36190) 
	{.print("[!] It's a Titan"); .send(central, achieve, product("Nissan Titan")); }
	if ((Manufacturer == "All" | Manufacturer == "Toyota"	  ) & (Trailer == "All" | Trailer == "false") & (Cargo_area == "All"  | Cargo_area == "true") & Cargo_size <=63 & Price >= 42120) 
	{.print("[!] It's a Tundra"); .send(central, achieve, product("Toyota Tundra")); }
	if ((Manufacturer == "All" | Manufacturer == "Tesla"	  ) & (Trailer == "All" | Trailer == "false") & (Cargo_area == "All"  | Cargo_area == "true") & Cargo_size <=60 & Price >= 39900) 
	{.print("[!] It's a Cybertruck"); .send(central, achieve, product("Tesla Cybertruck")); }.				